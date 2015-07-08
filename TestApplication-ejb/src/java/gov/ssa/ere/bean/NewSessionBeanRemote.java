/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.ssa.ere.bean;

import gov.ssa.ere.model.EREFile;
import javax.ejb.Remote;

/**
 *
 * @author lisner
 */
@Remote
public interface NewSessionBeanRemote {
    EREFile getTree();
}
