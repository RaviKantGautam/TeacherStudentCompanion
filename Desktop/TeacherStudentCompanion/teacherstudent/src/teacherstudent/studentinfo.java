/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherstudent;

/**
 *
 * @author Lab-3_1
 */
public class studentinfo{
    
public String rollno,em,phno,addr,sem,dn,cn,photo;

    public studentinfo(String rollno, String em, String phno, String addr, String sem, String dn, String cn, String photo) {
        this.rollno = rollno;
        
        this.em = em;
        this.phno = phno;
        this.addr = addr;
        this.sem = sem;
        this.dn = dn;
        this.cn = cn;
        this.photo= photo;
    }

    public studentinfo(String rollno, String em, String phno, String addr, String sem, String cn, String photo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
