package teacherstudent;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class addFaculty extends javax.swing.JInternalFrame {
String photo;
    int f = 0;
File file;
    public addFaculty() {
        
        initComponents();
        setSize(783, 609);
      //  setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fetchDepartments();
      

    }

    public void fetchDepartments() {

        try {
            HttpResponse<String> response = Unirest.get("http://127.0.0.1:9595/departmentnames")
                    .asString();
            String ans = response.getBody();
            StringTokenizer st = new StringTokenizer(ans, "^");
            while (st.hasMoreTokens()) {
                cb1.addItem(st.nextToken());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    
//     try {
//                URL url = new URL("http://localhost:9595/GetResource/" + photo);
//                Image img = ImageIO.read(url);
//                lb5.setIcon(new ImageIcon(img.getScaledInstance(lb5.getWidth(), lb5.getHeight(), Image.SCALE_SMOOTH)));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
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
        cb2 = new javax.swing.JComboBox<>();
        lb5 = new javax.swing.JLabel();
        bt1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        tf2 = new javax.swing.JTextField();
        tf5 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        tf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf6 = new javax.swing.JTextField();
        bt2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("    Add Faculty");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 10, 340, 60);

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 100, 100, 40);

        jLabel5.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("Department Name");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 160, 130, 40);

        jLabel6.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("Course Name");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 220, 100, 40);

        jLabel7.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setText("Email");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 280, 110, 40);

        jLabel8.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 153));
        jLabel8.setText("Qualifications");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 340, 100, 20);

        cb2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb2ItemStateChanged(evt);
            }
        });
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });
        getContentPane().add(cb2);
        cb2.setBounds(150, 220, 400, 30);
        getContentPane().add(lb5);
        lb5.setBounds(600, 20, 130, 130);

        bt1.setText("Browse");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(660, 170, 90, 30);

        jLabel11.setText("Photo");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(570, 170, 70, 20);

        cb1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb1ItemStateChanged(evt);
            }
        });
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        getContentPane().add(cb1);
        cb1.setBounds(150, 160, 400, 30);

        tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf2ActionPerformed(evt);
            }
        });
        getContentPane().add(tf2);
        tf2.setBounds(150, 280, 400, 30);
        getContentPane().add(tf5);
        tf5.setBounds(150, 440, 400, 30);
        getContentPane().add(tf4);
        tf4.setBounds(150, 390, 400, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Experience");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 390, 120, 30);

        jLabel12.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 153));
        jLabel12.setText("Phone");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 440, 70, 30);
        getContentPane().add(tf3);
        tf3.setBounds(150, 340, 400, 30);

        tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActionPerformed(evt);
            }
        });
        getContentPane().add(tf);
        tf.setBounds(150, 100, 400, 30);

        jLabel9.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 153));
        jLabel9.setText("Address");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 480, 70, 30);
        getContentPane().add(tf6);
        tf6.setBounds(150, 490, 400, 30);

        bt2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        bt2.setText("Add");
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });
        getContentPane().add(bt2);
        bt2.setBounds(160, 530, 150, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(380, 530, 150, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf2ActionPerformed

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_cb1ActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb2ActionPerformed

    private void tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        String user = tf.getText();
        String em = tf2.getText();
        String ph = tf5.getText();
        String addr = tf6.getText();
        String qul = tf3.getText();
        String exp = tf4.getText();
        String dn = (String) cb1.getSelectedItem();
        String cn = (String) cb2.getSelectedItem();
        
        if (user.equals(" ") || em.equals(" ") || ph.equals(" ") || addr.equals(" ") || qul.equals(" ") || exp.equals(" ") || dn.equals(" ") || cn.equals(" ")) {
            JOptionPane.showMessageDialog(this, "field must not be empty");
        } else {
            try {
                HttpResponse<String> response = Unirest.post("http://127.0.0.1:9595/addFaculty")
                        .queryString("user", tf.getText())
                        
                        .queryString("em", tf2.getText())
                        .queryString("ph", tf5.getText())
                        .queryString("addr", tf6.getText())
                        .queryString("qul", tf3.getText())
                        .queryString("exp", tf4.getText())
                        .queryString("dn", cb1.getSelectedItem())
                        .queryString("cn", cb2.getSelectedItem())
                        .field("photo", file)
                        .asString();
                String ans = response.getBody();
                System.out.println(ans);

                if (ans.equals("success")) {
                    tf.setText("");
                  
                    tf2.setText("");
                    tf5.setText("");
                    tf6.setText("");
                    tf3.setText("");
                    tf4.setText("");
                    lb5.setIcon(null);

                    JOptionPane.showMessageDialog(this, "Faculty Added Successfully");

                } else if (ans.equals("fail")) {
                    JOptionPane.showMessageDialog(this, "Faculty Already Exists");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_bt2ActionPerformed

    private void cb1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb1ItemStateChanged
//        if(f==0){
//            f=1;
//            new Thread (new Runnable() {
//                @Override
//                public void run() {
//                HttpResponse<String> httpResponse=null;
//                    try {
//                         httpResponse = Unirest.get("http://127.0.0.1:9595/departmentname")
//                .queryString("user",cb1.getSelectedItem().toString())
//                                 .asString();
//                        
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    if(httpResponse.getStatus()==200){
//                        String ans = (String) httpResponse.getBody();
//                        System.out.println(ans);
//                        StringTokenizer st = new StringTokenizer(ans,"^");
//                        
//                        cb2.removeAllItems();
//                        cb2.removeAll();
//                        
//                        while(st.hasMoreTokens()){
//                            cb2.addItem(st.nextToken());
//                        }
//                        
//                        f=0;
//                    }
//                }
//            }).start();
//        }
        String dept = (String) cb1.getSelectedItem();
        try {
            cb2.removeAllItems();
            HttpResponse<String> httpResponse = Unirest.get("http://localhost:9595/fetchcoursenames").queryString("dept", dept).asString();

            String ans = httpResponse.getBody();
            System.out.println(ans);
            StringTokenizer st = new StringTokenizer(ans, "^");

            while (st.hasMoreTokens()) {
                cb2.addItem(st.nextToken());

            }
        } catch (UnirestException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cb1ItemStateChanged

    private void cb2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb2ItemStateChanged
        if (f == 0) {
            f = 1;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpResponse<String> httpResponse = null;
                    try {
                        httpResponse = Unirest.get("http://127.0.0.1:9595//courses")
                                .queryString("user", cb1.getSelectedItem().toString())
                                .asString();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (httpResponse.getStatus() == 200) {
                        String ans = (String) httpResponse.getBody();
                        System.out.println(ans);
                        StringTokenizer st = new StringTokenizer(ans, "^");

                        cb2.removeAllItems();
                        cb2.removeAll();

                        while (st.hasMoreTokens()) {
                            cb2.addItem(st.nextToken());
                        }

                        f = 0;
                    }
                }
            }).start();
        }


    }//GEN-LAST:event_cb2ItemStateChanged

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        JFileChooser chooser = new JFileChooser("D:\\");
        int r = chooser.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
           file = chooser.getSelectedFile();
            try {
                Image img = ImageIO.read(file);
                //Icon icon = new Icone
                ImageIcon icon = new ImageIcon(img.getScaledInstance(lb5.getWidth(), lb5.getHeight(), Image.SCALE_SMOOTH));
                lb5.setIcon(icon);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("File Send");
        }
    }//GEN-LAST:event_bt1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        View_Faculty obj = new View_Faculty();
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
            java.util.logging.Logger.getLogger(addFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addFaculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addFaculty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb5;
    private javax.swing.JTextField tf;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JTextField tf6;
    // End of variables declaration//GEN-END:variables
}
