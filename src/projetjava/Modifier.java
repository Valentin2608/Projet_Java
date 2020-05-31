
package projetjava;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static projetjava.DBAction.*;

public class Modifier 
{
    private Container contenu=new JFrame().getContentPane();
    int action=0;
    
    ArrayList<String>n;
    public Modifier()
    {
        
    }
    public Container getcontenu()
    {
        return contenu;
    }
    public void paint()
    {
        
        final JButton creer=new JButton("Créer une séance");
        final JButton AouV=new JButton("Anulé ou Validé une séance");
        final JButton ajouter=new JButton("Ajouter à une séance");
        final JButton enlever=new JButton("Enlever d'une séance");
        final JButton deplacer=new JButton("Déplacer une séance ");
        final JButton modifier=new JButton("Modifier un cours");
        contenu.add(creer);
        contenu.add(AouV);
        contenu.add(ajouter);
        contenu.add(enlever);
        contenu.add(deplacer);
        contenu.add(modifier);
        creer.setBounds(0, 0, 200, 25);
        AouV.setBounds(210, 0, 200, 25);
        ajouter.setBounds(420, 0, 200, 25);
        enlever.setBounds(630, 0, 200, 25);
        deplacer.setBounds(840, 0, 300, 25);
        modifier.setBounds(1150, 0, 200, 25);
        contenu.setBackground(new Color(240,240,240));
         AouV.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                contenu.add(creer);
                contenu.add(AouV);
                contenu.add(ajouter);
                contenu.add(enlever);
                contenu.add(deplacer);
                contenu.add(modifier);
                AouV a=new AouV(contenu);
                a.paint();
                contenu.repaint();
            }});
         deplacer.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                contenu.add(creer);
                contenu.add(AouV);
                contenu.add(ajouter);
                contenu.add(enlever);
                contenu.add(deplacer);
                contenu.add(modifier);
                Deplacer a=new Deplacer(contenu);
                a.paint();
                contenu.repaint();
            }});
         ajouter.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                contenu.add(creer);
                contenu.add(AouV);
                contenu.add(ajouter);
                contenu.add(enlever);
                contenu.add(deplacer);
                contenu.add(modifier);
                Ajouter a=new Ajouter();
                a.paint();
                Container c1=a.getcontenu();
                contenu.add(c1);
                c1.setBounds(10, 50, 1500, 50);
                contenu.repaint();
            }});
         enlever.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                contenu.add(creer);
                contenu.add(AouV);
                contenu.add(ajouter);
                contenu.add(enlever);
                contenu.add(deplacer);
                contenu.add(modifier);
                Enlever a=new Enlever();
                a.paint();
                Container c1=a.getcontenu();
                contenu.add(c1);
                c1.setBounds(10, 50, 1500, 70);
                contenu.repaint();
            }});
         modifier.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                contenu.add(creer);
                contenu.add(AouV);
                contenu.add(ajouter);
                contenu.add(enlever);
                contenu.add(deplacer);
                contenu.add(modifier);
                MTouN a=new MTouN();
                a.paint();
                Container c1=a.getcontenu();
                contenu.add(c1);
                c1.setBounds(10, 50, 1500, 70);
                contenu.repaint();
            }});
         creer.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                contenu.add(creer);
                contenu.add(AouV);
                contenu.add(ajouter);
                contenu.add(enlever);
                contenu.add(deplacer);
                contenu.add(modifier);
                Creer a=new Creer();
                a.paint();
                Container c1=a.getcontenu();
                contenu.add(c1);
                c1.setBounds(10, 50, 1500, 70);
                contenu.repaint();
            }});
         
    }
}
