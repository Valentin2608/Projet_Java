
package projetjava;

import javax.swing.JFrame;


public class Projetjava {

    
    public static void main(String[] args) 
    {
        JFrame fenetre=new JFrame();
        
        
        fenetre.setTitle("HyperPlaning");
        fenetre.setSize(1900,1000);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
        PanelLog pan1=new PanelLog(fenetre.getContentPane());
        pan1.paintlog();
    }
    
}
