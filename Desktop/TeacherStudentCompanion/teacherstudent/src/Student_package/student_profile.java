/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student_package;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Image;
import static java.awt.SystemColor.text;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class student_profile extends javax.swing.JFrame {

    String rollno, email, address, phono, photo;
    File file;

    student_profile(String rollno, String em, String phno, String addr, String photo) {
        initComponents();
        setSize(692, 503);
        setVisible(true);
        lbrollno.setText(rollno);
        tfemail.setText(email);
        tfphno.setText(phno);
        tfaddr.setText(addr);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        try {
            URL url = new URL("http://localhost:9595/GetResource/" + photo);
            Image img=ImageIO.read(url);
            lbphoto.setIcon(new ImageIcon(img.getScaledInstance(lbphoto.getWidth(), lbphoto.getHeight(), Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbrollno = new javax.swing.JLabel();
        jLABEL2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        tfphno = new javax.swing.JTextField();
        tfaddr = new javax.swing.JTextField();
        lbphoto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EDITING STUDENT PROFILE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 10, 310, 50);

        jLabel2.setText("ROLL NUMBER");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 140, 100, 30);
        getContentPane().add(lbrollno);
        lbrollno.setBounds(150, 130, 280, 40);

        jLABEL2.setText("EMAIL");
        getContentPane().add(jLABEL2);
        jLABEL2.setBounds(20, 190, 90, 40);

        jLabel4.setText("PHONE NUMBER");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 250, 110, 30);

        jLabel5.setText("ADDRESS");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 310, 90, 30);

        tfemail.setText("jTextField1");
        getContentPane().add(tfemail);
        tfemail.setBounds(150, 190, 320, 30);

        tfphno.setText("jTextField2");
        getContentPane().add(tfphno);
        tfphno.setBounds(150, 250, 320, 30);

        tfaddr.setText("jTextField3");
        getContentPane().add(tfaddr);
        tfaddr.setBounds(150, 300, 320, 30);

        lbphoto.setText("jLabel3");
        getContentPane().add(lbphoto);
        lbphoto.setBounds(500, 80, 120, 130);

        jButton1.setText("CHANGE PHOTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(500, 230, 120, 40);

        jButton2.setText("APPLY CHANGES");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(70, 380, 180, 60);

        jButton3.setText("CANCEL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(320, 380, 160, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String roll = this.lbrollno.getText();
        String email = this.tfemail.getText();
        String phno = this.tfphno.getText();
        String addr = this.tfaddr.getText();
      
        
        if (roll.equals(" ") || email.equals(" ") || phno.equals(" ") || addr.equals(" ")) {
            JOptionPane.showMessageDialog(this, "Please fill all fields...");

        } else {
            try {
                HttpResponse<String> httpResponse = null;
                if (file == null) {
                    httpResponse = Unirest.get("http://127.0.0.1:9595/studenteditprofile")
                            .queryString("rollno", lbrollno.getText())
                            .queryString("email", email)
                            .queryString("phno", phno)
                            .queryString("addr", addr)
                            .queryString("status", "false")
                            .asString();
                } else {
                    httpResponse = Unirest.post("http://127.0.0.1:9595/studenteditprofile")
                            .queryString("rollno", lbrollno.getText())
                            .queryString("email", email)
                            
                            .queryString("phno", phno)
                            .queryString("status", "true")
                            .field("photo", file)
                            .asString();
                }
                if (httpResponse.getStatus() == 200) {
                    String ans = httpResponse.getBody();
                    if (ans.equals("success")) {

                        JOptionPane.showMessageDialog(rootPane, "Changes added successfully");

                    } else if (ans.equals("fail")) {
                        JOptionPane.showMessageDialog(rootPane, "Student already exists");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
            java.util.logging.Logger.getLogger(student_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(student_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(student_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(student_profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //      new Editing_student_profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLABEL2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbphoto;
    private javax.swing.JLabel lbrollno;
    private javax.swing.JTextField tfaddr;
    private javax.swing.JTextField tfemail;
    private javax.swing.JTextField tfphno;
    // End of variables declaration//GEN-END:variables
}
