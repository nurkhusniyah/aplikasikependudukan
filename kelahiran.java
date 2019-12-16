
package from;

import tool.aplikasikependudukan;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class kelahiran extends javax.swing.JFrame {

    public String JK="";
    public String kewarganegaraan_ibu="";
    public String kewarganegraan_ayah="";
    String vtanggallahir,vtanggal_lahiribu,vtanggal_lahirayah; 
    aplikasikependudukan getCnn = new aplikasikependudukan();
    Connection _Cnn;
    String sqlselect, sqlinsert, sqldelete,sqlupdate;
    String vnama_bayi, vhari, vtempat_lahir,vjk,vagama, vtempat_kelahiran,
            vpenolong_kelahiran,vnama_ibu, valamat, vumuribu,vkewarganegaraan_ibu,vnama_ayah,
            vumur_ayah,vkewarganegaraan_ayah,vno_kk,vno_ktpayah,vpetugas;
    private DefaultTableModel Tabelkelahiran;
    
    public kelahiran() {
        initComponents();
    }
    
    private void aksisimpan() {
        vnama_bayi = txtnamabayi.getText();
        vhari =combohari.getSelectedItem().toString();
        vtempat_lahir=txttmptlahir.getText();
        vjk = radiojk.getText();
        vagama = comboagama.getSelectedItem().toString();
        SimpleDateFormat tanggallahir= new SimpleDateFormat("yyy-MM-dd");
        String t = tanggallahir.format(datetglbayi.getDate());
        vtanggallahir = t;
        vtempat_kelahiran = combotempatlahir.getSelectedItem().toString();
        vpenolong_kelahiran = combopenolong.getSelectedItem().toString();
        vnama_ibu = txtnamaibu.getText();
        valamat = txtalamat.getText();
        SimpleDateFormat tanggallahiribu= new SimpleDateFormat("yyy-MM-dd");
        String y = tanggallahiribu.format(dateibu.getDate());
        vtanggal_lahiribu = y;
        vumuribu = txtumuribu.getText();
        vkewarganegaraan_ibu = txtibu.getText();
        vnama_ayah = txtnamaayah.getText();
        SimpleDateFormat tanggallahirayah= new SimpleDateFormat("yyy-MM-dd");
        String z = tanggallahirayah.format(datetglayah.getDate());
        vtanggal_lahirayah = z;
        vumur_ayah = txtumurayah.getText();
        vkewarganegaraan_ayah = txtayah.getText();
        vno_kk = txtkk.getText();
        vno_ktpayah = txtnik.getText();
        vpetugas = txtpetugas.getText();
        
        
        if(btnsimpan.getText().equals("Simpan")){
            sqlinsert = "insert into kelahiran values('"+vnama_bayi+"','"+vhari+"','"+vtanggallahir+"','"+vtempat_lahir+"','"+vjk+"','"+vagama+"','"+vtempat_kelahiran+"',"
                    + "'"+vpenolong_kelahiran+"','"+vnama_ibu+"','"+valamat+"','"+vtanggal_lahiribu+"','"+vumuribu+"','"+vkewarganegaraan_ibu+"','"+vnama_ayah+"','"+vtanggal_lahirayah+"', "
                    + "'"+vumur_ayah+"','"+vkewarganegaraan_ayah+"','"+vno_kk+"','"+vno_ktpayah+"','"+vpetugas+"')";
                                                       
                       
        }else{
            sqlupdate = "update kelahiran set nama_bayi='"+vnama_bayi+"', jk='"+vjk+"', '"+vtanggallahir+"', '"+vtempat_lahir+"',"
                    + "'"+vhari+"', '"+vpenolong_kelahiran+"', '"+vtempat_kelahiran+"', '"+vnama_ibu+"' " 
                    + " where jk='"+vjk+"'";
            
        }
        try{
            _Cnn = getCnn.getConnection ();
            Statement stat = _Cnn.createStatement();
            stat.executeUpdate(sqlinsert);
            JOptionPane.showMessageDialog(this, "Data Berhasil Di Simpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
            new Tabelkelahiran().setVisible (true);
            this.dispose();
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "eror Method aksisimpan() :"+ ex);
        }
                
                
        
        
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txttmptlahir = new javax.swing.JTextField();
        comboagama = new javax.swing.JComboBox<>();
        lbljk = new javax.swing.JLabel();
        lbltmptlahir = new javax.swing.JLabel();
        lbltglbayi = new javax.swing.JLabel();
        datetglbayi = new com.toedter.calendar.JDateChooser();
        combohari = new javax.swing.JComboBox<>();
        lblhari = new javax.swing.JLabel();
        txtnamabayi = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblagama = new javax.swing.JLabel();
        combotempatlahir = new javax.swing.JComboBox<>();
        lbltempatlahir = new javax.swing.JLabel();
        lblpenolong = new javax.swing.JLabel();
        combopenolong = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        lblnamaibu = new javax.swing.JLabel();
        txtnamaibu = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        lblalamat = new javax.swing.JLabel();
        lbltglibu = new javax.swing.JLabel();
        dateibu = new com.toedter.calendar.JDateChooser();
        txtumuribu = new javax.swing.JTextField();
        lblumuribu = new javax.swing.JLabel();
        lblkwg = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtnamaayah = new javax.swing.JTextField();
        lblnamaayah = new javax.swing.JLabel();
        lbltglayah = new javax.swing.JLabel();
        datetglayah = new com.toedter.calendar.JDateChooser();
        txtumurayah = new javax.swing.JTextField();
        lblumurayah = new javax.swing.JLabel();
        lblkewarganegaraan = new javax.swing.JLabel();
        txtkk = new javax.swing.JTextField();
        lblkk = new javax.swing.JLabel();
        lblnik = new javax.swing.JLabel();
        lblpetugas = new javax.swing.JLabel();
        txtnik = new javax.swing.JTextField();
        lblnamabayi = new javax.swing.JLabel();
        btnbatal = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        radiolk = new javax.swing.JRadioButton();
        radiopr = new javax.swing.JRadioButton();
        radiowni = new javax.swing.JRadioButton();
        radiowna = new javax.swing.JRadioButton();
        radiowniayah = new javax.swing.JRadioButton();
        radiownaayah = new javax.swing.JRadioButton();
        txtpetugas = new javax.swing.JTextField();
        radiojk = new javax.swing.JLabel();
        txtibu = new javax.swing.JLabel();
        txtayah = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("APLIKASI PELAYANAN KELAHIRAN DAN KEMATIAN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DESA BULAKSARI");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("KECAMATAN SRAGI KABUPATEN PEKALONGAN");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-embassy-50 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(57, 57, 57))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        comboagama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Islam ", "Kristen", "Katolik", "Hindu", "Budha", "Konghucu" }));
        comboagama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboagamaActionPerformed(evt);
            }
        });

        lbljk.setText("Jenis Kelamain :");

        lbltmptlahir.setText("Tempat Lahir :");

        lbltglbayi.setText("Tanggal Lahir :");

        combohari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" }));
        combohari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohariActionPerformed(evt);
            }
        });

        lblhari.setText("Hari :");

        txtnamabayi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamabayiActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("BAYI");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 153));
        jLabel28.setText("DATA KELAHIRAN");

        lblagama.setText("Agama :");

        combotempatlahir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Rumah Sakit", "Pukesmas", "Rumah Bersalin", " " }));
        combotempatlahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combotempatlahirActionPerformed(evt);
            }
        });

        lbltempatlahir.setText("Tempat Kelahiran :");

        lblpenolong.setText("Penolong Kelahiran :");

        combopenolong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Bidan", "Dokter Kandungan" }));
        combopenolong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combopenolongActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setText("IBU");

        lblnamaibu.setText("Nama Ibu : ");

        txtalamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalamatActionPerformed(evt);
            }
        });

        lblalamat.setText("Alamat :");

        lbltglibu.setText("Tanggal Lahir Ibu:");

        lblumuribu.setText("Umur Ibu :");

        lblkwg.setText("Kewaganegaraan Ibu :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("AYAH");

        txtnamaayah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaayahActionPerformed(evt);
            }
        });

        lblnamaayah.setText("Nama Ayah :");

        lbltglayah.setText("Tanggal Lahir Ayah :");

        txtumurayah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtumurayahActionPerformed(evt);
            }
        });

        lblumurayah.setText("Umur Ayah:");

        lblkewarganegaraan.setText("Kewarganegaran Ayah :");

        txtkk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkkActionPerformed(evt);
            }
        });

        lblkk.setText("No.KK :");

        lblnik.setText("No.KTP Ayah :");

        lblpetugas.setText("Petugas :");

        lblnamabayi.setText("Nama Bayi  :");

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
        radiowna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiownaActionPerformed(evt);
            }
        });

        radiowniayah.setText("WNI");
        radiowniayah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiowniayahActionPerformed(evt);
            }
        });

        radiownaayah.setText("WNA");
        radiownaayah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiownaayahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel28)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel16))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lbljk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbltmptlahir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbltglbayi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(lblagama)
                                                .addGap(19, 19, 19))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lblnamabayi))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(lblhari))
                                    .addComponent(lblpenolong)
                                    .addComponent(lbltempatlahir))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(combopenolong, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(combotempatlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(combohari, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtnamabayi, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txttmptlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(datetglbayi, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(comboagama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(radiolk)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radiopr)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radiojk, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblkwg)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblnamaibu)
                                        .addComponent(lbltglibu)
                                        .addComponent(lblalamat)
                                        .addComponent(lblumuribu)))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(radiowni)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radiowna)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtibu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateibu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtalamat)
                                        .addComponent(txtnamaibu)
                                        .addComponent(txtumuribu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnbatal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnsimpan)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(64, 64, 64))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbltglayah)
                                    .addComponent(lblkewarganegaraan)
                                    .addComponent(lblnamaayah)
                                    .addComponent(lblumurayah)
                                    .addComponent(lblkk)
                                    .addComponent(lblnik)
                                    .addComponent(lblpetugas))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnamaayah)
                                    .addComponent(txtumurayah)
                                    .addComponent(txtkk, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(datetglayah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(txtnik, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(radiowniayah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radiownaayah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtayah, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtpetugas))
                        .addGap(238, 238, 238))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblnamaibu)
                                    .addComponent(txtnamaibu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblalamat))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateibu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltglibu))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtumuribu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblumuribu))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblkwg)
                                    .addComponent(radiowni)
                                    .addComponent(radiowna)
                                    .addComponent(txtibu, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnamaayah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblnamaayah))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(datetglayah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltglayah))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtumurayah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblumurayah))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblkewarganegaraan)
                                    .addComponent(radiowniayah)
                                    .addComponent(radiownaayah)
                                    .addComponent(txtayah, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtkk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblkk))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnik, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblnik))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblpetugas)
                                    .addComponent(txtpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnbatal)
                            .addComponent(btnsimpan))
                        .addGap(101, 101, 101))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnamabayi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnamabayi))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(combohari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblhari))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datetglbayi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltglbayi))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txttmptlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltmptlahir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbljk)
                                    .addComponent(radiolk)
                                    .addComponent(radiopr)
                                    .addComponent(radiojk, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboagama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblagama)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combotempatlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltempatlahir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combopenolong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpenolong))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboagamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboagamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboagamaActionPerformed

    private void combohariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combohariActionPerformed

    private void txtnamabayiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamabayiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamabayiActionPerformed

    private void combotempatlahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combotempatlahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combotempatlahirActionPerformed

    private void combopenolongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combopenolongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combopenolongActionPerformed

    private void txtalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamatActionPerformed

    private void txtnamaayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaayahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaayahActionPerformed

    private void txtumurayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtumurayahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtumurayahActionPerformed

    private void txtkkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkkActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        aksisimpan();
//new Tabelkelahiran().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
new beranda().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbatalActionPerformed

    private void radioprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioprActionPerformed
        JK="perempuan";
        radiolk.setSelected(false);
        
        radiojk.setText(JK);    
        // TODO add your handling code here:
    }//GEN-LAST:event_radioprActionPerformed

    private void radiolkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiolkActionPerformed
 JK="laki-laki";
        radiopr.setSelected(false);
        
        radiojk.setText(JK);    
        // TODO add your handling code here:
    }//GEN-LAST:event_radiolkActionPerformed

    private void radiowniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowniActionPerformed
 kewarganegaraan_ibu="WNI";
        radiowna.setSelected(false);
        
        txtibu.setText(kewarganegaraan_ibu);    
        // TODO add your handling code here:
    }//GEN-LAST:event_radiowniActionPerformed

    private void radiownaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiownaActionPerformed
         kewarganegaraan_ibu="WNA";
        radiowni.setSelected(false);
        
        txtibu.setText(kewarganegaraan_ibu);    
// TODO add your handling code here:
    }//GEN-LAST:event_radiownaActionPerformed

    private void radiowniayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowniayahActionPerformed
          kewarganegraan_ayah="WNI";
        radiownaayah.setSelected(false);
        
        txtayah.setText(kewarganegraan_ayah);   
// TODO add your handling code here:
    }//GEN-LAST:event_radiowniayahActionPerformed

    private void radiownaayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiownaayahActionPerformed
  kewarganegraan_ayah="WNA";
        radiowniayah.setSelected(false);
        
        txtayah.setText(kewarganegraan_ayah);   
        // TODO add your handling code here:
    }//GEN-LAST:event_radiownaayahActionPerformed

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
            java.util.logging.Logger.getLogger(kelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kelahiran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> comboagama;
    private javax.swing.JComboBox<String> combohari;
    private javax.swing.JComboBox<String> combopenolong;
    private javax.swing.JComboBox<String> combotempatlahir;
    private com.toedter.calendar.JDateChooser dateibu;
    private com.toedter.calendar.JDateChooser datetglayah;
    private com.toedter.calendar.JDateChooser datetglbayi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblagama;
    private javax.swing.JLabel lblalamat;
    private javax.swing.JLabel lblhari;
    private javax.swing.JLabel lbljk;
    private javax.swing.JLabel lblkewarganegaraan;
    private javax.swing.JLabel lblkk;
    private javax.swing.JLabel lblkwg;
    private javax.swing.JLabel lblnamaayah;
    private javax.swing.JLabel lblnamabayi;
    private javax.swing.JLabel lblnamaibu;
    private javax.swing.JLabel lblnik;
    private javax.swing.JLabel lblpenolong;
    private javax.swing.JLabel lblpetugas;
    private javax.swing.JLabel lbltempatlahir;
    private javax.swing.JLabel lbltglayah;
    private javax.swing.JLabel lbltglbayi;
    private javax.swing.JLabel lbltglibu;
    private javax.swing.JLabel lbltmptlahir;
    private javax.swing.JLabel lblumurayah;
    private javax.swing.JLabel lblumuribu;
    private javax.swing.JLabel radiojk;
    private javax.swing.JRadioButton radiolk;
    private javax.swing.JRadioButton radiopr;
    private javax.swing.JRadioButton radiowna;
    private javax.swing.JRadioButton radiownaayah;
    private javax.swing.JRadioButton radiowni;
    private javax.swing.JRadioButton radiowniayah;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JLabel txtayah;
    private javax.swing.JLabel txtibu;
    private javax.swing.JTextField txtkk;
    private javax.swing.JTextField txtnamaayah;
    private javax.swing.JTextField txtnamabayi;
    private javax.swing.JTextField txtnamaibu;
    private javax.swing.JTextField txtnik;
    private javax.swing.JTextField txtpetugas;
    private javax.swing.JTextField txttmptlahir;
    private javax.swing.JTextField txtumurayah;
    private javax.swing.JTextField txtumuribu;
    // End of variables declaration//GEN-END:variables
}
