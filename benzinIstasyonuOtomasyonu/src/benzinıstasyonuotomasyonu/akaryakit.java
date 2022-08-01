package benzinıstasyonuotomasyonu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

    
public class akaryakit extends javax.swing.JFrame {
    private Connection conn = null; //Bağlantı nesnemiz
    private String url = "jdbc:mysql://localhost:3306/";//veritabanının adresi ve portu
    private String dbName = "benzinistasyonu"; //veritabanının ismi
    private String driver = "com.mysql.jdbc.Driver";//mySQL ile Java arasındaki bağlantıyı sağlayan JDBC sürücüsü
    private String userName = "root"; //veritabanı için kullanıcı adı
    private String password = ""; //kullanıcı şifresi
    private ResultSet res; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
    
    public akaryakit() {
        initComponents();
        Statement st; // SQL komutumuz için
        try {
            st = baglantiAc(); //veritabanına bağlanılıyor
            res = st.executeQuery("SELECT * FROM  akaryakit"); //tablodaki kayıtlar getiriliyor
        } catch (Exception ex) {
            //Eğer bir hata oluşursa
            //örneğin veritabanına bağlanılamazsa
            //aşağıdaki kod çalışacak
            JOptionPane.showConfirmDialog(null, "Bağlantı Başarısız", "MySQL Bağlantısı", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
     public Statement baglantiAc() throws Exception {
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url + dbName, userName, password);//bağlantı açılıyor           
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        //return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //return conn.createStatement();
    }
    
    public void baglantiKapat() throws Exception {
        conn.close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ad = new javax.swing.JTextField();
        txt_ltFiyat = new javax.swing.JTextField();
        txt_depo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_ekle = new javax.swing.JButton();
        btn_anasayfa = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        txt_silinecekID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        akaryakit = new javax.swing.JTable();
        btn_listele = new javax.swing.JButton();

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
        setBackground(new java.awt.Color(51, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setText("AKARYAKIT ADI  :");
        jLabel1.setToolTipText("");

        jLabel2.setText("LİTRE FİYATI :");

        jLabel3.setText("DEPO :");

        txt_ad.setName("txt_akaryakitAdi"); // NOI18N

        txt_ltFiyat.setName("txt_litreFiyat"); // NOI18N

        txt_depo.setName("txt_depo"); // NOI18N

        jLabel4.setText("TL");

        jLabel5.setText("LT");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/akaryakit.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ad, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(txt_ltFiyat)
                    .addComponent(txt_depo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ltFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_depo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        btn_ekle.setBackground(new java.awt.Color(255, 102, 0));
        btn_ekle.setText("EKLE");
        btn_ekle.setName("btn_ekle"); // NOI18N
        btn_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ekleActionPerformed(evt);
            }
        });

        btn_anasayfa.setBackground(new java.awt.Color(255, 102, 0));
        btn_anasayfa.setText("ANASAYFA");
        btn_anasayfa.setName("btn_anasayfa"); // NOI18N
        btn_anasayfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anasayfaActionPerformed(evt);
            }
        });

        btn_guncelle.setBackground(new java.awt.Color(255, 102, 0));
        btn_guncelle.setText("GÜNCELLE");
        btn_guncelle.setName("btn_guncelle"); // NOI18N
        btn_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guncelleActionPerformed(evt);
            }
        });

        btn_sil.setBackground(new java.awt.Color(255, 102, 0));
        btn_sil.setText("SİL");
        btn_sil.setName("btn_sil"); // NOI18N
        btn_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silActionPerformed(evt);
            }
        });

        txt_silinecekID.setName("txt_ara"); // NOI18N

        jLabel6.setText("Silinecek Veya Güncellenecek ID");

        akaryakit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "akaryakit_adi", "akaryakit_ltFiyatı", "akaryakit_depo"
            }
        ));
        jScrollPane3.setViewportView(akaryakit);

        btn_listele.setText("LISTELE");
        btn_listele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listeleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addComponent(txt_silinecekID, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_listele)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_anasayfa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_ekle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_sil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btn_anasayfa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btn_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btn_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_silinecekID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_listele))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void ekle(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Driver Sürücüsünde bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
        Connection baglanti=null;
        try{
           baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/benzinistasyonu","root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Bağlantı oluşturmada bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
        
        try{
            PreparedStatement uygula=baglanti.prepareStatement("INSERT INTO akaryakit(yakit_adi,yakit_ltFiyat,yakit_depo) values(?,?,?)");

            uygula.setString(1,txt_ad.getText());
            uygula.setInt(2,Integer.valueOf(txt_ltFiyat.getText()));
            uygula.setInt(3,Integer.valueOf(txt_depo.getText()));
            
            int donut=uygula.executeUpdate();
            if(donut>0)
                 JOptionPane.showConfirmDialog(null, "Kayıt Başarı İle Eklendi", "Akaryakıt Tablosu", JOptionPane.PLAIN_MESSAGE);
            else
                 JOptionPane.showConfirmDialog(null, "Kayıt Eklenemedi", "Akaryakıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "SQL sorgusunda Hata Açıklaması: "+e.getMessage());
        }
    }
    
    private void sil(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Driver Sürücüsünde bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
        Connection baglanti=null;
        try{
           baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/benzinistasyonu","root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Bağlantı oluşturmada bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
        
        try{
            PreparedStatement uygula=baglanti.prepareStatement("DELETE FROM akaryakit where yakit_id=?");
            
            uygula.setString(1,txt_silinecekID.getText());
            
            
            int donut=uygula.executeUpdate();
            if(donut>0)
                 JOptionPane.showConfirmDialog(null, "Silme İşlemi Başarı İle Gerçekleşti", "Akaryakıt Tablosu", JOptionPane.PLAIN_MESSAGE);
            else
                 JOptionPane.showConfirmDialog(null, "Silme İşlemi Gerçekleşmedi", "Akaryakıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "SQL sorgusunda Hata Açıklaması: "+e.getMessage());
        }
    }
    
    private void guncelle(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Driver Sürücüsünde bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
        Connection baglanti=null;
        try{
           baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/benzinistasyonu","root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Bağlantı oluşturmada bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
        
        try{
            PreparedStatement uygula=baglanti.prepareStatement("UPDATE akaryakit set yakit_adi=?,yakit_ltFiyat=?,yakit_depo=? WHERE yakit_id=?");
            uygula.setString(1,txt_ad.getText());
            uygula.setInt(2,Integer.valueOf(txt_ltFiyat.getText()));
            uygula.setInt(3,Integer.valueOf(txt_depo.getText()));
            uygula.setInt(4,Integer.valueOf(txt_silinecekID.getText()));
            
            
            int donut=uygula.executeUpdate();
            if(donut>0)
                 JOptionPane.showConfirmDialog(null, "Güncelleme İşlemi Başarı İle Gerçekleşti", "Akaryakıt Tablosu", JOptionPane.PLAIN_MESSAGE);
            else
                 JOptionPane.showConfirmDialog(null, "Güncelleme İşlemi Gerçekleşmedi", "Akaryakıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "SQL sorgusunda Hata Açıklaması: "+e.getMessage());
        }
    }
    
   
    public void listele(){
        Connection baglanti=null;
        try{
           baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/benzinistasyonu","root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Bağlantı oluşturmada bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
        
        try{
           Statement st=baglantiAc();
           int sutunSayisi;
           
           res=st.executeQuery("SELECT * FROM akaryakit");
           sutunSayisi=res.getMetaData().getColumnCount();
           DefaultTableModel model=new DefaultTableModel();
           
           for(int i=1;i<=sutunSayisi;i++)
               model.addColumn(res.getMetaData().getColumnName(i));
           
           while(res.next()){
               Object[]row=new Object[sutunSayisi];
               for(int i=1;i<=sutunSayisi;i++)
                   row[i-1]=res.getObject(i);
               model.addRow(row);
           }
           
           akaryakit.setModel(model);
           res.close();
           
           txt_ad.setText("");
           txt_ltFiyat.setText("");
           txt_depo.setText("");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Listelemede bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
    }
    
    
    private void btn_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ekleActionPerformed
      
        ekle();   
    }//GEN-LAST:event_btn_ekleActionPerformed

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
        sil();
    }//GEN-LAST:event_btn_silActionPerformed

    private void btn_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guncelleActionPerformed
       guncelle();
    }//GEN-LAST:event_btn_guncelleActionPerformed

    private void btn_anasayfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anasayfaActionPerformed
        menu men=new menu();
        men.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btn_anasayfaActionPerformed

    private void btn_listeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listeleActionPerformed
        listele();
    }//GEN-LAST:event_btn_listeleActionPerformed

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new akaryakit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable akaryakit;
    private javax.swing.JButton btn_anasayfa;
    private javax.swing.JButton btn_ekle;
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_listele;
    private javax.swing.JButton btn_sil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_ad;
    private javax.swing.JTextField txt_depo;
    private javax.swing.JTextField txt_ltFiyat;
    private javax.swing.JTextField txt_silinecekID;
    // End of variables declaration//GEN-END:variables
}
