/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import javax.swing.JFrame;
import java.awt.*;

/**
 *
 * @author Estudiante
 */
public class escenario extends JFrame {
    public escenario(){
        add(new character());
        setResizable(false);
        pack();
    }
    public static void main( String[] args){
        
        escenario frame = new escenario();
        frame.setTitle("TestPaintComponent");
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
