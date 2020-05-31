
package projetjava;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import static projetjava.DBRecherche.getstring;


public class Admin
{
     private Container contenu;
   
    public Admin(Container c)
    {
        contenu=c;
        
    }
    public Container getcontenu()
    {
         return contenu;
    }
    public void paint(final int droit)
    {
        final JLabel entete = new JLabel(new ImageIcon("Entete.png"));
        final JLabel entete2 = new JLabel(new ImageIcon("Entete2.png"));
        final JLabel perso = new JLabel(new ImageIcon("perso.png"));
        final JButton edt=new JButton("Emploi du temps");
        final JButton recap=new JButton("Recapitulatif des cours");
        final JButton modifier=new JButton("Modifier les cours");
        final JLabel Nom=new JLabel("Administration");
        Nom.setForeground(Color.white);
        Font font1=new Font(Font.SERIF,Font.BOLD,25);
        Nom.setFont(font1);
        /*Edt e=new Edt(contenu,id);
        e.draw(droit);*/
        contenu.add(edt);
        contenu.add(recap);
        contenu.add(modifier);
        contenu.add(perso);
        contenu.add(Nom);
        contenu.add(entete);
        contenu.add(entete2);
        Nom.setBounds(70,10,200,50);
        entete.setBounds(0, 0, 1900, 80);
        entete2.setBounds(0, 80, 1900, 55);
        edt.setBounds(10, 90, 200, 25);
        recap.setBounds(220, 90, 200, 25);
        modifier.setBounds(430, 90, 200, 25);
        perso.setBounds(10, 10, 50, 50);
        contenu.setBackground(new Color(240,240,240));
        edt.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                EdtAdmin e1=new EdtAdmin(contenu);
                e1.draw();
                contenu.add(edt);
                contenu.add(recap);
                contenu.add(perso);
                contenu.add(Nom);
                contenu.add(modifier);
                contenu.add(entete);
                contenu.add(entete2);
                contenu.repaint();
            }
            
        }
        );
        recap.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                RecapAdmin r=new RecapAdmin(contenu);
                r.draw();
                //r.setBounds(10,140,1800,760);
                contenu.add(edt);
                contenu.add(recap);
                contenu.add(perso);
                contenu.add(modifier);
                contenu.add(Nom);
                contenu.add(entete);
                contenu.add(entete2);
                contenu.repaint();
            }
            
        }
        );
        modifier.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                Modifier r=new Modifier();
                r.paint();
                Container c1=r.getcontenu();
                contenu.add(c1);
                c1.setBounds(10, 150, 1350, 150);
                contenu.add(edt);
                contenu.add(recap);
                contenu.add(modifier);
                contenu.add(perso);
                contenu.add(Nom);
                contenu.add(entete);
                contenu.add(entete2);
                contenu.repaint();
            }
            
        }
        );
    }
}
