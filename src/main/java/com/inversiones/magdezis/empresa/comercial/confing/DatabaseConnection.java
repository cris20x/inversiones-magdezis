
package main.java.com.inversiones.magdezis.empresa.comercial.confing;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class DatabaseConnection {
    
    
    public static final String URL = "jdbc:mysql://localhost:3306/inversiones_magdezis_in4bv";
    public static final String USER = "IN4BV";
    public static final String PASS_DB="%IndiVA4";
    
    public static  Connection getconexion () throws SQLException{
        return DriverManager.getConnection(
             URL,
            USER,
            PASS_DB
        );
    } 
            
}

