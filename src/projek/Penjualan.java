/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projek;
import impor.Koneksi;
import impor.sumonkode;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.*; 
import java.sql.*; 
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import java.util.Locale;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;


public class Penjualan extends javax.swing.JFrame {

    private DefaultTableModel tabmode;
    private int jumlah1Value = 0;
    private int jumlah2Value = 0;
    private int jumlah3Value = 0;
    private int subtotal1 = 0;
    private int subtotal2 = 0;
    private int subtotal3 = 0;
    private int waktumulai = 0;

    private Connection koneksi;
    int Harga, subTotal, bayar, Kembalian;
    int Total = 0;
    double ppn = 0.0;
    Connection con;
    PreparedStatement pst; 
    

    
    public Penjualan() {
        initComponents();
        
        // Menyesuaikan ukuran JFrame dengan komponen di dalamnya
        pack();
        
        // Mengatur agar JFrame ditengah layar
        setLocationRelativeTo(null);
        
        // Mengatur operasi default saat tombol 'x' di JFrame diklik
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JamRealTime();
        KoneksiDatabase();
        makanan();
        minuman();
        pelengkap();
        bersihkan();
    }


    
    private String JamRilTime(){
    Calendar kalender = new GregorianCalendar();
    int jam = kalender.get(Calendar.HOUR);
    int menit = kalender.get(Calendar.MINUTE);
    int detik = kalender.get(Calendar.SECOND);
    int AMPM = kalender.get(Calendar.AM_PM);
    String JamRealTime = jam + "" + menit + detik;
    return JamRealTime;
}

    public static String formatRibuan(String x){
        int bil = Integer.parseInt(x);
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        String formatRibuan = nf.format(bil);
        
        return "Rp " + formatRibuan;
    }
    
    public static String formatRibuanTok(String x){
        int bil = Integer.parseInt(x);
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        String formatRibuan = nf.format(bil);
        
        return formatRibuan;
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bayar = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        panelImage2 = new impor.PanelImage();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        kembalian = new javax.swing.JTextField();
        btotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        bayarpesanan = new javax.swing.JTextField();
        bayaran = new javax.swing.JButton();
        receipt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        panelImage11 = new impor.PanelImage1();
        LabelJamRealTime = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelImage1 = new impor.PanelImage();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        makananfoto = new javax.swing.JLabel();
        nmmakanan = new javax.swing.JLabel();
        jumlah1 = new javax.swing.JSpinner();
        harga1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        minumanfoto = new javax.swing.JLabel();
        nmminuman = new javax.swing.JLabel();
        jumlah2 = new javax.swing.JSpinner();
        harga2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pelengkap = new javax.swing.JLabel();
        nmpelengkap = new javax.swing.JLabel();
        jumlah3 = new javax.swing.JSpinner();
        harga3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        total = new javax.swing.JLabel();
        pembayaran = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        PPN = new javax.swing.JLabel();
        makananbox = new javax.swing.JComboBox<>();
        minumanbox = new javax.swing.JComboBox<>();
        pelengkapbox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpesanan = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Bayar");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Kembalian");

        kembalian.setEditable(false);
        kembalian.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        kembalian.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalianActionPerformed(evt);
            }
        });

        btotal.setEditable(false);
        btotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        btotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btotalActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Total");

        bayarpesanan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bayarpesanan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bayarpesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarpesananActionPerformed(evt);
            }
        });
        bayarpesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bayarpesananKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayarpesananKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bayarpesananKeyTyped(evt);
            }
        });

        bayaran.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        bayaran.setText("Bayar");
        bayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bayaranMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bayaranMouseExited(evt);
            }
        });
        bayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayaranActionPerformed(evt);
            }
        });

        receipt.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        receipt.setText("Receipt");
        receipt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                receiptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                receiptMouseExited(evt);
            }
        });
        receipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btotal)
                                .addComponent(bayarpesanan)
                                .addComponent(kembalian, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelImage2Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jLabel16))
                            .addGroup(panelImage2Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel17))))
                    .addGroup(panelImage2Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(bayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelImage2Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel18)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        panelImage2Layout.setVerticalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btotal, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bayarpesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BayarLayout = new javax.swing.GroupLayout(Bayar.getContentPane());
        Bayar.getContentPane().setLayout(BayarLayout);
        BayarLayout.setHorizontalGroup(
            BayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        BayarLayout.setVerticalGroup(
            BayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jButton5.setBackground(new java.awt.Color(127, 79, 62));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Home");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton5MouseExited(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Powered by");

        panelImage11.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout panelImage11Layout = new javax.swing.GroupLayout(panelImage11);
        panelImage11.setLayout(panelImage11Layout);
        panelImage11Layout.setHorizontalGroup(
            panelImage11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        panelImage11Layout.setVerticalGroup(
            panelImage11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );

        LabelJamRealTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelJamRealTime.setText("JAM");

        jButton6.setBackground(new java.awt.Color(127, 79, 62));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Menu");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton6MouseExited(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(127, 79, 62));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Data Penjualan");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton7MouseExited(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelJamRealTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(panelImage11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImage11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(LabelJamRealTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(52, 52, 52))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 50)); // NOI18N
        jLabel1.setText("YR JIWA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(379, 379, 379))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Makanan");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Minuman");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Pelengkap");

        makananfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        nmmakanan.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        nmmakanan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jumlah1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jumlah1StateChanged(evt);
            }
        });

        harga1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        harga1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(makananfoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(harga1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(nmmakanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jumlah1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(makananfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nmmakanan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jumlah1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(harga1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        minumanfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        nmminuman.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        nmminuman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jumlah2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jumlah2StateChanged(evt);
            }
        });

        harga2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        harga2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(minumanfoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(harga2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nmminuman, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addGap(42, 42, 42))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jumlah2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(minumanfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nmminuman, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jumlah2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(harga2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pelengkap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        nmpelengkap.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        nmpelengkap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jumlah3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jumlah3StateChanged(evt);
            }
        });

        harga3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        harga3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(pelengkap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(harga3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nmpelengkap, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addGap(42, 42, 42))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jumlah3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 79, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pelengkap, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nmpelengkap, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jumlah3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(harga3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        total.setFont(new java.awt.Font("Segoe UI Emoji", 1, 50)); // NOI18N

        pembayaran.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pembayaran.setText("Bayar");
        pembayaran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pembayaranMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pembayaranMouseExited(evt);
            }
        });
        pembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pembayaranActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Total");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("SubTotal");

        subtotal.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        subtotal.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                subtotalComponentHidden(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("PPN %");

        PPN.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(PPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PPN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        makananbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makananboxActionPerformed(evt);
            }
        });

        minumanbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minumanboxActionPerformed(evt);
            }
        });

        pelengkapbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelengkapboxActionPerformed(evt);
            }
        });

        tabelpesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Makanan", "QTY", "Harga", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelpesanan);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Hapus");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel3))
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(makananbox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel4))
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(minumanbox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                    .addComponent(pelengkapbox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42))
                                .addGroup(panelImage1Layout.createSequentialGroup()
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(79, 79, 79)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(makananbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minumanbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pelengkapbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new Home_Karyawan1().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void pembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pembayaranActionPerformed
        Bayar.pack();
        Bayar.setLocationRelativeTo(null);
        Bayar.setVisible(true); 
        bayarpesanan.requestFocus();
    }//GEN-LAST:event_pembayaranActionPerformed

    private void btotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btotalActionPerformed

    }//GEN-LAST:event_btotalActionPerformed

    private void bayarpesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarpesananActionPerformed
    // Ambil nilai total belanja dan uang bayar dari form
    int totalBelanja = Integer.parseInt(btotal.getText().replace("Rp ", "").replace(",", ""));
    int uangBayar = Integer.parseInt(bayarpesanan.getText().replace("Rp ", "").replace(",", ""));

    // Hitung nilai kembalian
    int kembalian1 = uangBayar - totalBelanja;
    if (kembalian1 >= 0){
        JOptionPane.showMessageDialog(this, "Terimakasih");
        kembalian.setText("Rp " + Penjualan.formatRibuanTok(String.valueOf(kembalian1)));
    }else{
        JOptionPane.showMessageDialog(this, "Uang bayar kurang dari total belanja!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_bayarpesananActionPerformed

    private void kembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembalianActionPerformed

    private void bayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayaranActionPerformed
    if (JOptionPane.showConfirmDialog(null, "Yakin Untuk Melakukan Pembayaran Ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == 0) {
        // Kode ketika konfirmasi diterima
        DefaultTableModel model = (DefaultTableModel) tabelpesanan.getModel();
        int rowCount = model.getRowCount();
        try {
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_cafe", "root", "");
            Statement stat = koneksi.createStatement();

            for (int i = 0; i < rowCount; i++) {
                try {                 
                    java.util.Date now = new java.util.Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                    String tgl = dateFormat.format(now);
                    UUID uuid = UUID.randomUUID();
                    String uuidString = uuid.toString();  
                    String JamRil = JamRilTime();
                    String faktur = generateIdTransaksi();
                    stat.executeUpdate("INSERT INTO `penjualan` (no, faktur, tanggal, jam, makanan, qty, harga, subtotal, ppn, total, bayar, kembalian)"
                            + "VALUES('" + uuidString + "'"
                            + ", '" + faktur + "'"
                            + ", '" + dateFormat.format(now) + "'"
                            + ", '" + JamRilTime() + "'"
                            + ", '" + model.getValueAt(i, 0) + "'"
                            + ", '" + model.getValueAt(i, 1) + "'"
                            + ", '" + model.getValueAt(i, 2) + "'"
                            + ", '" + model.getValueAt(i, 3) + "'"
                            + ", '" + PPN.getText() + "'"
                            + ", '" + btotal.getText() + "'"
                            + ", '" + bayarpesanan.getText() + "'"
                            + ", '" + kembalian.getText() + "')");
                } catch (SQLException e) {
                    System.out.println("Error : " + e);
                }
            }
            // Menutup koneksi setelah selesai
            koneksi.close();
            bersihkan();
        } catch (SQLException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        // Kode ketika konfirmasi ditolak
        JOptionPane.showMessageDialog(null, "Pembayaran dibatalkan.");
    }
    }//GEN-LAST:event_bayaranActionPerformed

    private void receiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptActionPerformed
    try{    
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/db_cafe","root","");
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\raiha\\OneDrive\\Dokumen\\NetBeansProjects\\Akhir (3)\\Akhir\\src\\projek\\struk.Jrxml");
            HashMap param = new HashMap();
            
            
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, param,con);
            
           JasperViewer.viewReport(jprint);
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(Penjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_receiptActionPerformed

    private void bayaranMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bayaranMouseEntered
   // ubah warna latar belakang button menjadi hijau
    JButton simpanButton = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    simpanButton.setBackground(Color.BLUE);
    }//GEN-LAST:event_bayaranMouseEntered

    private void bayaranMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bayaranMouseExited
    // ubah warna latar belakang button menjadi warna semula (default)
    JButton simpanButton = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    simpanButton.setBackground(UIManager.getColor("Button.background")); // warna semula (default)
    }//GEN-LAST:event_bayaranMouseExited

    private void receiptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receiptMouseEntered
   // ubah warna latar belakang button menjadi hijau
    JButton simpanButton = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    simpanButton.setBackground(Color.YELLOW);
    }//GEN-LAST:event_receiptMouseEntered

    private void receiptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_receiptMouseExited
    // ubah warna latar belakang button menjadi warna semula (default)
    JButton simpanButton = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    simpanButton.setBackground(UIManager.getColor("Button.background")); // warna semula (default)
    }//GEN-LAST:event_receiptMouseExited

    private void pembayaranMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembayaranMouseEntered
   // ubah warna latar belakang button menjadi hijau
    JButton simpanButton = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    simpanButton.setBackground(Color.GREEN);
    }//GEN-LAST:event_pembayaranMouseEntered

    private void pembayaranMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pembayaranMouseExited
    // ubah warna latar belakang button menjadi warna semula (default)
    JButton simpanButton = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    simpanButton.setBackground(UIManager.getColor("Button.background")); // warna semula (default)
    }//GEN-LAST:event_pembayaranMouseExited

    private void jumlah1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jumlah1StateChanged
    int hargab = harga1.getText().isEmpty() ? 0 : Integer.parseInt(sumonkode.reverseRibuan((harga1.getText())));
    int jumlah1CurrentValue = (int) jumlah1.getValue();
    
    if (nmmakanan.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Pilih Menu Makanan", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // Menghitung subTotal
        int subtotal1Change = jumlah1CurrentValue * hargab;

        // Validasi jumlah negatif
        if (jumlah1CurrentValue < 0) {
            JOptionPane.showMessageDialog(null, "Jumlah tidak bisa bernilai negatif!");
            jumlah1.setValue(jumlah1Value);
        } else {
            // Update nilai penampung
            jumlah1Value = jumlah1CurrentValue;

            // Perbarui subtotal1
            subtotal1 = subtotal1Change;


            // Perbarui subtotal

            // Perbarui data di tabel jika jumlah berubah
            DefaultTableModel model = (DefaultTableModel) tabelpesanan.getModel();
            boolean found = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                String namaProduk = model.getValueAt(i, 0).toString();
                if (namaProduk.equals(nmmakanan.getText())) {
                    model.setValueAt(jumlah1CurrentValue, i, 1);
                    model.setValueAt(harga1.getText(), i, 2);
                    model.setValueAt(subtotal1Change, i, 3);
                    found = true;
                    break;
                }
            }
            // Tambahkan data baru jika tidak ditemukan di tabel
            if (!found) {
                Object[] rowData = {nmmakanan.getText(), jumlah1CurrentValue, harga1.getText(), subtotal1Change};
                model.addRow(rowData);
            }

            // Perbarui total
            
            Hitungtotal();
        }
    }
    }//GEN-LAST:event_jumlah1StateChanged

    private void jumlah2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jumlah2StateChanged
    int hargab = harga2.getText().isEmpty() ? 0 : Integer.parseInt(sumonkode.reverseRibuan((harga2.getText())));
    int jumlah1CurrentValue = (int) jumlah2.getValue();

    if (nmminuman.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Pilih Menu Minuman", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // Menghitung subTotal
        int subtotal1Change = jumlah1CurrentValue * hargab;
    
        // Validasi jumlah negatif
        if (jumlah1CurrentValue < 0) {
            JOptionPane.showMessageDialog(null, "Jumlah tidak bisa bernilai negatif!");
            jumlah2.setValue(jumlah1Value);
        } else {
            // Update nilai penampung
            jumlah2Value = jumlah1CurrentValue;

            // Perbarui subtotal1
            subtotal2 = subtotal1Change;

            // Perbarui subtotal
            

            // Perbarui data di tabel jika jumlah berubah
            DefaultTableModel model = (DefaultTableModel) tabelpesanan.getModel();
            boolean found = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                String namaProduk = model.getValueAt(i, 0).toString();
                if (namaProduk.equals(nmminuman.getText())) {
                    model.setValueAt(jumlah1CurrentValue, i, 1);
                    model.setValueAt(harga2.getText(), i, 2);
                    model.setValueAt(subtotal1Change, i, 3);
                    found = true;
                    break;
                }
            }
            // Tambahkan data baru jika tidak ditemukan di tabel
            if (!found) {
                Object[] rowData = {nmminuman.getText(), jumlah1CurrentValue, harga2.getText(), subtotal1Change};
                model.addRow(rowData);
            }

            // Perbarui total
            Hitungtotal();
        }
    }
    }//GEN-LAST:event_jumlah2StateChanged

    private void jumlah3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jumlah3StateChanged
    int hargab = harga3.getText().isEmpty() ? 0 : Integer.parseInt(sumonkode.reverseRibuan((harga3.getText())));
    int jumlah1CurrentValue = (int) jumlah3.getValue();

    if (nmpelengkap.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Pilih Menu Pelengkap", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // Menghitung subTotal
        int subtotal1Change = jumlah1CurrentValue * hargab;
    
        // Validasi jumlah negatif
        if (jumlah1CurrentValue < 0) {
            JOptionPane.showMessageDialog(null, "Jumlah tidak bisa bernilai negatif!");
            jumlah3.setValue(jumlah1Value);
        } else {
            // Update nilai penampung
            jumlah3Value = jumlah1CurrentValue;

            // Perbarui subtotal1
            subtotal3 = subtotal1Change;

            // Perbarui subtotal
            

            // Perbarui data di tabel jika jumlah berubah
            DefaultTableModel model = (DefaultTableModel) tabelpesanan.getModel();
            boolean found = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                String namaProduk = model.getValueAt(i, 0).toString();
                if (namaProduk.equals(nmpelengkap.getText())) {
                    model.setValueAt(jumlah1CurrentValue, i, 1);
                    model.setValueAt(harga3.getText(), i, 2);
                    model.setValueAt(subtotal1Change, i, 3);
                    found = true;
                    break;
                }
            }
            // Tambahkan data baru jika tidak ditemukan di tabel
            if (!found) {
                Object[] rowData = {nmpelengkap.getText(), jumlah1CurrentValue, harga3.getText(), subtotal1Change};
                model.addRow(rowData);
            }

            // Perbarui total
            Hitungtotal();
            
        }
    }
    }//GEN-LAST:event_jumlah3StateChanged

    private void makananboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makananboxActionPerformed
if (makananbox.getSelectedIndex() == 0) {
    makananfoto.setIcon(null);
    nmmakanan.setText("");
    harga1.setText("");
} else {
try {
    java.sql.Statement stat = koneksi.createStatement();
    ResultSet data = stat.executeQuery("SELECT * FROM `menu_makanan` WHERE `Kategori` ='Makanan' AND `Nm_menu` ='" + makananbox.getSelectedItem() + "'");
    if (data.next()) {
        byte[] imageData = data.getBytes("Foto");
        if (imageData != null) {
            ImageIcon imageIcon = new ImageIcon(imageData);
            Image originalImage = imageIcon.getImage();
            int originalWidth = originalImage.getWidth(null);
            int originalHeight = originalImage.getHeight(null);

            int desiredWidth = 222; // Lebar gambar yang diinginkan
            int desiredHeight = 156; // Tinggi gambar yang diinginkan

            // Skala sesuai dengan lebar atau tinggi yang lebih besar
            double scale = Math.max((double) desiredWidth / originalWidth, (double) desiredHeight / originalHeight);
            int newWidth = (int) (originalWidth * scale);
            int newHeight = (int) (originalHeight * scale);

            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            makananfoto.setIcon(new ImageIcon(scaledImage));
            makananfoto.setPreferredSize(new Dimension(desiredWidth, desiredHeight));
            makananfoto.setMaximumSize(new Dimension(desiredWidth, desiredHeight));
            makananfoto.setMinimumSize(new Dimension(desiredWidth, desiredHeight));
        } else {
            makananfoto.setIcon(null);
            makananfoto.setPreferredSize(new Dimension(0, 0));
            makananfoto.setMaximumSize(new Dimension(0, 0));
            makananfoto.setMinimumSize(new Dimension(0, 0));
        }
            nmmakanan.setText(data.getString("Nm_menu"));
            harga1.setText(data.getString("Harga"));
            jumlah1.setValue(0);
        } else {
            // Jika tidak ada data yang cocok, atur komponen ke nilai default
            makananfoto.setIcon(null);
            nmmakanan.setText("");
            harga1.setText("");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
    }//GEN-LAST:event_makananboxActionPerformed

    private void minumanboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minumanboxActionPerformed
if (minumanbox.getSelectedIndex() == 0) {
    minumanfoto.setIcon(null);
    nmminuman.setText("");
    harga2.setText("");
} else {
try {
    java.sql.Statement stat = koneksi.createStatement();
    ResultSet data = stat.executeQuery("SELECT * FROM `menu_makanan` WHERE `Kategori` ='Minuman' AND `Nm_menu` ='" + minumanbox.getSelectedItem() + "'");
    if (data.next()) {
        byte[] imageData = data.getBytes("Foto");
        if (imageData != null) {
            ImageIcon imageIcon = new ImageIcon(imageData);
            Image originalImage = imageIcon.getImage();
            int originalWidth = originalImage.getWidth(null);
            int originalHeight = originalImage.getHeight(null);

            int desiredWidth = 222; // Lebar gambar yang diinginkan
            int desiredHeight = 156; // Tinggi gambar yang diinginkan

            // Skala sesuai dengan lebar atau tinggi yang lebih besar
            double scale = Math.max((double) desiredWidth / originalWidth, (double) desiredHeight / originalHeight);
            int newWidth = (int) (originalWidth * scale);
            int newHeight = (int) (originalHeight * scale);

            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            minumanfoto.setIcon(new ImageIcon(scaledImage));
            minumanfoto.setPreferredSize(new Dimension(desiredWidth, desiredHeight));
            minumanfoto.setMaximumSize(new Dimension(desiredWidth, desiredHeight));
            minumanfoto.setMinimumSize(new Dimension(desiredWidth, desiredHeight));
        } else {
            minumanfoto.setIcon(null);
            minumanfoto.setPreferredSize(new Dimension(0, 0));
            minumanfoto.setMaximumSize(new Dimension(0, 0));
            minumanfoto.setMinimumSize(new Dimension(0, 0));
        }
            nmminuman.setText(data.getString("Nm_menu"));
            harga2.setText(data.getString("Harga"));
            jumlah2.setValue(0);
        } else {
            minumanfoto.setIcon(null);
            nmminuman.setText("");
            harga2.setText("");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
    }//GEN-LAST:event_minumanboxActionPerformed

    private void pelengkapboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelengkapboxActionPerformed
if (pelengkapbox.getSelectedIndex() == 0) {
    pelengkap.setIcon(null);
    nmpelengkap.setText("");
    harga3.setText("");
} else {
try {
    java.sql.Statement stat = koneksi.createStatement();
    ResultSet data = stat.executeQuery("SELECT * FROM `menu_makanan` WHERE `Kategori` ='Pelengkap' AND `Nm_menu` ='" + pelengkapbox.getSelectedItem() + "'");
    if (data.next()) {
        byte[] imageData = data.getBytes("Foto");
        if (imageData != null) {
            ImageIcon imageIcon = new ImageIcon(imageData);
            Image originalImage = imageIcon.getImage();
            int originalWidth = originalImage.getWidth(null);
            int originalHeight = originalImage.getHeight(null);

            int desiredWidth = 222; // Lebar gambar yang diinginkan
            int desiredHeight = 156; // Tinggi gambar yang diinginkan

            // Skala sesuai dengan lebar atau tinggi yang lebih besar
            double scale = Math.max((double) desiredWidth / originalWidth, (double) desiredHeight / originalHeight);
            int newWidth = (int) (originalWidth * scale);
            int newHeight = (int) (originalHeight * scale);

            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            pelengkap.setIcon(new ImageIcon(scaledImage));
            pelengkap.setPreferredSize(new Dimension(desiredWidth, desiredHeight));
            pelengkap.setMaximumSize(new Dimension(desiredWidth, desiredHeight));
            pelengkap.setMinimumSize(new Dimension(desiredWidth, desiredHeight));
        } else {
            pelengkap.setIcon(null);
            pelengkap.setPreferredSize(new Dimension(0, 0));
            pelengkap.setMaximumSize(new Dimension(0, 0));
            pelengkap.setMinimumSize(new Dimension(0, 0));
        }
            nmpelengkap.setText(data.getString("Nm_menu"));
            harga3.setText(data.getString("Harga"));
            jumlah3.setValue(0);
        } else {
            pelengkap.setIcon(null);
            nmpelengkap.setText("");
            harga3.setText("");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
    }//GEN-LAST:event_pelengkapboxActionPerformed

    private void subtotalComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_subtotalComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalComponentHidden

    private void bayarpesananKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarpesananKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarpesananKeyPressed

    private void bayarpesananKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarpesananKeyReleased
       String format = bayarpesanan.getText();
       String nonFormat = sumonkode.reverseRibuan(format);
        
        if (!nonFormat.trim().isEmpty()) {
            bayarpesanan.setText(sumonkode.formatRibuan(nonFormat));
        }
    }//GEN-LAST:event_bayarpesananKeyReleased

    private void bayarpesananKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarpesananKeyTyped
        sumonkode.FilterAngka(evt);
    }//GEN-LAST:event_bayarpesananKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
         // ubah warna latar belakang button menjadi hijau
    JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseExited
        JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(127,79,62));
    }//GEN-LAST:event_jButton5MouseExited

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(95,158,160));
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseExited
        JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(127,79,62));
    }//GEN-LAST:event_jButton6MouseExited

    private void jButton7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseEntered
        JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(0,191,255));
    }//GEN-LAST:event_jButton7MouseEntered

    private void jButton7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseExited
        JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(127,79,62));
    }//GEN-LAST:event_jButton7MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(128,128,0));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        JButton simpanButton = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    simpanButton.setBackground(UIManager.getColor("Button.background")); // warna semula (default)
    }//GEN-LAST:event_jButton1MouseExited

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
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
                
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Bayar;
    private javax.swing.JLabel LabelJamRealTime;
    private javax.swing.JLabel PPN;
    private javax.swing.JButton bayaran;
    private javax.swing.JTextField bayarpesanan;
    private javax.swing.JTextField btotal;
    private javax.swing.JLabel harga1;
    private javax.swing.JLabel harga2;
    private javax.swing.JLabel harga3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jumlah1;
    private javax.swing.JSpinner jumlah2;
    private javax.swing.JSpinner jumlah3;
    private javax.swing.JTextField kembalian;
    private javax.swing.JComboBox<String> makananbox;
    private javax.swing.JLabel makananfoto;
    private javax.swing.JComboBox<String> minumanbox;
    private javax.swing.JLabel minumanfoto;
    private javax.swing.JLabel nmmakanan;
    private javax.swing.JLabel nmminuman;
    private javax.swing.JLabel nmpelengkap;
    private impor.PanelImage panelImage1;
    private impor.PanelImage1 panelImage11;
    private impor.PanelImage panelImage2;
    private javax.swing.JLabel pelengkap;
    private javax.swing.JComboBox<String> pelengkapbox;
    private javax.swing.JButton pembayaran;
    private javax.swing.JButton receipt;
    private javax.swing.JLabel subtotal;
    private javax.swing.JTable tabelpesanan;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

private void makanan() {
    try {
        java.sql.Statement stat = koneksi.createStatement();
        ResultSet data = stat.executeQuery("SELECT Nm_menu FROM `menu_makanan` WHERE `Kategori` = 'Makanan'");
        ArrayList<String> list = new ArrayList<>();
        list.add("--Pilih--");

        while(data.next()){
            list.add(data.getString("Nm_menu"));
        }

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(list.toArray(new String[0]));
        makananbox.setModel(model);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

private void minuman() {
    try {
        java.sql.Statement stat = koneksi.createStatement();
        ResultSet data = stat.executeQuery("SELECT Nm_menu FROM `menu_makanan` WHERE `Kategori` = 'Minuman'");
        ArrayList<String> list = new ArrayList<>();
        list.add("--Pilih--");

        while(data.next()){
            list.add(data.getString("Nm_menu"));
        }

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(list.toArray(new String[0]));
        minumanbox.setModel(model);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

private void pelengkap() {
    try {
        java.sql.Statement stat = koneksi.createStatement();
        ResultSet data = stat.executeQuery("SELECT Nm_menu FROM `menu_makanan` WHERE `Kategori` = 'Pelengkap'");
        ArrayList<String> list = new ArrayList<>();
        list.add("--Pilih--");

        while(data.next()){
            list.add(data.getString("Nm_menu"));
        }

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(list.toArray(new String[0]));
        pelengkapbox.setModel(model);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    private void JamRealTime(){
        new Thread(){
            @Override
            public void run(){
                while(waktumulai == 0){
                    Calendar kalender = new GregorianCalendar();
                    int jam = kalender.get(Calendar.HOUR);
                    int menit = kalender.get(Calendar.MINUTE);
                    int detik = kalender.get(Calendar.SECOND);
                    int AMPM = kalender.get(Calendar.AM_PM);
                    String SiangMalam;
                    if (AMPM == 1){
                        SiangMalam = "PM";
                    }else{
                        SiangMalam = "AM";
                    }
                    String JamRealTime = jam + ":" + menit + ":" + detik + ":" + SiangMalam;
                    LabelJamRealTime.setText("Jam: " + JamRealTime);
                }
            }
        }.start();
    }
    
   private String generateBatch(int a) {
    Date now = new Date();
    DefaultTableModel keranjang = (DefaultTableModel) tabelpesanan.getModel();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    int jumlahBaris = keranjang.getRowCount();
    String batch = "YRJ" + String.format("%02d", jumlahBaris + 1);
    return batch;
}

    
    
    private void hitungDanTampilkanPPN() {
    double tot = 0;
    
    for (int i = 0; i < tabelpesanan.getRowCount(); i++) {
        double subtotal = tabelpesanan.getValueAt(i, 3).toString().isEmpty() ? 0 : Double.parseDouble(tabelpesanan.getValueAt(i, 3).toString().replaceAll(",", "").replaceAll("Rp", ""));
        tot += subtotal;
    }
    
    double ppn = tot * 0.1;  // Menghitung PPN dengan asumsi persentase PPN sebesar 10%
    double totalDenganPPN = tot + ppn;
    
    total.setText("Rp " + Penjualan.formatRibuanTok(String.valueOf(totalDenganPPN)));
    btotal.setText("Rp " + Penjualan.formatRibuanTok(String.valueOf(totalDenganPPN)));
}
    
private void Hitungtotal() {
    long totalHarga = 0;
    long totalJumlah = 0;
    double ppn = 0;

    for (int j = 0; j < tabelpesanan.getRowCount(); j++) {
        int jumlah = (int) tabelpesanan.getValueAt(j, 1);
        totalJumlah += jumlah;
        String value = tabelpesanan.getValueAt(j, 3).toString().replace("Rp ", "").replace(".", "");
        long subtotal = Long.parseLong(value);
        totalHarga += subtotal;
    }

    // Menghitung PPN 10% dari total harga
    ppn = 0.1 * totalHarga;

    // Menghitung harga akhir (total harga + PPN)
    long hargaAkhir = totalHarga + (long) ppn;

    // Menggunakan NumberFormat untuk format angka
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumFractionDigits(0);

    // Mengubah nilai total jumlah dan harga akhir menjadi string yang diformat
    String totalJumlahStr = nf.format(totalJumlah);
    String hargaAkhirStr = nf.format(hargaAkhir);
    String ppnStr = nf.format(ppn);
    String subtot = nf.format(totalHarga);

    // Menyimpan nilai total jumlah dan harga akhir ke komponen UI
    total.setText("Rp " + hargaAkhirStr);
    PPN.setText("Rp " + ppnStr);
    btotal.setText("Rp " + hargaAkhirStr);
    subtotal.setText("Rp " + subtot);
}


private String generateIdTransaksi() {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HHmmss");
    int jumlahBaris = 1;
    String idTransaksi = "YRJ" + now.format(dateFormat);
    try {
        Statement stat = koneksi.createStatement();
        ResultSet data = stat.executeQuery("SELECT COUNT(*) FROM `penjualan` WHERE `no` LIKE '"
                + idTransaksi + "%'");
        if (data.next()) {
            jumlahBaris = data.getInt(1);
            idTransaksi += String.valueOf(jumlahBaris + 1);
        } else {
            idTransaksi += String.valueOf(jumlahBaris);
        }
    } catch (SQLException e) {
        System.err.println("Error id transaksi : " + e);
    }
    return idTransaksi;
}


    private void KoneksiDatabase() {
        try {
 Class.forName("com.mysql.cj.jdbc.Driver");
 } catch (ClassNotFoundException cnf) {
 }
  try {
      koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_cafe", "root", "");
 } catch (SQLException se) {
      JOptionPane.showMessageDialog(null, "Koneksi Database Tidak Berhasil");
 } catch (Exception e) {
 }
    }

    private void bersihkan() {
        jumlah1.setValue(0);
        jumlah2.setValue(0);
        jumlah3.setValue(0);
        makananbox.setSelectedIndex(0);
        minumanbox.setSelectedIndex(0);
        pelengkapbox.setSelectedIndex(0);
        makananfoto.setIcon(null);
        minumanfoto.setIcon(null);
        pelengkap.setIcon(null);
        nmmakanan.setText("");
        nmminuman.setText("");
        nmpelengkap.setText("");
        harga1.setText("");
        harga2.setText("");
        harga3.setText("");
        subtotal.setText("");
        PPN.setText("");
        total.setText("");
        btotal.setText("");
        bayarpesanan.setText("");
        kembalian.setText("");
        DefaultTableModel model = (DefaultTableModel) tabelpesanan.getModel();
        model.setRowCount(0);
    }
    
}

