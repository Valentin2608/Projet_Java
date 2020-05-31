
package projetjava;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import static projetjava.DBRecherche.*;



public class RecapAdmin 
{
    private Container contenu;
     private int droit=0;
    private int id=0;
    private int d=0;
    ArrayList<String>n;
    public RecapAdmin(Container c)
    {
        contenu=c;
        
        
    }
     public void draw()
    {
        final JComboBox<String> type=new JComboBox<>();
        final JComboBox<String> nom=new JComboBox<String>();
        final JButton affiche=new JButton("afficher");
        
        type.addItem("groupe");
        type.addItem("enseignant");
         contenu.add(type);
         
         type.setBounds(10,145,100,30);
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
                      affiche.setBounds(230,145,100,30);
                     nom.setBounds(120,145,100,30);
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
                      affiche.setBounds(230,145,100,30);
                    nom.setBounds(120,145,100,30);
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
                    if(d==1)
                        contenu.remove(5);
                    
                    int i=nom.getSelectedIndex();
                    String name=n.get(i);
                    id=getidgroupe(name);
                    Recap r = new Recap(id,droit);
                   contenu.add(r,5);d=1;
                   r.setBounds(10,180,1800,760);
                    contenu.repaint();
                } 
                if(1==type.getSelectedIndex())
                {
                    if(d==1)
                        contenu.remove(5);
                    
                    int i=nom.getSelectedIndex();
                    String name=n.get(i);
                    id=getidprof(name);
                   Recapprof r = new Recapprof(id,droit);
                   contenu.add(r,5);d=1;
                   r.setBounds(10,180,1800,760);
                    contenu.repaint();
                } 
            }
            
        }
        );
    }
}
