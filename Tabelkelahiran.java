
package from;
import tool.aplikasikependudukan;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import static org.apache.log4j.NDC.clear;

public class Tabelkelahiran extends javax.swing.JFrame {

  
     aplikasikependudukan getCnn = new aplikasikependudukan();
     Connection _Cnn;
     String sqlselect, sqlinsert, sqldelete,sqlupdate,JK,kewarganegaraan;
     
    ResultSet data1=null; 
    private static String no_ktpayah= "";
    String  vnama_bayi, vhari,vtanggal_lahir, vtempat_lahir,vjk,vagama, vtempat_kelahiran,
            vpenolong_kelahiran,vnama_ibu,valamat, vtanggal_lahir_ibu, vumur_ibu,vkewarganegaraan_ibu,vnama_ayah,vtanggal_lahir_ayah,
            vumur_ayah,vkewarganegaraan_ayah,vno_kk,vno_ktp_ayah,vpetugas;
     PreparedStatement pst;
     private DefaultTableModel tbkelahiran;
     private DefaultTableModel model;
     private Object No;

    public Tabelkelahiran() {
        initComponents();
         JdInputKelahiran.setSize(900, 680);
         JdInputKelahiran.setLocationRelativeTo(this);
        
        model=new DefaultTableModel();
        tabelkelahiran.setModel(model);
        model.addColumn("nama_bayi");
        model.addColumn("hari");
        model.addColumn("tanggal_lahir");
        model.addColumn("tempat_lahir");
        model.addColumn("jk");
        model.addColumn("agama");
        model.addColumn("tempat_kelahiran");
        model.addColumn("penolong_kelahiran");
        model.addColumn("nama_ibu");
        model.addColumn("alamat");
        model.addColumn("tanggal_lahir_ibu");
        model.addColumn("umur_ibu");
        model.addColumn("kewarganegaraan_ibu");
        model.addColumn("nama_ayah");
        model.addColumn("tanggal_lahir_ayah");
        model.addColumn("umur_ayah");
        model.addColumn("kewarganegaraan_ayah");
        model.addColumn("no_kk");
        model.addColumn("no_ktp_ayah");
        model.addColumn("petugas");
       
        showdatakelahiran();
 
      /*          
         String[] kolom1 = {"nama_bayi", "hari", "tanggal_lahir", "tempat_lahir","jk","agama",
             "tempat_kelahiran","penolong_kelahiran","nama_ibu","alamat","tanggal_lahir_ibu",
             "umur_ibu","kewarganegaraan_ibu","nama_ayah","tanggal_lahir_ayah","umur_ayah","kewarganegaraan_ayah","no_kk","no_ktp_ayah","petugas" 
         };
        tbkelahiran = new DefaultTableModel(null, kolom1){
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
                java.lang.String.class,
                java.lang.String.class,
              };
    };*/
                }
    
     private void clearInput(){
        txtnamabayi.setText("");
        combohari.setSelectedIndex(0);
        datetglbayi.setDate(new java.util.Date());
        txttmptlahir.setText("");
        txtjk.setText("");
        comboagama.setSelectedIndex(0);
        combotempatlahir.setSelectedIndex(0);
        combopenolong.setSelectedIndex(0);
        txtnamaibu.setText("");
        txtalamat.setText("");
        dateibu.setDate(new java.util.Date());
        txtumuribu.setText("");
        txtwarganegaraibu.setText("");
        txtnamaayah.setText("");
        txtumurayah.setText("");
        txtwarganegaraayah.setText("");
        txtkk.setText("");
        txtnik.setText("");
        txtpetugas.setText("");
        btnsimpan.setText("Simpan");
        btnbatal.setText("Batal");
        vno_ktp_ayah="";
        
    }
      private void settabelkelahiran(){
        String[] kolom1 = {"nama_bayi","hari", "tanggal_lahir", "tempat_lahir", "jk", "", "agama", 
             "tempat_kelahiran", "penolong_kelahiran", "nama_ibu","alamat","tanggal_lahir_ibu","umur_ibu","kewarganegaraan_ibu","nama_ayah","tanggal_lahir_ayah","no_kk","no_ktp_ayah","petugas"};
        tbkelahiran = new DefaultTableModel(null, kolom1){
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
                java.lang.String.class,
                java.lang.String.class,
            };
            public Class getColumnClass(int columnIndex){
                return types [columnIndex];
            }
            public boolean isCellEditable(int row, int col){
                int cola = tabelkelahiran.getColumnCount();
                //java.lang.String.class,
                //java.lang.String.ctColumnCount();
                return (col < cola) ? true : true;
            }
                };
                 // agar tabel bisa diedit
            
        tabelkelahiran.setModel(tbkelahiran);
        tabelkelahiran.getColumnModel().getColumn(0).setPreferredWidth(75);
        tabelkelahiran.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabelkelahiran.getColumnModel().getColumn(2).setPreferredWidth(25);
        tabelkelahiran.getColumnModel().getColumn(3).setPreferredWidth(75);
        tabelkelahiran.getColumnModel().getColumn(4).setPreferredWidth(75);
        tabelkelahiran.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(6).setPreferredWidth(300);
        tabelkelahiran.getColumnModel().getColumn(7).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(8).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(9).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(10).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(11).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(12).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(13).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(14).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(15).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(16).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(17).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(18).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(19).setPreferredWidth(150);
    }
      
       private void aksiHapus(){
        int jawab = JOptionPane.showConfirmDialog(this, "Anda yakin akan menghapus data ini? No.KTP Ayah : "+vno_ktp_ayah, 
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(jawab == JOptionPane.YES_OPTION){
            try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                sqldelete = "delete from kelahiran where no_ktp_ayah ='" +vno_ktp_ayah+ "'";
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
        vnama_bayi = txtnamabayi.getText();
        vhari =combohari.getSelectedItem().toString();
        SimpleDateFormat tanggallahir= new SimpleDateFormat("yyy-MM-dd");
        String t = tanggallahir.format(datetglbayi.getDate());
        vtanggal_lahir = t;
        vtempat_lahir=txttmptlahir.getText();
        vjk = txtjk.getText();
        vagama = comboagama.getSelectedItem().toString();
        vtempat_kelahiran = combotempatlahir.getSelectedItem().toString();
        vpenolong_kelahiran = combopenolong.getSelectedItem().toString();
        vnama_ibu = txtnamaibu.getText();
        valamat = txtalamat.getText();
        SimpleDateFormat tanggallahiribu= new SimpleDateFormat("yyy-MM-dd");
        String y = tanggallahiribu.format(dateibu.getDate());
        vtanggal_lahir_ibu = y;
        vumur_ibu = txtumuribu.getText();
        vkewarganegaraan_ibu = txtwarganegaraibu.getText();
        vnama_ayah = txtnamaayah.getText();
        SimpleDateFormat tanggallahirayah= new SimpleDateFormat("yyy-MM-dd");
        String z = tanggallahirayah.format(datetglayah.getDate());
        vtanggal_lahir_ayah = z;
        vumur_ayah = txtumurayah.getText();
        vkewarganegaraan_ayah = txtwarganegaraayah.getText();
        vno_kk = txtkk.getText();
        vno_ktp_ayah = txtnik.getText();
        vpetugas = txtpetugas.getText();
        
            
            sqlinsert = "insert into kematian values ('"+vnama_bayi+"', '"+vhari+"', '"+vtanggal_lahir+"', "+vtempat_lahir+"', '"+vjk+"', "
                    + "'"+vagama+"', '"+vtempat_kelahiran+"', '"+vpenolong_kelahiran+"', '"+vnama_ibu+"', "
                    + "'"+valamat+"', '"+vtanggal_lahir_ibu+"', '"+vumur_ibu+"', '"+vkewarganegaraan_ibu+"', '"+vnama_ayah+"', '"+vtanggal_lahir_ayah+"', '"+vumur_ayah+"', '"+vkewarganegaraan_ayah+"', '"+vno_kk+"', '"+vno_ktp_ayah+"', '"+vpetugas+"')";
        
          
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            Statement stat = _Cnn.createStatement();
            stat.executeUpdate(sqlinsert);
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
              //disableForm();showDataTabel();
             new Tabelkelahiran().show();
               this.dispose();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method aksiSimpan() : "+ex);
        }
    }
      
      private void aksiUbah(){
       vnama_bayi = txtnamabayi.getText();
        vhari =combohari.getSelectedItem().toString();
        SimpleDateFormat tanggallahir= new SimpleDateFormat("yyy-MM-dd");
        String t = tanggallahir.format(datetglbayi.getDate());
        vtanggal_lahir = t;
        vtempat_lahir=txttmptlahir.getText();
        vjk = txtjk.getText();
        vagama = comboagama.getSelectedItem().toString();
        vtempat_kelahiran = combotempatlahir.getSelectedItem().toString();
        vpenolong_kelahiran = combopenolong.getSelectedItem().toString();
        vnama_ibu = txtnamaibu.getText();
        valamat = txtalamat.getText();
        SimpleDateFormat tanggallahiribu= new SimpleDateFormat("yyy-MM-dd");
        String y = tanggallahiribu.format(dateibu.getDate());
        vtanggal_lahir_ibu = y;
        vumur_ibu = txtumuribu.getText();
        vkewarganegaraan_ibu = txtwarganegaraibu.getText();
        vnama_ayah = txtnamaayah.getText();
        SimpleDateFormat tanggallahirayah= new SimpleDateFormat("yyy-MM-dd");
        String z = tanggallahirayah.format(datetglayah.getDate());
        vtanggal_lahir_ayah = z;
        vumur_ayah = txtumurayah.getText();
        vkewarganegaraan_ayah = txtwarganegaraayah.getText();
        vno_kk = txtkk.getText();
        vno_ktp_ayah = txtnik.getText();
        vpetugas = txtpetugas.getText();
        
       
       sqlupdate = "update kelahiran set no_ktp_ayah='"+vno_ktp_ayah+"', nama_bayi='"+vnama_bayi+"',hari='"+vhari+"', tanggal_lahir='"+vtanggal_lahir+"', tempat_lahir='"+vtempat_lahir+"',"
                    + "jk= '"+vjk+"',agama= '"+vagama+"', tempat_kelahiran='"+vtempat_kelahiran+"',"
                    + "penolong_kelahiran= '"+vpenolong_kelahiran+"', nama_ibu='"+vnama_ibu+"', alamat= '"+valamat+"', "
                    + "tanggal_lahir_ibu= '"+vtanggal_lahir_ibu+"', umur_ibu= '"+vumur_ibu+"'" + "kewarganegaraan_ibu= '"+vkewarganegaraan_ibu+"', nama_ayah= '"+vnama_ayah+"'" + "tanggal_lahir_ayah= '"+vtanggal_lahir_ayah+"', kewarganegaraan_ayah='"+vkewarganegaraan_ayah+"',no_kk= '"+vno_kk+"'" + "no_ktp_ayah= '"+vno_ktp_ayah+"' ,petugas='"+vpetugas+"', "
                    + " where no_ktp_ayah= ' " +vno_ktp_ayah+ " ' ";
       
       try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            Statement stat = _Cnn.createStatement();
            stat.executeUpdate(sqlupdate);
            JOptionPane.showMessageDialog(this, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
              //disableForm();showDataTabel();
             new Tabelkelahiran().show();
               this.dispose();
               JdInputKelahiran.setVisible(false);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method aksiSimpan() : "+ex);
        }
    }
      
     
     private void showdatakelahiran(){
          try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            
            sqlselect="select*from kelahiran order by no_ktp_ayah asc";           
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
             while(res.next()){
                Object[]obj=new Object[20];
                obj[0]=res.getString("nama_bayi");
                obj[1]=res.getString("hari");
                obj[2]=res.getString("tanggal_lahir");
                obj[3]=res.getString("tempat_lahir");
                obj[4]=res.getString("jk");
                obj[5]=res.getString("agama");
                obj[6]=res.getString("tempat_kelahiran");
                obj[7]=res.getString("penolong_kelahiran");
                obj[8]=res.getString("nama_ibu");
                obj[9]=res.getString("alamat");
                obj[10]=res.getString("tanggal_lahir_ibu");
                obj[11]=res.getString("umur_ibu");
                obj[12]=res.getString("kewarganegaraan_ibu");
                obj[13]=res.getString("nama_ayah");
                obj[14]=res.getString("tanggal_lahir_ayah");
                obj[15]=res.getString("umur_ayah");
                obj[16]=res.getString("kewarganegaraan_ayah");
                obj[17]=res.getString("no_kk");
                obj[18]=res.getString("no_ktp_ayah");
                obj[19]=res.getString("petugas");
                
                 model.addRow(obj);
            }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Eror Method showDataBarang(): "+ex);
            
            
        }
     }
     
  private void getdatakelahiran(){
            try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sqlselect = "select * from kelahiran where no_ktp_ayah= ' " +vno_ktp_ayah+ " ' ";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            if(res.first()){
                    
                    txtnamabayi.setText(res.getString("nama_bayi"));
                    combohari.setSelectedItem(res.getString("hari"));
                    java.util.Date vtanggal_lahir= null;
                    datetglbayi.setDate(res.getDate("tanggal_lahir"));
                    txttmptlahir.setText(res.getString("tempat_lahir"));
                    txtjk.setText(res.getString("jk"));
                    comboagama.setSelectedItem(res.getString("agama"));
                    txttmptlahir.setText(res.getString("tempat_kelahiran"));
                    combopenolong.setSelectedItem(res.getString("penolong_kelahiran"));
                    txtnamaibu.setText(res.getString("nama_ibu"));
                    txtalamat.setText(res.getString("alamat"));
                    java.util.Date vtanggal_lahir_ibu = null;
                    dateibu.setDate(res.getDate("tanggal_lahir_ibu"));
                    txtumuribu.setText(res.getString("umur_ibu"));
                    txtwarganegaraibu.setText(res.getString("kewarganegaraan_ibu"));
                    txtnamaayah.setText(res.getString("nama_ayah"));
                    java.util.Date vtanggal_lahir_ayah = null;
                    datetglayah.setDate(res.getDate("tanggal_lahir_ayah"));
                    txtumurayah.setText(res.getString("umur_ayah"));
                    txtwarganegaraayah.setText(res.getString("kewarganegaraan_ayah"));
                    txtkk.setText(res.getString("no_kk"));
                    txtnik.setText(res.getString("no_ktp_ayah"));
                    txtpetugas.setText(res.getString("petugas"));
                   
                    

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
                    txtnamabayi.setText("");
                    combohari.setSelectedIndex(0);
                    datetglbayi.setDate(new java.util.Date());
                    txttmptlahir.setText("");
                    txtjk.setText("");
                    comboagama.setSelectedIndex(0);
                    combotempatlahir.setSelectedIndex(0);
                    combopenolong.setSelectedIndex(0);
                    txtnamaibu.setText("");
                    txtalamat.setText("");
                    dateibu.setDate(new java.util.Date());
                    txtumuribu.setText("");
                    txtwarganegaraibu.setText("");
                    txtnamaayah.setText("");
                    txtumurayah.setText("");
                    txtwarganegaraayah.setText("");
                    txtkk.setText("");
                    txtnik.setText("");
                    txtpetugas.setText("");
                    btnsimpan.setText("Simpan");
                    btnbatal.setText("Batal");
                    vno_ktp_ayah="";
        
    }
        
         private void setTabelkelahiran(){
        String[] kolom1 = {"nama_bayi","hari", "tanggal_lahir", "tempat_lahir", "agama", "tempat_kelahiran", "penolong_kelahiran", 
             "nama_ibu", "alamat", "tanggal_lahir_ibu", "umur_ibu", "kewarganegaraan_ibu", "nama_ayah", "tanggal_lahir_ayah",
             "umur_ayah", "kewarganegaraan_ayah", "no_kk", "no_ktp_ayah", "petugas"};
        tbkelahiran = new DefaultTableModel(null, kolom1){
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
                java.lang.String.class,
                java.lang.String.class,
            };
            public Class getColumnClass(int columnIndex){
                return types [columnIndex];
            }
            public boolean isCellEditable(int row, int col){
                int cola = tabelkelahiran.getColumnCount();
                //java.lang.String.class,
                //java.lang.String.ctColumnCount();
                return (col < cola) ? true : true;
            }
                };
  
        tabelkelahiran.setModel(tbkelahiran);
        tabelkelahiran.getColumnModel().getColumn(0).setPreferredWidth(75);
        tabelkelahiran.getColumnModel().getColumn(1).setPreferredWidth(250);
        tabelkelahiran.getColumnModel().getColumn(2).setPreferredWidth(25);
        tabelkelahiran.getColumnModel().getColumn(3).setPreferredWidth(75);
        tabelkelahiran.getColumnModel().getColumn(4).setPreferredWidth(75);
        tabelkelahiran.getColumnModel().getColumn(5).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(6).setPreferredWidth(300);
        tabelkelahiran.getColumnModel().getColumn(7).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(8).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(9).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(10).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(11).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(12).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(13).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(14).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(15).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(16).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(17).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(18).setPreferredWidth(150);
        tabelkelahiran.getColumnModel().getColumn(19).setPreferredWidth(150);
//   private void initComponents() {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
         }
       /*  private void showdatakelahiran(){
            try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
           
            sqlselect = "select * from kelahiran where no_ktp_ayah='' "; 
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            
            while(res.next()){
                Object[]obj=new Object[20];
                obj[0]=res.getString("nama_bayi");
                obj[1]=res.getString("hari");
                obj[2]=res.getString("tanggal_lahir");
                obj[3]=res.getString("tempat_lahir");
                obj[4]=res.getString("jk");
                obj[5]=res.getString("agama");
                obj[6]=res.getString("tempat_kelahiran");
                obj[7]=res.getString("penolong_kelahiran");
                obj[8]=res.getString("nama_ibu");
                obj[9]=res.getString("alamat");
                obj[10]=res.getString("tanggal_lahir_ibu");
                obj[11]=res.getString("umur_ibu");
                obj[12]=res.getString("kewarganegaraan_ibu");
                obj[13]=res.getString("nama_ayah");
                obj[14]=res.getString("tanggal_lahir_ayah");
                obj[15]=res.getString("umur_ayah");
                obj[16]=res.getString("kewarganegaraan_ayah");
                obj[17]=res.getString("no_kk");
                obj[18]=res.getString("no_ktp_ayah");
                obj[19]=res.getString("petugas");
               
                
                        
                model.addRow(obj);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method showDataRGuru(): " + ex);
        }
    }*/

   private void AksiSimpan(){
        vnama_bayi = txtnamabayi.getText();
        vhari =combohari.getSelectedItem().toString();
        SimpleDateFormat tanggallahir= new SimpleDateFormat("yyy-MM-dd");
        String t = tanggallahir.format(datetglbayi.getDate());
        vtanggal_lahir = t;
        vtempat_lahir=txttmptlahir.getText();
        vjk = txtjk.getText();
        vagama = comboagama.getSelectedItem().toString();
        vtempat_kelahiran = combotempatlahir.getSelectedItem().toString();
        vpenolong_kelahiran = combopenolong.getSelectedItem().toString();
        vnama_ibu = txtnamaibu.getText();
        valamat = txtalamat.getText();
        SimpleDateFormat tanggallahiribu= new SimpleDateFormat("yyy-MM-dd");
        String y = tanggallahiribu.format(dateibu.getDate());
        vtanggal_lahir_ibu = y;
        vumur_ibu = txtumuribu.getText();
        vkewarganegaraan_ibu = txtumuribu.getText();
        vnama_ayah = txtnamaayah.getText();
        SimpleDateFormat tanggallahirayah= new SimpleDateFormat("yyy-MM-dd");
        String z = tanggallahirayah.format(datetglayah.getDate());
        vtanggal_lahir_ayah = z;
        vumur_ayah = txtumurayah.getText();
        vkewarganegaraan_ayah = txtwarganegaraayah.getText();
        vno_kk = txtkk.getText();
        vno_ktp_ayah = txtnik.getText();
        vpetugas = txtpetugas.getText();
      
         if(btnsimpan.getText().equals("Simpan")){
            sqlinsert = "insert into kelahiran values('"+vnama_bayi+"','"+vhari+"','"+vtanggal_lahir+"','"+vtempat_lahir+"','"+vjk+"','"+vagama+"','"+vtempat_kelahiran+"',"
                    + "'"+vpenolong_kelahiran+"','"+vnama_ibu+"','"+valamat+"','"+vtanggal_lahir_ibu+"','"+vumur_ibu+"','"+vkewarganegaraan_ibu+"','"+vnama_ayah+"','"+vtanggal_lahir_ayah+"', "
                    + "'"+vumur_ayah+"','"+vkewarganegaraan_ayah+"','"+vno_kk+"','"+vno_ktp_ayah+"','"+vpetugas+"')";
            
               
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
             new Tabelkelahiran().show();
               this.dispose();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method aksiSimpan() : "+ex);
        }
    
        };
                                                              
         private void aksiUpdate(){
 
        vnama_bayi = txtnamabayi.getText();
        vhari = combohari.getSelectedItem().toString();
        SimpleDateFormat tanggallahir= new SimpleDateFormat("yyy-MM-dd");
        String t = tanggallahir.format(datetglbayi.getDate());
        vtanggal_lahir = t;
        vtempat_lahir=txttmptlahir.getText();
        vjk = txtjk.getText();
        vagama = comboagama.getSelectedItem().toString();
        vtempat_kelahiran = combotempatlahir.getSelectedItem().toString();
        vpenolong_kelahiran = combopenolong.getSelectedItem().toString();
        vnama_ibu = txtnamaibu.getText();
        valamat = txtalamat.getText();
        SimpleDateFormat tanggallahiribu= new SimpleDateFormat("yyy-MM-dd");
        String y = tanggallahiribu.format(dateibu.getDate());
        vtanggal_lahir_ibu = y;
        vumur_ibu = txtumuribu.getText();
        vkewarganegaraan_ibu = txtumuribu.getText();
        vnama_ayah = txtnamaayah.getText();
        SimpleDateFormat tanggallahirayah= new SimpleDateFormat("yyy-MM-dd");
        String z = tanggallahirayah.format(datetglayah.getDate());
        vtanggal_lahir_ayah = z;
        vumur_ayah = txtumurayah.getText();
        vkewarganegaraan_ayah = txtwarganegaraayah.getText();
        vno_kk = txtkk.getText();
        vno_ktp_ayah = txtnik.getText();
        vpetugas = txtpetugas.getText();
      
        
        
        if(btnsimpan.getText().equals("Update")){
            sqlupdate = "update kelahiran set nama_bayi='"+vnama_bayi+"',hari='"+vhari+"',"
                    + "tanggal_lahir='"+vtanggal_lahir+"', tempat_lahir='"+vtempat_lahir+"',jk='"+vjk+"', agama='"+vagama+"',"
                    + "tempat_kelahiran='"+vtempat_kelahiran+"', penolong_kelahiran='"+ vpenolong_kelahiran+"', nama_ibu='"+vnama_ibu+"', alamat= '"+valamat+"', tanggal_lahir_ibu= '"+vtanggal_lahir_ibu+"',"
                    + "umur_ibu='"+vumur_ibu+"', kewarganegaraan_ibu='"+vkewarganegaraan_ibu+"', nama_ayah='"+vnama_ayah+"', tanggal_lahir_ayah='"+vtanggal_lahir_ayah+"', umur_ayah= '"+vumur_ayah+"',"
                    + "kewarganegaraan_ayah = '"+vkewarganegaraan_ayah+"', no_kk= '"+vno_kk+"',"
                    + "petugas= '"+vpetugas+"'"
                    + "where no_ktp_ayah='"+vno_ktp_ayah+"' ";
            
            
        }
             
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            Statement stat = _Cnn.createStatement();
            stat.executeUpdate(sqlupdate);
            JOptionPane.showMessageDialog(this, "Data berhasil diubah", "Informasi", JOptionPane.INFORMATION_MESSAGE);
              //disableForm();showDataTabel();
             new Tabelkelahiran().show();
               this.dispose();
               JdInputKelahiran.setVisible(false);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method aksiUpdate() : "+ex);
        }
    
        };
         
     private void AksiHapus(){
        int jawab = JOptionPane.showConfirmDialog(this, "Anda yakin akan menghapus data ini? no_ktp_ayah : "+no_ktpayah, 
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(jawab == JOptionPane.YES_OPTION){
            try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                sqldelete = "delete from kelahiran where no_ktp_ayah='"+no_ktpayah+"'";
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

        JdInputKelahiran = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
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
        txtjk = new javax.swing.JLabel();
        txtwarganegaraibu = new javax.swing.JLabel();
        txtwarganegaraayah = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        iconkeluar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkelahiran = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtpencarian = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btntambah = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        txtkelahiran = new javax.swing.JTextField();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        comboagama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "Islam ", "Kristen", "Katoilk", "Hindu", "Buduha", "Konghucu" }));
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
        jLabel28.setText("UBAH KELAHIRAN");

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel28)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel16))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lbljk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbltmptlahir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbltglbayi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(lblagama)
                                                .addGap(19, 19, 19))))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lblnamabayi))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(lblhari))
                                    .addComponent(lblpenolong)
                                    .addComponent(lbltempatlahir))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(combopenolong, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(combotempatlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(combohari, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtnamabayi, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txttmptlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(datetglbayi, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(comboagama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(radiolk)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radiopr)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtjk, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblkwg)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblnamaibu)
                                        .addComponent(lbltglibu)
                                        .addComponent(lblalamat)
                                        .addComponent(lblumuribu)))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(radiowni)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radiowna)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtwarganegaraibu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateibu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtalamat)
                                        .addComponent(txtnamaibu)
                                        .addComponent(txtumuribu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnbatal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnsimpan)))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(64, 64, 64))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbltglayah)
                                    .addComponent(lblkewarganegaraan)
                                    .addComponent(lblnamaayah)
                                    .addComponent(lblumurayah)
                                    .addComponent(lblkk)
                                    .addComponent(lblnik)
                                    .addComponent(lblpetugas))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnamaayah)
                                    .addComponent(txtumurayah)
                                    .addComponent(txtkk, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(datetglayah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(txtnik, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(radiowniayah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radiownaayah)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtwarganegaraayah, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtpetugas))
                        .addGap(238, 238, 238))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblnamaibu)
                                    .addComponent(txtnamaibu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblalamat))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dateibu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltglibu))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtumuribu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblumuribu))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblkwg)
                                    .addComponent(radiowni)
                                    .addComponent(radiowna)
                                    .addComponent(txtwarganegaraibu, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(13, 13, 13)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnamaayah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblnamaayah))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(datetglayah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltglayah))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtumurayah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblumurayah))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblkewarganegaraan)
                                    .addComponent(radiowniayah)
                                    .addComponent(radiownaayah)
                                    .addComponent(txtwarganegaraayah, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtkk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblkk))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnik, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblnik))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblpetugas)
                                    .addComponent(txtpetugas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnbatal)
                            .addComponent(btnsimpan))
                        .addGap(101, 101, 101))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnamabayi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnamabayi))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(combohari, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblhari))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datetglbayi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltglbayi))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txttmptlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltmptlahir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbljk)
                                    .addComponent(radiolk)
                                    .addComponent(radiopr)
                                    .addComponent(txtjk, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboagama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblagama)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combotempatlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltempatlahir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combopenolong, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpenolong))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("APLIKASI PELAYANAN KELAHIRAN DAN KEMATIAN");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DESA BULAKSARI");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("KECAMATAN SRAGI KABUPATEN PEKALONGAN");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-embassy-50 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel10)
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(57, 57, 57))))
        );

        javax.swing.GroupLayout JdInputKelahiranLayout = new javax.swing.GroupLayout(JdInputKelahiran.getContentPane());
        JdInputKelahiran.getContentPane().setLayout(JdInputKelahiranLayout);
        JdInputKelahiranLayout.setHorizontalGroup(
            JdInputKelahiranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        JdInputKelahiranLayout.setVerticalGroup(
            JdInputKelahiranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JdInputKelahiranLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

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
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconkeluar)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(iconkeluar)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelkelahiran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama Bayi", "Hari", "Tgl Lahir", "Tempat Lahir", "JK", "Agama", "Tempat Kelahiran", "Penolong Kelahiran", "Nama Ibu", "Alamat", "Tanggal Lahir", "Umur ibu", "Kewarganegaraan", "Nama Ayah", "Tanggal Lahir", "Umur ayah", "Kewarganegaraan", "No. KK", "No. ktp ayah", "Petugas"
            }
        ));
        tabelkelahiran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkelahiranMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelkelahiran);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("TABEL DATA KELAHIRAN");

        txtpencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpencarianActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-30.png"))); // NOI18N

        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/insert.png"))); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trans-edit.png"))); // NOI18N
        btnubah.setText("Ubah");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trans-hapus.png"))); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btntambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnhapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtkelahiran, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 742, Short.MAX_VALUE)
                        .addComponent(txtpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(105, 105, 105))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtpencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnubah)
                    .addComponent(btnhapus)
                    .addComponent(txtkelahiran, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
    
    JdInputKelahiran.setVisible(true);
    getdatakelahiran();
    txtnik.setEnabled(false);
    
    btnsimpan.setText("Update");       
    }//GEN-LAST:event_btnubahActionPerformed

    private void iconkeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconkeluarMouseClicked
        new beranda().setVisible(true);
    }//GEN-LAST:event_iconkeluarMouseClicked

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
new kelahiran().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
aksiHapus();
new Tabelkelahiran().show();
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhapusActionPerformed

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

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        new beranda().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
         if(btnsimpan.getText().equals("Simpan")){
        AksiSimpan();
        }else if(btnsimpan.getText().equals("Update")){
        aksiUpdate();
        }
//new Tabelkelahiran().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tabelkelahiranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkelahiranMouseClicked
        if(evt.getClickCount()==1){
            int brs = tabelkelahiran.getSelectedRow();
            vnama_bayi= tabelkelahiran.getValueAt(brs, 0).toString(); 
            vhari = tabelkelahiran.getValueAt(brs, 1).toString();
            vtanggal_lahir = tabelkelahiran.getValueAt(brs, 2).toString();
            vtempat_lahir = tabelkelahiran.getValueAt(brs, 3).toString();
            vjk = tabelkelahiran.getValueAt(brs, 4).toString();
            vagama = tabelkelahiran.getValueAt(brs, 5).toString();
            vtempat_kelahiran = tabelkelahiran.getValueAt(brs, 6).toString();
            vpenolong_kelahiran = tabelkelahiran.getValueAt(brs, 7).toString();
            vnama_ibu = tabelkelahiran.getValueAt(brs, 8).toString();
            valamat = tabelkelahiran.getValueAt(brs, 9).toString();
            vtanggal_lahir_ibu = tabelkelahiran.getValueAt(brs, 10).toString();
            vumur_ibu = tabelkelahiran.getValueAt(brs, 11).toString();
            vkewarganegaraan_ibu = tabelkelahiran.getValueAt(brs, 12).toString();
            vnama_ayah= tabelkelahiran.getValueAt(brs, 13).toString(); 
            vtanggal_lahir_ayah= tabelkelahiran.getValueAt(brs, 14).toString(); 
            vumur_ayah= tabelkelahiran.getValueAt(brs, 15).toString(); 
            vkewarganegaraan_ayah= tabelkelahiran.getValueAt(brs, 16).toString(); 
            vno_kk= tabelkelahiran.getValueAt(brs, 17).toString(); 
            vno_ktp_ayah= tabelkelahiran.getValueAt(brs, 18).toString();
            vpetugas= tabelkelahiran.getValueAt(brs, 19).toString();
        
        }
 
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelkelahiranMouseClicked

    private void txtpencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpencarianActionPerformed

        // pPENCARIAN
        DefaultTableModel tabel = (DefaultTableModel)tabelkelahiran.getModel();
        String sc = txtpencarian.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tabel);
        tabelkelahiran.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(sc));
        
        
    }//GEN-LAST:event_txtpencarianActionPerformed

    private void radiownaayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiownaayahActionPerformed
         kewarganegaraan="WNA";
        radiownaayah.setSelected(false);
        
        
        txtwarganegaraayah.setText(kewarganegaraan);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_radiownaayahActionPerformed

    private void radiowniayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowniayahActionPerformed
         kewarganegaraan="WNI";
        radiowniayah.setSelected(false);
        
        
        txtwarganegaraayah.setText(kewarganegaraan);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_radiowniayahActionPerformed

    private void radiownaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiownaActionPerformed
        kewarganegaraan="WNA";
        radiowna.setSelected(false);
        
        
        txtwarganegaraibu.setText(kewarganegaraan);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_radiownaActionPerformed

    private void radiowniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowniActionPerformed
         kewarganegaraan="WNI";
        radiowni.setSelected(false);
        
        
        txtwarganegaraibu.setText(kewarganegaraan);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_radiowniActionPerformed

    private void radioprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioprActionPerformed
         JK="Perempuan";
        radiopr.setSelected(false);
        
        
        txtjk.setText(JK);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_radioprActionPerformed

    private void radiolkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiolkActionPerformed
        JK="Laki-laki";
        radiolk.setSelected(false);
        
        
        txtjk.setText(JK);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_radiolkActionPerformed

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
            java.util.logging.Logger.getLogger(Tabelkelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabelkelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabelkelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabelkelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabelkelahiran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame JdInputKelahiran;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox<String> comboagama;
    private javax.swing.JComboBox<String> combohari;
    private javax.swing.JComboBox<String> combopenolong;
    private javax.swing.JComboBox<String> combotempatlahir;
    private com.toedter.calendar.JDateChooser dateibu;
    private com.toedter.calendar.JDateChooser datetglayah;
    private com.toedter.calendar.JDateChooser datetglbayi;
    private javax.swing.JLabel iconkeluar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JRadioButton radiolk;
    private javax.swing.JRadioButton radiopr;
    private javax.swing.JRadioButton radiowna;
    private javax.swing.JRadioButton radiownaayah;
    private javax.swing.JRadioButton radiowni;
    private javax.swing.JRadioButton radiowniayah;
    private javax.swing.JTable tabelkelahiran;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JLabel txtjk;
    private javax.swing.JTextField txtkelahiran;
    private javax.swing.JTextField txtkk;
    private javax.swing.JTextField txtnamaayah;
    private javax.swing.JTextField txtnamabayi;
    private javax.swing.JTextField txtnamaibu;
    private javax.swing.JTextField txtnik;
    private javax.swing.JTextField txtpencarian;
    private javax.swing.JTextField txtpetugas;
    private javax.swing.JTextField txttmptlahir;
    private javax.swing.JTextField txtumurayah;
    private javax.swing.JTextField txtumuribu;
    private javax.swing.JLabel txtwarganegaraayah;
    private javax.swing.JLabel txtwarganegaraibu;
    // End of variables declaration//GEN-END:variables

  
   
  
}
