
package from;


public class beranda extends javax.swing.JFrame {

   
    public beranda() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnlogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtlaporan = new javax.swing.JPanel();
        lbllaporan = new javax.swing.JLabel();
        lbllaporan2 = new javax.swing.JLabel();
        txtdatakematian = new javax.swing.JPanel();
        lbldatakematian = new javax.swing.JLabel();
        lbldatakemtian2 = new javax.swing.JLabel();
        txtdatakelahiran = new javax.swing.JPanel();
        lbldatakelahiran = new javax.swing.JLabel();
        lbldatakelahiran2 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("APLIKASI PELAYANAN SURAT KEMATIAN DAN KELAHIRAN");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DESA BULAKSARI");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("KECAMATAN SRAGI KABUPATEN PEKALONGAN");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-embassy-50 (1).png"))); // NOI18N

        btnlogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnlogout.setText("Logout");
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addContainerGap(372, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnlogout)
                        .addGap(28, 28, 28))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(btnlogout))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtlaporan.setBackground(new java.awt.Color(204, 255, 255));

        lbllaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-document-96.png"))); // NOI18N

        lbllaporan2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbllaporan2.setForeground(new java.awt.Color(0, 51, 204));
        lbllaporan2.setText("LAPORAN");
        lbllaporan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbllaporan2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout txtlaporanLayout = new javax.swing.GroupLayout(txtlaporan);
        txtlaporan.setLayout(txtlaporanLayout);
        txtlaporanLayout.setHorizontalGroup(
            txtlaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtlaporanLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(txtlaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbllaporan2)
                    .addComponent(lbllaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        txtlaporanLayout.setVerticalGroup(
            txtlaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtlaporanLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(lbllaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbllaporan2)
                .addGap(25, 25, 25))
        );

        txtdatakematian.setBackground(new java.awt.Color(204, 204, 204));

        lbldatakematian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-dead-100.png"))); // NOI18N

        lbldatakemtian2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbldatakemtian2.setForeground(new java.awt.Color(0, 51, 255));
        lbldatakemtian2.setText("DATA KEMATIAN");
        lbldatakemtian2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldatakemtian2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout txtdatakematianLayout = new javax.swing.GroupLayout(txtdatakematian);
        txtdatakematian.setLayout(txtdatakematianLayout);
        txtdatakematianLayout.setHorizontalGroup(
            txtdatakematianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtdatakematianLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(txtdatakematianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbldatakematian)
                    .addComponent(lbldatakemtian2))
                .addGap(51, 51, 51))
        );
        txtdatakematianLayout.setVerticalGroup(
            txtdatakematianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtdatakematianLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbldatakematian)
                .addGap(18, 18, 18)
                .addComponent(lbldatakemtian2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtdatakelahiran.setBackground(new java.awt.Color(255, 204, 204));

        lbldatakelahiran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-pregnant-100.png"))); // NOI18N

        lbldatakelahiran2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbldatakelahiran2.setForeground(new java.awt.Color(51, 51, 255));
        lbldatakelahiran2.setText("DATA KELAHIRAN");
        lbldatakelahiran2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldatakelahiran2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout txtdatakelahiranLayout = new javax.swing.GroupLayout(txtdatakelahiran);
        txtdatakelahiran.setLayout(txtdatakelahiranLayout);
        txtdatakelahiranLayout.setHorizontalGroup(
            txtdatakelahiranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtdatakelahiranLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(txtdatakelahiranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbldatakelahiran)
                    .addComponent(lbldatakelahiran2))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        txtdatakelahiranLayout.setVerticalGroup(
            txtdatakelahiranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtdatakelahiranLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbldatakelahiran)
                .addGap(18, 18, 18)
                .addComponent(lbldatakelahiran2)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(txtlaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(txtdatakematian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtdatakelahiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtdatakelahiran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtdatakematian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtlaporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
         //new login().setVisible(true);         
         login fr =new login ();
        fr.setVisible(true);
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void lbllaporan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbllaporan2MouseClicked
        cetak_laporan fr =new cetak_laporan ();
        fr.setVisible(true);
        
    }//GEN-LAST:event_lbllaporan2MouseClicked

    private void lbldatakemtian2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldatakemtian2MouseClicked
         Daftar_Kematian fr =new Daftar_Kematian ();
        fr.setVisible(true);
    }//GEN-LAST:event_lbldatakemtian2MouseClicked

    private void lbldatakelahiran2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldatakelahiran2MouseClicked
        kelahiran fr =new kelahiran();
        fr.setVisible(true);
    }//GEN-LAST:event_lbldatakelahiran2MouseClicked

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
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new beranda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogout;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbldatakelahiran;
    private javax.swing.JLabel lbldatakelahiran2;
    private javax.swing.JLabel lbldatakematian;
    private javax.swing.JLabel lbldatakemtian2;
    private javax.swing.JLabel lbllaporan;
    private javax.swing.JLabel lbllaporan2;
    private javax.swing.JPanel txtdatakelahiran;
    private javax.swing.JPanel txtdatakematian;
    private javax.swing.JPanel txtlaporan;
    // End of variables declaration//GEN-END:variables
}
