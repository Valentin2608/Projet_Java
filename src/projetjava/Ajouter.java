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
public class Ajouter 
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
    public Ajouter()
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
        final JButton valider=new JButton("Valider");
        type.removeAllItems();
        varie.removeAllItems();
        type.addItem("goupe");
        type.addItem("proffesseur");
        type.addItem("salle");
        n=getnomcours();
        for(int i=0;i<n.size();i++)
        {
            varie.addItem(n.get(i));
        }
        contenu.add(type);
        contenu.add(varie);
        contenu.add(semaine);
        contenu.add(jours);
        contenu.add(heure);
        
        contenu.add(se);
        contenu.add(jour);
        contenu.add(heur);
        contenu.add(cour);
        type.setBounds(10, 0, 100, 25);
        se.setBounds(120, 0, 100, 25);
        semaine.setBounds(180, 0, 100, 25);
        jour.setBounds(340, 0, 100, 25);
        jours.setBounds(380, 0, 100, 25);
        heur.setBounds(560, 0, 100, 25);
        heure.setBounds(670, 0, 100, 25);
        cour.setBounds(780, 0, 100, 25);
        varie.setBounds(850, 0, 100, 25);
        valider.setBounds(1220, 0, 100, 25);
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
                        if(0==type.getSelectedIndex())
                        {
                            i=element.getSelectedItem();
                            String nom=i.toString();
                            int k=verifeexistancegroupe(id,nom);
                            if(k==0)
                            {
                                k=blindagenb(id,"seanceg");
                                if(k<2)
                                {
                                    k=verifenewgroupe(week,j,h,nom);
                                    if(k==0)
                                    {
                                        insertgroupe(id,nom);
                                        JOptionPane.showMessageDialog(null, "La Mise à Jour a bien été efféctué");
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null, "Ce groupe a deja une séance a ce moment la");
                                    }
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Le nombre de groupe est deja au maximum");
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Le groupe est deja affecter a cette séance");
                            }
                        }
                        if(1==type.getSelectedIndex())
                        {
                            i=element.getSelectedItem();
                            String nom=i.toString();
                            int k=verifeexistanceprof(id,nom);
                            if(k==0)
                            {
                                k=blindagenb(id,"seancee");
                                if(k<2)
                                {
                                    k=verifenewprof(week,j,h,nom);
                                    if(k==0)
                                    {
                                        insertprof(id,nom);
                                        JOptionPane.showMessageDialog(null, "La Mise à Jour a bien été efféctué");
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null, "Le proffesseur a deja une séance a ce moment la");
                                    }
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Le nombre d'enseignant est deja au maximum");
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Le proffesseur est deja affecter a cette séance");
                            }
                        }
                        if(2==type.getSelectedIndex())
                        {
                            i=element.getSelectedItem();
                            String nom=i.toString();
                            int k=verifeexistancesalle(id,nom);
                            if(k==0)
                            {
                                k=blindagenb(id,"seances");
                                if(k<2)
                                {
                                    k=verifenewsalle(week,j,h,nom);
                                    if(k==0)
                                    {
                                        insertsalle(id,nom);
                                        JOptionPane.showMessageDialog(null, "La Mise à Jour a bien été efféctué");
                                    }
                                    else 
                                    {
                                        JOptionPane.showMessageDialog(null, "La salle est deja occupé a ce moment la");
                                    }
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(null, "Le nombre de salle est deja au maximum");
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "La salle est deja affecter a cette séance");
                            }
                        }
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
                contenu.add(type);
                    contenu.add(varie);
                    contenu.add(semaine);
                    contenu.add(jours);
                    contenu.add(heure);
                    contenu.add(valider);
                    contenu.add(se);
                    contenu.add(jour);
                    contenu.add(heur);
                    contenu.add(cour);
                    element.removeAllItems();
                    JLabel genre = null;
                    if(0==type.getSelectedIndex())
                    {
                        genre=new JLabel("Groupe:");
                        n2=getttnomgroupe();
                    }
                    if(1==type.getSelectedIndex())
                    {
                        genre=new JLabel("Proffesseur:");
                        n2=getttnomprof(1);
                    }
                    if(2==type.getSelectedIndex())
                    {
                        genre=new JLabel("Salle:");
                        n2=getttnomsalle();
                    }
                    for(int i=0;i<n2.size();i++)
                    {
                        element.addItem(n2.get(i));
                    }
                    contenu.add(genre);
                    contenu.add(element);
                    genre.setBounds(1000, 0, 100, 25);
                    element.setBounds(1110, 0, 100, 25);
                    contenu.repaint();
                
            }});
    }
}
