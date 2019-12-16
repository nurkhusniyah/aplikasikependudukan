
package from;

import tool.aplikasikependudukan;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;



public class Daftar_Kematian extends javax.swing.JFrame {
    public String JK="";
    public String Kewarganegaraan="";
   String vtanggalkelahiran,vtanggalkematian; 
   aplikasikependudukan getCnn = new aplikasikependudukan();
    Connection _Cnn;
    String sqlselect, sqlinsert, sqldelete,sqlupdate;
    String vno_ktp, vnama_lengkap, vjk, valamat,vtgl_kelahiran, vtgl_kematian, vhari_kematian,vumur,vtmp_kematian,vsebab_kematian,vpekerjaan, vkewarganegaraan,vagama,vstatus_perkawinan,vno_kk,vnama_pelapor,vhub_pelapor,vpetugas;
    private DefaultTableModel tabelkematian;
    
    
    
    
           
    

   
    public Daftar_Kematian() {
        this.
        initComponents();
        
        try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                sqlselect = "select from kematian where no_ktp='"+vno_ktp+"'";
                Statement stat = _Cnn.createStatement();
                //stat.executeUpdate(sqlselect);
                
 
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "belum bisa() : "+ex);
            }
        
         ambildata();
        
    }
    
    
     private void ambildata(){
        
        tablekematian ambil = new tablekematian();
        
        
        //bssmilah...namainputan.variabel.terus paling belakang itu nama db//
        txtnamalengkap.setText(vnama_lengkap);
        txtjk.setText(JK);
        txtalamat.setText(valamat);
        java.util.Date vtgl_kelahiran = null;
        datetglkelahiran.setDate(vtgl_kelahiran);
        java.util.Date vtgl_kematin = null;
        datetglkematian.setDate(vtgl_kematin);
        combohari.setSelectedItem(vhari_kematian);
        txtumur.setText(vumur);
        txttmptkematian.setText(vtmp_kematian);
        txtsbbkematian.setText(vsebab_kematian);
        txtpekerjaan.setText(vpekerjaan);
        txtkewarganegaraan.setText(vkewarganegaraan);
        comboagama.setSelectedItem(vagama);
        combostatus.setSelectedItem(vstatus_perkawinan);
        txtnokk.setText(vno_kk);
        txtnoktp.setText(vno_ktp);
        txtnamapelapor.setText(vnama_pelapor);
        combohubpelapor.setSelectedItem(vhub_pelapor);
        txtpetugas.setText(vpetugas);
       
             
    }
    
    private void aksisimpan() {
        vno_ktp = txtnoktp.getText();
        vnama_lengkap = txtnamalengkap.getText();
        vjk = txtjk.getText();
        valamat = txtalamat.getText();
        SimpleDateFormat tanggalkelahiran= new SimpleDateFormat("yyy-MM-dd");
        String t = tanggalkelahiran.format(datetglkelahiran.getDate());
        vtanggalkelahiran = t;
         SimpleDateFormat tanggalkematian= new SimpleDateFormat("yyy-MM-dd");
        String y = tanggalkematian.format(datetglkematian.getDate());
        vtanggalkematian = y;
        vhari_kematian = combohari.getSelectedItem().toString();
        vumur = txtumur.getText();
        String vtmp_kematin = txttmptkematian.getText();
        vsebab_kematian = txtsbbkematian.getText();
        vpekerjaan = txtpekerjaan.getText();
        vkewarganegaraan = txtkewarganegaraan.getText();
        vagama = comboagama.getSelectedItem().toString();
        String vsatus_perkawinan = combostatus.getSelectedItem().toString();
        vno_kk = txtnokk.getText();
        vnama_pelapor = txtnamapelapor.getText();
        vhub_pelapor = combohubpelapor.getSelectedItem().toString();
        vpetugas = txtpetugas.getText();
        
        
        if(btnsimpan.getText().equals("Simpan")){
            sqlinsert = "insert into kematian values('"+vno_ktp+"','"+vnama_lengkap+"','"+vjk+"','"+valamat+"','"+vtanggalkelahiran+"','"+vtanggalkematian+"','"+vhari_kematian+"',"
                    + "'"+vumur+"','"+vtmp_kematin+"','"+vsebab_kematian+"','"+vpekerjaan+"','"+vkewarganegaraan+"','"+vagama+"','"+vsatus_perkawinan+"','"+vno_kk+"', "
                    + "'"+vnama_pelapor+"','"+vhub_pelapor+"','"+vpetugas+"')";
                                                       
                       
        }else{
            sqlupdate = "update kematian set nama_lengkap='"+vnama_lengkap+"', jk='"+vjk+"', '"+valamat+"', '"+vtanggalkelahiran+"',"
                    + "'"+vtanggalkematian+"', '"+vhari_kematian+"', '"+vumur+"', '"+vtmp_kematin+"' " 
                    + " where jk='"+vjk+"'";
            
        }
        try{
            _Cnn = getCnn.getConnection ();
            Statement stat = _Cnn.createStatement();
            stat.executeUpdate(sqlinsert);
            JOptionPane.showMessageDialog(this, "Data Berhasil Di Simpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
            new tablekematian().setVisible (true);
            this.dispose();
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "eror Method aksisimpan() :"+ ex);
        }
                
                
        
        
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblnamalengkap = new javax.swing.JLabel();
        txtnamalengkap = new javax.swing.JTextField();
        lbljk = new javax.swing.JLabel();
        lbtglkelahiran = new javax.swing.JLabel();
        datetglkematian = new com.toedter.calendar.JDateChooser();
        lblalamat = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        lbltglkematian = new javax.swing.JLabel();
        datetglkelahiran = new com.toedter.calendar.JDateChooser();
        lblhari = new javax.swing.JLabel();
        combohari = new javax.swing.JComboBox<>();
        lblumur = new javax.swing.JLabel();
        txtumur = new javax.swing.JTextField();
        lblkewarganegaraan = new javax.swing.JLabel();
        lblagama = new javax.swing.JLabel();
        comboagama = new javax.swing.JComboBox<>();
        lblstatus = new javax.swing.JLabel();
        combostatus = new javax.swing.JComboBox<>();
        lblpekerjaan = new javax.swing.JLabel();
        txtpekerjaan = new javax.swing.JTextField();
        lbltmptkematian = new javax.swing.JLabel();
        lblsbbkematian = new javax.swing.JLabel();
        txtsbbkematian = new javax.swing.JTextField();
        lblnokk = new javax.swing.JLabel();
        txtnokk = new javax.swing.JTextField();
        txtnoktp = new javax.swing.JTextField();
        lblnoktp = new javax.swing.JLabel();
        lblnamapelapor = new javax.swing.JLabel();
        txtnamapelapor = new javax.swing.JTextField();
        lblhubpelapor = new javax.swing.JLabel();
        combohubpelapor = new javax.swing.JComboBox<>();
        lblpetugas = new javax.swing.JLabel();
        txtpetugas = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        btnbatal = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        txttmptkematian = new javax.swing.JTextField();
        radiolk = new javax.swing.JRadioButton();
        radiopr = new javax.swing.JRadioButton();
        radiowni = new javax.swing.JRadioButton();
        radiowna = new javax.swing.JRadioButton();
        txtjk = new javax.swing.JLabel();
        txtkewarganegaraan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("APLIKASI PELAYANAN SURAT KEMATIAN DAN KELAHIRAN");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("DESA BULAKSARI");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("KECAMATAN SRAGI KABUPATEN PEEKALONGAN");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-embassy-50 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblnamalengkap.setText("Nama Lengkap :");

        txtnamalengkap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamalengkapActionPerformed(evt);
            }
        });

        lbljk.setText("Jenis Kelamin  : ");

        lbtglkelahiran.setText("Tgl Kelahiran :        ");

        lblalamat.setText("Alamat : ");

        txtalamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalamatActionPerformed(evt);
            }
        });

        lbltglkematian.setText("Tgl Kematian :        ");

        datetglkelahiran.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datetglkelahiranPropertyChange(evt);
            }
        });

        lblhari.setText("Hari Kematian :");

        combohari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" }));
        combohari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohariActionPerformed(evt);
            }
        });

        lblumur.setText("Umur :");

        txtumur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtumurActionPerformed(evt);
            }
        });

        lblkewarganegaraan.setText("Kewarganegaraan:");

        lblagama.setText("Agama :");

        comboagama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Islam", "Kristen", "Katolik", "Hindu", "Budha", "Konghucu" }));
        comboagama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboagamaActionPerformed(evt);
            }
        });

        lblstatus.setText("Status Perkawinan:");

        combostatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Kawin", "Belum Kawin", "Cerai" }));
        combostatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combostatusActionPerformed(evt);
            }
        });

        lblpekerjaan.setText("Pekerjaan :");

        txtpekerjaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpekerjaanActionPerformed(evt);
            }
        });

        lbltmptkematian.setText("Tempat Kematian :");

        lblsbbkematian.setText("Sebab Kematian :");

        lblnokk.setText("No.KK :");

        lblnoktp.setText("No KTP :");

        lblnamapelapor.setText("Nama Pelapor :");

        txtnamapelapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamapelaporActionPerformed(evt);
            }
        });

        lblhubpelapor.setText("Hub Pelapor :");

        combohubpelapor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Orang Tua", "Anak", "Saudara Kandung", "Anak Angkat", "Lain-lain" }));
        combohubpelapor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohubpelaporActionPerformed(evt);
            }
        });

        lblpetugas.setText("Petugas");

        txtpetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpetugasActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("DATA KEMATIAN");

        btnbatal.setBackground(new java.awt.Color(0, 51, 153));
        btnbatal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnbatal.setForeground(new java.awt.Color(255, 255, 255));
        btnbatal.setText("Batal");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnsimpan.setBackground(new java.awt.Color(0, 51, 153));
        btnsimpan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnsimpan.setText("Simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        radiolk.setText("Laki-laki");
        radiolk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiolkActionPerformed(evt);
            }
        });

        radiopr.setText("Perempuan");
        radiopr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioprActionPerformed(evt);
            }
        });

        radiowni.setText("WNI");
        radiowni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiowniActionPerformed(evt);
            }
        });

        radiowna.setText("WNA");

        txtjk.setForeground(new java.awt.Color(255, 255, 255));

        txtkewarganegaraan.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblumur)
                                        .addGap(64, 64, 64))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lbltmptkematian)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtumur, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(txttmptkematian)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel23)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblhari)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(combohari, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(lblnamalengkap)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtnamalengkap, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbljk)
                                                    .addComponent(lblalamat)
                                                    .addComponent(lbtglkelahiran, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(datetglkelahiran, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(radiolk)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(radiopr)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtjk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(lbltglkematian)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(datetglkematian, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(10, 10, 10)))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblnamapelapor)
                                                        .addComponent(lblnoktp))
                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblpetugas)
                                                        .addComponent(lblhubpelapor))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblnokk))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                                .addComponent(btnbatal)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnsimpan)
                                                .addGap(0, 29, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblstatus)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnoktp, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(txtnokk)
                                            .addGap(1, 1, 1))
                                        .addComponent(combostatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtnamapelapor, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblagama)
                                        .addGap(28, 28, 28)
                                        .addComponent(comboagama, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combohubpelapor, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(1, 1, 1))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(lblpekerjaan)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtpekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(lblkewarganegaraan)
                                .addGap(18, 18, 18)
                                .addComponent(radiowni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radiowna)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtkewarganegaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(lblsbbkematian)
                        .addGap(16, 16, 16)
                        .addComponent(txtsbbkematian, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnamalengkap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblnamalengkap))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtpekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblpekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbtglkelahiran, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datetglkelahiran, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltglkematian, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datetglkematian, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblhari)
                            .addComponent(combohari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtumur, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblumur))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltmptkematian)
                            .addComponent(txttmptkematian, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsbbkematian, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblsbbkematian))
                        .addGap(169, 169, 169))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(radiopr)
                                .addComponent(radiolk)
                                .addComponent(lbljk)
                                .addComponent(txtjk, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtkewarganegaraan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblkewarganegaraan)
                                    .addComponent(radiowni)
                                    .addComponent(radiowna))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboagama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblagama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combostatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblstatus))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnokk, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnokk))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnoktp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnoktp))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnamapelapor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnamapelapor))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combohubpelapor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblhubpelapor))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpetugas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnbatal)
                            .addComponent(btnsimpan))
                        .addGap(67, 67, 67))))
        );

        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnamalengkapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamalengkapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamalengkapActionPerformed

    private void txtalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamatActionPerformed

    private void txtumurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtumurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtumurActionPerformed

    private void combohubpelaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohubpelaporActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combohubpelaporActionPerformed

    private void txtpekerjaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpekerjaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpekerjaanActionPerformed

    private void combohariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combohariActionPerformed

    private void combostatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combostatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combostatusActionPerformed

    private void comboagamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboagamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboagamaActionPerformed

    private void txtpetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpetugasActionPerformed

    private void txtnamapelaporActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamapelaporActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamapelaporActionPerformed

    private void radiowniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowniActionPerformed
    Kewarganegaraan="WNI";
        radiowna.setSelected(false);
        
        txtkewarganegaraan.setText(Kewarganegaraan);        
        // TODO add your handling code here:
    }//GEN-LAST:event_radiowniActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
 aksisimpan();
//new tablekematian().setVisible(true);
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
new beranda().setVisible(true);
        // TODO add your handling code here:
         beranda fr =new beranda ();
        fr.setVisible(true);
    }//GEN-LAST:event_btnbatalActionPerformed

    private void datetglkelahiranPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datetglkelahiranPropertyChange
       /*try{
           if(datetglkelahiran.getDate()!= null){
               String pattren = "yyyy-MM-dd";
               SimpleDateFormat format = new SimpleDateFormat(pattren);
               vtgl_kelahiran=String.valueOf(format.format(datetglkelahiran.getDate()));
               
           }else if (datetglkematian.getDate()!=null)
           
       }catch (Exception e){
           
       } */
        // TODO add your handling code here:
    }//GEN-LAST:event_datetglkelahiranPropertyChange

    private void radiolkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiolkActionPerformed
    JK="Laki-laki";
        radiopr.setSelected(false);
        
        txtjk.setText(JK);        
    }//GEN-LAST:event_radiolkActionPerformed

    private void radioprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioprActionPerformed
 JK="perempuan";
        radiolk.setSelected(false);
        
        txtjk.setText(JK);                // TODO add your handling code here:
    }//GEN-LAST:event_radioprActionPerformed

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
            java.util.logging.Logger.getLogger(Daftar_Kematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Daftar_Kematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Daftar_Kematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Daftar_Kematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Daftar_Kematian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> comboagama;
    private javax.swing.JComboBox<String> combohari;
    private javax.swing.JComboBox<String> combohubpelapor;
    private javax.swing.JComboBox<String> combostatus;
    private com.toedter.calendar.JDateChooser datetglkelahiran;
    private com.toedter.calendar.JDateChooser datetglkematian;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblagama;
    private javax.swing.JLabel lblalamat;
    private javax.swing.JLabel lblhari;
    private javax.swing.JLabel lblhubpelapor;
    private javax.swing.JLabel lbljk;
    private javax.swing.JLabel lblkewarganegaraan;
    private javax.swing.JLabel lblnamalengkap;
    private javax.swing.JLabel lblnamapelapor;
    private javax.swing.JLabel lblnokk;
    private javax.swing.JLabel lblnoktp;
    private javax.swing.JLabel lblpekerjaan;
    private javax.swing.JLabel lblpetugas;
    private javax.swing.JLabel lblsbbkematian;
    private javax.swing.JLabel lblstatus;
    private javax.swing.JLabel lbltglkematian;
    private javax.swing.JLabel lbltmptkematian;
    private javax.swing.JLabel lblumur;
    private javax.swing.JLabel lbtglkelahiran;
    private javax.swing.JRadioButton radiolk;
    private javax.swing.JRadioButton radiopr;
    private javax.swing.JRadioButton radiowna;
    private javax.swing.JRadioButton radiowni;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JLabel txtjk;
    private javax.swing.JLabel txtkewarganegaraan;
    private javax.swing.JTextField txtnamalengkap;
    private javax.swing.JTextField txtnamapelapor;
    private javax.swing.JTextField txtnokk;
    private javax.swing.JTextField txtnoktp;
    private javax.swing.JTextField txtpekerjaan;
    private javax.swing.JTextField txtpetugas;
    private javax.swing.JTextField txtsbbkematian;
    private javax.swing.JTextField txttmptkematian;
    private javax.swing.JTextField txtumur;
    // End of variables declaration//GEN-END:variables

  
        
}
