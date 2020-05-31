
package projetjava;

import java.sql.*;

/**
 *
 * @author paulc
 */
public class Connexion 
{
    public static Connection connecterDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/edt";
            String user="root";
            String password="";
            Connection cnx=DriverManager.getConnection(url,user,password); 
            return cnx;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
}
