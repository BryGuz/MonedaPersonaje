
package character;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.Polygon;
import java.awt.Shape;
import java.util.logging.Level;
import java.util.logging.Logger;

public class character extends JPanel implements ActionListener,MouseListener {
    private Timer timer;
    private int mx=500;
    private int my=500;
    private int sec = 0;
    private int px =60;
    private int py =575;
    private int cs = 0;
    private int cs1 = 0;
    private int cs2 = 0;
    private int s =0;
    private int MN =0;
    public character() {
        addKeyListener(new TAdapter());
        setFocusable(true);    
        
        timer = new Timer(25, this);
        timer.start();
        
        
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g){
        Image fondo = loadImage("blue_background.png");
        Image piso = loadImage("ground_loop.png");
        Image p = loadImage("walking.png");
        Image c = loadImage("clouds.png");
        Image m = loadImage("coin.png");
        
      
                
        for (int i = 0; i < 100; i++) {
            g.drawImage(fondo, 0+(i*22), 0, null);
        }
        for (int i = 0; i < 100; i++) {
            g.drawImage(piso, 0+(i*112), 700, null);
            
        }
        int t = s*96;
        int t2 = t+96;
        Font fuente=new Font("TimesRoman", Font.BOLD, 30);
        
        g.setColor(Color.WHITE);
         g.setFont(fuente);
       g.drawString("MONEDAS: " + MN, 700, 50);
        g.drawImage(p, px, py,(px) + 96,py +134,t,0,t2,134, null);
      //  g.drawRect(px, py, 100, 134);
     
        g.drawImage(c, 400-cs, 200, null);
        g.drawImage(c, 700-cs1, 300, null);
        g.drawImage(c, 1000-cs2, 100, null);
        g.drawImage(m,mx ,my , null); 
        g.setColor(Color.red);
        g.fillRect(900, 610, 90, 90);
        g.setColor(Color.WHITE);
        g.drawString("META", 905, 670);
     //   g.drawRect(mx, my, 55, 55);
        
        
        
           
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        checkcolision();
        if (cs ==900) {
            cs = -500;
        }else{
            cs+=10;
        }
        if (cs1 ==1200) {
            cs1 = -700;
        }else{
            cs1+=20;
        }
        if (cs2 ==1500) {
            cs2 = -1000;
        }else{
            cs2+=8;
        }
        
        
       
        
        
        repaint();
    }
    public Rectangle getBounds(){
        
        return new Rectangle(px, py, 100, 134);
    }
    public Rectangle getBoundsobjeto(){
        return new Rectangle(mx, my, 55, 55);
    }
     public Rectangle getBoundObjeto2(){
       return new Rectangle(0,732,1000,68);
     }
    public Rectangle getBoundObjeto3(){
        return new Rectangle(900, 610, 90, 90);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Point mo = e.getPoint();
        if (getBounds().contains(mo)) {
            timer.stop();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(character.class.getName()).log(Level.SEVERE, null, ex);
            }
            timer.start();
        }
        
       
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
    
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
            for (int j = 4; j > 0; j--) {
                    py+=10*j;
                    px+=10*j;
                    
                    repaint();
                    
                }
            }
        }
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
                
                for (int j = 0; j < 5; j++) {
                    px+=10*j;
                    py-=10*j;
                    repaint();
                  
                }                
                
          
            }
        
            if (key == KeyEvent.VK_RIGHT) {
                px+=15;
                if(s==3){
                    s =0;
                }else{
                    s++;
                }
            }
            if (key == KeyEvent.VK_UP) {
                py-=5;
                
            }
            if (key == KeyEvent.VK_DOWN) {
                py+=5;
            }
        }
        
    }
    
    public void checkcolision(){
        
        Rectangle Character = this.getBounds();
        Rectangle coin = this.getBoundsobjeto();
        Rectangle piso = this.getBoundObjeto2();
        Rectangle meta = this.getBoundObjeto3();
        
        if(Character.intersects(coin)){
            
            mx = 60000;
            my = 60000;
            MN += 1;
        }
        if(Character.intersects(meta)){
           py=10000;
           px=10000;
            
         //  JOptionPane.showMessageDialog(null,"¡GANASTE!"); 
         if(Character.intersects(piso)){
             //AQUI NO SE COMO  va :C
         }
        }
        
    }
   
    
}
