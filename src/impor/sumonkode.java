/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impor;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class sumonkode {
public static void main(String[] args) {
        
    }
    
    public static String formatRibuan(String x){
        long bil = Long.parseLong(x);
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        String formatRibuan = nf.format(bil);
        
        return "Rp " + formatRibuan;
    }
    
    public static String reverseRibuan(String x) {
         String numericString = x.replaceAll("[^\\d]", "");
         return numericString;
    }
    
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&-]+)@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);

        return pattern.matcher(email).matches();
    }
    
    public static String isAlphaNumeric(String str) {
        if (!str.matches("^[a-zA-Z0-9 ]*$")) {
            str = str.substring(0, str.length() - 1);
            JOptionPane.showMessageDialog(null, "Tidak diperkenankan menggunakan karakter spesial",
                "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
        return str;
    }
    
    public static String isAlphaNumericS(String str) {
        if (!str.matches("^[a-zA-Z0-9]*$")) {
            str = str.substring(0, str.length() - 1);
            JOptionPane.showMessageDialog(null, "Tidak diperkenankan menggunakan karakter spesial",
                "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
        return str;
    }
    
    public static void FilterHuruf(KeyEvent a) {
        if (Character.isDigit(a.getKeyChar())) {
            a.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Masukan Hanya Huruf",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
 
    //Method Untuk Menyaring Angka
    public static void FilterAngka(KeyEvent b) {
        if (Character.isAlphabetic(b.getKeyChar())) {
            b.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Masukan Hanya Angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static String ribuanFormat(int subtotal1Change) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    //Method Untuk Menyaring Huruf Besar
    public void HurufBesar(KeyEvent c) {
        if (Character.isLowerCase(c.getKeyChar())) {
            c.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Masukan Hanya Huruf Besar", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
 
    //Method Untuk Menyaring Huruf Kecil
    public void HurufKecil(KeyEvent d) {
        if (Character.isUpperCase(d.getKeyChar())) {
            d.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Masukan Hanya Huruf Kecil", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
 
    //Method Untuk Membatasi Jumlah Karakter
    public void JumlahKarakter(KeyEvent e) {
        /*if (karakter.getText().length() == 8) {
            e.consume();
            //Pesan Dialog Boleh Di Hapus Ini Hanya Sebagai Contoh
            JOptionPane.showMessageDialog(null, "Maksimal yang dimasukan Hanya 8 Karakter", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }*/
    }
   
    public static boolean cekKolom(JTable table, int kolom, String value) {
        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getValueAt(i, kolom).equals(value)) {
                return true;
            }
        }
        return false;
    }

}
