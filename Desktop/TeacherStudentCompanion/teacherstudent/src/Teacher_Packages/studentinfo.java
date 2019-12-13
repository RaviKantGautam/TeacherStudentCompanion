/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher_Packages;



/**
 *
 * @author Lab-3_1
 */
public class studentinfo{
     String rollno,em,phno,addr,sem,dn,cn,photo;
     boolean ischecked;

    public studentinfo(String rollno, String em, String phno, String addr, String sem, String dn, String cn, String photo,boolean ischecked) {
        this.rollno = rollno;
        
        this.em = em;
        this.phno = phno;
        this.addr = addr;
        this.sem = sem;
        this.dn = dn;
        this.cn = cn;
        this.photo= photo;
        this.ischecked=ischecked;
    }

    

    
    
}
