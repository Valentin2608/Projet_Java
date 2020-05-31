/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static projetjava.DBRecherche.*;


/**
 *
 * @author paulc
 */
public class Liste extends JPanel
{
    private int ids;
    private int ide;
    private int droit;
    public Liste(int id,int i,int d)
    {
        super();
        ids=id;
        ide=i;
        droit=d;
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // cast Graphics to Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        Color a=new Color(240,240,240);
        g2.setColor(a);
        g2.fillRect(0,0,1800,1000);
        int[]n={-1};
        if(droit==0)
        {
            n=getsceance(ide,ids);
        }
        if(droit==1)
        {
            n=getsceanceprof(ide,ids);
        }
        ArrayList<String> done=new ArrayList<>();
        int type;
        String heur;
        int []nb;
        int d=0;
        String jour,mois = null;
        ArrayList<String>profl,sallel,groupel;
        String prof,salle,groupe,cours;
        int x = 0,y = 0,day;
        if(n[0]!=-1)
        {
            n=trilistejour(n);
            for(int i=0; i<n.length;i++)
            {
                jour=getjour(n[i]);
                d=0;
                for(int z=0;z<done.size();z++)
                {
                    String temp=done.get(z);
                    if(jour.equals(temp))
                    {
                        d=1;
                    }
                    
                }
                if(d==0)
                {
                    nb=getnbcour(n,jour);
                    nb=trilisteheure(nb);
                    a=new Color(128,255,128);
                    g2.setColor(a);
                    g2.fillRect(x+2,y+2,800,40);
                    day=jour(0);
                    if("lun".equals(jour))
                    {
                        jour="lundi";
                        day=jour(0);
                        mois=mois(day,0);
                        done.add("lun");
                    }
                    if("mar".equals(jour))
                    {
                        jour="mardi";
                        day=jour(1);
                        mois=mois(day,1);
                        done.add("mar");
                    }
                    if("mer".equals(jour))
                    {
                        jour="mercredi";
                        day=jour(2);
                        mois=mois(day,2);
                        done.add("mer");
                    }
                    if("jed".equals(jour))
                    {
                        jour="jeudi";
                        day=jour(3);
                        mois=mois(day,3);
                        done.add("jed");
                    }
                    if("ven".equals(jour))
                    {
                        jour="vendredi";
                        day=jour(4);
                        mois=mois(day,4);
                        done.add("ven");
                    }
                    if("sam".equals(jour))
                    {
                        jour="samedi";
                        day=jour(5);
                        mois=mois(day,5);
                        done.add("sam");
                    }
                    jour+=" "+day+" "+mois+" 2020";
                    a=new Color(100,100,100);
                    g2.setColor(a);
                    g2.drawString(jour,x+15,y+25);
                    a=new Color(225,225,225);
                    g2.setColor(a);
                    g2.fillRect(x+2,y+42,800,50*nb.length);
                    
                    for(int j=0; j<nb.length;j++)
                    {
                        
                        a=definec(nb[j],droit);
                        
                        g2.setColor(a);
                        g2.fillRect(x+17,y+57+50*j,15,20);
                        a=new Color(100,100,100);
                        g2.setColor(a);
                        heur=getheur(nb[j],"HDebut")+"-"+getheur(nb[j],"HFin");
                        cours=getnomcour(nb[j]);
                        profl=getnomprof(nb[j]);
                        prof="";
                        for(int k=0;k<profl.size();k++)
                        {
                            prof+=profl.get(k)+"-";
                        }
                        sallel=getnomsalle(nb[j]);
                        salle="";
                        for(int k=0;k<sallel.size();k++)
                        {
                            salle+=sallel.get(k)+"-";
                        }
                        groupe="";
                        groupel=getnomgroupe(nb[j]);
                        for(int k=0;k<groupel.size();k++)
                        {
                            groupe+=groupel.get(k)+"-";
                        }
                        g2.drawString(heur,x+100,y+72+50*j);
                        g2.drawString(cours,x+250,y+72+50*j);
                        g2.drawString(prof,x+700,y+72+50*j);
                        g2.drawString(groupe,x+380,y+72+50*j);
                        g2.drawString(salle,x+500,y+72+50*j);
                        g2.drawLine(x+2, y+92+50*j, x+800, y+92+50*j);
                    }
                    if (y+52+50*nb.length>500)
                    {
                        y=0;x=850;
                    }
                    else
                    {
                        y+=52+50*nb.length;
                    }
                }
            }
        }
    }
    public  int jour(int inter)
    {
        int day=0;
        int m=0;int i=ids*7;
        if(ids<=31)
        {   
            
            if(i>31)
            {i=i-31;m=2;}
            if(i>29)
            {i=i-29;m=0;}
            if(i>31)
            {i=i-31;m=1;}
            if(i>30)
            {i=i-30;m=0;}
            if(i>31)
            {i=i-31;m=1;}
            if(i>30)
            {i=i-30;m=0;}
            if(i>31)
            {i=i-31;m=1;}
            if(i-8>0)
            {day=i-8;}
            if(i-8<0 && m==0)
            {day=30+i-8;}
            if(i-8<0 && m==1)
            {day=31+i-8;}
            if(i-8<0 && m==2)
            {day=29+i-8;}
        }
        if(ids>31)
        {
            i=i-212;
            if(i>31)
            {i=i-31;m=1;}
            if(i>30)
            {i=i-30;m=0;}
            if(i>31)
            {i=i-31;m=1;}
            if(i>30)
            {i=i-30;m=0;}
            if(i>31)
            {i=i-31;}
            if(i-8>0)
            {day=i-7;}
            if(i-8<0 && m==0)
            {day=30+i-7;}
            if(i-8<0 && m==1)
            {day=31+i-7;}
        }
        for(int j=0;j<inter;j++)
        {
            if(day+1<29)
            {
                day=day+1;
            }
            else
            {
                if(day+1>=29 && ids!=9)
                {
                    if(day+1>30 && (ids==18 || ids==27 || ids==40 || ids==48))
                    {
                        day=1;
                    }
                    else
                    {
                        day=day+1;
                    }
                }
                else 
                {
                    day=1;
                }
            }
            if(day==32)
            {day=1;}
        }
        return day;
    
    }
    public String mois(int day,int inter)
    {
        String mois="janvier";
        int k=0;
        String[]tab={"janvier","février","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","decembre"};
        int m=0;int i=ids*7-8;
        if(ids<=31)
        {   
            
            if(i>31)
            {i=i-31;mois="février";k+=1;m=1;}
            if(i>29)
            {i=i-29;mois="mars";k+=1;m=2;}
            if(i>31)
            {i=i-31;mois="avril";k+=1;m=1;}
            if(i>30)
            {i=i-30;mois="mai";k+=1;m=0;}
            if(i>31)
            {i=i-31;mois="juin";k+=1;m=1;}
            if(i>30)
            {i=i-30;mois="juillet";k+=1;m=0;}
            if(i>31)
            {i=i-31;mois="aout";k+=1;m=1;}
            if(i>31)
            {i=i-31;mois="septembre";k+=1;m=1;}
            if(i>30)
            {i=i-30;mois="octobre";k+=1;m=0;}
            if(i>31)
            {i=i-31;mois="novembre";k+=1;m=1;}
            if(i>30)
            {i=i-30;mois="decembre";k+=1;m=0;}
            if(i-8>0)
            {day=i;}
            if(i-8<0 && m==0)
            {day=30+i;}
            if(i-8<0 && m==1)
            {day=31+i;}
            if(i-8<0 && m==2)
            {day=29+i;}
            
            
        }
        for(int j=0;j<inter;j++)
        {
             if(day+1<29)
            {
                day=day+1;
            }
            else
             {
                if(day+1>=29 && ids!=9)
                {
                    if(day+1>30 && (ids==18 || ids==27 || ids==40 || ids==48))
                    {
                        mois=tab[k+1];
                    }
                    else
                    {
                        day=day+1;
                    }
                }
                else 
                {
                    mois=tab[k+1];
                }
             }
            if(day==32)
            {mois=tab[k+1];}
        }
        return mois;
    
    }
     public Color definec(int id, int droit)
    {
        Color a = null;
        if (droit==0)
        {
            int type=gettypecour(id);
            if(type==2)
                a=new Color(255,255,128);
            if(type==3)
                a=new Color(128,255,128);
            if(type==4)
                a=new Color(128,128,255);
            if(type==5)
                a=new Color(255,128,255);
            if(type==1)
                a=new Color(255,128,128);
        }
        if (droit==1)
        {
            int type=getpromo(id);
            if(type==2)
                a=new Color(255,255,128);
            if(type==3)
                a=new Color(128,255,128);
            if(type==1)
                a=new Color(255,128,128);
        }
        return a;
    }
     public int[]trilistejour(int[] nb)
     {
         int size=nb.length;
         String jour;int z=0;
         int []tabtrier=new int[size];
         for(int i=0;i<size;i++)
         {
             jour=getjour(nb[i]);
             if("lun".equals(jour))
             {
                 tabtrier[z]=nb[i];
                 z+=1;
             }
         }
          for(int i=0;i<size;i++)
         {
             jour=getjour(nb[i]);
             if("mar".equals(jour))
             {
                 tabtrier[z]=nb[i];
                 z+=1;
             }
         }
           for(int i=0;i<size;i++)
         {
             jour=getjour(nb[i]);
             if("mer".equals(jour))
             {
                 tabtrier[z]=nb[i];
                 z+=1;
             }
         }
            for(int i=0;i<size;i++)
         {
             jour=getjour(nb[i]);
             if("jed".equals(jour))
             {
                 tabtrier[z]=nb[i];
                 z+=1;
             }
         } for(int i=0;i<size;i++)
         {
             jour=getjour(nb[i]);
             if("ven".equals(jour))
             {
                 tabtrier[z]=nb[i];
                 z+=1;
             }
         }
         return tabtrier;
     }
     public int[]trilisteheure(int[] nb)
     {
         int size=nb.length;
         String heure;int z=0;
         int []tabtrier=new int[size];
         for(int i=0;i<size;i++)
         {
             heure=getheur(nb[i],"HDebut");
             if("08:30:00".equals(heure))
             {
                 tabtrier[z]=nb[i];
                 z+=1;
             }
         }
          for(int i=0;i<size;i++)
         {
             heure=getheur(nb[i],"HDebut");
             if("10:15:00".equals(heure))
             {
                 tabtrier[z]=nb[i];
                 z+=1;
             }
         }
           for(int i=0;i<size;i++)
         {
             heure=getheur(nb[i],"HDebut");
             if("12:00:00".equals(heure))
             {
                 tabtrier[z]=nb[i];
                 z+=1;
             }
         }
            for(int i=0;i<size;i++)
         {
              heure=getheur(nb[i],"HDebut");
             if("13:45:00".equals(heure))
             {
                 tabtrier[z]=nb[i];
                 z+=1;
             }
         } 
         for(int i=0;i<size;i++)
         {
              heure=getheur(nb[i],"HDebut");
             if("15:30:00".equals(heure))
             {
                 tabtrier[z]=nb[i];
                 z+=1;
             }
         }
          for(int i=0;i<size;i++)
         {
              heure=getheur(nb[i],"HDebut");
             if("17:15:00".equals(heure))
             {
                 tabtrier[z]=nb[i];
                 z+=1;
             }
         }
         return tabtrier;
     }
}
