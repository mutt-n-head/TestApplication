/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.ssa.ere.service;

import gov.ssa.ere.entity.Person;
import java.util.Calendar;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author lisner
 */
@Path("test")
public class TestService {
    /**
     * This is a sample web service operation
     */
    @GET
    @Path("/hello")
    public String hello() {
        return "Hello there";
    }
    
    @GET
    @Path("/mutton")
    public String test() {
        return "Hello Mutt";
    }
    
    @GET
    @Path("/git")
    public String git() {
        return "Hello there from git";
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Person makePerson() {
        return birthAPerson();
    }

    public Person birthAPerson() {
        Person taylorSwift = new Person();
        taylorSwift.setFirstName("Taylor");
        taylorSwift.setLastName("Swift");
        taylorSwift.setId(1);
        taylorSwift.setDateOfBirth(Calendar.getInstance().getTime());
        
        return taylorSwift;        
    }
    
    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public Person makeAnotherPerson() {
        return birthAPerson();
    }
}
