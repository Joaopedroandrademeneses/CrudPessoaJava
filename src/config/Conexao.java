package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String url = "jdbc:postgresql://localhost:5432/pessoa";
    private static final String usuario = "postgres";
    private static final String senha = "75790406";
    private static Connection con = null;

    public static Connection Conectar() {
        try {
            if (con == null) {
                con = DriverManager.getConnection(url, usuario, senha);
                return con;
            }else {
                return con;
            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
