
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


public class personel extends javax.swing.JFrame {
    private Connection conn = null; //Bağlantı nesnemiz
    private String url = "jdbc:mysql://localhost:3306/";//veritabanının adresi ve portu
    private String dbName = "benzinistasyonu"; //veritabanının ismi
    private String driver = "com.mysql.jdbc.Driver";//mySQL ile Java arasındaki bağlantıyı sağlayan JDBC sürücüsü
    private String userName = "root"; //veritabanı için kullanıcı adı
    private String password = ""; //kullanıcı şifresi
    private ResultSet res; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
    
    public personel() {
        initComponents();
        Statement st; // SQL komutumuz için
        try {
            st = baglantiAc(); //veritabanına bağlanılıyor
            res = st.executeQuery("SELECT * FROM  personel"); //tablodaki kayıtlar getiriliyor
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_tc = new javax.swing.JTextField();
        txt_ad = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        cmb_pozisyon = new javax.swing.JComboBox<>();
        txt_maas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_ekle = new javax.swing.JButton();
        btn_anasayfa = new javax.swing.JButton();
        btn_guncelle = new javax.swing.JButton();
        btn_sil = new javax.swing.JButton();
        txt_silGuncelle = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPersonel = new javax.swing.JTable();
        btn_listele = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setText("TC :");

        jLabel2.setText("ADI SOYADI :");
        jLabel2.setToolTipText("");

        jLabel4.setText("TELEFON NUMARASI :");

        jLabel5.setText("POZİSYON :");

        jLabel6.setText("MAAŞ :");

        txt_tc.setName("txt_TC"); // NOI18N

        txt_ad.setName("txt_adSoyad"); // NOI18N

        txt_tel.setName("txt_telNo"); // NOI18N

        cmb_pozisyon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Müdür", "Pompacı" }));
        cmb_pozisyon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_pozisyonActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/menu2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_tc)
                    .addComponent(txt_ad)
                    .addComponent(txt_tel)
                    .addComponent(cmb_pozisyon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_maas, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 338, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_tc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmb_pozisyon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_maas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_ekle.setBackground(new java.awt.Color(255, 102, 0));
        btn_ekle.setText("Ekle");
        btn_ekle.setName("btn_ekle"); // NOI18N
        btn_ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ekleActionPerformed(evt);
            }
        });

        btn_anasayfa.setBackground(new java.awt.Color(255, 102, 0));
        btn_anasayfa.setText("Anasayfa");
        btn_anasayfa.setName("btn_anasayfa"); // NOI18N
        btn_anasayfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anasayfaActionPerformed(evt);
            }
        });

        btn_guncelle.setBackground(new java.awt.Color(255, 102, 0));
        btn_guncelle.setText("Güncelle");
        btn_guncelle.setName("btn_guncelle"); // NOI18N
        btn_guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guncelleActionPerformed(evt);
            }
        });

        btn_sil.setBackground(new java.awt.Color(255, 102, 0));
        btn_sil.setText("Sil");
        btn_sil.setName("btn_sil"); // NOI18N
        btn_sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_silActionPerformed(evt);
            }
        });

        txt_silGuncelle.setName("txt_ara"); // NOI18N

        jLabel7.setText("TC :");

        jPersonel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "TC", "Ad_Soyad", "Dogum_Tarihi", "Tel", "Pozisyon", "Maaş"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jPersonel);
        if (jPersonel.getColumnModel().getColumnCount() > 0) {
            jPersonel.getColumnModel().getColumn(0).setMaxWidth(11);
        }

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
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_silGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_listele)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_anasayfa, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_anasayfa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sil, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_silGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btn_listele))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void ekle(){
        try{
            res.moveToInsertRow();
            res.updateString("personel_tc", txt_tc.getText());
            res.updateString("personel_adSoyad", txt_ad.getText());
            res.updateString("personel_tel", txt_tel.getText());
            String value=(String)cmb_pozisyon.getSelectedItem();
            res.updateString("personel_pozisyon",value);
            res.updateInt("personel_maas", Integer.parseInt(txt_maas.getText()));
            res.insertRow(); 
            JOptionPane.showConfirmDialog(null, "Kayıt Başarılı Bir şekilde Eklendi", "Personel Tablosu", JOptionPane.PLAIN_MESSAGE);
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
            PreparedStatement uygula=baglanti.prepareStatement("DELETE FROM personel where personel_tc=?");
            
            uygula.setString(1,txt_silGuncelle.getText());
            
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
        Connection baglanti=null;
        try{
           baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/benzinistasyonu","root","");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Bağlantı oluşturmada bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
        
        try{
            PreparedStatement uygula=baglanti.prepareStatement("UPDATE personel set personel_tc=?,personel_adSoyad=?,personel_tel=?,personel_pozisyon=?,personel_maas=? WHERE personel_tc=?");
            
            uygula.setString(1,txt_tc.getText());
            uygula.setString(2,txt_ad.getText());
            uygula.setString(3,txt_tel.getText());
            String value=(String)cmb_pozisyon.getSelectedItem();
            uygula.setString(4,value);
            uygula.setInt(5,Integer.valueOf(txt_maas.getText()));
            uygula.setString(6,txt_silGuncelle.getText());
           
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
           
           res=st.executeQuery("SELECT * FROM personel");
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
           
           jPersonel.setModel(model);
           res.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Listelemede bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
    }
    
    
    
    
    
    private void cmb_pozisyonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_pozisyonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_pozisyonActionPerformed

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
            java.util.logging.Logger.getLogger(personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new personel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anasayfa;
    private javax.swing.JButton btn_ekle;
    private javax.swing.JButton btn_guncelle;
    private javax.swing.JButton btn_listele;
    private javax.swing.JButton btn_sil;
    private javax.swing.JComboBox<String> cmb_pozisyon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jPersonel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_ad;
    private javax.swing.JTextField txt_maas;
    private javax.swing.JTextField txt_silGuncelle;
    private javax.swing.JTextField txt_tc;
    private javax.swing.JTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}
