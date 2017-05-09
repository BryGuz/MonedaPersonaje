/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import juego.NewPanel2;
/**
 *
 * @author Estudiante
 */
public class character extends JPanel implements ActionListener,MouseListener {
    private Timer timer;
    
    private int sec = 0;
    private int px =60;
    private int py =575;
    int cs = 0;
    int cs1 = 0;
    int cs2 = 0;
    int s =0;

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
        //g.drawImage(fondo, 50, 50, null);
                
        for (int i = 0; i < 100; i++) {
            g.drawImage(fondo, 0+(i*22), 0, null);
        }
        for (int i = 0; i < 100; i++) {
            g.drawImage(piso, 0+(i*112), 700, null);
        }
        int t = s*115;
        int t2 = t+115;
        
        g.drawImage(p, px, py,(px) + 115,py +134,t,0,t2,134, null);
        g.drawRect(px, py, 100, 134);
        
        g.drawImage(c, 400-cs, 200, null);
        g.drawImage(c, 700-cs1, 300, null);
        g.drawImage(c, 1000-cs2, 100, null);
        g.drawImage(m,500 ,500 , null);        
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //i+=5;
        //nubes
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
        
        
        //person
        /*
        if (sec%4 ==0) {
            if(s ==4){
                s=0;
            }else{
                s++;
            }
            
        }*/
        
        
        repaint();
    }
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
            for (int j = 4; j > 0; j--) {
                    py+=10*j;
                    px+=10*j;
                    System.out.println("ciclo2");
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
                
                //x =c;
                System.out.println("Espacio");
            }
            if (key == KeyEvent.VK_LEFT) {
                px-=10;
                if(s==0){
                    s =3;
                }else{
                    s--;
                }
                
                
            }
            if (key == KeyEvent.VK_RIGHT) {
                px+=5;
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
    
}
