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


public class akaryakitSatis extends javax.swing.JFrame {
    private Connection conn = null; //Bağlantı nesnemiz
    private String url = "jdbc:mysql://localhost:3306/";//veritabanının adresi ve portu
    private String dbName = "benzinistasyonu"; //veritabanının ismi
    private String driver = "com.mysql.jdbc.Driver";//mySQL ile Java arasındaki bağlantıyı sağlayan JDBC sürücüsü
    private String userName = "root"; //veritabanı için kullanıcı adı
    private String password = ""; //kullanıcı şifresi
    private ResultSet res; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
  
    
    
    public akaryakitSatis() {
        initComponents();
        Statement st; // SQL komutumuz için
        try {
            st = baglantiAc(); //veritabanına bağlanılıyor
            res = st.executeQuery("SELECT * FROM  akaryakit_satis"); //tablodaki kayıtlar getiriliyor
        } catch (Exception ex) {
            //Eğer bir hata oluşursa
            //örneğin veritabanına bağlanılamazsa
            //aşağıdaki kod çalışacak
            JOptionPane.showConfirmDialog(null, "Bağlantı Başarısız", "MySQL Bağlantısı", JOptionPane.PLAIN_MESSAGE);
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
           
           res=st.executeQuery("SELECT * FROM akaryakit_satis");
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
           
           table_Satis.setModel(model);
           res.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Listelemede bir hata oluştu Hata Açıklaması: "+e.getMessage());
        }
    }
    
    
    
    
    
     private void ekle(){
        try{
            res.moveToInsertRow();
            res.updateString("plaka", txt_plaka.getText());
            String value=(String)cmb_akaryakit.getSelectedItem();
            res.updateString("akaryakit",value);
            res.updateInt("litre_fiyati",Integer.parseInt(txt_litrefiyati.getText()));   
            res.updateInt("satilan_litre", Integer.parseInt(txt_satilanLitre.getText()));
            
            int litreFiyati=Integer.parseInt(txt_litrefiyati.getText());
            int satilanLitre=Integer.parseInt(txt_satilanLitre.getText());
            int sonuc=litreFiyati*satilanLitre;
            res.updateInt("toplam",sonuc);
            res.insertRow(); 
            listele();
            
            JOptionPane.showConfirmDialog(null, "Kayıt Başarılı Bir şekilde Eklendi", "akaryakitsatis tablosu", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showConfirmDialog(null,sonuc,"TOPLAM TUTAR",JOptionPane.PLAIN_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Kayıt Eklenemedi Hata Açıklaması: "+e.getMessage());
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_plaka = new javax.swing.JTextField();
        txt_litrefiyati = new javax.swing.JTextField();
        cmb_akaryakit = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_satisYap = new javax.swing.JButton();
        btn_anasayfa = new javax.swing.JButton();
        txt_satilanLitre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Satis = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setText("PLAKA:");

        jLabel2.setText("AKARYAKIT :");

        jLabel3.setText("LİTRE FİYATI :");

        jLabel5.setText("SATILAN LİTRE :");

        txt_plaka.setName("txt_plaka"); // NOI18N

        txt_litrefiyati.setName("txt_SatilanLitre"); // NOI18N

        cmb_akaryakit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BENZİN", "MAZOT", "GAZ" }));
        cmb_akaryakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_akaryakitActionPerformed(evt);
            }
        });

        jLabel7.setName("txt_litrefiyati"); // NOI18N

        jLabel8.setName("lbl_toplamtutar"); // NOI18N

        jLabel9.setName("lbl_litrefiyati"); // NOI18N

        btn_satisYap.setBackground(new java.awt.Color(255, 153, 51));
        btn_satisYap.setText("SATIŞ YAP");
        btn_satisYap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_satisYapActionPerformed(evt);
            }
        });

        btn_anasayfa.setText("ANASAYFA");
        btn_anasayfa.setName("btn_Anasayfa"); // NOI18N
        btn_anasayfa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anasayfaActionPerformed(evt);
            }
        });

        txt_satilanLitre.setName("txt_DepodaKalan"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_plaka, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_litrefiyati, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9)))
                                    .addComponent(cmb_akaryakit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_satilanLitre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_anasayfa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_satisYap, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_plaka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_akaryakit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(txt_litrefiyati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_satilanLitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(39, 39, 39)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_satisYap, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_anasayfa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        table_Satis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "plaka", "akaryakit", "litre_fiyati", "depoda_kalan", "satilan_litre", "toplam"
            }
        ));
        jScrollPane1.setViewportView(table_Satis);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_anasayfaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anasayfaActionPerformed

        menu men=new menu();
        men.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_anasayfaActionPerformed

    private void btn_satisYapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_satisYapActionPerformed
       
        ekle();
       
    }//GEN-LAST:event_btn_satisYapActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void cmb_akaryakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_akaryakitActionPerformed
        Statement st;
        try {
            st = baglantiAc();
           
            ResultSet as=st.executeQuery("SELECT yakit_adi,yakit_ltFiyat FROM akaryakit");
        
            String t = (String) cmb_akaryakit.getSelectedItem();
            
            if(as.first()){
                if (t == "BENZİN"){
                    txt_litrefiyati.setText(Integer.toString(as.getInt("yakit_ltFiyat")));
                }
            }
            
            if(as.next()){
                if (t == "MAZOT"){
                    txt_litrefiyati.setText(Integer.toString(as.getInt("yakit_ltFiyat")));
                }
            }
            
            if(as.absolute(3)){
                if (t == "GAZ"){
                    txt_litrefiyati.setText(Integer.toString(as.getInt("yakit_ltFiyat")));
                }
            }
            
                
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Combo Hata Açıklaması: "+e.getMessage());
        }
        
        
    }//GEN-LAST:event_cmb_akaryakitActionPerformed

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
            java.util.logging.Logger.getLogger(akaryakitSatis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(akaryakitSatis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(akaryakitSatis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(akaryakitSatis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new akaryakitSatis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anasayfa;
    private javax.swing.JButton btn_satisYap;
    private javax.swing.JComboBox<String> cmb_akaryakit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_Satis;
    private javax.swing.JTextField txt_litrefiyati;
    private javax.swing.JTextField txt_plaka;
    private javax.swing.JTextField txt_satilanLitre;
    // End of variables declaration//GEN-END:variables
}
