/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherstudent;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.xml.ws.Response;
import teacherstudent.Viewdepartment.DepartmentTableModel;

/**
 *
 * @author Lab-3_1
 */
public class managecourse extends javax.swing.JInternalFrame {
  CourseTableModel dtm;
    Response res;
    ArrayList<courseinfo> al = new ArrayList<courseinfo>();

    public managecourse() {
        initComponents();
         setSize(732, 479);
        dtm = new CourseTableModel();
        tb2.setModel(dtm);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Response res;
        setVisible(true);
        coursedepartment();

    }
     public void coursedepartment() {
        try {

            HttpResponse<String> httpResponse = Unirest.get("http://127.0.0.1:9595/coursedepartment")
                    .asString();

            String anws = httpResponse.getBody();
            System.out.println(anws);
            StringTokenizer st = new StringTokenizer(anws, "&*");

            System.out.println(anws);
            
            al.clear();
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                System.out.println(s + "=====");
                StringTokenizer st1 = new StringTokenizer(s, "^");

                String cn = st1.nextToken();
                String dn = st1.nextToken();
                String des = st1.nextToken();
               
                System.out.println(" ");

                al.add(new courseinfo(cn, dn, des));
            }
            dtm.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class CourseTableModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
              if (columnIndex == 0) {
                return al.get(rowIndex).cn;

            } else if (columnIndex == 1) {
                return al.get(rowIndex).dn;

            } else if (columnIndex == 2) {
                return al.get(rowIndex).des;

            }
            return "null";
        }
        }
        
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        btn4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Sitka Banner", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage courses");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(226, 11, 220, 40);

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 90, 620, 230);

        btn4.setText("Delete");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn4);
        btn4.setBounds(220, 340, 230, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed

        int index = tb2.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "please select atlast one row");

        } else {
            int r = JOptionPane.showConfirmDialog(this, "Are you sure you want to Delete?");
            if (r == JOptionPane.YES_OPTION) {
                String dn = al.get(index).dn;

                try {
                    HttpResponse<String> httpResponse = Unirest.get("http://127.0.0.1:9595/deletecourse")
                            .queryString("dn", dn)
                            .asString();

                    String ans = httpResponse.getBody();

                    if(ans.equals("success"))
                    {
                        JOptionPane.showMessageDialog(rootPane, "Course deleted");
                        coursedepartment();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }


       
    }//GEN-LAST:event_btn4ActionPerformed

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
            java.util.logging.Logger.getLogger(managecourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managecourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managecourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managecourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managecourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb2;
    // End of variables declaration//GEN-END:variables
}
