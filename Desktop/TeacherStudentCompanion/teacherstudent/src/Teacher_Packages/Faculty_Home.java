/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher_Packages;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.javafx.scene.control.skin.FXVK;
import java.awt.Image;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Lab-3_1
 */
public class Faculty_Home extends javax.swing.JFrame {

    String username = null;
String photo;
    /**
     * Creates new form Teacher_Home
     */
    public Faculty_Home(String username) throws UnirestException {
        initComponents();
        setSize(932, 486);
        this.username = username;
        jLabel4.setText("Welcome" + username);
        getFacultyInfo();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
         try {
            URL url = new URL("http://localhost:9595/GetResource/" + photo);
            Image img=ImageIO.read(url);
            jLabel3.setIcon(new ImageIcon(img.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(), Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void getFacultyInfo() throws UnirestException {
        HttpResponse<String> httpresponse = Unirest.get("http://127.0.0.1:9595/getfacultyinfo")
                .queryString("username", username)
                .asString();
        if (httpresponse.getStatus() == 200) {
            String ans = httpresponse.getBody();

            StringTokenizer st1 = new StringTokenizer(ans, "#&%");

            String user = st1.nextToken();
           
            String dn = st1.nextToken();
            String cn = st1.nextToken();
            String em = st1.nextToken();
            String addr = st1.nextToken();
            String exp = st1.nextToken();
            String qul = st1.nextToken();
                        String phno = st1.nextToken();

             photo = st1.nextToken();
             System.out.println(photo);
            try {
                URL url = new URL("http://localhost:9595/GetResource/" + photo);
                jLabel3.setIcon(new ImageIcon(url));
            } catch (Exception e) {
                e.printStackTrace();
            }

            jLabel4.setText(user);
            jLabel2.setText(dn);
            jLabel5.setText(cn);
            jLabel6.setText(em);
            jLabel7.setText(phno);
            jLabel8.setText(addr);
            jLabel9.setText(qul);
            jLabel10.setText(exp);
            setVisible(true);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Sitka Display", 2, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TEACHER HOME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 20, 520, 30);

        jPanel1.setLayout(null);

        jLabel3.setText("photo");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 20, 150, 110);

        jLabel2.setText("departmentname");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(350, 10, 90, 40);

        jLabel4.setText("Username");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(110, 140, 70, 30);

        jLabel5.setText("coursename");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(350, 70, 90, 40);

        jLabel6.setText("email");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(350, 130, 90, 30);

        jLabel7.setText("phone number");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(350, 200, 90, 30);

        jLabel8.setText("address");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(640, 20, 120, 40);

        jLabel9.setText("qulification");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(640, 80, 130, 50);

        jLabel10.setText("experience");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(640, 140, 130, 50);

        jLabel11.setText("DEPARTMENT NAME");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(200, 10, 130, 40);

        jLabel12.setText("COURSE NAME");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(200, 70, 120, 40);

        jLabel13.setText("EMAIL");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(200, 130, 100, 40);

        jLabel14.setText("PHONE NUMBER");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(200, 200, 100, 30);

        jLabel15.setText("ADDRESS");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(500, 30, 100, 30);

        jLabel16.setText("QUALIFICATION");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(500, 90, 110, 40);

        jLabel17.setText("EXPERIENCE");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(500, 150, 100, 30);

        jLabel18.setText("USERNAME");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(10, 140, 90, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 60, 860, 260);

        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(60, 350, 150, 40);

        jButton2.setText("Edit Profile");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(270, 350, 150, 40);

        jButton3.setText("Add Notes");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(490, 350, 160, 40);

        jButton4.setText("View notes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(680, 350, 160, 40);

        jButton5.setText("Send SMS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(60, 410, 150, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        facultychangepassword obj = new facultychangepassword(username);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Editing_profile obj = new Editing_profile(jLabel4.getText(),jLabel6.getText(),jLabel7.getText(),jLabel8.getText(),jLabel9.getText(),jLabel10.getText(),photo);
        obj.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Add_notes obj = new Add_notes( jLabel4.getText(),jLabel5.getText(),jLabel2.getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       view_notes_history obj = new view_notes_history(username);
       obj.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        send_sms obj = new send_sms(jLabel4.getText(),jLabel5.getText(),jLabel2.getText());
        obj.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Faculty_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Faculty_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Faculty_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Faculty_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //new Faculty_Home().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
