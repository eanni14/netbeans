package impor;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImage1 extends JPanel{
   Image gambar;
   public PanelImage1(){
       gambar = new ImageIcon(getClass().getResource("/gambar/iconbulat.png")).getImage();
   }
   @Override
   protected void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D gd = (Graphics2D)g.create();
      gd.drawImage(gambar,0,0,getWidth(),getHeight(),null);
      gd.dispose();
   }
}
