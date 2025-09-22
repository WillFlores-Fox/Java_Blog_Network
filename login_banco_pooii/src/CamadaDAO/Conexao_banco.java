package CamadaDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao_banco {

    public static Connection conector() {
        Connection conexao = null;

        String driver = "org.mariadb.jdbc.Driver";
        String url = "jdbc:mariadb://localhost:3306/login";
        String user = "root";
        String password = "root";

        try {
            Class.forName(driver); // Carrega o driver JDBC
            conexao = DriverManager.getConnection(url, user, password);

            // Mensagem de confirmação
            System.out.println("✅ Conexão estabelecida com o banco de dados: " + url + " | Usuário: " + user);

            return conexao;
        } catch (Exception e) {
            System.out.println(" Conexão perdida com o banco de dados.");
            return null;
        }
    }
}
