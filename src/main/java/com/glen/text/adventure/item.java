/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.glen.text.adventure;

/**
 *
 * @author Admin
 */
public class item {
    String name;
    
    boolean isOwned;
    
    
    public item(String gname, boolean gisOwned){
        name=gname;
        isOwned=gisOwned;
    }
    
    public void acquireItem(){
        isOwned=true;
    }
            
    
    
}
