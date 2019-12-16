
package from;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import tool.aplikasikependudukan;
import java.awt.Color;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;


public class tablekematian extends javax.swing.JFrame {

   // private static void setModel(DefaultTableModel model) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
     aplikasikependudukan getCnn = new aplikasikependudukan();
     Connection _Cnn;
     String sqlselect, sqlinsert, sqldelete,sqlupdate;
     ResultSet data1;
     String vtanggalkelahiran,vtanggalkematian,JK,kewarganegaraan;
     private static String no_ktp= "";
     String vno_ktp,vnama_lengkap, vjk, valamat,vtgl_kelahiran,vtgl_kematian,vhari_kematian,vumur,vtmp_kematian,vsebab_kematian,vpekerjaan, vkewarganegaraan,vagama,vsatus_perkawinan,vno_kk,vnama_pelapor,vhub_pelapor,vpetugas;
     PreparedStatement pst;
     private DefaultTableModel tbkematian;
     //private DefaultTableModel tabelkematian;
     private DefaultTableModel model;
    private Object No;
     
     
     
     


    
    public tablekematian() {
        initComponents();
        JdInputKematian.setSize(900, 680);
        JdInputKematian.setLocationRelativeTo(this);
        
        model=new DefaultTableModel();
        tabelkematian.setModel(model);
        model.addColumn("no_ktp");
        model.addColumn("nama_lengkap");
        model.addColumn("jk");
        model.addColumn("alamat");
        model.addColumn("tgl_kelahiran");
        model.addColumn("tgl_kematian");
        model.addColumn("hari_kematian");
        model.addColumn("umur");
        model.addColumn("tempat_kematian");
        model.addColumn("sebab_kematian");
        model.addColumn("pekerjaan");
        model.addColumn("kewarganegaraan");
        model.addColumn("agama");
        model.addColumn("status_perkawinan");
        model.addColumn("No.KK");
        model.addColumn("nama_pelapor");
        model.addColumn("hub_pelapor");
        model.addColumn("petugas");
        
        showdatakematian();
 
    }
    
     private void clearInput(){
        txtnoktp1.setText("");
        txtjk1.setText("");
        txtalamat1.setText("");
        datetglkelahiran1.setDate(new Date());
        datetglkematian1.setDate(new Date());
        combohari1.setSelectedIndex(0);
        txtumur1.setText("");
        txttmptkematian1.setText("");
        txtsbbkematian1.setText("");
        txtpekerjaan1.setText("");
        txtkewarganegaraan1.setText("");
        comboagama1.setSelectedIndex(0);
        combostatus1.setSelectedIndex(0);
        txtnokk1.setText("");
        txtnoktp1.setText("");
        txtnamapelapor1.setText("");
        combohubpelapor1.setSelectedIndex(0);
        txtpetugas1.setText("");
        btnsimpan1.setText("Simpan");
        btnbatal1.setText("Batal");
        vno_ktp="";
        
    }
     
        
        private void settabelkematian(){
        String[] kolom1 = {"no_ktp","nama_lengkap", "jk", "alamat", "tgl_kelahiran", "tgl_kematian", "hari_kematian", 
             "umur", "tempat_kematian", "sebab_kematian","pekerjaan","kewarganegaraan","agama","status_perkawinan","No.KK","nama_pelapor","hub_pelapor","petugas"};
        tbkematian = new DefaultTableModel(null, kolom1){
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
            };
            public Class getColumnClass(int columnIndex){
                return types [columnIndex];
            }
            public boolean isCellEditable(int row, int col){
                int cola = tabelkematian.getColumnCount();
                //java.lang.String.class,
                //java.lang.String.ctColumnCount();
                return (col < cola) ? true : true;
            }
                };
                 // agar tabel bisa diedit
            
        
        tabelkematian.setModel(tbkematian);
        tabelkematian.getColumnModel().getColumn(0).setPreferredWidth(75);
        tabelkematian.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabelkematian.getColumnModel().getColumn(2).setPreferredWidth(25);
        tabelkematian.getColumnModel().getColumn(3).setPreferredWidth(75);
        tabelkematian.getColumnModel().getColumn(4).setPreferredWidth(75);
        tabelkematian.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(6).setPreferredWidth(300);
        tabelkematian.getColumnModel().getColumn(7).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(8).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(9).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(10).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(11).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(12).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(13).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(14).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(15).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(16).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(17).setPreferredWidth(150);
    }
                
        
                
        /* String[] kolom1 = {"no_ktp", "nama_lengkap", "jk", "alamat","tgl_kelahiran","tgl_kematian",
             "hari_kematian","umur","tempat_kematian","sebab_kematian","pekerjaan",
             "kewarganegaraan","agama","status_perkawinan","No.KK","nama_pelapor","hub_pelapor","petugas"
         };
        tbkematian = new DefaultTableModel(null, kolom1){
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
              };
    };
                }
    /* private void showdata(){
          try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            
            sqlselect = " select * from kematian order by No.KTP asc ";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            while(res.next()){
                 vnama_lengkap = res.getString(1);
                 vjk = res.getString(2);
                 valamat = res.getString(3);
                 vtgl_kelahiran= res.getString(4);
                 vtgl_kematian= res.getString(5);
                 vhari_kematian= res.getString(6);
                 vumur= res.getString(7);
                 vtmp_kematian= res.getString(8);
                 vsebab_kematian= res.getString(9);
                 vpekerjaan= res.getString(10);
                 vkewarganegaraan= res.getString(11);
                 vagama= res.getString(12);
                 vsatus_perkawinan= res.getString(13);
                 vno_kk= res.getString(14);
                 vno_ktp= res.getString(15);
                 vnama_pelapor= res.getString(16);
                 vhub_pelapor= res.getString(17);
                 vpetugas= res.getString(18);
                 
                Object[] data = {"no_ktp","nama_lengkap", "jk", "alamat","tgl_kelahiran","tgl_kematian",
             "hari_kematian","umur","tempat_kematian","sebab_kematian","pekerjaan",
             "kewarganegaraan","agama","status_perkawinan","No.KK","nama_pelapor","hub_pelapor","petugas"};
                tbkematian.addRow(data);
                
            }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Eror Method showdata(): "+ex);
            
            
        }  
      
          
     
            }
    */

   
  
      private void aksiHapus(){
        int jawab = JOptionPane.showConfirmDialog(this, "Anda yakin akan menghapus data ini? no_ktp : "+no_ktp+"", 
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(jawab == JOptionPane.YES_OPTION){
            try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                sqldelete = "delete from kematian where no_ktp ='" +no_ktp+ "'";
                Statement stat = _Cnn.createStatement();
                stat.executeUpdate(sqldelete);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                
                   //disableForm();showDataTabel();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Error method aksiHapus() : "+ex);
            }
        }
    }
     
      
      
      
      private void aksiSimpan(){
        vno_ktp = txtnoktp1.getText();
        vnama_lengkap = txtnamalengkap1.getText();
        vjk = txtjk1.getText();
        valamat = txtalamat1.getText();
        SimpleDateFormat tanggalkelahiran= new SimpleDateFormat("yyy-MM-dd");
        String t = tanggalkelahiran.format(datetglkelahiran1.getDate());
        vtanggalkelahiran = t;
         SimpleDateFormat tanggalkematian= new SimpleDateFormat("yyy-MM-dd");
        String y = tanggalkematian.format(datetglkematian1.getDate());
        vtanggalkematian = y;
        vhari_kematian = combohari1.getSelectedItem().toString();
        vumur = txtumur1.getText();
        vtmp_kematian = txttmptkematian1.getText();
        vsebab_kematian = txtsbbkematian1.getText();
        vpekerjaan = txtpekerjaan1.getText();
        vkewarganegaraan = txtkewarganegaraan1.getText();
        vagama = comboagama1.getSelectedItem().toString();
        vsatus_perkawinan = combostatus1.getSelectedItem().toString();
        vno_kk = txtnokk1.getText();
        vnama_pelapor = txtnamapelapor1.getText();
        vhub_pelapor = combohubpelapor1.getSelectedItem().toString();
        vpetugas = txtpetugas1.getText();
        
            
            sqlinsert = "insert into kematian values ('"+vno_ktp+"', '"+vnama_lengkap+"', '"+vjk+"', '"+valamat+"', "
                    + "'"+vtgl_kelahiran+"', '"+vtgl_kematian+"', '"+vhari_kematian+"', '"+vumur+"', '"+vtmp_kematian+"', "
                    + "'"+vsebab_kematian+"', '"+vpekerjaan+"', '"+vkewarganegaraan+"', '"+vagama+"', '"+vsatus_perkawinan+"', '"+vno_kk+"', '"+vnama_pelapor+"', '"+vhub_pelapor+"', '"+vpetugas+"')";
        
          
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            Statement stat = _Cnn.createStatement();
            stat.executeUpdate(sqlinsert);
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
              //disableForm();showDataTabel();
             new tablekematian().show();
               this.dispose();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method aksiSimpan() : "+ex);
        }
    }
      
      private void aksiUbah(){
        vno_ktp = txtnoktp1.getText();
        vnama_lengkap = txtnamalengkap1.getText();
        vjk = txtjk1.getText();
        valamat = txtalamat1.getText();
        SimpleDateFormat tanggalkelahiran= new SimpleDateFormat("yyy-MM-dd");
        String t = tanggalkelahiran.format(datetglkelahiran1.getDate());
        vtanggalkelahiran = t;
         SimpleDateFormat tanggalkematian= new SimpleDateFormat("yyy-MM-dd");
        String y = tanggalkematian.format(datetglkematian1.getDate());
        vtanggalkematian = y;
        vhari_kematian = combohari1.getSelectedItem().toString();
        vumur = txtumur1.getText();
         vtmp_kematian = txttmptkematian1.getText();
        vsebab_kematian = txtsbbkematian1.getText();
        vpekerjaan = txtpekerjaan1.getText();
        vkewarganegaraan = txtkewarganegaraan1.getText();
        vagama = comboagama1.getSelectedItem().toString();
        vsatus_perkawinan = combostatus1.getSelectedItem().toString();
        vno_kk = txtnokk1.getText();
        vnama_pelapor = txtnamapelapor1.getText();
        vhub_pelapor = combohubpelapor1.getSelectedItem().toString();
        vpetugas = txtpetugas1.getText();
        
       sqlupdate = "update kematian set no_ktp='"+vno_ktp+"', nama_lengkap='"+vnama_lengkap+"', jk='"+vjk+"', alamat='"+valamat+"', tgl_kelahiran='"+vtgl_kelahiran+"', "
                    + "tgl_kematian= '"+vtgl_kematian+"',hari_kematian= '"+vhari_kematian+"', umur='"+vumur+"',"
                    + "tempat_kematian= '"+vtmp_kematian+"', sebab_kemtian='"+vsebab_kematian+"', pekerjaan= '"+vpekerjaan+"', "
                    + "kewarganegaraan= '"+vkewarganegaraan+"', agama= '"+vagama+"'" + "status_perkawinan= '"+vsatus_perkawinan+"', No.KK= '"+vno_kk+"'" + "nama_pelapor= '"+vnama_pelapor+"',hub_pelapor= '"+vhub_pelapor+"'" + "petugas= '"+vpetugas+"',"
                    + " where no_ktp= ' " +vno_ktp+ " ' ";
       
       try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            Statement stat = _Cnn.createStatement();
            stat.executeUpdate(sqlupdate);
            JOptionPane.showMessageDialog(this, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
              //disableForm();showDataTabel();
             new tablekematian().show();
               this.dispose();
               JdInputKematian.setVisible(false);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method aksiSimpan() : "+ex);
        }
    }
      
     private void showdatakematian(){
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
           
            sqlselect = "select * from kematian ";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            
            while(res.next()){
                Object[]obj=new Object[20];
                obj[0]=res.getString("no_ktp");
                obj[1]=res.getString("nama_lengkap");
                obj[2]=res.getString("jk");
                obj[3]=res.getString("alamat");
                obj[4]=res.getString("tgl_kelahiran");
                obj[5]=res.getString("tgl_kematian");
                obj[6]=res.getString("hari_kematian");
                obj[7]=res.getString("umur");
                obj[8]=res.getString("tempat_kematian");
                obj[9]=res.getString("sebab_kematian");
                obj[10]=res.getString("pekerjaan");
                obj[11]=res.getString("kewarganegaraan");
                obj[12]=res.getString("agama");
                obj[13]=res.getString("status_perkawinan");
                obj[14]=res.getString("No.KK");
                obj[15]=res.getString("nama_pelapor");
                obj[16]=res.getString("hub_pelapor");
                obj[17]=res.getString("petugas");
                
                
                model.addRow(obj);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method showtablr(): " + ex);
        }
    }
      
      private void getdatakematian(){
            try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sqlselect = "select * from kematian where no_ktp= ' " +no_ktp+ " ' ";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            if(res.first()){
                    
                    txtnoktp1.setText(res.getString("no_ktp"));
                    txtnamalengkap1.setText(res.getString("nama_lengkap"));
                    txtjk1.setText(res.getString("jk"));
                    txtalamat1.setText(res.getString("alamat"));
                    java.util.Date vtgl_kelahiran = null;
                    datetglkelahiran1.setDate(res.getDate("tgl_kelahiran"));
                    java.util.Date vtgl_kematin = null;
                    datetglkematian1.setDate(res.getDate("tgl_kematian"));
                    combohari1.setSelectedItem(res.getString("hari_kematian"));
                    txtumur1.setText(res.getString("umur"));
                    txttmptkematian1.setText(res.getString("tmpt_kematian"));
                    txtsbbkematian1.setText(res.getString("sebab_kematian"));
                    txtpekerjaan1.setText(res.getString("pekerjaan"));
                    txtkewarganegaraan1.setText(res.getString("kewarganegaraan"));
                    comboagama1.setSelectedItem(res.getString("agama"));
                    combostatus1.setSelectedItem(res.getString("status_perkawinan"));
                    txtnokk1.setText(res.getString("No.KK"));                  
                    txtnamapelapor1.setText(res.getString("nama_pelapor"));
                    combohubpelapor1.setSelectedItem(res.getString("hub_pelapor"));
                    txtpetugas1.setText(res.getString("petugas"));

                /*if(res.getBlob("foto").getBinaryStream() == null){
                    lbFoto.setIcon(new javax.swing.ImageIcon(getClass().
                            getResource("/Image/no-picture.jpg")));
                }else{
                   InputStream is = res.getBlob("foto").getBinaryStream();
                       ImageIcon icon = new ImageIcon(resize(ImageIO.read(is), 
                               lbFoto.getWidth(), lbFoto.getHeight()));
                       lbFoto.setIcon(icon);
                }*/
            }
          
    
            
            }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method gettablekematian() : "+ex, 
               "Informasi", JOptionPane.INFORMATION_MESSAGE);
            }
//        } catch (IOException ex) {
//            Logger.getLogger(FrDatabarang.class.getName()).log(Level.SEVERE, null, ex);
//        }
        }
    
    
        
    
    
    
        private void ClearInput(){
                    txtnoktp1.setText("");
                    txtnamalengkap1.setText("");
                    txtjk1.setText("");
                    txtalamat1.setText("");
                    datetglkelahiran1.setDate(new Date());
                    datetglkematian1.setDate(new Date());
                    combohari1.setSelectedItem(0);
                    txtumur1.setText("");
                    txttmptkematian1.setText("");
                    txtsbbkematian1.setText("");
                    txtpekerjaan1.setText("");
                    txtkewarganegaraan1.setText("");
                    comboagama1.setSelectedItem(0);
                    combostatus1.setSelectedItem(0);
                    txtnokk1.setText("");                  
                    txtnamapelapor1.setText("");
                    combohubpelapor1.setSelectedItem(0);
                    txtpetugas1.setText("");
        
    }
        
        private void setTabelkematian(){
        String[] kolom1 = {"no_ktp","nama_lengkap", "tgl_kelahiran", "tgl_kematian", "hari_kematian", "umur", "tempat_kematian", 
             "sebab_kematian", "pekerjaan", "kewarganegaraan", "agama", "status_perkawinan", "No.KK", "nama_pelapor", "hub_pelapor", "petugas"};
        tbkematian = new DefaultTableModel(null, kolom1){
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
            };
            public Class getColumnClass(int columnIndex){
                return types [columnIndex];
            }
            public boolean isCellEditable(int row, int col){
                int cola = tabelkematian.getColumnCount();
                //java.lang.String.class,
                //java.lang.String.ctColumnCount();
                return (col < cola) ? true : true;
            }
                };
                 // agar tabel bisa diedit
            
            
        
        tabelkematian.setModel(tbkematian);
        tabelkematian.getColumnModel().getColumn(0).setPreferredWidth(75);
        tabelkematian.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabelkematian.getColumnModel().getColumn(2).setPreferredWidth(25);
        tabelkematian.getColumnModel().getColumn(3).setPreferredWidth(75);
        tabelkematian.getColumnModel().getColumn(4).setPreferredWidth(75);
        tabelkematian.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(6).setPreferredWidth(300);
        tabelkematian.getColumnModel().getColumn(7).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(8).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(9).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(10).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(11).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(12).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(13).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(14).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(15).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(16).setPreferredWidth(150);
        tabelkematian.getColumnModel().getColumn(17).setPreferredWidth(150);
    }
          private void showDatakematian(){
            try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
           
            sqlselect = "select * from kematian where no_ktp='' "; 
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            
            while(res.next()){
                Object[]obj=new Object[18];
                obj[0]=res.getString("no_ktp");
                obj[1]=res.getString("nama_lengkap");
                obj[2]=res.getString("jk");
                obj[3]=res.getString("alamat");
                obj[4]=res.getString("tgl_kelahiran");
                obj[5]=res.getString("tgl_kematian");
                obj[6]=res.getString("hari_kematian");
                obj[7]=res.getString("umur");
                obj[8]=res.getString("tempat_kematian");
                obj[9]=res.getString("sebab_kematian");
                obj[10]=res.getString("pekerjaan");
                obj[11]=res.getString("kewarganegaraan");
                obj[12]=res.getString("agama");
                obj[13]=res.getString("status_perkawinan");
                obj[14]=res.getString("No.KK");
                obj[15]=res.getString("nama_pelapor");
                obj[16]=res.getString("hub_pelapor");
                obj[17]=res.getString("petugas");
                
                        
                model.addRow(obj);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method showDataRGuru(): " + ex);
        }
    }
         private void getDatakematian(){
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sqlselect = "select * from kematian"; 
                    
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            if(res.first()){
                   txtnoktp1.setText(res.getString("no_ktp"));
                    txtnamalengkap1.setText(res.getString("nama_lengkap"));
                    txtjk1.setText(res.getString("jk"));
                    txtalamat1.setText(res.getString("alamat"));
                    java.util.Date vtgl_kelahiran = null;
                    datetglkelahiran1.setDate(res.getDate("tgl_kelahiran"));
                    java.util.Date vtgl_kematin = null;
                    datetglkematian1.setDate(res.getDate("tgl_kematian"));
                    combohari1.setSelectedItem(res.getString("hari_kematian"));
                    txtumur1.setText(res.getString("umur"));
                    txttmptkematian1.setText(res.getString("tempat_kematian"));
                    txtsbbkematian1.setText(res.getString("sebab_kematian"));
                    txtpekerjaan1.setText(res.getString("pekerjaan"));
                    txtkewarganegaraan1.setText(res.getString("kewarganegaraan"));
                    comboagama1.setSelectedItem(res.getString("agama"));
                    combostatus1.setSelectedItem(res.getString("status_perkawinan"));
                    txtnokk1.setText(res.getString("No.KK"));                  
                    txtnamapelapor1.setText(res.getString("nama_pelapor"));
                    combohubpelapor1.setSelectedItem(res.getString("hub_pelapor"));
                    txtpetugas1.setText(res.getString("petugas"));
                /*if(res.getBlob("foto").getBinaryStream() == null){
                    lbFoto.setIcon(new javax.swing.ImageIcon(getClass().
                            getResource("/Image/no-picture.jpg")));
                }else{
                   InputStream is = res.getBlob("foto").getBinaryStream();
                       ImageIcon icon = new ImageIcon(resize(ImageIO.read(is), 
                               lbFoto.getWidth(), lbFoto.getHeight()));
                       lbFoto.setIcon(icon);
                }*/
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method getDataKematian() : "+ex, 
               "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
          
         
   /* private void listRuang(){
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sqlselect = "select * from tb_ruang order by id_ruang asc";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            cbidruang.removeAllItems();
            cbidruang.repaint();
            cbidruang.addItem("-- KP01 --");
            int i = 1;
            while(res.next()){
                cbidruang.addItem(res.getString(2));
                i++;
            }
            res.first();
            KeyRuang = new String[i+1];
            for(Integer x = 1;x < i;x++){
                KeyRuang[x] = res.getString(1);
                res.next();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method listRuang() : " 
                    + ex, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
        String[] KeyKondisi;
    private void listKondisi(){
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sqlselect = "select kondisi"
                    + " from tb_barang order by id_barang asc";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            cbkondisi.removeAllItems();
            cbkondisi.repaint();
            cbkondisi.addItem("-- Baik --");
            int i = 1;
            while(res.next()){
                cbkondisi.addItem(res.getString(2));
                i++;
            }
            res.first();
            KeyKondisi = new String[i+1];
            for(Integer x = 1;x < i;x++){
                KeyKondisi[x] = res.getString(1);
                res.next();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method listKondisi() : " 
                    + ex, "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
          
    }
    */

        private void AksiSimpan(){
        vno_ktp = txtnoktp1.getText();
        vnama_lengkap = txtnamalengkap1.getText();
        vjk = txtjk1.getText();
        valamat = txtalamat1.getText();
        SimpleDateFormat tanggalkelahiran= new SimpleDateFormat("yyy-MM-dd");
        String t = tanggalkelahiran.format(datetglkelahiran1.getDate());
        vtanggalkelahiran = t;
         SimpleDateFormat tanggalkematian= new SimpleDateFormat("yyy-MM-dd");
        String y = tanggalkematian.format(datetglkematian1.getDate());
        vtanggalkematian = y;
        vhari_kematian = combohari1.getSelectedItem().toString();
        vumur = txtumur1.getText();
        vtmp_kematian = txttmptkematian1.getText();
        vsebab_kematian = txtsbbkematian1.getText();
        vpekerjaan = txtpekerjaan1.getText();
        vkewarganegaraan = txtkewarganegaraan1.getText();
        vagama = comboagama1.getSelectedItem().toString();
        vsatus_perkawinan = combostatus1.getSelectedItem().toString();
        vno_kk = txtnokk1.getText();
        vnama_pelapor = txtnamapelapor1.getText();
        vhub_pelapor = combohubpelapor1.getSelectedItem().toString();
        vpetugas = txtpetugas1.getText();
       
         if(btnsimpan1.getText().equals("Simpan")){
            sqlinsert = "insert into kematian values('"+vno_ktp+"','"+vnama_lengkap+"','"+vjk+"','"+valamat+"','"+vtanggalkelahiran+"','"+vtanggalkematian+"','"+vhari_kematian+"',"
                    + "'"+vumur+"','"+vtmp_kematian+"','"+vsebab_kematian+"','"+vpekerjaan+"','"+vkewarganegaraan+"','"+vagama+"','"+vsatus_perkawinan+"','"+vno_kk+"', "
                    + "'"+vnama_pelapor+"','"+vhub_pelapor+"','"+vpetugas+"')";
                                                                  
            
//        }else if(btnsimpan.getText().equals("Update")){
//            sqlupdate = "update tb_barang set id_barang='"+vidbarang+"', nama_kategori='"+vnama_kategori+"', id_ruang='"+vidruang+"', nama_barang='"+vnamabarang+"','"
//                    + "', kondisi='"+vkondisi+"', merek='"+vmerek+"', harga='"+vharga+"', bahan='"+vbahan+"', keterangan='"+vketerangan+"',thn_perolehan='"+vthnperolehan+"','"
//                    + " where id_barang='"+vidbarang+"','";
//            JOptionPane.showMessageDialog(this, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
//        
        }else{
            JOptionPane.showMessageDialog(this, "Data tidak berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            Statement stat = _Cnn.createStatement();
            stat.executeUpdate(sqlinsert);
            //stat.executeUpdate(sqlupdate);
//            pst = _Cnn.prepareStatement(sqlupdate);
//                pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
              //disableForm();showDataTabel();
             new tablekematian().show();
               this.dispose();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method aksiSimpan() : "+ex);
        }
    
        };
    
    
       private void aksiUpdate(){
 
        vno_ktp = txtnoktp1.getText();
        vnama_lengkap = txtnamalengkap1.getText();
        vjk = txtjk1.getText();
        valamat = txtalamat1.getText();
        SimpleDateFormat tanggalkelahiran= new SimpleDateFormat("yyy-MM-dd");
        String t = tanggalkelahiran.format(datetglkelahiran1.getDate());
        vtanggalkelahiran = t;
         SimpleDateFormat tanggalkematian= new SimpleDateFormat("yyy-MM-dd");
        String y = tanggalkematian.format(datetglkematian1.getDate());
        vtanggalkematian = y;
        vhari_kematian = combohari1.getSelectedItem().toString();
        vumur = txtumur1.getText();
        vtmp_kematian = txttmptkematian1.getText();
        vsebab_kematian = txtsbbkematian1.getText();
        vpekerjaan = txtpekerjaan1.getText();
        vkewarganegaraan = txtkewarganegaraan1.getText();
        vagama = comboagama1.getSelectedItem().toString();
        vsatus_perkawinan = combostatus1.getSelectedItem().toString();
        vno_kk = txtnokk1.getText();
        vnama_pelapor = txtnamapelapor1.getText();
        vhub_pelapor = combohubpelapor1.getSelectedItem().toString();
        vpetugas = txtpetugas1.getText();
       
        
        
        if(btnsimpan1.getText().equals("Update")){
            sqlupdate = "update kematian set nama_lengkap='"+vnama_lengkap+"',jk='"+vjk+"',"
                    + "alamat='"+valamat+"',tgl_kelahiran='"+vtgl_kelahiran+"',tgl_kematian='"+vtgl_kematian+"',hari_kematian='"+vhari_kematian+"',"
                    + "umur='"+vumur+"',tempat_kematian='"+ vtmp_kematian+"',sebab_kematian='"+vsebab_kematian+"', pekerjaan= '"+vpekerjaan+"', kewarganegaraan= '"+vkewarganegaraan+"',"
                    + "agama='"+vagama+"', status_perkawinan='"+vsatus_perkawinan+"',no_ktp='"+vno_kk+"', nama_pelapor='"+vhub_pelapor+"', petugas='"+vpetugas+"'"
                    + "where no_ktp='"+vno_ktp+"' ";
            
            
        }
          
            
       
        
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            Statement stat = _Cnn.createStatement();
            stat.executeUpdate(sqlupdate);
            JOptionPane.showMessageDialog(this, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
              //disableForm();showDataTabel();
             new tablekematian().show();
               this.dispose();
               JdInputKematian.setVisible(false);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method aksiUpdate() : "+ex);
        }
    
        };
       
       private void AksiHapus(){
        int jawab = JOptionPane.showConfirmDialog(this, "Anda yakin akan menghapus data ini? No.KTP : "+vno_ktp+"", 
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(jawab == JOptionPane.YES_OPTION){
            try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                sqldelete = "delete from kematian where no_ktp='"+vno_ktp+"'";
                Statement stat = _Cnn.createStatement();
                stat.executeUpdate(sqldelete);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                
                   //disableForm();showDataTabel();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Error method aksiHapus() : "+ex);
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JdInputKematian = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblnamalengkap1 = new javax.swing.JLabel();
        txtnamalengkap1 = new javax.swing.JTextField();
        lbljk1 = new javax.swing.JLabel();
        lbtglkelahiran1 = new javax.swing.JLabel();
        datetglkematian1 = new com.toedter.calendar.JDateChooser();
        lblalamat1 = new javax.swing.JLabel();
        txtalamat1 = new javax.swing.JTextField();
        lbltglkematian1 = new javax.swing.JLabel();
        datetglkelahiran1 = new com.toedter.calendar.JDateChooser();
        lblhari1 = new javax.swing.JLabel();
        combohari1 = new javax.swing.JComboBox<>();
        lblumur1 = new javax.swing.JLabel();
        txtumur1 = new javax.swing.JTextField();
        lblkewarganegaraan1 = new javax.swing.JLabel();
        lblagama1 = new javax.swing.JLabel();
        comboagama1 = new javax.swing.JComboBox<>();
        lblstatus1 = new javax.swing.JLabel();
        combostatus1 = new javax.swing.JComboBox<>();
        lblpekerjaan1 = new javax.swing.JLabel();
        txtpekerjaan1 = new javax.swing.JTextField();
        lbltmptkematian1 = new javax.swing.JLabel();
        lblsbbkematian1 = new javax.swing.JLabel();
        txtsbbkematian1 = new javax.swing.JTextField();
        lblnokk1 = new javax.swing.JLabel();
        txtnokk1 = new javax.swing.JTextField();
        txtnoktp1 = new javax.swing.JTextField();
        lblnoktp1 = new javax.swing.JLabel();
        lblnamapelapor1 = new javax.swing.JLabel();
        txtnamapelapor1 = new javax.swing.JTextField();
        lblhubpelapor1 = new javax.swing.JLabel();
        combohubpelapor1 = new javax.swing.JComboBox<>();
        lblpetugas1 = new javax.swing.JLabel();
        txtpetugas1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        btnbatal1 = new javax.swing.JButton();
        btnsimpan1 = new javax.swing.JButton();
        txttmptkematian1 = new javax.swing.JTextField();
        radiolk1 = new javax.swing.JRadioButton();
        radiopr1 = new javax.swing.JRadioButton();
        radiowni1 = new javax.swing.JRadioButton();
        radiowna1 = new javax.swing.JRadioButton();
        txtjk1 = new javax.swing.JLabel();
        txtkewarganegaraan1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        iconkeluar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkematian = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtpencarian = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnubah = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        txtjumlah = new javax.swing.JTextField();

        jPanel6.setBackground(new java.awt.Color(0, 51, 153));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("APLIKASI PELAYANAN SURAT KEMATIAN DAN KELAHIRAN");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("DESA BULAKSARI");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("KECAMATAN SRAGI KABUPATEN PEEKALONGAN");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-embassy-50 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel9))
                .addContainerGap(463, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblnamalengkap1.setText("Nama Lengkap :");

        txtnamalengkap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamalengkap1ActionPerformed(evt);
            }
        });

        lbljk1.setText("Jenis Kelamin  : ");

        lbtglkelahiran1.setText("Tgl Kelahiran :        ");

        lblalamat1.setText("Alamat : ");

        txtalamat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalamat1ActionPerformed(evt);
            }
        });

        lbltglkematian1.setText("Tgl Kematian :        ");

        datetglkelahiran1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datetglkelahiran1PropertyChange(evt);
            }
        });

        lblhari1.setText("Hari Kematian :");

        combohari1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu" }));
        combohari1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohari1ActionPerformed(evt);
            }
        });

        lblumur1.setText("Umur :");

        txtumur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtumur1ActionPerformed(evt);
            }
        });

        lblkewarganegaraan1.setText("Kewarganegaraan:");

        lblagama1.setText("Agama :");

        comboagama1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Islam", "Kristen", "Katolik", "Hindu", "Budha", "Konghucu" }));
        comboagama1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboagama1ActionPerformed(evt);
            }
        });

        lblstatus1.setText("Status Perkawinan:");

        combostatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Kawin", "Belum Kawin", "Cerai" }));
        combostatus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combostatus1ActionPerformed(evt);
            }
        });

        lblpekerjaan1.setText("Pekerjaan :");

        txtpekerjaan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpekerjaan1ActionPerformed(evt);
            }
        });

        lbltmptkematian1.setText("Tempat Kematian :");

        lblsbbkematian1.setText("Sebab Kematian :");

        lblnokk1.setText("No.KK :");

        lblnoktp1.setText("No KTP :");

        lblnamapelapor1.setText("Nama Pelapor :");

        txtnamapelapor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamapelapor1ActionPerformed(evt);
            }
        });

        lblhubpelapor1.setText("Hub Pelapor :");

        combohubpelapor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Orang Tua", "Anak", "Saudara Kandung", "Anak Angkat", "Lain-lain" }));
        combohubpelapor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combohubpelapor1ActionPerformed(evt);
            }
        });

        lblpetugas1.setText("Petugas");

        txtpetugas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpetugas1ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setText("DATA KEMATIAN");

        btnbatal1.setBackground(new java.awt.Color(0, 51, 153));
        btnbatal1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnbatal1.setForeground(new java.awt.Color(255, 255, 255));
        btnbatal1.setText("Batal");
        btnbatal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatal1ActionPerformed(evt);
            }
        });

        btnsimpan1.setBackground(new java.awt.Color(0, 51, 153));
        btnsimpan1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsimpan1.setForeground(new java.awt.Color(255, 255, 255));
        btnsimpan1.setText("Simpan");
        btnsimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpan1ActionPerformed(evt);
            }
        });

        radiolk1.setText("Laki-laki");
        radiolk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiolk1ActionPerformed(evt);
            }
        });

        radiopr1.setText("Perempuan");
        radiopr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiopr1ActionPerformed(evt);
            }
        });

        radiowni1.setText("WNI");
        radiowni1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiowni1ActionPerformed(evt);
            }
        });

        radiowna1.setText("WNA");
        radiowna1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiowna1ActionPerformed(evt);
            }
        });

        txtjk1.setForeground(new java.awt.Color(255, 255, 255));

        txtkewarganegaraan1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblumur1)
                                        .addGap(64, 64, 64))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lbltmptkematian1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtumur1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(txttmptkematian1)))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel30)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblhari1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(combohari1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                                .addComponent(lblnamalengkap1)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtnamalengkap1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbljk1)
                                                    .addComponent(lblalamat1)
                                                    .addComponent(lbtglkelahiran1, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtalamat1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(datetglkelahiran1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                                        .addComponent(radiolk1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(radiopr1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtjk1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                                .addComponent(lbltglkematian1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(datetglkematian1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(10, 10, 10)))))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblnamapelapor1)
                                                        .addComponent(lblnoktp1))
                                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblpetugas1)
                                                        .addComponent(lblhubpelapor1))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblnokk1))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                                .addComponent(btnbatal1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnsimpan1)
                                                .addGap(0, 29, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblstatus1)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnoktp1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(txtnokk1)
                                            .addGap(1, 1, 1))
                                        .addComponent(combostatus1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtnamapelapor1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblagama1)
                                        .addGap(28, 28, 28)
                                        .addComponent(comboagama1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtpetugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(combohubpelapor1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(1, 1, 1))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(lblpekerjaan1)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtpekerjaan1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(lblkewarganegaraan1)
                                .addGap(18, 18, 18)
                                .addComponent(radiowni1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radiowna1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtkewarganegaraan1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(lblsbbkematian1)
                        .addGap(16, 16, 16)
                        .addComponent(txtsbbkematian1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnamalengkap1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblnamalengkap1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtpekerjaan1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblpekerjaan1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblalamat1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtalamat1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbtglkelahiran1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datetglkelahiran1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltglkematian1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datetglkematian1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblhari1)
                            .addComponent(combohari1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtumur1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblumur1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltmptkematian1)
                            .addComponent(txttmptkematian1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsbbkematian1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblsbbkematian1))
                        .addGap(169, 169, 169))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(radiopr1)
                                .addComponent(radiolk1)
                                .addComponent(lbljk1)
                                .addComponent(txtjk1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtkewarganegaraan1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblkewarganegaraan1)
                                    .addComponent(radiowni1)
                                    .addComponent(radiowna1))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboagama1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblagama1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combostatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblstatus1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnokk1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnokk1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnoktp1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnoktp1))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnamapelapor1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnamapelapor1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combohubpelapor1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblhubpelapor1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpetugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpetugas1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnbatal1)
                            .addComponent(btnsimpan1))
                        .addGap(67, 67, 67))))
        );

        javax.swing.GroupLayout JdInputKematianLayout = new javax.swing.GroupLayout(JdInputKematian.getContentPane());
        JdInputKematian.getContentPane().setLayout(JdInputKematianLayout);
        JdInputKematianLayout.setHorizontalGroup(
            JdInputKematianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JdInputKematianLayout.createSequentialGroup()
                .addGroup(JdInputKematianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JdInputKematianLayout.setVerticalGroup(
            JdInputKematianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JdInputKematianLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        iconkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-exit-32.png"))); // NOI18N
        iconkeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconkeluarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconkeluar)
                        .addGap(97, 97, 97))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconkeluar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabelkematian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.KTP", "Nama Lengkap", "Jenis Kelamin", "Alamat", "Tgl Kelahiran", "Tgl Kematian", "Hari Kematian", "Umur", "Tempat Kematian", "Sebab Kematian", "Pekerjaan", "Kewarganegaraan", "Agama", "Status Perkawinan", "No.KK", "Nama Pelapor", "Hub.pelapor", "Petugas"
            }
        ));
        tabelkematian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkematianMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelkematian);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("TABEL DATA KEMATIAN");

        txtpencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpencarianActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-30.png"))); // NOI18N

        btnubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trans-edit.png"))); // NOI18N
        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/insert.png"))); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trans-hapus.png"))); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapusMouseClicked(evt);
            }
        });
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btntambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnubah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnhapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(593, 593, 593)
                                .addComponent(txtpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btntambah)
                        .addComponent(btnubah)
                        .addComponent(btnhapus)
                        .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
     
    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
 getDatakematian();
    JdInputKematian.setVisible(true);
    
    txtnoktp1.setEnabled(false);
    
    btnsimpan1.setText("Update");
    //txtidbarang.setEnabled(false);
    //judul.setText("Edit Barang");
    //btnsimpan.setText("Update");
//        new ubahkematian().setVisible(true); 
//        getdata();

//        ubahkematian.setDefaultLookAndFeelDecorated(rootPaneCheckingEnabled);
//       // ubahkematian.setVisible(true); 
//        ambildata();    
//        // TODO add your handling code here:
    }//GEN-LAST:event_btnubahActionPerformed

    private void iconkeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconkeluarMouseClicked
new beranda().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_iconkeluarMouseClicked

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
    JdInputKematian.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
AksiHapus();
new tablekematian().show();
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhapusActionPerformed

    private void tabelkematianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkematianMouseClicked
 if(evt.getClickCount()==1){
            int brs = tabelkematian.getSelectedRow();
            vno_ktp= tabelkematian.getValueAt(brs, 0).toString(); 
            vnama_lengkap = tabelkematian.getValueAt(brs, 1).toString();
            vjk = tabelkematian.getValueAt(brs, 2).toString();
            valamat = tabelkematian.getValueAt(brs, 3).toString();
            vtgl_kelahiran = tabelkematian.getValueAt(brs, 4).toString();
            vtgl_kematian = tabelkematian.getValueAt(brs, 5).toString();
            vhari_kematian = tabelkematian.getValueAt(brs, 6).toString();
            vumur = tabelkematian.getValueAt(brs, 7).toString();
            vtmp_kematian = tabelkematian.getValueAt(brs, 8).toString();
            vsebab_kematian = tabelkematian.getValueAt(brs, 9).toString();
            vpekerjaan = tabelkematian.getValueAt(brs, 10).toString();
            vkewarganegaraan = tabelkematian.getValueAt(brs, 11).toString();
            vagama = tabelkematian.getValueAt(brs, 12).toString();
            vsatus_perkawinan= tabelkematian.getValueAt(brs, 13).toString(); 
            vno_kk= tabelkematian.getValueAt(brs, 14).toString(); 
            vnama_pelapor= tabelkematian.getValueAt(brs, 15).toString(); 
            vhub_pelapor= tabelkematian.getValueAt(brs, 16).toString(); 
            vpetugas= tabelkematian.getValueAt(brs, 17).toString(); 
        
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelkematianMouseClicked

    private void txtnamalengkap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamalengkap1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamalengkap1ActionPerformed

    private void txtalamat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalamat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamat1ActionPerformed

    private void datetglkelahiran1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datetglkelahiran1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_datetglkelahiran1PropertyChange

    private void combohari1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohari1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combohari1ActionPerformed

    private void txtumur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtumur1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtumur1ActionPerformed

    private void comboagama1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboagama1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboagama1ActionPerformed

    private void combostatus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combostatus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combostatus1ActionPerformed

    private void txtpekerjaan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpekerjaan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpekerjaan1ActionPerformed

    private void txtnamapelapor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamapelapor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamapelapor1ActionPerformed

    private void combohubpelapor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combohubpelapor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combohubpelapor1ActionPerformed

    private void txtpetugas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpetugas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpetugas1ActionPerformed

    private void btnbatal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbatal1ActionPerformed

    private void btnsimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpan1ActionPerformed
        if(btnsimpan1.getText().equals("Simpan")){
        AksiSimpan();
        }else if(btnsimpan1.getText().equals("Update")){
        aksiUpdate();
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnsimpan1ActionPerformed

    private void radiolk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiolk1ActionPerformed
       JK="laki-laki";
        radiopr1.setSelected(false);
        
        txtjk1.setText(JK);  
    }//GEN-LAST:event_radiolk1ActionPerformed

    private void radiopr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiopr1ActionPerformed
        JK="Perempuan";
        radiolk1.setSelected(false);
        
        txtjk1.setText(JK);
    }//GEN-LAST:event_radiopr1ActionPerformed

    private void radiowni1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowni1ActionPerformed
        kewarganegaraan="WNI";
        radiowni1.setSelected(false);
        
        
        txtkewarganegaraan1.setText(kewarganegaraan);
        // TODO add your handling code here:
    }//GEN-LAST:event_radiowni1ActionPerformed

    private void txtpencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpencarianActionPerformed
        DefaultTableModel tabel = (DefaultTableModel)tabelkematian.getModel();
        String sc = txtpencarian.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tabel);
        tabelkematian.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(sc));
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpencarianActionPerformed

    private void btnhapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapusMouseClicked
       if(evt.getClickCount()==1){
            int brs = tabelkematian.getSelectedRow();
            vno_ktp= tabelkematian.getValueAt(brs, 0).toString(); 
            vnama_lengkap = tabelkematian.getValueAt(brs, 1).toString();
            vjk = tabelkematian.getValueAt(brs, 2).toString();
            valamat = tabelkematian.getValueAt(brs, 3).toString();
            vtgl_kelahiran = tabelkematian.getValueAt(brs, 4).toString();
            vtgl_kematian = tabelkematian.getValueAt(brs, 5).toString();
            vhari_kematian = tabelkematian.getValueAt(brs, 6).toString();
            vumur = tabelkematian.getValueAt(brs, 7).toString();
            vtmp_kematian = tabelkematian.getValueAt(brs, 8).toString();
            vsebab_kematian = tabelkematian.getValueAt(brs, 9).toString();
            vpekerjaan = tabelkematian.getValueAt(brs, 10).toString();
            vkewarganegaraan = tabelkematian.getValueAt(brs, 11).toString();
            vagama = tabelkematian.getValueAt(brs, 12).toString();
            vsatus_perkawinan= tabelkematian.getValueAt(brs, 13).toString(); 
            vno_kk= tabelkematian.getValueAt(brs, 14).toString(); 
            vnama_pelapor= tabelkematian.getValueAt(brs, 15).toString(); 
            vhub_pelapor= tabelkematian.getValueAt(brs, 16).toString(); 
            vpetugas= tabelkematian.getValueAt(brs, 17).toString(); 
        
        }
 
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhapusMouseClicked

    private void radiowna1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowna1ActionPerformed
        kewarganegaraan="WNA";
        radiowna1.setSelected(false);
        
        
        txtkewarganegaraan1.setText(kewarganegaraan);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_radiowna1ActionPerformed

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
            java.util.logging.Logger.getLogger(tablekematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablekematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablekematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablekematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablekematian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame JdInputKematian;
    private javax.swing.JButton btnbatal1;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan1;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox<String> comboagama1;
    private javax.swing.JComboBox<String> combohari1;
    private javax.swing.JComboBox<String> combohubpelapor1;
    private javax.swing.JComboBox<String> combostatus1;
    private com.toedter.calendar.JDateChooser datetglkelahiran1;
    private com.toedter.calendar.JDateChooser datetglkematian1;
    private javax.swing.JLabel iconkeluar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblagama1;
    private javax.swing.JLabel lblalamat1;
    private javax.swing.JLabel lblhari1;
    private javax.swing.JLabel lblhubpelapor1;
    private javax.swing.JLabel lbljk1;
    private javax.swing.JLabel lblkewarganegaraan1;
    private javax.swing.JLabel lblnamalengkap1;
    private javax.swing.JLabel lblnamapelapor1;
    private javax.swing.JLabel lblnokk1;
    private javax.swing.JLabel lblnoktp1;
    private javax.swing.JLabel lblpekerjaan1;
    private javax.swing.JLabel lblpetugas1;
    private javax.swing.JLabel lblsbbkematian1;
    private javax.swing.JLabel lblstatus1;
    private javax.swing.JLabel lbltglkematian1;
    private javax.swing.JLabel lbltmptkematian1;
    private javax.swing.JLabel lblumur1;
    private javax.swing.JLabel lbtglkelahiran1;
    private javax.swing.JRadioButton radiolk1;
    private javax.swing.JRadioButton radiopr1;
    private javax.swing.JRadioButton radiowna1;
    private javax.swing.JRadioButton radiowni1;
    private javax.swing.JTable tabelkematian;
    private javax.swing.JTextField txtalamat1;
    private javax.swing.JLabel txtjk1;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JLabel txtkewarganegaraan1;
    private javax.swing.JTextField txtnamalengkap1;
    private javax.swing.JTextField txtnamapelapor1;
    private javax.swing.JTextField txtnokk1;
    private javax.swing.JTextField txtnoktp1;
    private javax.swing.JTextField txtpekerjaan1;
    private javax.swing.JTextField txtpencarian;
    private javax.swing.JTextField txtpetugas1;
    private javax.swing.JTextField txtsbbkematian1;
    private javax.swing.JTextField txttmptkematian1;
    private javax.swing.JTextField txtumur1;
    // End of variables declaration//GEN-END:variables

  

   
}
