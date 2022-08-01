
package benzinıstasyonuotomasyonu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class musteri extends javax.swing.JFrame {
 private Connection conn = null; //Bağlantı nesnemiz
    private String url = "jdbc:mysql://localhost:3306/";//veritabanının adresi ve portu
    private String dbName = "benzinistasyonu"; //veritabanının ismi
    private String driver = "com.mysql.jdbc.Driver";//mySQL ile Java arasındaki bağlantıyı sağlayan JDBC sürücüsü
    private String userName = "root"; //veritabanı için kullanıcı adı
    private String password = ""; //kullanıcı şifresi
    private ResultSet res;
    public musteri() {
       initComponents();
        Statement st; // SQL komutumuz için
        try {
            st = baglantiAc(); //veritabanına bağlanılıyor
            res = st.executeQuery("SELECT * FROM  musteri"); //tablodaki kayıtlar getiriliyor
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

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmb_abone = new javax.swing.JComboBox<>();
        txt_tc = new javax.swing.JTextField();
        txt_adsoyad = new javax.swing.JTextField();
        txt_dogum = new javax.swing.JTextField();
        txt_telno = new javax.swing.JTextField();
        txt_plaka = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMusteri = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_anasayfa = new javax.swing.JButton();
        txt_silGuncelle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_ekle = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();
        btn_listele = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel7.setText("DOĞUM TARİHİ :");

        jLabel8.setText("TELEFON NUMARASI :");

        jLabel9.setText("ABONELİK DURUMU :");

        jLabel10.setText("ARAÇ PLAKASI :");

        jLabel11.setText("ADI SOYADI :");

        jLabel12.setText("T.C.KİMLİK :");

        cmb_abone.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Pasif" }));

        txt_tc.setName("txt_tc"); // NOI18N

        txt_adsoyad.setName("txt_adsoyad"); // NOI18N

        txt_dogum.setName("txt_dogumtarihi"); // NOI18N

        txt_telno.setName("txt_telefon"); // NOI18N

        txt_plaka.setName("txt_MusteriPlaka"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmb_abone, 0, 120, Short.MAX_VALUE)
                    .addComponent(txt_tc)
                    .addComponent(txt_adsoyad)
                    .addComponent(txt_dogum)
                    .addComponent(txt_telno)
                    .addComponent(txt_plaka))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_tc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_adsoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_dogum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_telno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_abone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_plaka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28))
        );

        jMusteri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "T.C.", "Adi_Soyadi", "Dogum_Tarihi", "Telefon", "Abonelik_Durumu", "Plaka"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jMusteri);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/menu2.png"))); // NOI18N

        btn_anasayfa.setBackground(new java.awt.Color(255, 102, 0));
        btn_anasayfa.setText("ANASAYFA");
        btn_anasayfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anasayfaActionPerformed(evt);
            }
        });

        jLabel2.setText("T.C");

        btn_ekle.setBackground(new java.awt.Color(255, 102, 0));
        btn_ekle.setText("EKLE");
        btn_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ekleActionPerformed(evt);
            }
        });

        btn_sil.setBackground(new java.awt.Color(255, 102, 0));
        btn_sil.setText("SİL");
        btn_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silActionPerformed(evt);
            }
        });

        btn_guncelle.setBackground(new java.awt.Color(255, 102, 0));
        btn_guncelle.setText("GÜNCELLE");
        btn_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guncelleActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_ekle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_sil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_anasayfa, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(btn_guncelle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_silGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_listele)
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_anasayfa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btn_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_silGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btn_listele))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
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
           
           res=st.executeQuery("SELECT * FROM musteri");
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
           
           jMusteri.setModel(model);
           res.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Listelemede bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }}
    
    
    
    
    private void ekle(){
        try{
            res.moveToInsertRow();
            res.updateString("musteri_tc", txt_tc.getText());
            res.updateString("musteri_adSoyad", txt_adsoyad.getText());
            res.updateString("musteri_dtarihi", txt_dogum.getText());
            res.updateString("musteri_tel", txt_telno.getText());
            String value=(String)cmb_abone.getSelectedItem();
            res.updateString("musteri_abone",value);
            res.updateString("musteri_plaka",txt_plaka.getText());
            res.insertRow(); 
            JOptionPane.showConfirmDialog(null, "Kayıt Başarılı Bir şekilde Eklendi", "Müşteri Tablosu", JOptionPane.PLAIN_MESSAGE);
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Kayıt Eklenemedi Hata Açıklaması: "+e.getMessage());
        }
    }
    
    private void sil(){
        
        Connection baglanti=null;
        try{
           baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/benzinistasyonu","root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Bağlantı oluşturmada bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
        
        try{
            PreparedStatement uygula=baglanti.prepareStatement("DELETE FROM musteri where musteri_tc=?");
            
            uygula.setString(1,txt_silGuncelle.getText());
            
            int donut=uygula.executeUpdate();
            listele();
            if(donut>0)
                 JOptionPane.showConfirmDialog(null, "Silme İşlemi Başarı İle Gerçekleşti", "Müşteri Tablosu", JOptionPane.PLAIN_MESSAGE);
            else
                 JOptionPane.showConfirmDialog(null, "Silme İşlemi Gerçekleşmedi", "Müşteri Tablosu", JOptionPane.PLAIN_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "SQL sorgusunda Hata Açıklaması: "+e.getMessage());
        }
        }
        private void guncelle(){
        Connection baglanti=null;
        try{
           baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/benzinistasyonu","root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Bağlantı oluşturmada bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
        
        try{
            PreparedStatement uygula=baglanti.prepareStatement("UPDATE musteri set musteri_tc=?,musteri_adSoyad=?,musteri_dtarihi=?,musteri_tel=?,musteri_abone=?,musteri_plaka=? WHERE musteri_tc=?");
            
            uygula.setString(1,txt_tc.getText());
            uygula.setString(2,txt_adsoyad.getText());
            uygula.setString(3,txt_dogum.getText());
            uygula.setString(4,txt_telno.getText());
            String value=(String)cmb_abone.getSelectedItem();
            uygula.setString(5,value);
            uygula.setString(6,txt_plaka.getText());
            uygula.setString(7,txt_silGuncelle.getText());
           
            int donut=uygula.executeUpdate();
            listele();
            if(donut>0){
                 JOptionPane.showConfirmDialog(null, "Güncelleme İşlemi Başarı İle Gerçekleşti", "Müşteri Tablosu", JOptionPane.PLAIN_MESSAGE);
            }
            else
                 JOptionPane.showConfirmDialog(null, "Güncelleme İşlemi Gerçekleşmedi", "Müşteri Tablosu", JOptionPane.PLAIN_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "SQL sorgusunda Hata Açıklaması: "+e.getMessage());
        }
    }
        
        
        
    private void btn_anasayfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anasayfaActionPerformed
        menu men=new menu();
        men.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_anasayfaActionPerformed

    private void btn_ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ekleActionPerformed
        ekle();
    }//GEN-LAST:event_btn_ekleActionPerformed

    private void btn_silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_silActionPerformed
        sil();
    }//GEN-LAST:event_btn_silActionPerformed

    private void btn_guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guncelleActionPerformed
        guncelle();
    }//GEN-LAST:event_btn_guncelleActionPerformed

    private void btn_listeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listeleActionPerformed
        listele();
    }//GEN-LAST:event_btn_listeleActionPerformed

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
            java.util.logging.Logger.getLogger(musteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(musteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(musteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(musteri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new musteri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anasayfa;
    private javax.swing.JButton btn_ekle;
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_listele;
    private javax.swing.JButton btn_sil;
    private javax.swing.JComboBox<String> cmb_abone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTable jMusteri;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_adsoyad;
    private javax.swing.JTextField txt_dogum;
    private javax.swing.JTextField txt_plaka;
    private javax.swing.JTextField txt_silGuncelle;
    private javax.swing.JTextField txt_tc;
    private javax.swing.JTextField txt_telno;
    // End of variables declaration//GEN-END:variables
}
