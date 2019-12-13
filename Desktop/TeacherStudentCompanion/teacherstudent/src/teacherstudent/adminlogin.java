package teacherstudent;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Color;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class adminlogin extends javax.swing.JFrame {

    public adminlogin() {
      
        initComponents();
        try {
            setSize(680, 500);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           lbphoto.setBounds(0, 0, getWidth(), getHeight());
           Image img1 = ImageIO.read(getClass().getResource("/pics/school-management.jpg"));
           lbphoto.setIcon(new javax.swing.ImageIcon(img1.getScaledInstance(lbphoto.getWidth(),lbphoto.getHeight(), Image.SCALE_SMOOTH)));
            Image img = ImageIO.read(getClass().getResource("/pics/login-icon-png-27.png"));
            lbicon.setIcon(new javax.swing.ImageIcon(img.getScaledInstance(lbicon.getWidth(),lbicon.getHeight(), Image.SCALE_SMOOTH)));
            setVisible(true);
            jPanel1.setBackground(new Color(0,0,0,200));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        btn = new javax.swing.JButton();
        tf2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lbicon = new javax.swing.JLabel();
        lbphoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 180, 110, 40);

        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(420, 140, 210, 30);

        btn.setFont(new java.awt.Font("Gabriola", 2, 24)); // NOI18N
        btn.setText("Submit");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        getContentPane().add(btn);
        btn.setBounds(310, 260, 120, 40);
        getContentPane().add(tf2);
        tf2.setBounds(420, 190, 210, 30);

        jButton1.setFont(new java.awt.Font("Gabriola", 2, 24)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(490, 260, 120, 40);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Sitka Banner", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin Login");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(230, 20, 230, 50);

        lb1.setBackground(new java.awt.Color(255, 255, 0));
        lb1.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        lb1.setForeground(new java.awt.Color(255, 255, 255));
        lb1.setText("Username");
        lb1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(lb1);
        lb1.setBounds(260, 130, 120, 40);

        lbicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/800px_COLOURBOX25066784.jpg"))); // NOI18N
        lbicon.setText("jLabel3");
        jPanel1.add(lbicon);
        lbicon.setBounds(20, 120, 200, 150);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 10, 660, 350);

        lbphoto.setText("jLabel3");
        getContentPane().add(lbphoto);
        lbphoto.setBounds(0, 10, 690, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed

    }//GEN-LAST:event_tf1ActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed

        try {
            HttpResponse<String> response = Unirest.get("http://127.0.0.1:9595/adminlogin")
                    .queryString("user", tf1.getText())
                    .queryString("pass", tf2.getText())
                    .asString();
            String ans = response.getBody();
            System.out.println(ans);

            if (ans.equals("success")) {

                home obj = new home(tf1.getText());
                

                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username/password");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(adminlogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminlogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminlogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminlogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new adminlogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lbicon;
    private javax.swing.JLabel lbphoto;
    private javax.swing.JTextField tf1;
    private javax.swing.JPasswordField tf2;
    // End of variables declaration//GEN-END:variables
}
