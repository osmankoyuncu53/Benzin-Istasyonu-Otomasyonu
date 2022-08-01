/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author osman
 */
public class login extends javax.swing.JFrame {

    private Connection conn = null; //Bağlantı nesnemiz
    private String url = "jdbc:mysql://localhost:3306/";//veritabanının adresi ve portu
    private String dbName = "benzinistasyonu"; //veritabanının ismi
    private String driver = "com.mysql.jdbc.Driver";//mySQL ile Java arasındaki bağlantıyı sağlayan JDBC sürücüsü
    private String userName = "root"; //veritabanı için kullanıcı adı
    private String password = ""; //kullanıcı şifresi
    private ResultSet res; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
    
    public login() {
        initComponents();
        
        Statement st; // SQL komutumuz için
        try {
            st = baglantiAc(); //veritabanına bağlanılıyor
            res = st.executeQuery("SELECT * FROM  admin"); //tablodaki kayıtlar getiriliyor
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

        jPasswordField2 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_kad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_sifre = new javax.swing.JPasswordField();
        jcheckSifre = new javax.swing.JCheckBox();
        btn_giris = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPasswordField2.setText("jPasswordField2");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("KULLANICI ADI :");
        jLabel1.setToolTipText("");

        txt_kad.setName("txt_ad"); // NOI18N

        jLabel2.setText("ŞİFRE :");

        txt_sifre.setName("txt_password"); // NOI18N

        jcheckSifre.setText("ŞİFREYİ GÖSTER");
        jcheckSifre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcheckSifreActionPerformed(evt);
            }
        });

        btn_giris.setBackground(new java.awt.Color(255, 102, 0));
        btn_giris.setText("GİRİŞ");
        btn_giris.setName("btn_girisYap"); // NOI18N
        btn_giris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_girisActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/AA.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_sifre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_kad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jcheckSifre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_giris, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_kad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_sifre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jcheckSifre)
                        .addGap(18, 18, 18)
                        .addComponent(btn_giris, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_girisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_girisActionPerformed
        
        try {
            Statement st=baglantiAc();
            
            String sorgu="SELECT COUNT(admin_id) as Giris FROM admin where admin_adi='"+txt_kad.getText()+"' and admin_sifre='"+txt_sifre.getText()+"'";
            res=st.executeQuery(sorgu);
            
            while(res.next()){
                if(res.getInt("Giris")==1){
                    menu men=new menu();
                    men.setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Giriş Başarısız", "LOGIN", JOptionPane.PLAIN_MESSAGE);
                }
            }
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Giriş sorgusunda Hata Açıklaması: "+e.getMessage());
        }
        
        
        
        
        
        
    }//GEN-LAST:event_btn_girisActionPerformed

    private void jcheckSifreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcheckSifreActionPerformed
        if(jcheckSifre.isSelected()){
            txt_sifre.setEchoChar((char)0);
        }
        else{
            txt_sifre.setEchoChar('*');
        }
    }//GEN-LAST:event_jcheckSifreActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_giris;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JCheckBox jcheckSifre;
    private javax.swing.JTextField txt_kad;
    private javax.swing.JPasswordField txt_sifre;
    // End of variables declaration//GEN-END:variables
}
