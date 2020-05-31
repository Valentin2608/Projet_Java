/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author paulc
 */
public class Creer 
{
    private Container contenu=new JFrame().getContentPane();
    JComboBox<String> groupes=new JComboBox<>();
    JComboBox<String> cours=new JComboBox<>();
    JComboBox<String> salles=new JComboBox<>();
    JTextField semaine=new JTextField();
    JComboBox<String> jours=new JComboBox<>();
    JComboBox<String> heure=new JComboBox<>();
    ArrayList<String>n;
    public Creer()
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
        final JLabel groupe=new JLabel("Groupe:");
        final JLabel salle=new JLabel("Salle:");
        final JButton valider=new JButton("Valider");
        n=getttnomgroupe();
        for(int i=0;i<n.size();i++)
        {
            groupes.addItem(n.get(i));
        }
        n=getnomcours();
        for(int i=0;i<n.size();i++)
        {
            cours.addItem(n.get(i));
        }
        n=getttnomsalle();
        for(int i=0;i<n.size();i++)
        {
            salles.addItem(n.get(i));
        }
        contenu.add(groupes);
         contenu.add(cours);
         contenu.add(salles);
        contenu.add(semaine);
        contenu.add(jours);
        contenu.add(heure);
        contenu.add(valider);
        contenu.add(se);
        contenu.add(jour);
        contenu.add(heur);
        contenu.add(cour);
        contenu.add(groupe);
        contenu.add(salle);
        se.setBounds(10, 0, 100, 25);
        semaine.setBounds(70, 0, 100, 25);
        jour.setBounds(180, 0, 100, 25);
        jours.setBounds(220, 0, 100, 25);
        heur.setBounds(350, 0, 100, 25);
        heure.setBounds(450, 0, 100, 25);
        cour.setBounds(560, 0, 100, 25);
        cours.setBounds(600, 0, 100, 25);
        groupe.setBounds(710, 0, 70, 25);
        groupes.setBounds(790, 0, 100, 25);
        salle.setBounds(900, 0, 70, 25);
        salles.setBounds(980, 0, 100, 25);
        valider.setBounds(1090, 0, 100, 25);
        valider.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String s=semaine.getText();
                int week=Integer.parseInt(s);
                Object i=groupes.getSelectedItem();
                String g=i.toString();
                i=cours.getSelectedItem();
                String c=i.toString();
                i=salles.getSelectedItem();
                s=i.toString();
                i=jours.getSelectedItem();
                String j=i.toString();
                i=heure.getSelectedItem();
                String h=i.toString();
                int k=verifenewsalle(week,j,h,s);
                if(k==0)
                {
                    String nom=getprof2(c);
                    k=verifenewprof(week,j,h,nom);
                    if(k==0)
                    {
                        k=verifenewgroupe(week,j,h,g);
                        if(k==0)
                        {
                            k=verifpromo(g,c);
                            if(k==0)
                            {
                                String h2=HFin(h);
                                insertseance(week,c, g,s, h, h2, j);
                                JOptionPane.showMessageDialog(null, "La Mise à Jour a bien été efféctué");
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Ce groupe n'est pas inscrit pour ce cours");
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Ce groupe a deja une séance a ce moment la");
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Le proffesseur a deja une séance a ce moment la");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "La salle est deja occupé a ce moment la");
                }
                    
            }});
    }
    public String HFin(String hdebut)
    {
        String hfin="";
        if(hdebut.equalsIgnoreCase("08:30:00"))
        {
            hfin="10:00:00";
        }
        if(hdebut.equalsIgnoreCase("10:15:00"))
        {
            hfin="11:45:00";
        }
        if(hdebut.equalsIgnoreCase("12:00:00"))
        {
            hfin="13:30:00";
        }
        if(hdebut.equalsIgnoreCase("13:45:00"))
        {
            hfin="15:15:00";
        }
        if(hdebut.equalsIgnoreCase("15:30:00"))
        {
            hfin="17:00:00";
        }
        return hfin;
    }
}
