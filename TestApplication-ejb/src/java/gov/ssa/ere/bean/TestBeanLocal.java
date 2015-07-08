/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.ssa.ere.bean;

import javax.ejb.Local;

/**
 *
 * @author lisner
 */
@Local
public interface TestBeanLocal {

    String helloThere();

    public String doSomethingFor30Seconds();

    public void doesSomethingAsynchronusFor45Seconds();
    
}
