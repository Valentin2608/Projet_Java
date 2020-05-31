
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



public class MTouN 
{
    private Container contenu=new JFrame().getContentPane();
    JComboBox<String> varie=new JComboBox<>();
    JComboBox<String> type=new JComboBox<>();
    JTextField nouveau=new JTextField();
    ArrayList<String>n;
    public Container getcontenu()
    {
        return contenu;
    }
    public void paint()
    {
        final JLabel texte1=new JLabel("Modifier le");
        final JLabel texte2=new JLabel("de");
        final JLabel texte3=new JLabel("à");
        final JButton valider=new JButton("Valider");
        type.removeAllItems();
        type.addItem("nom du cours");
        type.addItem("nom du type de cours");
        contenu.add(texte1);
        contenu.add(type);
        contenu.add(texte2);
        contenu.add(texte3);
        texte1.setBounds(10, 0, 80, 25);
        type.setBounds(100, 0, 120, 25);
        texte2.setBounds(230, 0, 20, 25);
        type.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                contenu.removeAll();
                contenu.add(nouveau);
                contenu.add(texte1);
                contenu.add(type);
                contenu.add(texte2);
                contenu.add(texte3);
                if(0==type.getSelectedIndex())
                {
                    n=getnomcours();
                }
                if(1==type.getSelectedIndex())
                {
                    n=getnomtype();
                }
               
                varie.removeAllItems();
                for(int i=0;i<n.size();i++)
                {
                    varie.addItem(n.get(i));
                }
                contenu.add(varie);
                contenu.add(valider);
                varie.setBounds(260, 0, 120, 25);
                texte3.setBounds(390, 0, 15, 25);
                nouveau.setBounds(415, 0, 100, 25);
                valider.setBounds(525, 0, 100, 25);
                contenu.repaint();
            }});
        valider.addActionListener(new ActionListener ()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String nouvnom=nouveau.getText();
                Object i=varie.getSelectedItem();
                String n=i.toString();
                if(0==type.getSelectedIndex())
                {
                    updatnom(nouvnom,n,"cours");
                }
                if(1==type.getSelectedIndex())
                {
                    updatnom(nouvnom,n,"typecours");
                }
                JOptionPane.showMessageDialog(null, "La Mise à Jour a bien été efféctué");
                    
            }});
    }
}
