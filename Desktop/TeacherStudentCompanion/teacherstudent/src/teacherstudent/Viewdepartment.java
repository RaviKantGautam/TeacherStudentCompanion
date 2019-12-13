/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherstudent;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.xml.ws.Response;

/**
 *
 * @author Lab-3(11)
 */
public class Viewdepartment extends javax.swing.JInternalFrame {

    DepartmentTableModel dtm;
    Response res;
    ArrayList<departmentinfo> al = new ArrayList<departmentinfo>();

    public Viewdepartment() throws UnirestException {
        initComponents();
        setSize(659, 439);
      //  setLocationRelativeTo(null);
        dtm = new DepartmentTableModel();
        jt1.setModel(dtm);
        fetchdepartment();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Response res;
        setVisible(true);

    }

    public void fetchdepartment() {
        try {

            HttpResponse<String> httpResponse = Unirest.get("http://127.0.0.1:9595/fetchdepartment")
                    .asString();

            String anws = httpResponse.getBody();
            System.out.println(anws);
            StringTokenizer st = new StringTokenizer(anws, "^");

            System.out.println(anws);
            
            al.clear();
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                System.out.println(s + "=====");
                StringTokenizer st1 = new StringTokenizer(s, "#&%");

                String dn = st1.nextToken();
                String des = st1.nextToken();
                String hod = st1.nextToken();
                String em = st1.nextToken();
                String mob = st1.nextToken();

                System.out.println(" ");

                al.add(new departmentinfo(dn, des, hod, em, mob));
            }
            dtm.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class DepartmentTableModel extends AbstractTableModel {

        String title[] = {"Department Name", "Description", "Department Head", "Email", "Phone No"};

        @Override
        public int getRowCount() {

            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public String getColumnName(int column) {

            return title[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).dn;

            } else if (columnIndex == 1) {
                return al.get(rowIndex).des;

            } else if (columnIndex == 2) {
                return al.get(rowIndex).hod;

            } else if (columnIndex == 3) {
                return al.get(rowIndex).em;

            } else if (columnIndex == 4) {
                return al.get(rowIndex).mob;
            }
            return "null";
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTable();
        btn4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jt1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Department Name", "Description", "Department Head", "Email", "Phone Number"
            }
        ));
        jScrollPane1.setViewportView(jt1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 100, 610, 270);

        btn4.setText("Delete");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn4);
        btn4.setBounds(420, 390, 200, 70);

        jLabel1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Department");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 20, 280, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed

        int index = jt1.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "please select atlast one row");

        } else {
            int r = JOptionPane.showConfirmDialog(this, "Are you sure you want to Delete?");
            if (r == JOptionPane.YES_OPTION) {
                String dn = al.get(index).dn;

                try {
                    HttpResponse<String> httpResponse = Unirest.get("http://127.0.0.1:9595/deletedepartment")
                            .queryString("dn", dn)
                            .asString();

                    String ans = httpResponse.getBody();

                    if(ans.equals("success"))
                    {
                        JOptionPane.showMessageDialog(rootPane, "Department deletd");
                        fetchdepartment();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }


    }//GEN-LAST:event_btn4ActionPerformed

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
            java.util.logging.Logger.getLogger(Viewdepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viewdepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viewdepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viewdepartment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Viewdepartment().setVisible(true);
                } catch (UnirestException ex) {
                    Logger.getLogger(Viewdepartment.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt1;
    // End of variables declaration//GEN-END:variables
}
