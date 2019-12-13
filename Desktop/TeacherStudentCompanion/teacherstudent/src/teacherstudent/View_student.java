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
public class View_student extends javax.swing.JInternalFrame {
     StudentTableModel ftm;
    Response res;
    ArrayList<studentinfo>al= new ArrayList<studentinfo>();
    int f = 0;


    /**
     * Creates new form View_student0+
     */
    public View_student() {
        initComponents();
        setSize(670, 505);
        //setLocationRelativeTo(null);
       
        ftm = new StudentTableModel();
        jTable1.setModel((TableModel) ftm);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       fetchdepartment();
        Response res;
        setVisible(true);
        jTable1.setRowHeight(100);
                    jTable1.getColumnModel().getColumn(7).setCellRenderer(new ImageRenderer());
                    ftm.fireTableDataChanged();

    }
public void fetchdepartment()
{
    try {
            HttpResponse<String> response = Unirest.get("http://127.0.0.1:9595/departmentnames")
                    .asString();
            String ans = response.getBody();
            StringTokenizer st = new StringTokenizer(ans, "^");
            while (st.hasMoreTokens()) {
                jComboBox1.addItem(st.nextToken());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
}
    public void fetchstudents() {
        try {  String dept = (String) jComboBox1.getSelectedItem();
        String cn = (String) jComboBox2.getSelectedItem();

            HttpResponse<String> httpResponse = Unirest.get("http://localhost:9595/fetchstudentinfo").queryString("dept",dept).queryString("cn",cn).asString();
       
        String anws = httpResponse.getBody().trim();
            System.out.println(anws);
            StringTokenizer st = new StringTokenizer(anws, "^");

            System.out.println(anws);

            al.clear();
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                System.out.println(s + "=====");
                StringTokenizer st1 = new StringTokenizer(s, "#&%");

                String rollno = st1.nextToken();
               
                String em = st1.nextToken();
                            String addr = st1.nextToken();
                String phno = st1.nextToken();
                    
                 dept = st1.nextToken();
                 cn = st1.nextToken();
                                 String sem = st1.nextToken();

                String photo = st1.nextToken();
                System.out.println(" ");

                al.add(new studentinfo(rollno, em,  phno, addr, sem, dept, cn,photo));
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



    class StudentTableModel extends AbstractTableModel {
        String title[]={"Rollno","Email","Phoneno","Address","Department","Course","Semester","Photo"};
public String getColumnName(int i)
{
    return title[i];
}
        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 8;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).rollno;

            }  else if (columnIndex == 1) {
                return al.get(rowIndex).em;

            } else if (columnIndex == 2) {
                return al.get(rowIndex).phno;

            } else if (columnIndex == 3) {
                return al.get(rowIndex).addr;
            }
            else if (columnIndex == 4) {
                return al.get(rowIndex).dn;

            } else if (columnIndex == 5) {
                return al.get(rowIndex).cn;

            }  else if (columnIndex == 6) {
                return al.get(rowIndex).sem;
            }
             else if (columnIndex == 7) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("DEPARTMENT NAME");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 60, 130, 30);

        jLabel2.setText("COURSE NAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 120, 30);

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(180, 60, 360, 30);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(180, 110, 360, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 180, 650, 230);

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(580, 110, 90, 30);

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(310, 430, 160, 40);

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(490, 430, 170, 40);

        jButton4.setText("Search Individual Student");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(30, 430, 260, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            fetchstudents();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        System.out.println("hello");
        String dn = (String) jComboBox1.getSelectedItem();
        System.out.println(dn);
        try {
            jComboBox2.removeAllItems();
            HttpResponse<String> httpResponse = Unirest.get("http://localhost:9595/fetchcoursenames").queryString("dept", dn).asString();

            String ans = httpResponse.getBody();
            System.out.println(ans);
            StringTokenizer st = new StringTokenizer(ans, "^");

            while (st.hasMoreTokens()) {
                jComboBox2.addItem(st.nextToken());

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                int index = jTable1.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "please select atlast one row");

        } else {
            int r = JOptionPane.showConfirmDialog(this, "Are you sure you want to Delete?");
            if (r == JOptionPane.YES_OPTION) {
                String rollno = al.get(index).rollno;

                try {
                    HttpResponse<String> httpResponse = Unirest.get("http://127.0.0.1:9595/deletestudent")
                            .queryString("rollnumber", rollno)
                            .asString();

                    String ans = httpResponse.getBody();

                    if(ans.equals("success"))
                    {
                        JOptionPane.showMessageDialog(rootPane, "Student deleted");
                        fetchstudents();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
                                      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        search_box obj = new search_box();
            obj.setVisible(true);
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
            java.util.logging.Logger.getLogger(View_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
