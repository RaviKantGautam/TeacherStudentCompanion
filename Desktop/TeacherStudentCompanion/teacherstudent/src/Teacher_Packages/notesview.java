/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher_Packages;

import teacherstudent.studentinfo;

/**
 *
 * @author R. K. Gautam
 */
public class notesview {
    String tt,des,tp,file,nid;

    public notesview(String title,  String description, String type, String file, String nid) {
        this.tt = title;
       
        this.des = description;
        this.tp  = type;
        this.file = file;
        this.nid = nid;
                
    }
    
}
