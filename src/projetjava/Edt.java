
package projetjava;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;


public class Edt 
{
     private Container contenu;
     private int goff;
     private int loff;
    private int id;
    public Edt(Container c,int i)
    {
        contenu=c;
        goff=1;loff=1;
        id=i;
    }
    public void draw(final int droit)
    {
        final JComboBox<String> option=new JComboBox<>();
        option.addItem("en grille");
        option.addItem("en liste");
        Date actual=new Date();
        final int day=actual.getDate();
        final int month=actual.getMonth();
        final int year=actual.getYear()+2000-100;
        final Calendar c= Calendar.getInstance();
        c.set(year,month,day);
        
        contenu.add(option);
        final Container co=contenu.getParent();
        final Semaine s=new Semaine(c.get(c.WEEK_OF_YEAR),contenu);
        s.draw(0,id,droit);loff=1;goff=0;
        option.setBounds(10, 145, 100, 30);
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
    }
}
