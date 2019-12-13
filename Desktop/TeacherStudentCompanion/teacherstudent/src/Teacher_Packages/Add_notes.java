/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher_Packages;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.xml.ws.Response;

public class Add_notes extends javax.swing.JFrame {

    File file;
    String user;
    StudentTableModel ftm;
    Response res;
    ArrayList<studentinfo> al = new ArrayList<studentinfo>();
    int f = 0;
    String dept, course;
String type="";
    public Add_notes(String username, String course,String dept) {
        initComponents();
        setSize(887, 605);
        setVisible(true);
        ftm = new StudentTableModel();
        jTable2.setModel(ftm);
        this.dept = dept;
        this.course = course;
        this.user = username;
        Response res;
        setVisible(true);
        ftm.fireTableDataChanged();
        fetchstudents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public void fetchstudents() {
        try {

            HttpResponse<String> httpResponse = Unirest.get("http://localhost:9595/fetchstudentinfo").queryString("dept", dept).queryString("cn", course).asString();

            String anws = httpResponse.getBody().trim();
            System.out.println(anws+"-----");
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

                String cn = st1.nextToken();
                String sem = st1.nextToken();

                String photo = st1.nextToken();
                System.out.println(" ");

                al.add(new studentinfo(rollno, em, phno, addr, sem, dept, cn, photo, false));

            }
            ftm.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class StudentTableModel extends AbstractTableModel {

        String title[] = {"Rollno", "Email", "Phoneno", "Address", "Semester","select"};

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
                return al.get(rowIndex).rollno;

            } else if (columnIndex == 1) {
                return al.get(rowIndex).em;

            } else if (columnIndex == 2) {
                return al.get(rowIndex).phno;

            } else if (columnIndex == 3) {
                return al.get(rowIndex).addr;
            } else if (columnIndex == 4) {
                return al.get(rowIndex).sem;
            } else if (columnIndex == 5) {
                return al.get(rowIndex).ischecked;
            }
            return "null";
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return String.class;
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return String.class;
                case 4:
                    return String.class;
                case 5:
                    return Boolean.class;
                default:
                    return null;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 5;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (columnIndex == 5) {
                al.get(rowIndex).ischecked = (Boolean) aValue;
                fireTableCellUpdated(rowIndex, columnIndex);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jtitle = new javax.swing.JTextField();
        rb4 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jdes = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jfile = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("TITLE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 70, 50, 30);

        buttonGroup1.add(rb1);
        rb1.setText("Audio");
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });
        getContentPane().add(rb1);
        rb1.setBounds(120, 140, 80, 23);

        buttonGroup1.add(rb2);
        rb2.setText("Pdf");
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });
        getContentPane().add(rb2);
        rb2.setBounds(200, 140, 60, 23);

        buttonGroup1.add(rb3);
        rb3.setText("Video");
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });
        getContentPane().add(rb3);
        rb3.setBounds(270, 140, 80, 23);

        jLabel2.setText("TYPE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 130, 90, 39);

        jButton1.setText("BROWSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(450, 190, 140, 40);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 310, 700, 170);

        jtitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtitleActionPerformed(evt);
            }
        });
        getContentPane().add(jtitle);
        jtitle.setBounds(80, 70, 160, 40);

        buttonGroup1.add(rb4);
        rb4.setText("Image");
        getContentPane().add(rb4);
        rb4.setBounds(360, 140, 100, 23);

        jLabel4.setText("DESCRIPTION");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(290, 60, 70, 30);

        jdes.setColumns(20);
        jdes.setRows(5);
        jScrollPane3.setViewportView(jdes);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(370, 60, 300, 60);

        jLabel5.setText("CHOOSE FILE");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 190, 80, 30);

        jLabel6.setText("                                                        ADD NOTES");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(140, 4, 430, 40);
        getContentPane().add(jfile);
        jfile.setBounds(120, 190, 290, 30);

        jButton2.setText("Select All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(290, 500, 150, 40);

        jButton3.setText("Deselect All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(490, 500, 150, 40);

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(60, 500, 160, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb1ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb2ActionPerformed

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb3ActionPerformed

    private void jtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtitleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            jTable2.getModel().setValueAt(Boolean.TRUE, i, 5);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String tt = jtitle.getText();
        String desc = jdes.getText();
     
        
       

        if (tt.equals(" ") || desc.equals(" ")|| file.equals(" ")) {
            JOptionPane.showMessageDialog(this, "field must not be empty");
        }
        else{
            String studentdata="";
            for (int i = 0; i < al.size(); i++) {
                if(al.get(i).ischecked){
                    studentdata=studentdata+al.get(i).rollno+"^";
                    
                }
                
            } 
            try {
              HttpResponse<String>  response = Unirest.post("http://127.0.0.1:9595/addnotes")
                        .queryString("username",user)
                        .queryString("description",desc)
                        .queryString("type",type)
                        .queryString("title",tt)
                      .queryString("studentdata",studentdata)
                         .field("file",file)
                        .asString();
                
                
                String ans = response.getBody();
                System.out.println(ans);
                if(ans.equals("success")){
                    jtitle.setText("");
                    jdes.setText("");
                    JOptionPane.showMessageDialog(rootPane, "notes added sussfully");
                    
                }else if(ans.equals("fail")){
                    JOptionPane.showMessageDialog(rootPane, "notes not added sucesfully");
                }
            } catch (UnirestException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser("D:\\");
        if (rb4.isSelected()) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("images", "jpg", "jpeg", "png");
            chooser.setFileFilter(filter);
            type="images";
        } else if (rb1.isSelected()) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("audio", "mp3");
            chooser.setFileFilter(filter);
            type="audio";
        } else if (rb2.isSelected()) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("pdf", "pdf");
            chooser.setFileFilter(filter);
            type="pdf";
        } else if (rb3.isSelected()) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("video", "mp4", "mkv");
            chooser.setFileFilter(filter);
            type="video";
        }
         int r = chooser.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            String path = file.getPath();
            jfile.setText(path);
            System.out.println("File Send");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        for (int i = 0; i < jTable2.getRowCount(); i++) {
            jTable2.getModel().setValueAt(Boolean.FALSE, i, 5);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Add_notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //  new Add_notes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jdes;
    private javax.swing.JLabel jfile;
    private javax.swing.JTextField jtitle;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    // End of variables declaration//GEN-END:variables
}
