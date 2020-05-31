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
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import static projetjava.DBRecherche.*;
/**
 *
 * @author paulc
 */
public class EdtAdmin 
{
     private Container contenu;
     private int goff;
     private int loff;
    private int droit=0;
    private int id=0;
    ArrayList<String>n;
    public EdtAdmin(Container c)
    {
        contenu=c;
        goff=1;loff=1;
        
    }
    public void draw()
    {
        
        final JComboBox<String> option=new JComboBox<>();
        final JComboBox<String> type=new JComboBox<>();
        final JComboBox<String> nom=new JComboBox<String>();
        final JButton affiche=new JButton("afficher");
        option.addItem("en grille");
        option.addItem("en liste");
        type.addItem("groupe");
        type.addItem("enseignant");
        Date actual=new Date();
        final int day=actual.getDate();
        final int month=actual.getMonth();
        final int year=actual.getYear()+2000-100;
        final Calendar c= Calendar.getInstance();
        c.set(year,month,day);
        contenu.add(option);
        contenu.add(type);
        final Semaine s=new Semaine(c.get(c.WEEK_OF_YEAR),contenu);
        s.draw(0,id,droit);loff=1;goff=0;
        option.setBounds(10, 145, 100, 30);
        type.setBounds(120,145,100,30);
        option.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(0==option.getSelectedIndex())
                {
                    if(loff==0)
                    {contenu.remove(5);
                    loff=1;goff=0;}
                    
                    s.draw(0,id,droit);
                    contenu.repaint();
                } 
                if(1==option.getSelectedIndex())
                {
                    if(goff==0)
                    {contenu.remove(5);
                    goff=1;loff=0;}
                    
                    s.draw(1,id,droit);
                    contenu.repaint();
                } 
            }
            
        }
        );
         type.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(0==type.getSelectedIndex())
                {
                    droit=0;
                    nom.removeAllItems();
                            n=new ArrayList<>();
                     n=getttnomgroupe();
                     
                     for(int i=0;i<n.size();i++)
                     {
                         nom.addItem(n.get(i));
                     }
                     contenu.add(nom);
                      contenu.add(affiche);
                      affiche.setBounds(340,145,100,30);
                     nom.setBounds(230,145,100,30);
                } 
                if(1==type.getSelectedIndex())
                {
                    droit=1;
                    nom.removeAllItems();
                    n=new ArrayList<>();
                    n=getttnomprof(droit);
                    for(int i=0;i<n.size();i++)
                     {
                         nom.addItem(n.get(i));
                     }
                    contenu.add(nom);
                    contenu.add(affiche);
                      affiche.setBounds(340,145,100,30);
                    nom.setBounds(230,145,100,30);
                } 
            }
            
        }
        );
         affiche.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(0==type.getSelectedIndex())
                {
                    contenu.remove(5);
                    goff=1;loff=0;
                    int i=nom.getSelectedIndex();
                    String name=n.get(i);
                    id=getidgroupe(name);
                    s.draw(0,id,droit);
                    contenu.repaint();
                } 
                if(1==type.getSelectedIndex())
                {
                    contenu.remove(5);
                    goff=1;loff=0;
                    int i=nom.getSelectedIndex();
                    String name=n.get(i);
                    id=getidprof(name);
                    s.draw(0,id,droit);
                    contenu.repaint();
                } 
            }
            
        }
        );
    }
}
