
package projetjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Enumeration;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class Semaine
{
    private Container contenu;
    private int ids;
    private int colo;
    public Semaine(int id,Container c)
    {
        contenu=c;
        ids=id;
    }
    @SuppressWarnings("empty-statement")
    public void draw(final int type,final int id,final int droit)
    {
        String[] s=new String[53];
        String[] s2={"aout   ","   sept   ","   oct   ","   nov   ","   dec   ","   janv   ","   fevr   ","   mars   ","   avr   ","   mai   ","   juin   ","   juil   "};
        int i=0;
        colo =0;
        for(int j=31;j<53;j++)
        {
            
            s[i]=""+j;
            if(j==ids)
                colo=i;
            i=i+1;
            
            
        }
        for(int j=1;j<32;j++)
        {
            
            s[i]=""+j;
            if(j==ids)
                colo=i;
            i=i+1;
            
        }
        
        Object [][] data={{"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""}};
        Object [][] data2={{"","","","","","","","","","","",""}}; 
        final JTable t=new JTable(data,s){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        ;
        final JTable t2=new JTable(){
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        ;
        DefaultTableModel t2Model = new DefaultTableModel(data2, s2);
        t2.setModel(t2Model);
        int col = 0, droiteMax = 0, larg = 0, largTotal = 0,
                row = 0, tableX = 0, width = 0;
        JTableHeader header = t.getTableHeader();
        Enumeration columns = t.getColumnModel().getColumns();
        
        t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        while(columns.hasMoreElements()){                            // longueur maximum du texte ou du titre d'une colonne
            TableColumn column = (TableColumn)columns.nextElement();
            col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            width = (int)t.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(t, column.getIdentifier()
                            , false, false, -1, col).getPreferredSize().getWidth();
            for(row = 0; row<t.getRowCount(); row++){
                int preferedWidth =
                        (int)t.getCellRenderer(row, col).getTableCellRendererComponent(t,
                                t.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column);                       // this line is very important
            larg = width+t.getIntercellSpacing().width;
            //   larg = (larg*13)/10;                            // largeur de la colonne plus un peu pour desserrer
            larg = larg+19;           // mais c'est mieux un ajout fixe, pas en %,
            // par ex. un blanc devant et derrière chaque donnée avant de l'écrire
            largTotal += larg;                                  // largeur totale de la table si utile
            column.setWidth(larg);
        }
         
        t2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn c=t2.getColumnModel().getColumn(0);
        c.setPreferredWidth(163);
        
        c=t2.getColumnModel().getColumn(1);
        c.setPreferredWidth(150);
        c=t2.getColumnModel().getColumn(2);
        c.setPreferredWidth(165);
        c=t2.getColumnModel().getColumn(3);
        c.setPreferredWidth(153);
        c=t2.getColumnModel().getColumn(4);
        c.setPreferredWidth(155);
        c=t2.getColumnModel().getColumn(5);
        c.setPreferredWidth(126);
        c=t2.getColumnModel().getColumn(6);
        c.setPreferredWidth(124);
        c=t2.getColumnModel().getColumn(7);
        c.setPreferredWidth(154);
        c=t2.getColumnModel().getColumn(8);
        c.setPreferredWidth(159);
        c=t2.getColumnModel().getColumn(9);
        c.setPreferredWidth(155);
        c=t2.getColumnModel().getColumn(10);
        c.setPreferredWidth(155);
        c=t2.getColumnModel().getColumn(11);
        c.setPreferredWidth(155);
        
        
        t.getTableHeader().setDefaultRenderer(new DefaultTableCellHeaderRenderer(){
            
            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if( (column) == colo)
                    c.setBackground(Color.GREEN);
                
                return c;
            }
            
        });
        
       t.getTableHeader().setReorderingAllowed(false);
        t2.getTableHeader().setReorderingAllowed(false);
        JScrollPane jscrollPane = new javax.swing.JScrollPane();
        jscrollPane.setViewportView(t2);
        
        t2.getTableHeader().setBackground(Color.white);
        contenu.add(t.getTableHeader());
        contenu.add(t);
        contenu.add(jscrollPane);
        contenu.add(t2.getTableHeader());
        if(type==0)
        {
            Grille p=new Grille(ids,id,droit);
            contenu.add(p, 5);
            p.setBounds(54,270,1793,621);
        }
        if(type==1)
        {
            Liste l=new Liste(ids,id,droit);
            
            contenu.add(l, 5);
            l.setBounds(54,270,1793,641);
        }
        t.getTableHeader().setBounds(11, 190, 1845, 20);
        t2.getTableHeader().setBounds(28, 225, 1813, 20);
        t.setBounds(11, 210, 1845, 15);
        
        t.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if(evt.getClickCount()==2)
                {
                    int col = t.columnAtPoint(evt.getPoint());
                    if(col>21)
                    {
                        col=col-21;
                    }
                    else
                    {
                        col=col+31;
                    }
                    ids=col;
                    contenu.remove(5);
                    draw(type,id,droit);
                    
                }
                
            }
        });
    }
}
