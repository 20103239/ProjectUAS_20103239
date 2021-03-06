/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas1;

import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class fmhs extends javax.swing.JFrame {
 private DefaultTableModel model;
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    dbkoneksi cnn = new dbkoneksi();
    loadIMG img = new loadIMG();
    
    public fmhs() {
        initComponents();
        this.cmdBATAL.setVisible(false);
        this.initTable();
        this.getdata();
        this.cmdCLOSE.setEnabled(true);
    }
    private void initTable(){
        model = new DefaultTableModel();
        tMHS.setModel(model);
        model.addColumn("NIM");
        model.addColumn("NAMA MAHASISWA");
        model.addColumn("TGL LAHIR");
        model.addColumn("JURUSAN");
        model.addColumn("JENIS KELAMIN");
    }
     private void getdata(){
        String sql = "SELECT NIM, NAMA, JURUSAN, TGL_LAHIR, JK FROM mahasiswa";
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            this.tampildata(sql);
            while(this.rs.next()){
                Object[] obj = new Object[5];
                obj[0] = this.rs.getString("NIM");
                obj[1] = this.rs.getString("NAMA");
                obj[2] = this.rs.getString("JURUSAN");
                String buttonGroup1 = this.rs.getString("JENIS KELAMIN");
                obj[4] = this.rs.getDate("TGL_LAHIR");
                if(Ljk.equals("L")){
                    obj[3] = "Laki-laki";
                } else {
                    obj[3] = "Perempuan";
                }
                model.addRow(obj);
            }
            stmt.close();
            cnn.koneksi().close();
        }catch(Exception err){
        
        }
    }
     private void tampildata(String sql){
        try{
            Statement stmt = cnn.koneksi().createStatement();
            this.rs = stmt.executeQuery(sql);
        }catch(Exception e){
            System.out.println("Terjadi kendala pada query");
        }
    }
     private boolean updatedata(String sql){
        boolean hsl = false;
        try{
            Statement stmt = cnn.koneksi().createStatement();
            stmt.executeUpdate(sql);
            hsl = true;
        }catch(Exception e){
            System.out.println("Terjadi kendala pada query");
            JOptionPane.showMessageDialog(null, "Terjadi kendala pada proses Store/Update Data");
        }
        return hsl;
    }
    private void simpandataform(){
        String NIM = this.txNIM.getText();
        String NAMA = this.txNAMA.getText();
        String JURUSAN = this.txJUR.getSelectedItem().toString();
        String JK = "P";
        if(this.txJKL.isSelected()){
            JK = "L";
        }
        String TGL_LAHIR = this.txTGL.getText();
        String sql = "INSERT INTO mahasiswa(NIM, NAMA, JURUSAN, JK, TGL_LAHIR) VALUES('"+NIM+"', '"+NAMA+"', '"+JURUSAN+"', '"+JK+"', '"+TGL_LAHIR+"')";
        if(this.updatedata(sql)){
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }
        this.getdata();
        this.cmdSIMPAN.setEnabled(false);
        this.cmdBATAL.setVisible(false);
    }
    private void updatedataform(){
        String NIM = this.txNIM.getText();
        String NAMA = this.txNAMA.getText();
        String JURUSAN = this.txJUR.getSelectedItem().toString();
        String JK = "P";
        if(this.txJKP.isSelected()){
            JK = "L";
        }
        String TGL_LAHIR = this.txTGL.getText();
         String sql = "UPDATE mahasiswa SET NIM= '"+NIM+"', NAMA= '"+NAMA+"', JURUSAN= '"+JURUSAN+"', JK= '"+JK+"', TGL_LAHIR= '"+TGL_LAHIR+"');";
        if(this.updatedata(sql)){
            JOptionPane.showMessageDialog(null, "Data mahasiswa " +NAMA+ "("+NIM+")\n Telah di update");
        }
        this.getdata();
        this.cmdSIMPAN.setEnabled(false);
        this.cmdBATAL.setVisible(false);
    }
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        LJudul = new javax.swing.JLabel();
        cmdBaru = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMHS = new javax.swing.JTable();
        LCurd = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Ljk = new javax.swing.JLabel();
        txJKL = new javax.swing.JRadioButton();
        txJKP = new javax.swing.JRadioButton();
        Ljur = new javax.swing.JLabel();
        txJUR = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmdSIMPAN = new javax.swing.JButton();
        cmdUPDATE = new javax.swing.JButton();
        cmdDELETE = new javax.swing.JButton();
        cmdBATAL = new javax.swing.JButton();
        cmdCLOSE = new javax.swing.JButton();
        txNIM = new javax.swing.JTextField();
        txNAMA = new javax.swing.JTextField();
        txTGL = new javax.swing.JTextField();
        imgphoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LJudul.setText("LIST DATA MAHASISWA");

        cmdBaru.setText("Data Baru");
        cmdBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBaruActionPerformed(evt);
            }
        });

        tMHS.setModel(new javax.swing.table.DefaultTableModel(
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
        tMHS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMHSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tMHS);

        LCurd.setText("EDIT DATA");

        jLabel3.setText("NIM");

        jLabel4.setText("NAMA");

        Ljk.setText("Jenis Kelamin");

        buttonGroup1.add(txJKL);
        txJKL.setText("Laki- laki");

        buttonGroup1.add(txJKP);
        txJKP.setText("Perempuan");

        Ljur.setText("Jurusan");

        txJUR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TI-KAB", "TI-MTI", "TI-DGM", "SK" }));
        txJUR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txJURActionPerformed(evt);
            }
        });

        jLabel7.setText("Tgl Lahir");

        cmdSIMPAN.setText("SIMPAN");
        cmdSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSIMPANActionPerformed(evt);
            }
        });

        cmdUPDATE.setText("UPDATE");
        cmdUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUPDATEActionPerformed(evt);
            }
        });

        cmdDELETE.setText("HAPUS");
        cmdDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDELETEActionPerformed(evt);
            }
        });

        cmdBATAL.setText("BATAL");
        cmdBATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBATALActionPerformed(evt);
            }
        });

        cmdCLOSE.setText("TUTUP ");
        cmdCLOSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCLOSEActionPerformed(evt);
            }
        });

        txNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNIMActionPerformed(evt);
            }
        });

        txTGL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTGLActionPerformed(evt);
            }
        });

        imgphoto.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(381, 381, 381)
                                .addComponent(cmdBaru))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LCurd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(imgphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(Ljur, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txJUR, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(Ljk)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txJKP)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(txJKL)
                                                                .addGap(28, 28, 28)
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txTGL, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))))))
                                            .addComponent(cmdUPDATE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(cmdSIMPAN)
                        .addGap(197, 197, 197)
                        .addComponent(cmdDELETE)
                        .addGap(163, 163, 163)
                        .addComponent(cmdBATAL)
                        .addGap(45, 45, 45)
                        .addComponent(cmdCLOSE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmdBaru)
                    .addComponent(LJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(LCurd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imgphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Ljk)
                                    .addComponent(txJKL)
                                    .addComponent(jLabel7)
                                    .addComponent(txTGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addComponent(txJKP)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txJUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ljur))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdSIMPAN)
                    .addComponent(cmdUPDATE)
                    .addComponent(cmdDELETE)
                    .addComponent(cmdBATAL)
                    .addComponent(cmdCLOSE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tMHSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMHSMouseClicked
         String urlGambarNull = "src/img/!!.png";
        
        txNIM.setText(model.getValueAt(tMHS.getSelectedRow(), 0).toString());
        txNAMA.setText(model.getValueAt(tMHS.getSelectedRow(), 1).toString());
        txTGL.setText(model.getValueAt(tMHS.getSelectedRow(), 2).toString());
        txJUR.setSelectedItem(model.getValueAt(tMHS.getSelectedRow(), 3).toString());
        
        String txJK = model.getValueAt(tMHS.getSelectedRow(), 4).toString();
        if(txJK.equals("Perempuan")){
            txJKL.setSelected(false);
            txJKP.setSelected(true);
        }else{
            txJKL.setSelected(true);
            txJKP.setSelected(false);
        }
        
        String urlGambar = "src/img/"+txNIM.getText()+ ".png";
        BufferedImage loadImg = img.loadImage(urlGambar);
        if(loadImg == null){
            loadImg = img.loadImage(urlGambarNull);
        }
        ImageIcon imageIcon = new ImageIcon(loadImg);
        this.imgphoto.setIcon(imageIcon);
       
    }//GEN-LAST:event_tMHSMouseClicked

    private void cmdBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBaruActionPerformed
        this.cmdBaru.setEnabled(false);
        this.cmdUPDATE.setEnabled(true);
        this.cmdDELETE.setEnabled(true);
        this.cmdCLOSE.setEnabled(true);
        this.cmdSIMPAN.setEnabled(true);
        this.cmdBATAL.setVisible(true);
        
        this.txNIM.setText("");
        this.txNAMA.setText("");
        this.txTGL.setText("");
        this.txJUR.setSelectedIndex(0);
        
        this.LCurd.setText("Tambah data Mahasiswa");
    }//GEN-LAST:event_cmdBaruActionPerformed

    private void cmdBATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBATALActionPerformed
        this.cmdCLOSE.setEnabled(true);
        this.cmdBaru.setEnabled(true);
        this.cmdSIMPAN.setEnabled(false);
        this.cmdBATAL.setVisible(false);
    }//GEN-LAST:event_cmdBATALActionPerformed

    private void cmdSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSIMPANActionPerformed
       String NIM = this.txNIM.getText();
        String NAMA = this.txNAMA.getText();
        String JURUSAN = this.txJUR.getSelectedItem().toString();
        String JK = "P";
        if(this.txJKL.isSelected()){
            JK = "L";
        }
        String TGL_LAHIR = this.txTGL.getText();
        String sqlInsert = "INSERT INTO mahasiswa(NIM, NAMA, JURUSAN, JK, TGL_LAHIR) VALUES('"+NIM+"', '"+NAMA+"', '"+JURUSAN+"', '"+JK+"', '"+TGL_LAHIR+"')";
        if(this.updatedata(sqlInsert)){
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        }
        this.getdata();
        this.cmdSIMPAN.setEnabled(false);
        this.cmdBATAL.setVisible(false);
        this.cmdCLOSE.setEnabled(true);
        this.LCurd.setVisible(true);
    }//GEN-LAST:event_cmdSIMPANActionPerformed

    private void cmdUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUPDATEActionPerformed
        String NIM = this.txNIM.getText();
        String NAMA = this.txNAMA.getText();
        String JURUSAN = this.txJUR.getSelectedItem().toString();
        String JK = "P";
        if(this.txJKP.isSelected()){
            JK = "L";
        }
        String TGL_LAHIR = this.txTGL.getText();
        String sqlUpdate = "UPDATE mahasiswa SET NAMA='"+NAMA+"', JURUSAN='"+JURUSAN+"', JK='"+JK+"', TGL LAHIR='"+TGL_LAHIR+"' WHERE NIM='"+NIM+"';";
        if(this.updatedata(sqlUpdate)){
            this.getdata();
            JOptionPane.showMessageDialog(null, "Data mahasiswa " +NAMA+ "("+NIM+")\n Telah di update");
        } 
    }//GEN-LAST:event_cmdUPDATEActionPerformed

    private void cmdDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDELETEActionPerformed
        String NIM = this.txNIM.getText();
        String NAMA = this.txNAMA.getText();
        
        String sqlDelete = "DELETE FROM mahasiswa WHERE NIM ='"+NIM+"';";
        
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data: \n"+NAMA+"("+NIM+")\n", "Penghapusan Data", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opsi == JOptionPane.YES_NO_CANCEL_OPTION){
            if(this.updatedata(sqlDelete)){
                JOptionPane.showMessageDialog(null, "Data Mahasiswa "+NIM+"("+NAMA+")\n Telah dihapus");
            }
            this.getdata();
        } 
    }//GEN-LAST:event_cmdDELETEActionPerformed

    private void cmdCLOSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCLOSEActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdCLOSEActionPerformed

    private void txJURActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txJURActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txJURActionPerformed

    private void txNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNIMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNIMActionPerformed

    private void txTGLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTGLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTGLActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(fmhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmhs().setVisible(true);
            }
        });
    }
    boolean isClosed() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LCurd;
    private javax.swing.JLabel LJudul;
    private javax.swing.JLabel Ljk;
    private javax.swing.JLabel Ljur;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cmdBATAL;
    private javax.swing.JButton cmdBaru;
    private javax.swing.JButton cmdCLOSE;
    private javax.swing.JButton cmdDELETE;
    private javax.swing.JButton cmdSIMPAN;
    private javax.swing.JButton cmdUPDATE;
    private javax.swing.JButton imgphoto;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMHS;
    private javax.swing.JRadioButton txJKL;
    private javax.swing.JRadioButton txJKP;
    private javax.swing.JComboBox<String> txJUR;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txNIM;
    private javax.swing.JTextField txTGL;
    // End of variables declaration//GEN-END:variables
}
