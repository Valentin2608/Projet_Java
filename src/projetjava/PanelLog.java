
package projetjava;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static projetjava.DBRecherche.*;

public class PanelLog 
{
    private Container contenu;
   
   public PanelLog(Container c)
   {
       contenu=c;
       contenu.setLayout(null);
   }
    public Container getcontenu()
    {
         return contenu;
    }
   
    
    public void paintlog()
    {
        Color a=new Color(117,20,65); //declarer les couleurs que on va utiliser 
        Color b=new Color(255,255,255); 
        JLabel log=new JLabel("Email:");//texte
         JLabel pass=new JLabel("Mot de Passe:");//texte 
        JButton logb=new JButton("Se connecter");//boutton 
        final JPasswordField textpass=new JPasswordField();//zone de texte MdP
        final JTextField textlog=new JTextField();//zone de texte email 
        textpass.setEchoChar('*');
        JLabel img = new JLabel(new ImageIcon("logo.jpg"));
        Font font1=new Font(Font.SERIF,Font.BOLD,25);
        textlog.setFont(font1);//modifier la police
        textpass.setFont(font1);
        Font font=new Font(Font.SERIF,Font.BOLD,45);
        log.setFont(font);//modifier la police
        pass.setFont(font);
        log.setForeground(b);//modifier la couleur 
        pass.setForeground(b);
        contenu.add(log);
        contenu.add(pass);
        contenu.add(logb);
        contenu.add(textlog);
        contenu.add(textpass);
        contenu.add(img);
        textlog.setBounds(950, 360, 300, 50);
        textpass.setBounds(950, 460, 300, 50);
        logb.setBounds(825, 570, 250, 60);
        log.setBounds(670, 360, 200, 60);
        pass.setBounds(670, 460, 300, 60);
        img.setBounds(875, 0, 150, 150);
        contenu.setBackground(a);
        logb.addActionListener(new ActionListener ()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String login=textlog.getText();
                String password=textpass.getText();
                 int id=Researchlog(login,password);
                 if(id!=0)
                 {
                    int droit=getdroit(id);
                    if(droit==0)
                    {
                        contenu.removeAll();
                        Etudiant E=new Etudiant(contenu,id);
                        E.paint(droit);
                        contenu=E.getcontenu();
                        contenu.repaint();
                    }
                    if(droit==1)
                    {
                        contenu.removeAll();
                        Enseignant E=new Enseignant(contenu,id);
                        E.paint(droit);
                        contenu=E.getcontenu();
                        contenu.repaint();
                    }
                    if(droit==2)
                    {
                        contenu.removeAll();
                        Admin E=new Admin(contenu);
                        E.paint(droit);
                        contenu=E.getcontenu();
                        contenu.repaint();
                    }
                   
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null, "mot de passe ou email incorrect ");
                 }
            }
            
        }
        );
        
        
        
   
  }
}
