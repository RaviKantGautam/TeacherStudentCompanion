package teacherstudent;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class course extends javax.swing.JInternalFrame {

    public course() {
        initComponents();
        setSize(635, 406);
        //setLocationRelativeTo(null);
        setVisible(true);
        fetchdepartmentname();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void fetchdepartmentname() {

        try {
            HttpResponse<String> response = Unirest.get("http://127.0.0.1:9595/departmentnames")
                    .asString();
            String ans = response.getBody();
            StringTokenizer st = new StringTokenizer(ans, "^");
            while (st.hasMoreTokens()) {
                tcb5.addItem(st.nextToken());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfd2 = new javax.swing.JLabel();
        tfd4 = new javax.swing.JLabel();
        tfd6 = new javax.swing.JLabel();
        tcb5 = new javax.swing.JComboBox<>();
        tf3 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        btn8 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tfd2.setBackground(new java.awt.Color(255, 255, 0));
        tfd2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        tfd2.setForeground(new java.awt.Color(0, 153, 153));
        tfd2.setText("Department Name");
        getContentPane().add(tfd2);
        tfd2.setBounds(30, 80, 140, 40);

        tfd4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        tfd4.setForeground(new java.awt.Color(255, 0, 0));
        tfd4.setText("Course name");
        getContentPane().add(tfd4);
        tfd4.setBounds(30, 160, 110, 40);

        tfd6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        tfd6.setForeground(new java.awt.Color(0, 0, 255));
        tfd6.setText("Description");
        getContentPane().add(tfd6);
        tfd6.setBounds(40, 220, 90, 50);

        tcb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcb5ActionPerformed(evt);
            }
        });
        getContentPane().add(tcb5);
        tcb5.setBounds(200, 90, 390, 30);
        getContentPane().add(tf3);
        tf3.setBounds(200, 170, 390, 30);
        getContentPane().add(tf4);
        tf4.setBounds(200, 230, 390, 30);

        btn8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn8.setForeground(new java.awt.Color(204, 204, 0));
        btn8.setText("Add ");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        getContentPane().add(btn8);
        btn8.setBounds(210, 300, 180, 50);

        btn2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn2.setForeground(new java.awt.Color(102, 102, 0));
        btn2.setText("View course");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2);
        btn2.setBounds(420, 300, 180, 50);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COURSE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 20, 440, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tcb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcb5ActionPerformed

    }//GEN-LAST:event_tcb5ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        String dn = (String) tcb5.getSelectedItem();
        String cn = tf3.getText();
        String des = tf4.getText();
        if (dn.equals(" ") || cn.equals(" ") || des.equals(" ")) {
            JOptionPane.showMessageDialog(this, "Please fill all Fields...");
        } else {
            try {
                HttpResponse<String> response = Unirest.get("http://127.0.0.1:9595/addcourse")
                        .queryString("dn", (String) tcb5.getSelectedItem())
                        .queryString("cn", tf3.getText())
                        .queryString("des", tf4.getText())
                        .asString();
                String ans = response.getBody().trim();
                if(ans.equals("success")){
               JOptionPane.showMessageDialog(rootPane, ans);
                }
                else if(ans.equals("fail")){
                    JOptionPane.showMessageDialog(rootPane, ans);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btn8ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        managecourse obj = new managecourse();
    }//GEN-LAST:event_btn2ActionPerformed

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
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(course.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new course().setVisible(true);
            }
        }
        );

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> tcb5;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JLabel tfd2;
    private javax.swing.JLabel tfd4;
    private javax.swing.JLabel tfd6;
    // End of variables declaration//GEN-END:variables
}
