package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Alunos
 */
public class Conexao {
    
    private static Connection conexao;

    public static Connection conectar() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(
            "jdbc:mysql://localhost/kleitom", "root", "");
            return conexao;
        } catch (ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }

    public static void desconectar() {
        if (conexao != null){
            try{
                conexao.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    
}
