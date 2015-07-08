/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.ssa.ere.bean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author lisner
 */
@Stateless
@LocalBean
public class NoInterfaceBean {
    public String ping(String _name) {
        return "Hello " + _name;
    }
    
    @Asynchronous
    public void asynchPingWithSleep(Integer _id) {
        System.out.println(
                "Call to pingWithSleep on Object "
                + hashCode()
                + " with id "
                + _id);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Logger.getLogger(NoInterfaceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void synchPingWithSleep(Integer _id) {
        System.out.println(
                "Call to pingWithSleep on Object "
                + hashCode()
                + " with id "
                + _id);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Logger.getLogger(NoInterfaceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
