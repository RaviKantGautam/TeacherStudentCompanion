/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher_Packages;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab-3_1
 */
public class Editing_profile extends javax.swing.JFrame {
String username;
File file;


    /**
     * Creates new form Editing_profile
     */
    public Editing_profile(String user,String email, String phno, String addr, String qul, String exp, String photo) {
        initComponents();
        setSize(767, 486);
        setVisible(true);
        jtb.setText(user);
        jtb.setEnabled(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        jTextField4.setText(email);
        jTextField5.setText(phno);
        jTextField6.setText(addr);
        jTextField7.setText(qul);
        jTextField8.setText(exp);
         try {
                URL url = new URL("http://localhost:9595/GetResource/" + photo);
                Image img = ImageIO.read(url);
                lbphoto.setIcon(new ImageIcon(img.getScaledInstance(lbphoto.getWidth(), lbphoto.getHeight(), Image.SCALE_SMOOTH)));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        lbphoto = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jtb = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDIT PROFILE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 10, 380, 50);

        jLabel2.setText("USERNAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 140, 140, 30);

        jLabel5.setText("EMAIL");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 180, 110, 40);

        jLabel6.setText("PHONE NUMBER");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 220, 120, 40);

        jLabel7.setText("ADDRESS");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 260, 90, 40);

        jLabel8.setText("QUALIFICATION");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 300, 110, 40);

        jLabel9.setText("EXPERIENCE");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 340, 120, 30);

        jButton1.setText("Apply Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 400, 180, 60);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(310, 400, 170, 60);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(170, 190, 390, 30);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(170, 230, 390, 30);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(170, 270, 390, 30);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(170, 310, 390, 30);
        getContentPane().add(jTextField8);
        jTextField8.setBounds(170, 350, 390, 30);

        lbphoto.setText("jLabel10");
        getContentPane().add(lbphoto);
        lbphoto.setBounds(590, 30, 130, 110);

        jButton3.setText("Change");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(590, 170, 130, 30);
        getContentPane().add(jtb);
        jtb.setBounds(170, 140, 380, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          String username =jtb.getText();
          String address=jTextField6.getText();
        String email=jTextField4.getText();
            String phoneno =jTextField5.getText();
            String qualification=jTextField7.getText();
          String experience=jTextField8.getText();
          if (username.equals(" ")||address.equals(" ")||email.equals(" ")||phoneno.equals(" ")||qualification.equals(" ")||experience.equals(" ")) {
              JOptionPane.showMessageDialog(this, "Please fill all fields...");
            
        }
          else {
              try {
                  HttpResponse<String> httpResponse= null;
                  if(file== null)
                  {
                httpResponse=Unirest.get("http://127.0.0.1:9595/Facultyeditprofile")
                          .queryString("username",username)
                          .queryString("address",address)
                          .queryString("em",email)
                          .queryString("phn",phoneno)
                          .queryString("quali",qualification)
                          .queryString("ex",experience)
                        .queryString("status","false")
                          .asString();
                  }
                  else 
                  {
                      httpResponse=Unirest.post("http://127.0.0.1:9595/Facultyeditprofile")
                          .queryString("username",username)
                          .queryString("address",address)
                          .queryString("em",email)
                          .queryString("phn",phoneno)
                          .queryString("quali",qualification)
                          .queryString("ex",experience)
                              .queryString("status",true)
                              .field("photo", file)
                          .asString();
                  }
                          if(httpResponse.getStatus()==200){
                              String ans = httpResponse.getBody();
                              if(ans.equals("success")){
                                 
                                  
                                  
                                  JOptionPane.showMessageDialog(rootPane, "Changes added successfully");
                                  
                                  
                                  
                              }
                              else if(ans.equals("fail")){
                                  JOptionPane.showMessageDialog(rootPane, "Faculty edit already exists");
                              }
                          }
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
          
                  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         JFileChooser chooser = new JFileChooser("D:\\");
        int r = chooser.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
           file = chooser.getSelectedFile();
            try {
                BufferedImage img = ImageIO.read(file);
                //Icon icon = new Icone
                ImageIcon icon = new ImageIcon(img);
                lbphoto.setIcon(icon);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("File changed");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Editing_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editing_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editing_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editing_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             //   new Editing_profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel jtb;
    private javax.swing.JLabel lbphoto;
    // End of variables declaration//GEN-END:variables
}
