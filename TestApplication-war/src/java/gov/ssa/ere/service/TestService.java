/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.ssa.ere.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

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
}
