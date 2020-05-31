
package projetjava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import static projetjava.Connexion.connecterDB;


public class DBRecherche 
{
    private static Connection cnx;
    private static Statement st;
    private static ResultSet rst;
    public static int Researchlog(String login,String password)
    {
         int n=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `utilisateur` WHERE `Email`='"+login+"' AND `MdP`='"+password+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
             n=rst.getInt("IDUtilisateur");
            
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int getdroit(int id)
    {
         int n=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `utilisateur` WHERE `IDUtilisateur`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
             n=rst.getInt("Droit");
            
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static String getstring(int id,String info)
    {
         String n="";
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `utilisateur` WHERE `IDUtilisateur`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
             n=rst.getString(info);
            
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }

public static int[] getsceance(int id,int ids)
    {
         int [] n = {-1};
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `etudiant` WHERE `IDUtilisateur`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            if(rst.last())
            {int g =rst.getInt("IDGroupe");
            query="SELECT * FROM `seanceg` WHERE `IDGroupe`='"+g+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            //rst.first();
            int nb=0;
            rst.beforeFirst();
            int temp=0;
            ResultSet rst2;
            int j=0;
            while(rst.next())
            {
                
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `Semaine`='"+ids+"'AND `IDSeance`='"+temp+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    nb=nb+1;
                }
                j+=1;
            }
            if(nb!=0)
            {n=new int[nb];
            temp=0;
            rst.first();
            int h=0;
            for(int i=0;i<j;i++)
            {
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `Semaine`='"+ids+"'AND `IDSeance`='"+temp+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    n[h]=temp;
                    h=h+1;
                }
                rst.next();
            }}}
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage()+"   "+e.getSQLState()+"  "+e.getLocalizedMessage());
            
        }
        return n;
    }
public static int[] getsceanceprof(int id,int ids)
    {
         int [] n = {-1};
        try
        {
            
            cnx=connecterDB();
            
            String query="SELECT * FROM `seancee` WHERE `IDUtilisateur`='"+id+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            int nb=0,j=0;
            int temp=0;
            ResultSet rst2;
            while(rst.next())
            {
                
                
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `Semaine`='"+ids+"'AND `IDSeance`='"+temp+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    nb=nb+1;
                }
                j+=1;
            }
            if(nb!=0)
            {n=new int[nb];
            
            temp=0;
            
            rst.first();
            int g=0;
            for(int i=0;i<j;i++)
            {
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `Semaine`='"+ids+"'AND `IDSeance`='"+temp+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    n[g]=temp;
                    g+=1;
                }
                rst.next();
                
            }}
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
            return n;
        }
        return n;
    }
    public static String getjour(int id)
    {
         String n="";
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `seance` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
             n=rst.getString("jour");
            
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int gettypecour(int id)
    {
         int n=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `seance` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
             n=rst.getInt("IDType");
            
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static String getheur(int id,String H)
    {
         String n="";
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `seance` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            Time h=rst.getTime(H);
            n=h.toString();
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static String getnomcour(int id)
    {
         String n="";
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `seance` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int c=rst.getInt("IDCours");
            query="SELECT * FROM `cours` WHERE `IDCours`='"+c+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            n=rst.getString("Nom");
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static ArrayList<String> getnomgroupe(int id)
    {
         ArrayList<String> n=new ArrayList<>();
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `seanceg` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            ResultSet rst2;
            while(rst.next())
            {
                int c=rst.getInt("IDGroupe");
                query="SELECT * FROM `groupe` WHERE `IDGroupe`='"+c+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {n.add(rst2.getString("Nom"));}
            }
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static ArrayList<String> getnomprof(int id)
    {
         ArrayList<String> n=new ArrayList<>();
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `seancee` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            ResultSet rst2;
            while(rst.next())
            {
                int c=rst.getInt("IDUtilisateur");
                query="SELECT * FROM `utilisateur` WHERE `IDUtilisateur`='"+c+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    n.add(rst2.getString("Nom"));
                }
            }
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static ArrayList<String> getnomsalle(int id)
    {
         ArrayList<String> n=new ArrayList<>();
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `seances` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            ResultSet rst2;String a;
            while(rst.next())
            {
                int c=rst.getInt("IDSalle");
                query="SELECT * FROM `salle` WHERE `IDSalle`='"+c+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    a=rst2.getString("Nom")+" - ";
                    int s=rst2.getInt("IDSite");
                    query="SELECT * FROM `site` WHERE `IDSite`='"+s+"'";
                    st=cnx.createStatement();
                    rst2=st.executeQuery(query);
                    rst2.last();
                    a+=rst2.getString("Nom");
                    n.add(a); 
                }
            }
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static ArrayList<String> getnomsalle2(int id)
    {
         ArrayList<String> n=new ArrayList<>();
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `seances` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            ResultSet rst2;String a;
            while(rst.next())
            {
                int c=rst.getInt("IDSalle");
                query="SELECT * FROM `salle` WHERE `IDSalle`='"+c+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    a=rst2.getString("Nom");
                    n.add(a); 
                }
            }
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int[] getnbcour(int [] id,String jour)
    {
         int []n={0};
         int j=0;
        try
        {
            
            cnx=connecterDB();
            for(int i=0;i<id.length;i++)
            {
                String query="SELECT * FROM `seance` WHERE `IDSeance`='"+id[i]+"'AND `jour`='"+jour+"'";
                
                st=cnx.createStatement();
                rst=st.executeQuery(query);
                rst.beforeFirst();

                while(rst.next())
                {j=j+1;}
            }
            n=new int[j];
            int g=0;
            for(int i=0;i<id.length;i++)
            {
                String query="SELECT * FROM `seance` WHERE `IDSeance`='"+id[i]+"'AND `jour`='"+jour+"'";
                
                st=cnx.createStatement();
                rst=st.executeQuery(query);
                
                
                if(rst.last())
                {
                    
                    n[g]=id[i];
                    g+=1;

                }
                
            }
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int getpromo(int id)
    {
         int n=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `seanceg` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
             int  g=rst.getInt("IDGroupe");
            query="SELECT * FROM `groupe` WHERE `IDGroupe`='"+g+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
             n=rst.getInt("IDPromo");
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static ArrayList<String> getttseance(int id)
    {
         ArrayList<String>n=new ArrayList<>();
         
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `etudiant` WHERE `IDUtilisateur`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int g =rst.getInt("IDGroupe");
            query="SELECT * FROM `seanceg` WHERE `IDGroupe`='"+g+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            int nb=0;
            rst.beforeFirst();
            int temp=0;
            ResultSet rst2,rst3;
            int j=0;String cour,courst;
            while(rst.next())
            {
                
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    j=0;
                    nb=rst2.getInt("IDCours");
                    query="SELECT * FROM `cours` WHERE `IDCours`='"+nb+"'";
                    st=cnx.createStatement();
                    rst3=st.executeQuery(query);
                    rst3.last();
                    cour=rst3.getString("Nom");
                    for(int i=0;i<n.size();i++)
                    {
                        courst=n.get(i);
                        if(cour.equals(courst))
                        {
                            j=1;
                        }
                    }
                    if(j==0)
                    {
                        n.add(cour);
                    }
                }
                
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage()+"   "+e.getSQLState()+"  "+e.getLocalizedMessage()+"jhfjfjf");
            
        }
        return n;
    }
    public static ArrayList<String> getttseanceprof(int id)
    {
         ArrayList<String>n=new ArrayList<>();
         ArrayList<String>n2=new ArrayList<>();
         
        try
        {
            cnx=connecterDB();
            String query="SELECT * FROM `enseignant` WHERE `IDUtilisateur`='"+id+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            int temp=0;
            ResultSet rst2;
            int j=0;String cour,courst;
            while(rst.next())
            {
                j=0;
                temp=rst.getInt("IDCours");
                query="SELECT * FROM `cours` WHERE `IDCours`='"+temp+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    cour=rst2.getString("Nom");
                    for(int i=0;i<n.size();i++)
                    {
                        courst=n.get(i);
                        if(cour.equals(courst))
                        {
                            j=1;
                        }
                    }
                    if(j==0)
                    {
                        n.add(cour);
                        
                    }
                }
            }
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage()+"   "+e.getSQLState()+"  "+e.getLocalizedMessage()+"jhfjfjf");
            
        }
        return n;
    }
    public static ArrayList<String> getnbgroupe(String nom)
    {
         ArrayList<String>n=new ArrayList<>();
        try
        {
            
            String groupe,groupet;
            cnx=connecterDB();
            String query="SELECT * FROM `cours` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int c=rst.getInt("IDCours");
            query="SELECT * FROM `seance` WHERE `IDCours`='"+c+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            int temp;
            ResultSet rst2,rst3;int j=0;
            while(rst.next())
            {
                
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seanceg` WHERE `IDSeance`='"+temp+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                rst2.beforeFirst();
                while(rst2.next())
                {
                    j=0;
                    int g=rst2.getInt("IDGroupe");
                    query="SELECT * FROM `groupe` WHERE `IDGroupe`='"+g+"'";
                    st=cnx.createStatement();
                    rst3=st.executeQuery(query);
                    rst3.last();
                    groupe=rst3.getString("Nom");
                    
                    for(int i=0;i<n.size();i++)
                    {
                        groupet=n.get(i);
                        if(groupe.equals(groupet))
                        {
                            j=1;
                        }
                    }
                    if(j==0)
                    {
                        n.add(groupe);
                        
                    }
                }
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static String getprof(String nom)
    {
         String n="";
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `cours` WHERE `Nom`='"+nom+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int c=rst.getInt("IDCours");
            query="SELECT * FROM `enseignant` WHERE `IDCours`='"+c+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            c=rst.getInt("IDUtilisateur");
            query="SELECT * FROM `utilisateur` WHERE `IDUtilisateur`='"+c+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            n=rst.getString("Prenom")+"  "+rst.getString("Nom");
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int getpremierjour(String nom,int ide,int d,String nomg)
    {
         int n=0;
        try
        {
            int g=0;
            cnx=connecterDB();
            String query="SELECT * FROM `cours` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int c=rst.getInt("IDCours");
            if(d==0)
            {
                query="SELECT * FROM `etudiant` WHERE `IDUtilisateur`='"+ide+"'";
                st=cnx.createStatement();
                rst=st.executeQuery(query);
                rst.last();
                g=rst.getInt("IDGroupe");
            }
            if(d==1)
            {
                query="SELECT * FROM `groupe` WHERE `Nom`='"+nomg+"'";
                st=cnx.createStatement();
                rst=st.executeQuery(query);
                rst.last();
                g=rst.getInt("IDGroupe");
            }
            query="SELECT * FROM `seanceg` WHERE `IDGroupe`='"+g+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            int nb=53;
            rst.beforeFirst();
            int temp=0;
            ResultSet rst2,rst3;
            int j=0;String jour,jourt="sam"; int j2=6;
            Time h,h2=new Time(18,0,0);
            while(rst.next())
            {
                
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `IDCours`='"+c+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    j=rst2.getInt("Semaine");
                    if(j<nb)
                    {
                        nb=j;
                    }
                }
            }
            rst.beforeFirst();
            while(rst.next())
            {
                
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `IDCours`='"+c+"'AND `Semaine`='"+nb+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    jour=rst2.getString("jour");
                    if("lun".equals(jour)){j=1;}if("mar".equals(jour)){j=2;}if("mer".equals(jour)){j=3;}if("jed".equals(jour)){j=4;}if("ven".equals(jour)){j=5;}
                    if(j<j2)
                    {
                        j2=j;
                        jourt=jour;
                    }
                }
            }
            rst.beforeFirst();
            while(rst.next())
            {
                
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `IDCours`='"+c+"' AND `Semaine`='"+nb+"' AND `jour`='"+jourt+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    h=rst2.getTime("HDebut");
                    
                    if(h.getHours()<h2.getHours())
                    {
                        h2=h;
                        n=temp;
                    }
                }
            }
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int getdernierjour(String nom,int ide,int d,String nomg)
    {
         int n=0;
        try
        {
            int g=0;
            cnx=connecterDB();
            String query="SELECT * FROM `cours` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int c=rst.getInt("IDCours");
            if(d==0)
            {
                query="SELECT * FROM `etudiant` WHERE `IDUtilisateur`='"+ide+"'";
                st=cnx.createStatement();
                rst=st.executeQuery(query);
                rst.last();
                g=rst.getInt("IDGroupe");
            }
            if(d==1)
            {
                query="SELECT * FROM `groupe` WHERE `Nom`='"+nomg+"'";
                st=cnx.createStatement();
                rst=st.executeQuery(query);
                rst.last();
                g=rst.getInt("IDGroupe");
            }
            query="SELECT * FROM `seanceg` WHERE `IDGroupe`='"+g+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            int nb=0;
            rst.beforeFirst();
            int temp=0;
            ResultSet rst2,rst3;
            int j=0;String jour,jourt="sam"; int j2=0;
            Time h,h2=new Time(7,0,0);
            while(rst.next())
            {
                
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `IDCours`='"+c+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    j=rst2.getInt("Semaine");
                    if(j>nb)
                    {
                        nb=j;
                    }
                }
            }
            rst.beforeFirst();
            while(rst.next())
            {
                
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `IDCours`='"+c+"'AND `Semaine`='"+nb+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    jour=rst2.getString("jour");
                    if("lun".equals(jour)){j=1;}if("mar".equals(jour)){j=2;}if("mer".equals(jour)){j=3;}if("jed".equals(jour)){j=4;}if("ven".equals(jour)){j=5;}
                    if(j>j2)
                    {
                        j2=j;
                        jourt=jour;
                    }
                }
            }
            rst.beforeFirst();
            while(rst.next())
            {
                
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `IDCours`='"+c+"' AND `Semaine`='"+nb+"' AND `jour`='"+jourt+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    h=rst2.getTime("HDebut");
                    
                    if(h.getHours()>h2.getHours())
                    {
                        h2=h;
                        n=temp;
                    }
                }
            }
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int getids(int id)
    {
         int n=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `seance` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            n=rst.getInt("Semaine");
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int getnbseance(int ide,String nom,int d,String nomg)
    {
         int n=0;
        try
        {
            String query;int g=0;
            cnx=connecterDB();
            if(d==0)
            {
                query="SELECT * FROM `etudiant` WHERE `IDUtilisateur`='"+ide+"'";
                st=cnx.createStatement();
                rst=st.executeQuery(query);
                rst.last();
                g=rst.getInt("IDGroupe");
            }
            if(d==1)
            {
                query="SELECT * FROM `groupe` WHERE `Nom`='"+nomg+"'";
                st=cnx.createStatement();
                rst=st.executeQuery(query);
                rst.last();
                g=rst.getInt("IDGroupe");
            }
            query="SELECT * FROM `cours` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int c=rst.getInt("IDCours");
            query="SELECT * FROM `seanceg` WHERE `IDGroupe`='"+g+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            int temp;
            ResultSet rst2;
            while(rst.next())
            {
                
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `IDCours`='"+c+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    n+=1;
                }
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
     public static ArrayList<String> getttnomprof(int droit)
    {
         ArrayList<String>n=new ArrayList<>();
        try
        {
            
            
            cnx=connecterDB();
            String query="SELECT * FROM `utilisateur` WHERE `droit`='"+droit+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
           
            while(rst.next())
            {
                n.add(rst.getString("Nom"));
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
     public static ArrayList<String> getttnomgroupe()
    {
         ArrayList<String>n=new ArrayList<>();
        try
        {
            
            
            cnx=connecterDB();
            String query="SELECT * FROM `groupe` WHERE 1";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
           
            while(rst.next())
            {
                n.add(rst.getString("Nom"));
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
     public static ArrayList<String> getttnomsalle()
    {
         ArrayList<String>n=new ArrayList<>();
        try
        {
            
            
            cnx=connecterDB();
            String query="SELECT * FROM `salle` WHERE 1";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
           
            while(rst.next())
            {
                n.add(rst.getString("Nom"));
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
      public static int getidgroupe(String nom)
    {
         int n=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `groupe` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int g=rst.getInt("IDGroupe");
            query="SELECT * FROM `etudiant` WHERE `IDGroupe`='"+g+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            n=rst.getInt("IDUtilisateur");
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
      public static int getidprof(String nom)
    {
         int n=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `utilisateur` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            n=rst.getInt("IDUtilisateur");
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
      public static int getetat(int id)
    {
         int n=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `seance` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            n=rst.getInt("Etat");
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
}