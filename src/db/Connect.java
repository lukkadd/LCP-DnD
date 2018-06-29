package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Marjorie
 */
public class Connect {
    
    public Connect() {
        
    }
    
    // Função para conectar ao banco de dados
    public Connection conectaBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String strUrl = "jdbc:mysql://localhost:3306/sys?useTimezone=true&serverTimezone=UTC";
            
            Connection conn = DriverManager.getConnection(strUrl, "root", "root");
            System.out.println("Conexão efetuada com sucesso!");
            
            return conn;
        } catch(Exception e) {
            System.err.println("Erro ao realizar conexão.");
            e.printStackTrace();
            return null;
        }
    }
    
    // Desconectar o banco de dados
    public void desconectaBD(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
            System.out.println("Conexão finalizada.");
        } catch(Exception e) {
            System.err.println("Problemas ao desconectar!");
        }
    }
}
