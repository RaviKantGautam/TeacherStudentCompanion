
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student_package;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab-3_1
 */
public class Student_Login extends javax.swing.JFrame {

    /**
     * Creates new form Student_Login
     */
    public Student_Login() {
        initComponents();
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         lbphoto.setBounds(0, 0, getWidth(), getHeight());
           
        try {
           Image img1 = ImageIO.read(getClass().getResource("/pics/students-graduate.jpg"));
            lbphoto.setIcon(new javax.swing.ImageIcon(img1.getScaledInstance(lbphoto.getWidth(),lbphoto.getHeight(), Image.SCALE_SMOOTH)));
             Image img = ImageIO.read(getClass().getResource("/pics/boy-student-uniform-icon-vector-10455960.jpg"));
            lbicon.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(lbicon.getWidth(),lbicon.getHeight(), Image.SCALE_SMOOTH)));
             jPanel1.setBackground(new Color(0,0,0,200));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
          
        
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        lbicon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbphoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 160, 130, 50);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Roll Number");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 110, 130, 60);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(380, 120, 220, 30);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(270, 240, 150, 40);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(380, 170, 220, 30);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(460, 240, 150, 40);

        lbicon.setText("jLabel5");
        getContentPane().add(lbicon);
        lbicon.setBounds(40, 110, 180, 170);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Student Login");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 20, 620, 50);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 80, 650, 240);

        lbphoto.setText("jLabel4");
        getContentPane().add(lbphoto);
        lbphoto.setBounds(20, 30, 80, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            HttpResponse<String> response = Unirest.get("http://127.0.0.1:9595/studentlogin")
                    .queryString("rollno", jTextField1.getText())
                    .queryString("pass", jTextField2.getText())
                    .asString();
            String ans = response.getBody();
            System.out.println(ans);

            if (ans.equals("success")) {

                Student_Home obj = new Student_Home(jTextField1.getText());

                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid rollno/password");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();

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
            java.util.logging.Logger.getLogger(Student_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField jTextField2;
    private javax.swing.JLabel lbicon;
    private javax.swing.JLabel lbphoto;
    // End of variables declaration//GEN-END:variables
}
