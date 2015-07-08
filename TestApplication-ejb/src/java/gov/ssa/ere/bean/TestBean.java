/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.ssa.ere.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author lisner
 */
@Stateless
public class TestBean implements TestBeanRemote, TestBeanLocal {

    @Override
    public String helloThere() {
        return "TestBean saying hi";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public String doSomethingFor30Seconds() {
        System.out.println("In the bean with hash of:  " + this.hashCode());
        SimpleDateFormat frmt = new SimpleDateFormat();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(
            "Finished bean with has of:  "
            + this.hashCode()
            + " at "
            + frmt.format(Calendar.getInstance().getTime()));
        return "Done doing nothing";
    }

    @Asynchronous
    public void doesSomethingAsynchronusFor45Seconds() {
        System.out.println("In the bean with hash of:  " + this.hashCode());
        SimpleDateFormat frmt = new SimpleDateFormat();

        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(6000);
                System.out.println("Finished interval " 
                        + i
                        + " on beanID "
                        + this.hashCode());
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(
            "Finished bean with hash of:  "
            + this.hashCode()
            + " at "
            + frmt.format(Calendar.getInstance().getTime())
            + " for method call asynch45");
    }
}
