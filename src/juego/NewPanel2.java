/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Estudiante
 */
public class NewPanel2 extends JPanel implements ActionListener, MouseListener{
    
    private Timer timer;
    int i =-700;
    int x =-335;
    int catx = 0;
    int caty = 335;
    int cx = 0;
    int cy =0;
    int secuencia =0;
    boolean cr = true;
    public NewPanel2(){
        timer = new Timer(25, this);
        timer.start();
        this.addMouseListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Image fondo = loadImage("fondo.png");
        Image cat = loadImage("cats.gif");
        
        
        g.drawImage(fondo,0,0,null);
        Color puerta = new Color(103,168,255);
        Color techo = new Color(106,194,255);
        
        int t = secuencia*132;
        int t2 = t+132;
        
        
        
        
        
        
        
        g.drawImage(cat, catx+i, caty,(catx+i) + 132,caty +80,t,0,t2,80, null);
        g.drawRect(catx+i, caty, 132, 80);
        
        
        g.setColor(techo);
            g.drawRect(700+i, 700+x, 100, 30);
            g.fillRect(700+i, 700+x, 100, 30);
            g.setColor(Color.BLACK);
            g.drawOval(715+i, 730+x, 25, 25);
            g.fillOval(715+i, 730+x, 25, 25);
            g.drawOval(760+i, 730+x, 25, 25);
            g.fillOval(760+i, 730+x, 25, 25);

                //roof
            Polygon roof = new Polygon();
                roof.addPoint(745+i, 685+x);
                roof.addPoint(760+i, 685+x);
                roof.addPoint(785+i, 700+x);
                roof.addPoint(720+i, 700+x);  
            g.setColor(puerta);
            g.fillPolygon(roof);
            g.drawPolygon(roof);
            
        
    }
    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        i+=5;
        
        if (secuencia ==5) {
            secuencia = 0;
        }else{
            secuencia++;
        }
        
        
        
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
     
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
    
}
