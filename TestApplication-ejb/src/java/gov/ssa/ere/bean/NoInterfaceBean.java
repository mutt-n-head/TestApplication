/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.ssa.ere.bean;

import gov.ssa.ere.bean.interceptors.SampleInterceptor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.interceptor.Interceptors;

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
            Logger.getLogger(
                    NoInterfaceBean.class.getName()).log(Level.SEVERE,
                    null,
                    ex);
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
            Logger.getLogger(
                    NoInterfaceBean.class.getName()).log(Level.SEVERE,
                    null,
                    ex);
        }
    }

    @Interceptors(SampleInterceptor.class)
    public String echoService(String _inputStr, Integer _ct) {
        String retStr = "";

        for (Integer i = 1; i <= _ct; i++) {
            retStr += _inputStr;
            retStr += " ... ";
        }

        return retStr;
    }
}
