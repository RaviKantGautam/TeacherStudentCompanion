
package teacherstudent;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.ws.Response;

public class Manage_Department extends javax.swing.JInternalFrame{

    public Manage_Department() {
        initComponents();
        setSize(837, 528);
      //  setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        Response res;
        setVisible(true);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lb5 = new javax.swing.JLabel();
        lb7 = new javax.swing.JLabel();
        lb9 = new javax.swing.JLabel();
        lb8 = new javax.swing.JLabel();
        lb6 = new javax.swing.JLabel();
        jt13 = new javax.swing.JTextField();
        jt5 = new javax.swing.JTextField();
        jt10 = new javax.swing.JTextField();
        jt6 = new javax.swing.JTextField();
        jt7 = new javax.swing.JTextField();
        btn6 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add Department");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(200, 20, 200, 30);

        lb5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lb5.setForeground(new java.awt.Color(255, 153, 153));
        lb5.setText("Department Name");
        jPanel2.add(lb5);
        lb5.setBounds(30, 80, 160, 30);

        lb7.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lb7.setForeground(new java.awt.Color(0, 153, 0));
        lb7.setText("Department Head");
        jPanel2.add(lb7);
        lb7.setBounds(30, 180, 120, 30);

        lb9.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lb9.setForeground(new java.awt.Color(204, 204, 0));
        lb9.setText("Phone Number");
        jPanel2.add(lb9);
        lb9.setBounds(30, 280, 120, 30);

        lb8.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lb8.setForeground(new java.awt.Color(153, 0, 153));
        lb8.setText("Email");
        jPanel2.add(lb8);
        lb8.setBounds(30, 230, 70, 30);

        lb6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lb6.setForeground(new java.awt.Color(0, 102, 204));
        lb6.setText("Description");
        jPanel2.add(lb6);
        lb6.setBounds(30, 130, 110, 30);
        jPanel2.add(jt13);
        jt13.setBounds(180, 280, 410, 40);
        jPanel2.add(jt5);
        jt5.setBounds(180, 180, 410, 40);
        jPanel2.add(jt10);
        jt10.setBounds(180, 230, 410, 40);

        jt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt6ActionPerformed(evt);
            }
        });
        jPanel2.add(jt6);
        jt6.setBounds(180, 80, 410, 40);
        jPanel2.add(jt7);
        jt7.setBounds(180, 130, 410, 40);

        btn6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn6.setForeground(new java.awt.Color(102, 102, 0));
        btn6.setText("ADD");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel2.add(btn6);
        btn6.setBounds(140, 380, 220, 60);

        bt4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bt4.setForeground(new java.awt.Color(0, 153, 153));
        bt4.setText("View Department");
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });
        jPanel2.add(bt4);
        bt4.setBounds(460, 380, 190, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 0, 680, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        String dn = jt6.getText();
        String des = jt7.getText();
        String hod = jt5.getText();
        String em = jt10.getText();
        String mob = jt13.getText();
        if (dn.equals(" ")||des.equals(" ")||hod.equals(" ")||em.equals(" ")||mob.equals(" ")){
            JOptionPane.showMessageDialog(this, "field must not be empty");
        }
        else{
            try {
                HttpResponse<String> response = Unirest.get("http://127.0.0.1:9595/adddepartment")
                .queryString("dn", jt6.getText())
                .queryString("des", jt7.getText())
                .queryString("hod", jt5.getText())
                .queryString("em", jt10.getText())
                .queryString("mob", jt13.getText())
                .asString();
                String ans = response.getBody();
                System.out.println(ans);

                if (ans.equals("success")) {
                    jt13.setText("");
                    jt5.setText("");
                    jt10.setText("");
                    jt6.setText("");
                    jt7.setText("");
                    
                    
                    
                    JOptionPane.showMessageDialog(this,"Department Added Successfully");
                    
                    
                    
                   
                } else if(ans.equals("fail")) {
                    JOptionPane.showMessageDialog(this, "Department Already Exists");
                    
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed
               Viewdepartment obj;
        try {
            obj = new Viewdepartment();
             obj.setVisible(true);
        } catch (UnirestException ex) {
            ex.printStackTrace();
        }
              
    }//GEN-LAST:event_bt4ActionPerformed

    private void jt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manage_Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Department.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Department().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt4;
    private javax.swing.JButton btn6;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jt10;
    private javax.swing.JTextField jt13;
    private javax.swing.JTextField jt5;
    private javax.swing.JTextField jt6;
    private javax.swing.JTextField jt7;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lb9;
    // End of variables declaration//GEN-END:variables
}
