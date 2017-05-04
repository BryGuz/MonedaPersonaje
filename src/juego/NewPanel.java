/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class NewPanel  extends JPanel implements ActionListener, MouseListener{
    private Timer timer;
    int i =-700;
    int x =0;
    int cx = 0;
    int cy =0;
    boolean cr = true;
    public NewPanel(){
        timer = new Timer(25, this);
        timer.start();
        this.addMouseListener(this);
    }
    
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //System.out.println("clicl");
        
        g.setColor(Color.RED);
        g.fillRect(100, 400+i, 95, 150);
        g.drawRect(100, 400+i, 95, 150);
        g.setColor(Color.WHITE);
        g.drawRect(110, 410, 75, 130);
        
        
        g.setColor(Color.GREEN);
        g.fillRect(800, 400+i, 95, 150);
        g.drawRect(800, 400+i, 95, 150);
        g.fillRect(450, 200+i, 95, 150);
        g.drawRect(450, 200+i, 95, 150);
        g.setColor(Color.RED);
        g.fillRect(500, 250+i, 95, 150);
        g.drawRect(500, 250+i, 95, 150);
        
        g.setColor(Color.BLUE);
        g.drawOval(450, 600-i, 50, 50);
        g.fillOval(450, 600-i, 50, 50);
        g.drawRect(400, 650-i, 150, 95);
        g.drawRect(400, 745-i, 40, 100);
        g.drawRect(510, 745-i, 40, 100);
        
        g.drawString("Puntos: 800", 800, 20);
        
        Color puerta = new Color(103,168,255);
        Color techo = new Color(106,194,255);
        
        
        
        /*
        //CAR
        g.setColor(techo);
        g.drawRect(700, 700, 100, 30);
        g.fillRect(700, 700, 100, 30);
        g.setColor(Color.BLACK);
        g.drawOval(715, 730, 25, 25);
        g.fillOval(715, 730, 25, 25);
        g.drawOval(760, 730, 25, 25);
        g.fillOval(760, 730, 25, 25);
        
            //roof
           
        Polygon roof = new Polygon();
        roof.addPoint(745, 685);
        roof.addPoint(760, 685);
        roof.addPoint(785, 700);
        roof.addPoint(720, 700);  
        g.setColor(puerta);
        g.fillPolygon(roof);
        g.drawPolygon(roof);
      
        //CAR 2
        
        g.setColor(techo);
        g.drawRect(720, 700, 100, 30);
        g.fillRect(720, 700, 100, 30);
        g.setColor(Color.BLACK);
        g.drawOval(735, 730, 25, 25);
        g.fillOval(735, 730, 25, 25);
        g.drawOval(790, 730, 25, 25);
        g.fillOval(790, 730, 25, 25);
        
            //roof
           
        Polygon roof2 = new Polygon();
        roof.addPoint(775, 685);
        roof.addPoint(790, 685);
        roof.addPoint(815, 700);
        roof.addPoint(740, 700);  
        g.setColor(puerta);
        g.fillPolygon(roof);
        g.drawPolygon(roof);
        
        
        //
        */
        
        
        
        
        
        /*
        //carro movimiento
        for (int i = -700; i < 300; i+=50) {*/
            //cuadrado de colision
            g.setColor(Color.WHITE);
            //g.drawRect(700+i, 685+x, 100, 70);
            
            //rectangulo objeto colision
            g.setColor(Color.BLACK);
            g.drawRect(700-i, 500, 100, 70);
            g.fillRect(700-i, 500, 100, 70);
         
            
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



    @Override
    public void actionPerformed(ActionEvent e) {
        checkCollisions();
        
        
        if(cr){
           i+=5;
           x-=2; 
           cx = i;
           if(cx == 50){
               cr = false;
           }
        }else{
           i-=5;
           x+=2; 
           cx = i;
           if(cx == -700){
               cx =0;
               cr = true;
           }
        }
         
        
        repaint();      
    }
    
    public Rectangle getBounds(){
        return new Rectangle(700+i, 685+x, 100, 70);
    }
    public Rectangle getBoundsobjeto(){
        return new Rectangle(700, 500, 100, 70);
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mo = e.getPoint();
        if (getBounds().contains(mo)) {
            timer.stop();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(NewPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            timer.start();
        }
        
        System.out.println("Hola");
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
    
    public void checkCollisions(){
        Rectangle carro = this.getBounds();
        Rectangle objeto = this.getBoundsobjeto();
        
        if(carro.intersects(objeto)){
            
        }
    }
    
    
    
}
