
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student_package;

import Teacher_Packages.Editing_profile;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Image;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Lab-3_1
 */
public class Student_Home extends javax.swing.JFrame {

    String photo, rollno, stname, dept, cour, em, phno, addr;

    /**
     * Creates new form Student_Home
     */
    public Student_Home(String rollno) throws UnirestException {
        initComponents();
        setSize(685, 586);
        this.rollno = rollno;
        jrollno.setText("welcome" + rollno);
        getStudentInfo();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
         try {
            URL url = new URL("http://localhost:9595/GetResource/" + photo);
            Image img=ImageIO.read(url);
            jphoto.setIcon(new ImageIcon(img.getScaledInstance(jphoto.getWidth(), jphoto.getHeight(), Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    

    public void getStudentInfo() throws UnirestException {
        HttpResponse<String> httpresponse = Unirest.get("http://127.0.0.1:9595/getstudentinfo")
                .queryString("rollnumber", rollno)
                .asString();
        if (httpresponse.getStatus() == 200) {
            String ans = httpresponse.getBody();

            StringTokenizer st1 = new StringTokenizer(ans, "#&%");

            rollno = st1.nextToken();
          
            dept = st1.nextToken();
            cour = st1.nextToken();
            em = st1.nextToken();
            phno = st1.nextToken();
            addr = st1.nextToken();

            photo = st1.nextToken();
            System.out.println(photo);
            try {
                URL url = new URL("http://localhost:9595/GetResource/" + photo);
                jphoto.setIcon(new ImageIcon(url));
            } catch (Exception e) {
                e.printStackTrace();
            }

            
            jrollno.setText(rollno);
            jdepart.setText(dept);
            jcour.setText(cour);
            jemail.setText(em);
            jphno.setText(phno);
            jaddr.setText(addr);

            setVisible(true);

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

        jPanel1 = new javax.swing.JPanel();
        jphoto = new javax.swing.JLabel();
        jdepart = new javax.swing.JLabel();
        jcour = new javax.swing.JLabel();
        jemail = new javax.swing.JLabel();
        jphno = new javax.swing.JLabel();
        jaddr = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jrollno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jphoto.setText("PHOTO");
        jPanel1.add(jphoto);
        jphoto.setBounds(10, 20, 150, 160);
        jPanel1.add(jdepart);
        jdepart.setBounds(390, 20, 150, 30);
        jPanel1.add(jcour);
        jcour.setBounds(380, 80, 150, 40);
        jPanel1.add(jemail);
        jemail.setBounds(390, 140, 130, 30);
        jPanel1.add(jphno);
        jphno.setBounds(380, 200, 150, 40);
        jPanel1.add(jaddr);
        jaddr.setBounds(380, 250, 160, 40);

        jButton1.setText("EDITING PROFILE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(20, 260, 170, 40);

        jButton2.setText("CHANGE PASSWORD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(20, 320, 170, 40);
        jPanel1.add(jrollno);
        jrollno.setBounds(110, 210, 120, 30);

        jLabel2.setText("Address:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(250, 250, 80, 40);

        jLabel3.setText("Department name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(250, 20, 120, 40);

        jLabel4.setText("Course name:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(250, 80, 120, 30);

        jLabel5.setText("Email:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(250, 140, 100, 30);

        jLabel6.setText("Phone number:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(250, 200, 80, 40);

        jLabel7.setText("Roll number:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 210, 80, 30);

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(410, 320, 140, 40);

        jButton4.setText("VIEW TABLE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(220, 320, 140, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 120, 590, 420);

        jLabel1.setFont(new java.awt.Font("Sitka Small", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STUDENT  HOME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 20, 600, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        studentchangepassword obj = new studentchangepassword(rollno);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        student_profile obj = new student_profile(rollno, em, phno, addr, photo);
        obj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            view_notes obj = new view_notes(rollno);
        obj.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Student_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Student_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jaddr;
    private javax.swing.JLabel jcour;
    private javax.swing.JLabel jdepart;
    private javax.swing.JLabel jemail;
    private javax.swing.JLabel jphno;
    private javax.swing.JLabel jphoto;
    private javax.swing.JLabel jrollno;
    // End of variables declaration//GEN-END:variables

}
