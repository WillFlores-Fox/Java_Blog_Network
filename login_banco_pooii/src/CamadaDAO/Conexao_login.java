package CamadaDAO;

import CamadaDTO.login;
import javax.swing.JOptionPane;
import java.sql.*;

public class Conexao_login {
    
    public boolean cadastrar(login login){
        Connection conn = Conexao_banco.conector();
        
        if (conn == null){
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
        }
        
        String sql = "INSERT INTO usuario(usuario,senha, nome) VALUES (? , ? , ?)";
        
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, login.getUsuario());
            pstm.setString(2, login.getSenha());
            pstm.setString(3, login.getNome());

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cadastro bem-sucedido!");

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro falhou. Verifique o preenchimento de tudo.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer o cadastro: " + e.getMessage());
            return false;
        }
    }
    
    public boolean entrar(login login) {
        Connection conn = Conexao_banco.conector();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
            return false;
        }

        String sql = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, login.getUsuario());
            pstm.setString(2, login.getSenha());

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Login falhou. Verifique suas credenciais.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer login: " + e.getMessage());
            return false;
        }
    }
}