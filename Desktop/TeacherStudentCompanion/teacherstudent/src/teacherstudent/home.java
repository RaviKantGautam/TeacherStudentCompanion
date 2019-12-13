
package teacherstudent;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class home extends javax.swing.JFrame {
int w, h;
    public home(String email) {
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d);
        w = d.width - 10;
        h = d.height- 100;
        jDesktopPane1.setSize(d);
       jDesktopPane1.removeAll();
       DummyForm obj = new DummyForm();
        obj.setVisible(true);
        obj.setSize(w,h);
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        obj.setIconifiable(true);
//        obj.setMaximizable(true);
//        obj.setClosable(true);
        jDesktopPane1.add(obj);
        setLocationRelativeTo(null);
        
      //  lb1.setText("WELCOME "+email);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setVisible(true);
    }
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(0, 0, 510, 410);

        jMenu1.setText("Add");

        jMenuItem1.setText("Add Department");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Add Course");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Add Faculty");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Add Students");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("View");

        jMenuItem5.setText("View Deapartment");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("View Course");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("View Faculty");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("View Student");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Dashboard");

        jMenuItem9.setText("Logout");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        Manage_Department obj = new Manage_Department();
        obj.setVisible(true);
        obj.setSize(w,h);
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        obj.setIconifiable(true);
        obj.setMaximizable(true);
        obj.setClosable(true);
        jDesktopPane1.add(obj);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
          jDesktopPane1.removeAll();
    course obj = new course();
        obj.setVisible(true);
        obj.setSize(w,h);
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        obj.setIconifiable(true);
        obj.setMaximizable(true);
        obj.setClosable(true);
        jDesktopPane1.add(obj);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
          jDesktopPane1.removeAll();
        addFaculty obj = new addFaculty();
        obj.setVisible(true);
        obj.setSize(w,h);
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        obj.setIconifiable(true);
        obj.setMaximizable(true);
        obj.setClosable(true);
        jDesktopPane1.add(obj);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
          jDesktopPane1.removeAll();
      Add_Student obj = new Add_Student();
        obj.setVisible(true);
        obj.setSize(w,h);
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        obj.setIconifiable(true);
        obj.setMaximizable(true);
        obj.setClosable(true);
        jDesktopPane1.add(obj);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
          jDesktopPane1.removeAll();
       Viewdepartment obj;
    try {
        obj = new Viewdepartment();
        obj.setVisible(true);
        obj.setSize(w,h);
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        obj.setIconifiable(true);
        obj.setMaximizable(true);
        obj.setClosable(true);
        jDesktopPane1.add(obj);
    } catch (UnirestException ex) {
       ex.printStackTrace();
    }
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:  jDesktopPane1.removeAll();
        jDesktopPane1.removeAll();
        course obj;
    try {
        obj = new course();
        obj.setVisible(true);
        obj.setSize(w,h);
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        obj.setIconifiable(true);
        obj.setMaximizable(true);
        obj.setClosable(true);
        jDesktopPane1.add(obj);
    } catch (Exception ex) {
       ex.printStackTrace();
    }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
         jDesktopPane1.removeAll();
        View_Faculty obj;
    try {
        obj = new View_Faculty();
        obj.setVisible(true);
        obj.setSize(w,h);
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        obj.setIconifiable(true);
        obj.setMaximizable(true);
        obj.setClosable(true);
        jDesktopPane1.add(obj);
    } catch (Exception ex) {
       ex.printStackTrace();
    }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        jDesktopPane1.removeAll();
        View_student obj;
    try {
        obj = new View_student();
        obj.setVisible(true);
        obj.setSize(w,h);
        obj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        obj.setIconifiable(true);
        obj.setMaximizable(true);
        obj.setClosable(true);
        jDesktopPane1.add(obj);
    } catch (Exception ex) {
       ex.printStackTrace();
    }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
         jDesktopPane1.removeAll();
        dispose();
        adminlogin obj = new adminlogin();
        obj.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new home("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
