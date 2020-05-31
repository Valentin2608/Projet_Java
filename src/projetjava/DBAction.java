
package projetjava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static projetjava.Connexion.connecterDB;


public class DBAction 
{
    private static Connection cnx;
    private static Statement st;
    private static ResultSet rst;
    public static ArrayList<String> getnomcours()
    {
         ArrayList<String>n=new ArrayList<>();
        try
        {
            
            
            cnx=connecterDB();
            String query="SELECT * FROM `cours` WHERE 1";
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
    public static ArrayList<String> getnomtype()
    {
         ArrayList<String>n=new ArrayList<>();
        try
        {
            
            
            cnx=connecterDB();
            String query="SELECT * FROM `typecours` WHERE 1";
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
    public static int getexistance(int s,String j,String h,String c)
    {
         int n=0;
        try
        {
            
            
            cnx=connecterDB();
            String query="SELECT * FROM `cours` WHERE `Nom`='"+c+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int temp=rst.getInt("IDCours");
             query="SELECT * FROM `seance` WHERE `Semaine`='"+s+"' AND `IDCours`='"+temp+"' AND `HDebut`='"+h+"' AND `jour`='"+j+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            if(rst.last())
            {
                n=rst.getInt("IDSeance");
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static void updateetat(int id,int etat)
    {
        
        try
        {
            
            
            cnx=connecterDB();
            String query="UPDATE `seance` SET `Etat`='"+etat+"'WHERE `IDSeance`='"+id+"'";
            st=cnx.createStatement();
            st.executeUpdate(query);
           
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        
    }
    public static int verifegroupe(int id,int s,String j,String h)
    {
         int n=0;
        try
        {
            ResultSet rst2,rst3;
            cnx=connecterDB();
            String query="SELECT * FROM `seanceg` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            while(rst.next())
            {
                int g=rst.getInt("IDGroupe");
                query="SELECT * FROM `seanceg` WHERE `IDGroupe`='"+g+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                rst2.beforeFirst();
                int temp=0;
                while(rst2.next())
                {
                    temp=rst2.getInt("IDSeance");
                    query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `Semaine`='"+s+"' AND `jour`='"+j+"' AND `HDebut`='"+h+"'";
                    st=cnx.createStatement();
                    rst3=st.executeQuery(query);
                    if(rst3.last())
                    {
                        n=1;
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
    public static int verifenewgroupe(int s,String j,String h,String nom)
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
            query="SELECT * FROM `seanceg` WHERE `IDGroupe`='"+g+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            ResultSet rst2;int temp=0;
            while(rst.next())
            {
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `Semaine`='"+s+"' AND `jour`='"+j+"' AND `HDebut`='"+h+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    n=1;
                }
            }
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int verifeprof(int id,int s,String j,String h)
    {
         int n=0;
        try
        {
            ResultSet rst2,rst3;
            cnx=connecterDB();
            String query="SELECT * FROM `seancee` WHERE `IDSeance`='"+id+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            while(rst.next())
            {
                int g=rst.getInt("IDUtilisateur");
                query="SELECT * FROM `seancee` WHERE `IDUtilisateur`='"+g+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                rst2.beforeFirst();
                int temp=0;
                while(rst2.next())
                {
                    temp=rst2.getInt("IDSeance");
                    query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `Semaine`='"+s+"' AND `jour`='"+j+"' AND `HDebut`='"+h+"'";
                    st=cnx.createStatement();
                    rst3=st.executeQuery(query);
                    if(rst3.last())
                    {
                        n=1;
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
    public static int verifenewprof(int s,String j,String h,String nom)
    {
         int n=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `utilisateur` WHERE `Nom`='"+nom+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int g=rst.getInt("IDUtilisateur");
            query="SELECT * FROM `seancee` WHERE `IDUtilisateur`='"+g+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            ResultSet rst2;int temp=0;
            while(rst.next())
            {
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `Semaine`='"+s+"' AND `jour`='"+j+"' AND `HDebut`='"+h+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    n=1;
                }
            }
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int verifesalle(int id,int s,String j,String h)
    {
         int n=0;
        try
        {
            ResultSet rst2,rst3;
            cnx=connecterDB();
            String query="SELECT * FROM `seances` WHERE `IDSeance`='"+id+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();int g=0;
            while(rst.next())
            {
                g=rst.getInt("IDSalle");
                query="SELECT * FROM `seances` WHERE `IDSalle`='"+g+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                rst2.beforeFirst();
                int temp=0;
                while(rst2.next())
                {
                    temp=rst2.getInt("IDSeance");
                    query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `Semaine`='"+s+"' AND `jour`='"+j+"' AND `HDebut`='"+h+"'";
                    st=cnx.createStatement();
                    rst3=st.executeQuery(query);
                    if(rst3.last())
                    {
                        n=1;
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
    public static int verifenewsalle(int s,String j,String h,String nom)
    {
         int n=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `salle` WHERE `Nom`='"+nom+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int g=rst.getInt("IDSalle");
            query="SELECT * FROM `seances` WHERE `IDSalle`='"+g+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            ResultSet rst2;int temp=0;
            while(rst.next())
            {
                temp=rst.getInt("IDSeance");
                query="SELECT * FROM `seance` WHERE `IDSeance`='"+temp+"' AND `Semaine`='"+s+"' AND `jour`='"+j+"' AND `HDebut`='"+h+"'";
                st=cnx.createStatement();
                rst2=st.executeQuery(query);
                if(rst2.last())
                {
                    n=1;
                }
            }
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static void updatedate(int id,int s,String j,String h)
    {
        
        try
        {
            cnx=connecterDB();
            String query="UPDATE `seance` SET `Semaine`='"+s+"',`jour`='"+j+"',`HDebut`='"+h+"'WHERE `IDSeance`='"+id+"'";
            st=cnx.createStatement();
            st.executeUpdate(query);
           
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        
    }
    public static int verifeexistancegroupe(int id,String nom)
    {
         int n=0;
        try
        {
            
            
            cnx=connecterDB();
            String query="SELECT * FROM `groupe` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int temp=rst.getInt("IDGroupe");
             query="SELECT * FROM `seanceg` WHERE `IDSeance`='"+id+"' AND `IDGroupe`='"+temp+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            if(rst.last())
            {
                n=1;
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int verifeexistanceprof(int id,String nom)
    {
         int n=0;
        try
        {
            
            
            cnx=connecterDB();
            String query="SELECT * FROM `utilisateur` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int temp=rst.getInt("IDUtilisateur");
             query="SELECT * FROM `seancee` WHERE `IDSeance`='"+id+"' AND `IDUtilisateur`='"+temp+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            if(rst.last())
            {
                n=1;
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int verifeexistancesalle(int id,String nom)
    {
         int n=0;
        try
        {
            
            
            cnx=connecterDB();
            String query="SELECT * FROM `salle` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int temp=rst.getInt("IDSalle");
             query="SELECT * FROM `seances` WHERE `IDSeance`='"+id+"' AND `IDSalle`='"+temp+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            if(rst.last())
            {
                n=1;
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static int blindagenb(int id,String type)
    {
         int n=0;
        try
        {
            cnx=connecterDB();
             String query="SELECT * FROM `"+type+"` WHERE `IDSeance`='"+id+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.beforeFirst();
            while(rst.next())
            {
                n+=1;
            }
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
    public static void insertgroupe(int id,String nom)
    {
        
        try
        {
            cnx=connecterDB();
            String query="SELECT * FROM `groupe` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int temp=rst.getInt("IDGroupe");
            query="INSERT INTO `seanceg`(`IDSeance`, `IDGroupe`) VALUES ('"+id+"','"+temp+"')";
            st=cnx.createStatement();
            st.executeUpdate(query);
           
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        
    }
    public static void insertprof(int id,String nom)
    {
        
        try
        {
            cnx=connecterDB();
            String query="SELECT * FROM `utilisateur` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int temp=rst.getInt("IDUtilisateur");
            query="INSERT INTO `seancee`(`IDSeance`, `IDUtilisateur`) VALUES ('"+id+"','"+temp+"')";
            st=cnx.createStatement();
            st.executeUpdate(query);
           
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        
    }
    public static void insertsalle(int id,String nom)
    {
        
        try
        {
            cnx=connecterDB();
            String query="SELECT * FROM `salle` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int temp=rst.getInt("IDSalle");
            query="INSERT INTO `seances`(`IDSeance`, `IDSalle`) VALUES ('"+id+"','"+temp+"')";
            st=cnx.createStatement();
            st.executeUpdate(query);
           
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        
    }
    public static void supprimersalle(int id,String nom)
    {
         
        try
        {
            cnx=connecterDB();
             String query="SELECT * FROM `salle` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int s=rst.getInt("IDSalle");
            query="DELETE FROM `seances` WHERE `IDSeance`='"+id+"' AND `IDSalle`='"+s+"'";
            st=cnx.createStatement();
            st.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        
    }
    public static void supprimerprof(int id,String nom)
    {
         
        try
        {
            cnx=connecterDB();
             String query="SELECT * FROM `utilisateur` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int s=rst.getInt("IDUtilisateur");
            query="DELETE FROM `seancee` WHERE `IDSeance`='"+id+"' AND `IDUtilisateur`='"+s+"'";
            st=cnx.createStatement();
            st.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        
    }
    public static void supprimergroupe(int id,String nom)
    {
         
        try
        {
            cnx=connecterDB();
             String query="SELECT * FROM `groupe` WHERE `Nom`='"+nom+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int s=rst.getInt("IDGroupe");
            query="DELETE FROM `seanceg` WHERE `IDSeance`='"+id+"' AND `IDGroupe`='"+s+"'";
            st=cnx.createStatement();
            st.executeUpdate(query);
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        
    }
     public static void updatnom(String nouveau,String ancien,String type)
    {
        
        try
        {
            cnx=connecterDB();
            String query="UPDATE `"+type+"` SET `Nom`='"+nouveau+"'WHERE `Nom`='"+ancien+"'";
            st=cnx.createStatement();
            st.executeUpdate(query);
           
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        
    }
     public static String getprof2(String nom)
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
            n=rst.getString("Nom");
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
     public static int verifpromo(String nomg,String nomc)
    {
         int n=0;
        try
        {
            
            cnx=connecterDB();
            String query="SELECT * FROM `cours` WHERE `Nom`='"+nomc+"'";
            
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int p1=rst.getInt("IDPromo");
            query="SELECT * FROM `groupe` WHERE `Nom`='"+nomg+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int p2=rst.getInt("IDPromo");
            if(p1!=p2)
            {
                n=1;
            }
            if(p1==4)
            {
                n=0;
            }
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        return n;
    }
     public static void insertseance(int se,String c,String g,String s,String h,String h2,String j)
    {
        
        try
        {
            cnx=connecterDB();
            String query="SELECT * FROM `salle` WHERE `Nom`='"+s+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int ids=rst.getInt("IDSalle");
            query="SELECT * FROM `groupe` WHERE `Nom`='"+g+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int idg=rst.getInt("IDGroupe");
            query="SELECT * FROM `cours` WHERE `Nom`='"+c+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int idc=rst.getInt("IDCours");
            int idt=rst.getInt("IDType");
            query="SELECT * FROM `enseignant` WHERE `IDCours`='"+idc+"'";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int idu=rst.getInt("IDUtilisateur");
            query="INSERT INTO `seance`(`IDSeance`, `Semaine`, `jour`, `HDebut`, `HFin`, `Etat`, `IDCours`, `IDType`) VALUES (NULL,'"+se+"','"+j+"','"+h+"','"+h2+"','0','"+idc+"','"+idt+"')";
            st=cnx.createStatement();
            st.executeUpdate(query);
             query="SELECT * FROM `seance` WHERE 1";
            st=cnx.createStatement();
            rst=st.executeQuery(query);
            rst.last();
            int id=rst.getRow();
            query="INSERT INTO `seancee` (`IDSeance`, `IDUtilisateur`) VALUES ('"+id+"', '"+idu+"')";
            st=cnx.createStatement();
            st.executeUpdate(query);
            query="INSERT INTO `seanceg` (`IDSeance`, `IDGroupe`) VALUES ('"+id+"', '"+idg+"')";
            st=cnx.createStatement();
            st.executeUpdate(query);
            query="INSERT INTO `seances` (`IDSeance`, `IDSalle`) VALUES ('"+id+"', '"+ids+"')";
            st=cnx.createStatement();
            st.executeUpdate(query);
           
        }
        catch(SQLException e)
        {
            System.out.print(e.getMessage());
        }
        
    }
}
