
package teacherstudent;

import Teacher_Packages.Teacher_Login;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class welcome_page extends javax.swing.JFrame {

    public welcome_page() throws IOException {
        initComponents();
        setSize(650,500);
        setLocationRelativeTo(null);
        lbphoto.setBounds(0, 0, getWidth(), getHeight());
        
        Image img = ImageIO.read(getClass().getResource("/pics/4698163-free-college-screensavers-and-wallpaper.jpg"));
        lbphoto.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(lbphoto.getWidth(), lbphoto.getHeight(), Image.SCALE_SMOOTH)));
         Image img1 = ImageIO.read(getClass().getResource("/pics/login_img.png"));
            lbicon1.setIcon(new javax.swing.ImageIcon(img1.getScaledInstance(lbicon1.getWidth(),lbicon1.getHeight(), Image.SCALE_SMOOTH)));
             Image img2 = ImageIO.read(getClass().getResource("/pics/13.png"));
            lbicon2.setIcon(new javax.swing.ImageIcon(img2.getScaledInstance(lbicon2.getWidth(),lbicon2.getHeight(), Image.SCALE_SMOOTH)));
             Image img3 = ImageIO.read(getClass().getResource("/pics/man-formal-suit-icon-vector-9494197.jpg"));
            lbicon3.setIcon(new javax.swing.ImageIcon(img3.getScaledInstance(lbicon3.getWidth(),lbicon3.getHeight(), Image.SCALE_SMOOTH)));
               jPanel1.setBackground(new Color(0,0,0,100));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lbicon1 = new javax.swing.JLabel();
        lbicon2 = new javax.swing.JLabel();
        lbicon3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbphoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jButton1.setText("Admin Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 400, 170, 50);

        jButton2.setBackground(new java.awt.Color(102, 255, 0));
        jButton2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jButton2.setText("Teacher Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(230, 400, 170, 50);

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome...");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 90, 380, 40);

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jButton3.setText("Student Login");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(440, 400, 170, 50);

        lbicon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/login_img.png"))); // NOI18N
        lbicon1.setText("jLabel2");
        lbicon1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(lbicon1);
        lbicon1.setBounds(30, 260, 140, 120);

        lbicon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/13.png"))); // NOI18N
        lbicon2.setText("jLabel3");
        getContentPane().add(lbicon2);
        lbicon2.setBounds(240, 260, 150, 120);

        lbicon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/man-formal-suit-icon-vector-9494197.jpg"))); // NOI18N
        lbicon3.setText("jLabel4");
        getContentPane().add(lbicon3);
        lbicon3.setBounds(450, 260, 150, 120);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Government  Polytechnic College.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 660, 70);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 240, 650, 220);

        lbphoto.setText("jLabel2");
        getContentPane().add(lbphoto);
        lbphoto.setBounds(20, 20, 100, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Student_package.Student_Login obj = new Student_package.Student_Login();
         obj.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        adminlogin obj = new adminlogin();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Teacher_Login obj = new Teacher_Login();
         obj.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(welcome_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcome_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcome_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcome_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new welcome_page().setVisible(true);
                } catch (IOException ex) {
                   ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbicon1;
    private javax.swing.JLabel lbicon2;
    private javax.swing.JLabel lbicon3;
    private javax.swing.JLabel lbphoto;
    // End of variables declaration//GEN-END:variables
}
