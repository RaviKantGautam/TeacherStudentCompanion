/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherstudent;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.xml.ws.Response;

/**
 *
 * @author Lab-3_1
 */
public class View_Faculty extends javax.swing.JInternalFrame {

    FacultyTableModel ftm;
    Response res;
    ArrayList<facultyinfo> al = new ArrayList<facultyinfo>();
    int f = 0;

    /**
     * Creates new form View_Faculty
     */
    public View_Faculty() {
        initComponents();
        setSize(725, 535);
       
        
        ftm = new FacultyTableModel();
        tf4.setModel((TableModel) ftm);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       fetchDepartment();
        Response res;
        setVisible(true);
        
       tf4.setRowHeight(100);
                    tf4.getColumnModel().getColumn(8).setCellRenderer(new ImageRenderer());
                    ftm.fireTableDataChanged(); 
        

    }
public void fetchDepartment()
{
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
}
    public void fetchFaculty() {
        try {  String dept = (String) cb1.getSelectedItem();
        String course = (String) cb2.getSelectedItem();

            HttpResponse<String> httpResponse = Unirest.get("http://localhost:9595/fetchFaculty").queryString("dept",dept).queryString("course",course).asString();
       
        String anws = httpResponse.getBody().trim();
            System.out.println(anws);
            StringTokenizer st = new StringTokenizer(anws, "^");

            System.out.println(anws);

            al.clear();
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                System.out.println(s + "=====");
                StringTokenizer st1 = new StringTokenizer(s, "#&%");

                String user = st1.nextToken();
               
                String em = st1.nextToken();
            
                String addr = st1.nextToken();
                String qul = st1.nextToken();
                String exp = st1.nextToken();
                    String ph = st1.nextToken();
                String dn = st1.nextToken();
                String cn = st1.nextToken();
String photo = st1.nextToken();
                System.out.println(" ");

                al.add(new facultyinfo(user, em,  addr, qul, exp,ph, dn, cn,photo));
            }
            ftm.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        ImageIcon icon = new ImageIcon("");
        BufferedImage bufferedImage, newimage;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            try {
                URL url = new URL("http://localhost:9595/GetResource/" + al.get(row).photo);
                bufferedImage = ImageIO.read(url);
                newimage = resizephoto(bufferedImage, 100, 100);
            } catch (Exception ex) {
             ex.printStackTrace();
            }
            icon = new ImageIcon(newimage);
            lbl.setIcon(icon);
            lbl.setBounds(0, 0, 100, 100);
            return lbl;
        }
    }

    BufferedImage resizephoto(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    class FacultyTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 9;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).user;

            }  else if (columnIndex == 1) {
                return al.get(rowIndex).em;

            } else if (columnIndex == 2) {
                return al.get(rowIndex).ph;

            } else if (columnIndex == 3) {
                return al.get(rowIndex).addr;
            }
            else if (columnIndex == 4) {
                return al.get(rowIndex).qul;

            } else if (columnIndex == 5) {
                return al.get(rowIndex).exp;

            } else if (columnIndex == 6) {
                return al.get(rowIndex).dn;

            } else if (columnIndex == 7) {
                return al.get(rowIndex).cn;
            }
             else if (columnIndex == 8) {
                return al.get(rowIndex).photo;
            }
            return "null";
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

        cb1 = new javax.swing.JComboBox<>();
        cb2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf4 = new javax.swing.JTable();
        btn3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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
        cb1.setBounds(160, 100, 370, 40);

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
        cb2.setBounds(160, 150, 370, 40);

        jLabel1.setText("Select Department");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 100, 110, 40);

        jLabel2.setText("Select Course");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 150, 110, 40);

        tf4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tf4);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 200, 660, 220);

        btn3.setText("Delete");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3);
        btn3.setBounds(200, 450, 240, 60);

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(570, 110, 120, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FACULTY");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(90, 10, 530, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb1ItemStateChanged
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

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        
    }//GEN-LAST:event_cb1ActionPerformed

    private void cb2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb2ItemStateChanged
//         if (f == 0) {
//            f = 1;
//            new Thread(new Runnable() {
//                @Override
//        public void run() {
//                    HttpResponse<String> httpResponse = null;
//                    try {
//                        httpResponse = Unirest.get("http://127.0.0.1:9595/courses")
//                                .queryString("user", cb1.getSelectedItem().toString())
//                                .asString();
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    if (httpResponse.getStatus() == 200) {
//                        String ans = (String) httpResponse.getBody();
//                        System.out.println(ans);
//                        StringTokenizer st = new StringTokenizer(ans, "^");
//
//                        cb2.removeAllItems();
//                        cb2.removeAll();
//
//                        while (st.hasMoreTokens()) {
//                            cb2.addItem(st.nextToken());
//                        }
//
//                        f = 0;
//                    }
//                }
//            }).start();
//
//         }
    }//GEN-LAST:event_cb2ItemStateChanged

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        int index = tf4.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "please select atlast one row");

        } else {
            int r = JOptionPane.showConfirmDialog(this, "Are you sure you want to Delete?");
            if (r == JOptionPane.YES_OPTION) {
                String user = al.get(index).user;

                try {
                    HttpResponse<String> httpResponse = Unirest.get("http://127.0.0.1:9595/deleteFaculty")
                            .queryString("user", user)
                            .asString();

                    String ans = httpResponse.getBody();

                    if(ans.equals("success"))
                    {
                        JOptionPane.showMessageDialog(rootPane, "Faculty deleted");
                        fetchFaculty();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      
        
        fetchFaculty();
        
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
            java.util.logging.Logger.getLogger(View_Faculty.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Faculty.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Faculty.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Faculty.class
.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Faculty().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn3;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JComboBox<String> cb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tf4;
    // End of variables declaration//GEN-END:variables
}
