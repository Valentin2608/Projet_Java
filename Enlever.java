
package projetjava;

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
import static projetjava.DBRecherche.*;

public class Enlever
{
    private Container contenu=new JFrame().getContentPane();;
    JComboBox<String> type=new JComboBox<>();
    JComboBox<String> element=new JComboBox<>();
    JComboBox<String> varie=new JComboBox<>();
    JTextField semaine=new JTextField();
    JComboBox<String> jours=new JComboBox<>();
    JComboBox<String> heure=new JComboBox<>();
    ArrayList<String>n;
    ArrayList<String>n2;
    int id;
    public Enlever()
    {
        
        jours.addItem("lun");
        jours.addItem("mar");
        jours.addItem("mer");
        jours.addItem("jed");
        jours.addItem("ven");
        heure.addItem("08:30:00");
        heure.addItem("10:15:00");
        heure.addItem("12:00:00");
        heure.addItem("13:45:00");
        heure.addItem("15:30:00");
    }
    public Container getcontenu()
    {
        return contenu;
    }
    public void paint()
    {
        final JLabel se=new JLabel("Semaine:");
        final JLabel jour=new JLabel("jour:");
        final JLabel heur=new JLabel("heure de debut:");
        final JLabel cour=new JLabel("Cours:");
        final JButton recherche=new JButton("Rechercher");
        final JButton valider=new JButton("Valider");
        type.removeAllItems();
        type.addItem("goupe");
        type.addItem("proffesseur");
        type.addItem("salle");
        n=getnomcours();
        for(int i=0;i<n.size();i++)
        {
            varie.addItem(n.get(i));
        }
        
        contenu.add(varie);
        contenu.add(semaine);
        contenu.add(jours);
        contenu.add(heure);
        contenu.add(recherche);
        contenu.add(se);
        contenu.add(jour);
        contenu.add(heur);
        contenu.add(cour);
        se.setBounds(10, 0, 100, 25);
        semaine.setBounds(70, 0, 100, 25);
        jour.setBounds(180, 0, 100, 25);
        jours.setBounds(220, 0, 100, 25);
        heur.setBounds(350, 0, 100, 25);
        heure.setBounds(450, 0, 100, 25);
        cour.setBounds(560, 0, 100, 25);
        varie.setBounds(600, 0, 100, 25);
        recherche.setBounds(710, 0, 150, 25);
        recherche.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String s=semaine.getText();
                int week=Integer.parseInt(s);
                Object i=jours.getSelectedItem();
                String j=i.toString();
                i=heure.getSelectedItem();
                String h=i.toString();
                i=varie.getSelectedItem();
                String v=i.toString();
                id=getexistance(week,j,h,v);
                if(id!=0)
                {
                    contenu.removeAll();
                    
                    contenu.add(varie);
                    contenu.add(semaine);
                    contenu.add(jours);
                    contenu.add(heure);
                    contenu.add(recherche);
                    contenu.add(se);
                    contenu.add(jour);
                    contenu.add(heur);
                    contenu.add(cour);  
                    
                    contenu.add(type);
                    type.setBounds(10, 35, 100, 25);
                    //contenu.repaint();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "la séance n'éxiste pas");
                }
                
            }});
        type.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                
                contenu.add(varie);
                contenu.add(semaine);
                contenu.add(jours);
                contenu.add(heure);
                contenu.add(recherche);
                contenu.add(se);
                contenu.add(jour);
                contenu.add(heur);
                contenu.add(cour);
                contenu.add(type);
                if(0==type.getSelectedIndex())
                {
                    n2=getnomgroupe(id);
                }
                if(1==type.getSelectedIndex())
                {
                    n2=getnomprof(id);
                }
                if(2==type.getSelectedIndex())
                {
                    n2=getnomsalle2(id);
                }
                element.removeAllItems();
                for(int i=0;i<n2.size();i++)
                {
                    element.addItem(n2.get(i));
                }
                contenu.add(element);
                contenu.add(valider);
                element.setBounds(120, 35, 100, 25);
                valider.setBounds(230, 35, 100, 25);
                contenu.repaint();
            }});
        valider.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               int k;String nom;
                if(0==type.getSelectedIndex())
                {
                    k=blindagenb(id,"seanceg");
                    if(k==2)
                    {
                        Object i=element.getSelectedItem();
                        nom=i.toString();
                        supprimergroupe(id,nom);
                        JOptionPane.showMessageDialog(null, "La Mise à Jour a bien été efféctué");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Vous ne pouvez pas retirer tous les groupes de la séance");
                    }
                }
                if(1==type.getSelectedIndex())
                {
                    k=blindagenb(id,"seancee");
                    if(k==2)
                    {
                        Object i=element.getSelectedItem();
                        nom=i.toString();
                        supprimerprof(id,nom);
                        JOptionPane.showMessageDialog(null, "La Mise à Jour a bien été efféctué");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Vous ne pouvez pas retirer tous les professeurs de la séance");
                    }
                }
                if(2==type.getSelectedIndex())
                {
                    k=blindagenb(id,"seances");
                    if(k==2)
                    {
                        Object i=element.getSelectedItem();
                        nom=i.toString();
                        supprimersalle(id,nom);
                        JOptionPane.showMessageDialog(null, "La Mise à Jour a bien été efféctué");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Vous ne pouvez pas retirer toutes les salles de la séance");
                    }
                }
                
            }});
    }
}
