package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
        
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // chama o driver
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Loja"; // chama nosso localhost + a porta de entrada + nome do BD + timezone(região do mundo)
    private static final String USER = "Fratty";
    private static final String PASS = "tfg548788";
    
    public static Connection getConnection() {
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro de conexão:",ex);
        }
    }
    
    public static void closeConnection(Connection con){
        
       try {
           if(con != null){
               con.close();
           }
       } catch (SQLException ex){
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
       closeConnection(con);
       
        try {
           if(stmt != null){
               stmt.close();
           }
       } catch (SQLException ex){
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
       closeConnection(con, stmt);
       
        try {
           if(rs != null){
               rs.close();
           }
       } catch (SQLException ex){
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    //construtor
    public ConnectionFactory() {

    }
}
