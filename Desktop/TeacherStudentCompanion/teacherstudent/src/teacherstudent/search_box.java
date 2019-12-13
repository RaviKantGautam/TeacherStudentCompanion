/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherstudent;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
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
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.xml.ws.Response;

/**
 *
 * @author Lab-3_1
 */
public class search_box extends javax.swing.JFrame {
    StudentTableModel ftm;
    Response res;
    ArrayList<studentinfo>al= new ArrayList<studentinfo>();
    int f = 0;
    /**
     * Creates new form search_box
     */
    public search_box() {
        initComponents();
        setSize(700,600);
        ftm = new StudentTableModel();
        jTable1.setModel((TableModel) ftm);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Response res;
        setVisible(true);
       jTable1.setRowHeight(100);
                   jTable1.getColumnModel().getColumn(7).setCellRenderer(new ImageRenderer());
                  ftm.fireTableDataChanged();

      
    }
     public void fetchstudents() {
        try {  String rollno = (String) jTextField1.getText();
        
al.clear();
            HttpResponse<String> httpResponse = Unirest.get("http://localhost:9595/searchstudentinfo").queryString("rollnumber",rollno).asString();
       
        String anws = httpResponse.getBody().trim();
            System.out.println(anws);
                StringTokenizer st1 = new StringTokenizer(anws, "#&%");

                 rollno = st1.nextToken();
               
                String em = st1.nextToken();
                            String addr = st1.nextToken();
                String phno = st1.nextToken();
                    
                String dept = st1.nextToken();
                 String cn = st1.nextToken();
                                 String sem = st1.nextToken();

                String photo = st1.nextToken();
                System.out.println(" ");

                al.add(new studentinfo(rollno, em,  phno, addr, sem, dept, cn,photo));
            
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
            System.out.println(al.get(row).photo);
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Please Enter the roll number for searching....");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 70, 340, 50);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(100, 130, 300, 30);

        jLabel2.setText("Search :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 130, 60, 30);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(420, 130, 120, 30);

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
        jScrollPane1.setBounds(20, 180, 590, 290);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Search Student");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 10, 630, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fetchstudents();
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
            java.util.logging.Logger.getLogger(search_box.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search_box.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search_box.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search_box.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search_box().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
