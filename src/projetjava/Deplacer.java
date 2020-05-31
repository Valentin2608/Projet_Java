
package projetjava;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static projetjava.DBAction.*;


public class Deplacer 
{
     private Container contenu;
    JComboBox<String> varie=new JComboBox<>();
    JTextField semaine=new JTextField();
    JComboBox<String> jours=new JComboBox<>();
    JComboBox<String> heure=new JComboBox<>();
    JTextField semaine2=new JTextField();
    JComboBox<String> jours2=new JComboBox<>();
    JComboBox<String> heure2=new JComboBox<>();
    ArrayList<String>n;
    public Deplacer(Container c)
    {
        contenu=c;
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
        jours2.addItem("lun");
        jours2.addItem("mar");
        jours2.addItem("mer");
        jours2.addItem("jed");
        jours2.addItem("ven");
        heure2.addItem("08:30:00");
        heure2.addItem("10:15:00");
        heure2.addItem("12:00:00");
        heure2.addItem("13:45:00");
        heure2.addItem("15:30:00");
    }
    public void paint()
    {
        final JLabel se=new JLabel("Semaine:");
        final JLabel se2=new JLabel("Semaine:");
        final JLabel texte1=new JLabel("Deplacer:");
        final JLabel texte2=new JLabel("Vers:");
        final JLabel jour=new JLabel("jour:");
        final JLabel heur=new JLabel("heure de debut:");
        final JLabel jour2=new JLabel("jour:");
        final JLabel heur2=new JLabel("heure de debut:");
        final JLabel cour=new JLabel("Cours:");
        final JButton valider=new JButton("Valider");
        n=getnomcours();
                for(int i=0;i<n.size();i++)
                {
                    varie.addItem(n.get(i));
                }
                
                contenu.add(varie);
                contenu.add(semaine);
                contenu.add(jours);
                contenu.add(heure);
                contenu.add(semaine2);
                contenu.add(jours2);
                contenu.add(heure2);
                contenu.add(valider);
                contenu.add(texte1);
                contenu.add(se);
                contenu.add(jour);
                contenu.add(heur);
                contenu.add(se2);
                contenu.add(jour2);
                contenu.add(heur2);
                contenu.add(cour);
                texte1.setBounds(10, 50, 100, 25);
                texte2.setBounds(10, 80, 100, 25);
                se.setBounds(120, 50, 100, 25);
                se2.setBounds(120, 80, 100, 25);
                semaine.setBounds(180, 50, 100, 25);
                semaine2.setBounds(180, 80, 100, 25);
                jour.setBounds(340, 50, 100, 25);
                jours.setBounds(380, 50, 100, 25);
                jour2.setBounds(340, 80, 100, 25);
                jours2.setBounds(380, 80, 100, 25);
                heur.setBounds(560, 50, 100, 25);
                heure.setBounds(670, 50, 100, 25);
                heur2.setBounds(560, 80, 100, 25);
                heure2.setBounds(670, 80, 100, 25);
                cour.setBounds(780, 50, 100, 25);
                varie.setBounds(850, 50, 100, 25);
                valider.setBounds(1000, 80, 100, 25);
                valider.addActionListener(new ActionListener ()
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
                    int id=getexistance(week,j,h,v);
                    if(id!=0)
                    {
                        s=semaine2.getText();
                        week=Integer.parseInt(s);
                        i=jours2.getSelectedItem();
                        j=i.toString();
                        i=heure2.getSelectedItem();
                        h=i.toString();
                        int k=verifegroupe(id,week,j,h);
                        if(k==0)
                        {
                            k=verifeprof(id,week,j,h);
                            if(k==0)
                            {
                                k=verifesalle(id,week,j,h);
                                if(k==0)
                                {
                                    updatedate(id,week,j,h);
                                    JOptionPane.showMessageDialog(null, "La Mise à Jour a bien été efféctué");
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "La salle est deja occupé a ce moment la");
                                }
                                
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Le proffesseur a deja une séance a ce moment la");
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Ce groupe a deja une séance a ce moment la");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "la séance n'éxiste pas");
                    }
                
            }});
    }
}
