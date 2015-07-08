/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.ssa.ere.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lisner
 */
public class EREFile implements Serializable {
    private long key;
    private List<EREFile> children;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the key
     */
    public long getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(long key) {
        this.key = key;
    }

    /**
     * @return the children
     */
    public List<EREFile> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<EREFile> children) {
        this.children = children;
    }
    
    public void display() {
        System.out.println("EREFile key:  " + key + " and name:  " + name);

        if (children != null) {
            for (EREFile child : children) {
                child.display();
            }
        }
    }
}
