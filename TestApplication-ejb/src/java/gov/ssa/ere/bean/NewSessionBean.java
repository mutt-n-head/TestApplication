/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.ssa.ere.bean;

import gov.ssa.ere.model.EREFile;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author lisner
 */
@Stateless
public class NewSessionBean implements NewSessionBeanRemote, NewSessionBeanLocal {

    @Override
    public EREFile getTree() {
        EREFile returnFile = new EREFile();
        List<EREFile> newFiles = new ArrayList<>();
        
        returnFile.setKey(1);
        returnFile.setName("root");
        
        for (int i = 100; i < 103; i++) {
            EREFile detailFile = new EREFile();
            detailFile.setKey(i);
            detailFile.setName("Node_number_" + i);
            
            newFiles.add(detailFile);
        }

        returnFile.setChildren(newFiles);
        
        return returnFile;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
