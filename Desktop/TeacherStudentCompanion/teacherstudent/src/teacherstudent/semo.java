/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherstudent;

import java.util.StringTokenizer;

/**
 *
 * @author Lab-3_1
 */
public class semo {
    public static void main(String[] args) {
        
        
        StringTokenizer st=new StringTokenizer("kapil sharma#&%child#&%grandchild#&%kpill@yahoo.com#&%25645456","#&%");
        while(st.hasMoreTokens())
        {
            System.out.println(st.nextToken());
        }
    }
 
}
