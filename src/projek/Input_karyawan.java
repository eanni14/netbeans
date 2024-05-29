/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projek;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author ACER
 */
public class Input_karyawan extends javax.swing.JFrame {

    private String kode;

    public void tanggal(){
        Date tgl = new Date();
        jtgllahir.setDate(tgl);
        tglkerja.setDate(tgl);
    }
    
    private Connection koneksi;
    

    /**
     * Creates new form Input_menu
     */
    
        public void JumlahKarakter(KeyEvent e) {
        if (txtkode.getText().length() == 5) {
            e.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Maksimal yang dimasukan Hanya 5 Karakter", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public Input_karyawan() {
        initComponents();
        KoneksiDatabase();
        tanggal();
        TampilData1();
        setLocationRelativeTo(this);
        txtkode.requestFocus();
        txtusername.setEnabled(false);
        txtpassword.setEnabled(false);
    }
    
        private void KoneksiDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {
        }
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_cafe", "root", "");;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Koneksi Database Tidak Berhasil");
        } catch (Exception e) {
        }
    }
        
        private void TampilData1() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Kode Karyawan");
    model.addColumn("Nama Karyawan");
    model.addColumn("Jenis Kelamin");
    model.addColumn("Tanggal Lahir");
    model.addColumn("Telepon");
    model.addColumn("Alamat");
    model.addColumn("Jabatan");
    model.addColumn("Tanggal Kerja");

    try {
        java.sql.Statement stat = koneksi.createStatement();
        ResultSet data = stat.executeQuery("SELECT `kode_karyawan`, `nama`, `jenis_kelamin`,"
                + " `tgl_lahir`, `telepon`, `alamat`, `jabatan`, `tgl_kerja` FROM karyawan");
        while (data.next()) {
            model.addRow(new Object[]{
                data.getString("kode_karyawan"),
                data.getString("nama"),
                data.getString("jenis_kelamin"),
                data.getString("tgl_lahir"),
                data.getString("telepon"),
                data.getString("alamat"),
                data.getString("jabatan"),
                data.getString("tgl_kerja"),
            });
        }
    } catch (Exception e) {
        System.err.println("Terjadi Kesalahan :" + e);
    }

    tblkaryawan.setModel(model);
}
        
        class Menu extends Input_menu {
    String  nama = "";
    String  kode = "";
    String  kelamin = "";
    String  telepon = "";
    String  alamat = "";
    String  jabatan = "";
    String  username = "";
    String  password = "";
    String  foto = "";

    public Menu() {
        kode = txtkode.getText();
        nama = txtnama.getText();
        kelamin = bkelamin.getSelection() != null ? bkelamin.getSelection().getActionCommand() : "";
        telepon = txttelepon.getText();
        alamat = txtalamat.getText();
        jabatan = (String) cbjabatan.getSelectedItem();
        username = txtusername.getText();
        password = txtpassword.getText();
    }
        }
        
        private boolean cekDataDariDatabase(String kode) {
        boolean dataDitemukan = false;

    try {
        // Menghubungkan ke database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db_cafe", "root", "");

        // Mengeksekusi query untuk mengambil data berdasarkan kode menu
        String sql = "SELECT * FROM karyawan WHERE kode_karyawan = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, kode);
        ResultSet resultSet = preparedStatement.executeQuery();

        // Memeriksa apakah data ditemukan
        if (resultSet.next()) {
            dataDitemukan = true;
        }

        // Menutup koneksi dan sumber daya
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return dataDitemukan;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bkelamin = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        panelImage11 = new impor.PanelImage1();
        bhome = new javax.swing.JButton();
        bmenu = new javax.swing.JButton();
        bdata = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelImage1 = new impor.PanelImage();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblkaryawan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        Laki = new javax.swing.JRadioButton();
        Perempuan = new javax.swing.JRadioButton();
        jtgllahir = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txttelepon = new javax.swing.JTextField();
        txtalamat = new javax.swing.JTextField();
        cbjabatan = new javax.swing.JComboBox<>();
        tglkerja = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        bubah = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bbersihkan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        lblfoto = new javax.swing.JLabel();
        bpilih = new javax.swing.JButton();
        txtpassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

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

        bhome.setBackground(new java.awt.Color(127, 79, 62));
        bhome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bhome.setForeground(new java.awt.Color(255, 255, 255));
        bhome.setText("Home");
        bhome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bhomeMouseExited(evt);
            }
        });
        bhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhomeActionPerformed(evt);
            }
        });

        bmenu.setBackground(new java.awt.Color(127, 79, 62));
        bmenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bmenu.setForeground(new java.awt.Color(255, 255, 255));
        bmenu.setText("Input Menu");
        bmenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bmenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bmenuMouseExited(evt);
            }
        });
        bmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmenuActionPerformed(evt);
            }
        });

        bdata.setBackground(new java.awt.Color(127, 79, 62));
        bdata.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bdata.setForeground(new java.awt.Color(255, 255, 255));
        bdata.setText("Data Penjualan");
        bdata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bdataMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bdataMouseExited(evt);
            }
        });
        bdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdataActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Powered by");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(panelImage11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bhome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panelImage11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(bhome, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bdata, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(37, 37, 37))
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        jLabel1.setFont(new java.awt.Font("Segoe Print", 3, 50)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CAFE YR JIWA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        tblkaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tblkaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkaryawanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblkaryawan);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Kode Karyawan");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Nama");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Jenis Kelamin");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Tanggal Lahir");

        txtkode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkodeActionPerformed(evt);
            }
        });
        txtkode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtkodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtkodeKeyTyped(evt);
            }
        });

        txtnama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });
        txtnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnamaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Cari Karyawan");

        txtcari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        bkelamin.add(Laki);
        Laki.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Laki.setText("Laki-Laki");
        Laki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LakiActionPerformed(evt);
            }
        });

        bkelamin.add(Perempuan);
        Perempuan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Perempuan.setText("Perempuan");
        Perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerempuanActionPerformed(evt);
            }
        });
        Perempuan.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                PerempuanPropertyChange(evt);
            }
        });

        jtgllahir.setDateFormatString("dd-MMMM-yyyy");
        jtgllahir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jtgllahir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtgllahirMouseClicked(evt);
            }
        });
        jtgllahir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jtgllahirPropertyChange(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("No. Telepon");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Alamat Rumah");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Jabatan");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Tanggal Kerja");

        txttelepon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txttelepon.setFocusable(false);
        txttelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtteleponActionPerformed(evt);
            }
        });
        txttelepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtteleponKeyTyped(evt);
            }
        });

        txtalamat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtalamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtalamatActionPerformed(evt);
            }
        });

        cbjabatan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbjabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Pilih Jabatan ----", "Kasir", "Chef", "Pramusaji" }));
        cbjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjabatanActionPerformed(evt);
            }
        });

        tglkerja.setDateFormatString("dd-MMMM-yyyy");
        tglkerja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tglkerja.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglkerjaPropertyChange(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Username");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Password");

        txtusername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });

        bubah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bubah.setText("Ubah");
        bubah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        bsimpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bsimpan.setText("Simpan");
        bsimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bbersihkan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bbersihkan.setText("Bersih");
        bbersihkan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bbersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbersihkanActionPerformed(evt);
            }
        });

        bhapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bhapus.setText("Hapus");
        bhapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        lblfoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));

        bpilih.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bpilih.setText("Pilih Gambar");
        bpilih.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bpilih.setFocusable(false);
        bpilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpilihActionPerformed(evt);
            }
        });

        txtpassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelImage1Layout.createSequentialGroup()
                                    .addComponent(bbersihkan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelImage1Layout.createSequentialGroup()
                                    .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(bubah, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelImage1Layout.createSequentialGroup()
                                    .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                            .addComponent(Laki, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Perempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtnama)
                                        .addComponent(jtgllahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtkode))
                                    .addGap(40, 40, 40)
                                    .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbjabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tglkerja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(panelImage1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txttelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtpassword))))
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bpilih)
                                .addGap(27, 27, 27)))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Laki)
                                    .addComponent(Perempuan)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addComponent(cbjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tglkerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtgllahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bsimpan)
                                    .addComponent(bubah))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bbersihkan)
                                    .addComponent(bhapus))
                                .addGap(0, 46, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bpilih)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bbersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersihkanActionPerformed
        txtkode.setText("");
        txtnama.setText("");
        cbjabatan.setSelectedIndex(0);
        txttelepon .setText("");
        lblfoto.setIcon(null);
        bkelamin.clearSelection();
        txtalamat.setText("");
        txtusername.setText("");
        txtpassword.setText("");
        txtkode.requestFocus();
        jtgllahir.setDate(new Date());
        tglkerja.setDate(new Date());
        txtkode.requestFocus();
        TampilData1();
    }//GEN-LAST:event_bbersihkanActionPerformed

    private void bpilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpilihActionPerformed
        Menu a = new Menu();
if (a.kode.equals("") || a.nama.equals("") || bkelamin.isSelected(null) || jtgllahir.getDate()== null || tglkerja.getDate()== null || a.telepon.equals("") || a.alamat.equals("") || cbjabatan.getSelectedIndex() == 0) {
    JOptionPane.showMessageDialog(null, "Pastikan Semua Data Terisi!");
} else {
    JFileChooser fchoser = new JFileChooser();
    fchoser.showOpenDialog(null);
    File f = fchoser.getSelectedFile();
    if (f != null) {
        String fname = f.getAbsolutePath();
        ImageIcon micon = new ImageIcon(fname);
        try {
            File image = new File(fname);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int readnum;
            while ((readnum = fis.read(buf)) != -1) {
                baos.write(buf, 0, readnum);
            }
            baos.toByteArray();
            lblfoto.setIcon(resizeImage(fname, buf));
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Anda tidak memilih file atau membatalkan dialog!");
        // Tangani situasi ketika file tidak dipilih atau dialog dibatalkan
    }
}
    }//GEN-LAST:event_bpilihActionPerformed
public ImageIcon resizeImage(String imagePath, byte[] pic) {
    ImageIcon myImage = null;
    if (imagePath != null) {
        myImage = new ImageIcon(imagePath);
    } else {
        myImage = new ImageIcon(pic);
    }
    Image img = myImage.getImage();

    // Mengatur ukuran tetap untuk lblfoto
    int lebarFoto = 165;
    int tinggiFoto = 195;

    Image img2 = img.getScaledInstance(lebarFoto, tinggiFoto, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(img2);
    return image;
}
    private void bhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhomeActionPerformed
        new Home_Admin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bhomeActionPerformed

    private void bmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmenuActionPerformed
        new Input_menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bmenuActionPerformed

    private void bdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bdataActionPerformed

    private void PerempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerempuanActionPerformed
        
    }//GEN-LAST:event_PerempuanActionPerformed

    private void txtkodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodeKeyTyped
        JumlahKarakter(evt);
        char c = evt.getKeyChar();
if (!(Character.isLetterOrDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE) || (c == KeyEvent.VK_ENTER))) {
    evt.consume();
    JOptionPane.showMessageDialog(null, "Inputkan Huruf dan Angka Saja!", "Peringatan", JOptionPane.WARNING_MESSAGE);
}
    }//GEN-LAST:event_txtkodeKeyTyped

    private void txtkodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodeKeyReleased
        txtkode.setText(txtkode.getText().toUpperCase());
    }//GEN-LAST:event_txtkodeKeyReleased

    private void txtnamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamaKeyTyped
        char c = evt.getKeyChar();
if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE) || (c == '\'') || (c == KeyEvent.VK_ENTER))) {
    evt.consume();
    JOptionPane.showMessageDialog(null, "Inputkan Huruf Saja!", "Peringatan", JOptionPane.WARNING_MESSAGE);
}
    }//GEN-LAST:event_txtnamaKeyTyped

    private void LakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LakiActionPerformed
        
    }//GEN-LAST:event_LakiActionPerformed

    private void jtgllahirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtgllahirMouseClicked
        
    }//GEN-LAST:event_jtgllahirMouseClicked

    private void txtkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkodeActionPerformed
        txtnama.requestFocus();
    }//GEN-LAST:event_txtkodeActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        Laki.requestFocus();
    }//GEN-LAST:event_txtnamaActionPerformed

    private void jtgllahirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jtgllahirPropertyChange
        txttelepon.requestFocus();
    }//GEN-LAST:event_jtgllahirPropertyChange

    private void txtteleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtteleponActionPerformed
        txtalamat.requestFocus();
    }//GEN-LAST:event_txtteleponActionPerformed

    private void txtalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtalamatActionPerformed
        cbjabatan.requestFocus();
    }//GEN-LAST:event_txtalamatActionPerformed

    private void cbjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjabatanActionPerformed
        String selectedJabatan = (String) cbjabatan.getSelectedItem();
    
    if (selectedJabatan.equals("Kasir")) {
        txtusername.setEnabled(true);
        txtpassword.setEnabled(true);
        bpilih.setEnabled(true);
    } else {
        txtusername.setEnabled(false);
        txtpassword.setEnabled(false);
        bpilih.setEnabled(true);
        txtusername.setText("");
        txtpassword.setText("");
    }
    }//GEN-LAST:event_cbjabatanActionPerformed

    private void PerempuanPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_PerempuanPropertyChange
        
    }//GEN-LAST:event_PerempuanPropertyChange

    private void tglkerjaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglkerjaPropertyChange
        String selectedJabatan = (String) cbjabatan.getSelectedItem();
    
    if (selectedJabatan.equals("Kasir")) {
        txtusername.requestFocus();
    } else {
        bpilih.requestFocus();
    }
    }//GEN-LAST:event_tglkerjaPropertyChange

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        txtpassword.requestFocus();
    }//GEN-LAST:event_txtusernameActionPerformed

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        bpilih.requestFocus();
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String kode             = txtkode.getText();
        String nama             = txtnama.getText();
        String jeniskelamin     = null;
        if (Laki.isSelected()) {
            jeniskelamin = "Laki-Laki";
        } else {
            jeniskelamin = "Perempuan";
        }
        SimpleDateFormat dateFormat   = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal          = dateFormat.format(jtgllahir.getDate());
        String telepon          = txttelepon.getText();
        String alamat           = txtalamat.getText();
        String jabatan          = (String) cbjabatan.getSelectedItem();
        SimpleDateFormat dateFormat1   = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal1         = dateFormat1.format(tglkerja.getDate());
        String username         = txtusername.getText();
        String password         = txtpassword.getText();
        Icon foto               = lblfoto.getIcon();

if (txtkode.getText().trim().equals("")) {
    JOptionPane.showMessageDialog(null, "Mohon Isikan Kode Menu", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
    txtkode.requestFocus();
} else if (txtnama.getText().trim().equals("")) {
    JOptionPane.showMessageDialog(null, "Mohon Isikan Nama Menu", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
    txtnama.requestFocus();
} else if (bkelamin.isSelected(null)) {
    JOptionPane.showMessageDialog(null, "Harap Pilih Jenis Kelamin Anda", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
    Laki.requestFocus();
} else if (txttelepon.getText().trim().equals("")) {
    JOptionPane.showMessageDialog(null, "Mohon Isikan Nomor Telepon", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
    txttelepon.requestFocus();
} else if (txtalamat.getText().trim().equals("")) {
    JOptionPane.showMessageDialog(null, "Mohon Isikan Alamat Rumah", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
    txttelepon.requestFocus();
} else if (cbjabatan.getSelectedIndex() == 0) {
    JOptionPane.showMessageDialog(null, "Harap Pilih Jabatan", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
    cbjabatan.requestFocus();
    } else if (cbjabatan.getSelectedIndex() == 1) {
    if (txtusername.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Mohon Isikan Username", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
        txtusername.requestFocus();
    } else if (txtpassword.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null, "Mohon Isikan Password", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
        txtpassword.requestFocus();
    } else if (foto == null) {
       JOptionPane.showMessageDialog(null, "Mohon Isikan Foto", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
       lblfoto.requestFocus(); 
    } else { try {
        java.sql.Statement stat = koneksi.createStatement();
        ResultSet data = stat.executeQuery("SELECT * FROM `karyawan` WHERE kode_karyawan ='" + txtkode.getText() + "'");
        if (data.next()) {
            JOptionPane.showMessageDialog(null, "Kode Telah Diinputkan", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
            txtkode.requestFocus();
        } else {
            // Mengambil gambar dari Icon
            Image image = ((ImageIcon) foto).getImage();

            // Membuat BufferedImage
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = bufferedImage.createGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.dispose();

            // Mengonversi BufferedImage menjadi byte[]
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ImageIO.write(bufferedImage, "jpg", baos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] fotoBytes = baos.toByteArray();

            String sql = "INSERT INTO karyawan (kode_karyawan, nama, jenis_kelamin,"
                    + " tgl_lahir, telepon, alamat, jabatan, tgl_kerja, username, "
                    + "password, foto) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = koneksi.prepareStatement(sql);
            preparedStatement.setString(1, kode);
            preparedStatement.setString(2, nama);
            preparedStatement.setString(3, jeniskelamin);
            preparedStatement.setString(4, tanggal);
            preparedStatement.setString(5, telepon);
            preparedStatement.setString(6, alamat);
            preparedStatement.setString(7, jabatan);
            preparedStatement.setString(8, tanggal1);
            preparedStatement.setString(9, username);
            preparedStatement.setString(10, password);
            preparedStatement.setBytes(11, fotoBytes);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
            txtkode.setText("");
            txtnama.setText("");
            cbjabatan.setSelectedIndex(0);
            txttelepon .setText("");
            lblfoto.setIcon(null);
            bkelamin.clearSelection();
            txtalamat.setText("");
            txtusername.setText("");
            txtpassword.setText("");
            txtkode.requestFocus();
            jtgllahir.setDate(new Date());
            tglkerja.setDate(new Date());
            txtkode.requestFocus();
            TampilData1();
        }
        stat.close();
    } catch (Exception exc) {
        System.err.println("Terjadi Kesalahan: " + exc);
    }   
    }  
} else if (foto == null) {
    JOptionPane.showMessageDialog(null, "Mohon Isikan Foto", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
    lblfoto.requestFocus();
} else {
    try {
        java.sql.Statement stat = koneksi.createStatement();
        ResultSet data = stat.executeQuery("SELECT * FROM `karyawan` WHERE kode_karyawan ='" + txtkode.getText() + "'");
        if (data.next()) {
            JOptionPane.showMessageDialog(null, "Kode Telah Diinputkan", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
            txtkode.requestFocus();
        } else {
            // Mengambil gambar dari Icon
            Image image = ((ImageIcon) foto).getImage();

            // Membuat BufferedImage
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = bufferedImage.createGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.dispose();

            // Mengonversi BufferedImage menjadi byte[]
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ImageIO.write(bufferedImage, "jpg", baos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] fotoBytes = baos.toByteArray();

            String sql = "INSERT INTO karyawan (kode_karyawan, nama, jenis_kelamin,"
                    + " tgl_lahir, telepon, alamat, jabatan, tgl_kerja, foto) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = koneksi.prepareStatement(sql);
            preparedStatement.setString(1, kode);
            preparedStatement.setString(2, nama);
            preparedStatement.setString(3, jeniskelamin);
            preparedStatement.setString(4, tanggal);
            preparedStatement.setString(5, telepon);
            preparedStatement.setString(6, alamat);
            preparedStatement.setString(7, jabatan);
            preparedStatement.setString(8, tanggal1);
            preparedStatement.setBytes(9, fotoBytes);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
            txtkode.setText("");
            txtnama.setText("");
            cbjabatan.setSelectedIndex(0);
            txttelepon .setText("");
            lblfoto.setIcon(null);
            bkelamin.clearSelection();
            txtalamat.setText("");
            txtusername.setText("");
            txtpassword.setText("");
            txtkode.requestFocus();
            jtgllahir.setDate(new Date());
            tglkerja.setDate(new Date());
            txtkode.requestFocus();
            TampilData1();
        }
        stat.close();
    } catch (Exception exc) {
        System.err.println("Terjadi Kesalahan: " + exc);
    }
}
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        int baris = tblkaryawan.getSelectedRow();
if (baris == -1) {
    JOptionPane.showMessageDialog(null, "Pilih Data Terlebih Dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
} else {
    int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data Ini?", "Konfirmasi Dialog", JOptionPane.YES_NO_OPTION);
    if (ok == 0) {
        String kode = txtkode.getText().trim();
        String sql = "DELETE FROM karyawan WHERE kode_karyawan=?";
        try {
            PreparedStatement preparedStatement = koneksi.prepareStatement(sql);
            preparedStatement.setString(1, kode);
            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus", "Hapus Data", JOptionPane.INFORMATION_MESSAGE);
                txtkode.setText("");
                txtnama.setText("");
                cbjabatan.setSelectedIndex(0);
                txttelepon .setText("");
                lblfoto.setIcon(null);
                bkelamin.clearSelection();
                txtalamat.setText("");
                txtusername.setText("");
                txtpassword.setText("");
                txtkode.requestFocus();
                jtgllahir.setDate(new Date());
                tglkerja.setDate(new Date());
                txtkode.requestFocus();
                TampilData1();
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan", "Gagal", JOptionPane.ERROR_MESSAGE);
            }

            preparedStatement.close();
        } catch (SQLException exc) {
            System.err.println(sql);
            System.err.println("Error : " + exc);
        }
    }
}
    }//GEN-LAST:event_bhapusActionPerformed

    private void txtteleponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtteleponKeyTyped
        char c = evt.getKeyChar();
if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)|| (c == KeyEvent.VK_ENTER))){
    evt.consume();
    JOptionPane.showMessageDialog(null, "Inputkan Angka Saja!", "Peringatan", JOptionPane.WARNING_MESSAGE);
}
    }//GEN-LAST:event_txtteleponKeyTyped

    private void tblkaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkaryawanMouseClicked
        int baris = tblkaryawan.getSelectedRow();
if (baris != -1) {
    String kodeMenu = tblkaryawan.getValueAt(baris, 0).toString();

    try {
    // Mengambil data username, password, dan foto dari database berdasarkan kode
    String sql = "SELECT username, password, Foto FROM karyawan WHERE kode_karyawan = ?";
    PreparedStatement preparedStatement = koneksi.prepareStatement(sql);
    preparedStatement.setString(1, kodeMenu);
    ResultSet resultSet = preparedStatement.executeQuery();

    if (resultSet.next()) {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        byte[] fotoBytes = resultSet.getBytes("foto");

        // Menampilkan data username dan password pada text fields
        txtusername.setText(username);
        txtpassword.setText(password);

        // Mengubah data foto menjadi objek ImageIcon
        ImageIcon imageIcon = new ImageIcon(fotoBytes);

        // Mengatur ukuran tetap untuk lblfoto
        int lebarFoto = 165; // Ganti dengan lebar yang diinginkan
        int tinggiFoto = 195; // Ganti dengan tinggi yang diinginkan

        // Mengatur ikon pada lblfoto dengan ukuran tetap
        Image image = imageIcon.getImage().getScaledInstance(lebarFoto, tinggiFoto, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        lblfoto.setIcon(scaledIcon);
        lblfoto.setPreferredSize(new Dimension(lebarFoto, tinggiFoto));
        lblfoto.revalidate();
        lblfoto.repaint();
    } else {
        System.out.println("Data tidak ditemukan");
    }
} catch (Exception exc) {
    System.err.println("Terjadi Kesalahan: " + exc);
}

    // Menampilkan data lainnya pada komponen input sesuai dengan baris yang dipilih
    txtkode.setText(tblkaryawan.getValueAt(baris, 0).toString());
    txtnama.setText(tblkaryawan.getValueAt(baris, 1).toString());
    if ("Laki-Laki".equals(tblkaryawan.getValueAt(baris, 2).toString())) {
                Laki.setSelected(true);
            } else {
                Perempuan.setSelected(true);
            }
    String tanggal = tblkaryawan.getValueAt(baris, 3).toString();
    String tanggal1 = tblkaryawan.getValueAt(baris, 7).toString();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    try {
        Date date = format.parse(tanggal);
        Date date1 = format.parse(tanggal1);
        jtgllahir.setDate(date);
        tglkerja.setDate(date1);
    } catch (ParseException ex) {
        ex.printStackTrace();
    }
    txttelepon.setText(tblkaryawan.getValueAt(baris, 4).toString());
    txtalamat.setText(tblkaryawan.getValueAt(baris, 5).toString());
    cbjabatan.setSelectedItem(tblkaryawan.getValueAt(baris, 6).toString());
    txtkode.setEnabled(false);
    txtnama.requestFocus();
} else {
    JOptionPane.showMessageDialog(null, "Anda belum memilih data yang akan diubah.", "Peringatan", JOptionPane.WARNING_MESSAGE);
}
    }//GEN-LAST:event_tblkaryawanMouseClicked

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        Menu a = new Menu();
        String kode             = txtkode.getText();
        String nama             = txtnama.getText();
        String jeniskelamin     = null;
        if (Laki.isSelected()) {
            jeniskelamin = "Laki-Laki";
        } else {
            jeniskelamin = "Perempuan";
        }
        SimpleDateFormat dateFormat   = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal          = dateFormat.format(jtgllahir.getDate());
        String telepon          = txttelepon.getText();
        String alamat           = txtalamat.getText();
        String jabatan          = (String) cbjabatan.getSelectedItem();
        SimpleDateFormat dateFormat1   = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal1         = dateFormat1.format(tglkerja.getDate());
        String username         = txtusername.getText();
        String password         = txtpassword.getText();
        Icon foto               = lblfoto.getIcon();
if (a.kode.equals("") || a.nama.equals("") || bkelamin.isSelected(null) || jtgllahir.getDate()== null || tglkerja.getDate()== null || a.telepon.equals("") || a.alamat.equals("") || cbjabatan.getSelectedIndex() == 0) {
    JOptionPane.showMessageDialog(null, "Pastikan Semua Data Terisi!");
} else {
    // Periksa apakah data diambil dari database
    boolean dataDariDatabase = cekDataDariDatabase(kode);
    if (!dataDariDatabase) {
        JOptionPane.showMessageDialog(null, "Data tidak bisa diubah karena tidak diambil dari database");
    } else {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan merubah data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                // Kode perubahan data
                // Mengubah ImageIcon menjadi Image
                Image image = ((ImageIcon) foto).getImage();
                // Mengonversi Image menjadi BufferedImage
                BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bufferedImage.createGraphics();
                g2d.drawImage(image, 0, 0, null);
                g2d.dispose();
                // Mengonversi BufferedImage menjadi byte[]
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    ImageIO.write(bufferedImage, "jpg", baos);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] fotoBytes = baos.toByteArray();

                String sql = "UPDATE karyawan SET nama = ?, jenis_kelamin = ?, tgl_lahir = ?, "
                        + "telepon = ?, alamat = ?, jabatan = ?, tgl_kerja = ?, username = ?, "
                        + "password = ?, foto = ? WHERE kode_karyawan = ?";

                PreparedStatement preparedStatement = koneksi.prepareStatement(sql);
                preparedStatement.setString(1, nama);
                preparedStatement.setString(2, jeniskelamin);
                preparedStatement.setString(3, tanggal);
                preparedStatement.setString(4, telepon);
                preparedStatement.setString(5, alamat);
                preparedStatement.setString(6, jabatan);
                preparedStatement.setString(7, tanggal1);
                preparedStatement.setString(8, username);
                preparedStatement.setString(9, password);
                preparedStatement.setBytes(10, fotoBytes);
                preparedStatement.setString(11, kode);
 
                int rowsUpdated = preparedStatement.executeUpdate();
                // Menampilkan konfirmasi setelah perubahan data berhasil
                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                // Refresh tampilan data
                txtkode.setText("");
                txtnama.setText("");
                cbjabatan.setSelectedIndex(0);
                txttelepon .setText("");
                lblfoto.setIcon(null);
                bkelamin.clearSelection();
                txtalamat.setText("");
                txtusername.setText("");
                txtpassword.setText("");
                txtkode.requestFocus();
                jtgllahir.setDate(new Date());
                tglkerja.setDate(new Date());
                txtkode.requestFocus();
                TampilData1();

            } catch (Exception exc) {
                System.err.println("Terjadi Kesalahan: " + exc);
            }
        }
    }
}
    }//GEN-LAST:event_bubahActionPerformed

    private void bhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhomeMouseEntered
        // ubah warna latar belakang button menjadi hijau
    JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_bhomeMouseEntered

    private void bhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bhomeMouseExited
        JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(127,79,62));
    }//GEN-LAST:event_bhomeMouseExited

    private void bmenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmenuMouseEntered
        JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(34,139,34));
    }//GEN-LAST:event_bmenuMouseEntered

    private void bmenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmenuMouseExited
        JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(127,79,62));
    }//GEN-LAST:event_bmenuMouseExited

    private void bdataMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdataMouseExited
        JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(127,79,62));
    }//GEN-LAST:event_bdataMouseExited

    private void bdataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdataMouseEntered
        JButton bdata = (JButton) evt.getSource(); // mendapatkan button yang menjadi sumber event
    bdata.setBackground(new Color(0,191,255));
    }//GEN-LAST:event_bdataMouseEntered

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
            java.util.logging.Logger.getLogger(Input_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Input_karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Laki;
    private javax.swing.JRadioButton Perempuan;
    private javax.swing.JButton bbersihkan;
    private javax.swing.JButton bdata;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bhome;
    private javax.swing.ButtonGroup bkelamin;
    private javax.swing.JButton bmenu;
    private javax.swing.JButton bpilih;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JComboBox<String> cbjabatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jtgllahir;
    private javax.swing.JLabel lblfoto;
    private impor.PanelImage panelImage1;
    private impor.PanelImage1 panelImage11;
    private javax.swing.JTable tblkaryawan;
    private com.toedter.calendar.JDateChooser tglkerja;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnama;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txttelepon;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
