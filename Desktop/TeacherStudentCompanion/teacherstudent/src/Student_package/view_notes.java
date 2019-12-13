 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student_package;

import Teacher_Packages.studentinfo;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
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
import teacherstudent.View_student;

public class view_notes extends javax.swing.JFrame {

    String rollno, title, username, description, type, file, nid, datetime;
    ArrayList<notesinfo> al = new ArrayList<notesinfo>();
   viewnotesTableModel vtm;
   
    public view_notes(String rollno) throws UnirestException {
        initComponents();
     

        this.rollno = rollno;
        vtm = new viewnotesTableModel();
        jTable1.setModel((TableModel) vtm);
            fetchnotes();
            setSize(800,800);
            pb1.setVisible(false);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        jTable1.setRowHeight(100);
                    jTable1.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());
                    vtm.fireTableDataChanged();

    }

    public void fetchnotes() throws UnirestException {
        HttpResponse<String> httpresponse = Unirest.get("http://127.0.0.1:9595/viewnotes")
                .queryString("rollno", rollno)
                .asString();
        if (httpresponse.getStatus() == 200) {
            String ans = httpresponse.getBody();
            System.out.println(ans);
            StringTokenizer st = new StringTokenizer(ans, "^");
            while(st.hasMoreTokens())
            {
                String row = st.nextToken();
                StringTokenizer st1= new StringTokenizer(row,"!&");
         
            title = st1.nextToken();
            username = st1.nextToken();
            description = st1.nextToken();
            type = st1.nextToken();
            file = st1.nextToken();
            nid = st1.nextToken();
            datetime= st1.nextToken();
           
al.add(new notesinfo(title, username, description, type, file, nid,datetime));
            }
        }
        vtm.fireTableDataChanged();
    }
    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        ImageIcon icon = new ImageIcon("");
        BufferedImage bufferedImage, newimage;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            try {
                if ( al.get (row).tp.equals("image")){
                    bufferedImage = ImageIO.read(new File("src/pics/img"));
                newimage = resizephoto(bufferedImage, 100, 100);
                }
                else if( al.get (row).tp.equals("pdf")){
                    bufferedImage = ImageIO.read(new File("src/pics/download"));
                newimage = resizephoto(bufferedImage, 100, 100);
                }
                 else if( al.get (row).tp.equals("video")){
                    bufferedImage = ImageIO.read(new File("src/pics/image2"));
                newimage = resizephoto(bufferedImage, 100, 100);
                }
                 else if( al.get (row).tp.equals("audio")){
                    bufferedImage = ImageIO.read(new File("src/pics/images"));
                newimage = resizephoto(bufferedImage, 100, 100);
                }
                
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


    class viewnotesTableModel extends AbstractTableModel {

        String title[] = {"title", "description", "username", "type", "file", "datetime"};

        public String getColumnName(int i) {
            return title[i];
        }

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 6;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).tt;

            } else if (columnIndex == 1) {
                return al.get(rowIndex).user;

            } else if (columnIndex == 2) {
                return al.get(rowIndex).des;

            } else if (columnIndex == 3) {
                return al.get(rowIndex).tp;
            } else if (columnIndex == 4) {
                return al.get(rowIndex).f;
            } else if (columnIndex == 5) {
                return al.get(rowIndex).dt;
            }
            return "null";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jdown = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pb1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VIEW TABLE");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 20, 229, 46);

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
        jScrollPane1.setBounds(30, 90, 650, 300);

        jdown.setText("Downlaod");
        jdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdownActionPerformed(evt);
            }
        });
        getContentPane().add(jdown);
        jdown.setBounds(140, 420, 200, 50);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(400, 420, 180, 50);
        getContentPane().add(pb1);
        pb1.setBounds(10, 480, 700, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdownActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        if(i== -1 )
        {
            JOptionPane.showMessageDialog(rootPane,"Please Select the Row");
        }
        else
        {
          int ans=  JOptionPane.showConfirmDialog(rootPane, "Are You Sure you want to download?");
          if(ans == JOptionPane.YES_OPTION)
          {
          pb1.setVisible(true); 
            
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    HttpResponse<InputStream> httpresponse = Unirest.get("http://localhost:9595/GetResource/"+al.get(i).f).asBinary();
int index=al.get(i).f.lastIndexOf("/");
String name=al.get(i).f.substring(index+1);
                    //File Download Code
                    InputStream is = httpresponse.getBody();
                    FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + "/Downloads/VMM/"+name);

                    long contentlength = Integer.parseInt(httpresponse.getHeaders().getFirst("Content-Length"));
                    byte b[] = new byte[10000];
                    int r;
                    long count = 0;

                    while (true) {
                        r = is.read(b, 0, 10000);
                        fos.write(b, 0, r);
                        count = count + r;
                        int per = (int) (count * 100 / contentlength);
                        pb1.setValue(per);
                        pb1.setString(per + "%");
                        if (count == contentlength) {
                            break;
                        }
                    }

                    fos.close();
                    JOptionPane.showMessageDialog(rootPane,"File Downloaded....");

                } catch (Exception ex) {
                    ex.printStackTrace();

                }

            }
        }).start();
          }
        }
    }//GEN-LAST:event_jdownActionPerformed

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
            java.util.logging.Logger.getLogger(view_notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //  new view_notes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jdown;
    private javax.swing.JProgressBar pb1;
    // End of variables declaration//GEN-END:variables
}
