package CamadaDAO;

import CamadaDTO.login;
import CamadaDTO.usuarioLogado;
import CamadaView.perfilView;
import javax.swing.JOptionPane;
import java.sql.*;

public class Conexao_login {

    public boolean cadastrar(login login) {
        Connection conn = Conexao_banco.conector();

        if (conn == null) {
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

                login.setNome(rs.getString("nome"));
                login.setId(rs.getInt("id_usuario"));
                login.setSenha(rs.getString("senha"));
                usuarioLogado.setNome(login);
                usuarioLogado.setIdAtual(login);
                usuarioLogado.setSenha(login);

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

    public boolean atualizar(login login) {
        Connection conn = Conexao_banco.conector();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
            return false;
        }

        String sql = "UPDATE usuario SET nome = ?, senha = ? WHERE usuario = ? AND senha = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, login.getNome());
            pstm.setString(2, login.getSenha());
            String user = JOptionPane.showInputDialog(null);
            pstm.setString(3, user);
            String senha = JOptionPane.showInputDialog(null);
            pstm.setString(4, senha);

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Atualização falhou. Verifique os dados.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer login: " + e.getMessage());
            return false;
        }
    }
    
    public boolean delete(login login) {
        Connection conn = Conexao_banco.conector();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
            return false;
        }

        String sql = "DELETE FROM usuario WHERE usuario = ? AND senha = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            String user = JOptionPane.showInputDialog(null);
            pstm.setString(1, user);
            String senha = JOptionPane.showInputDialog(null);
            pstm.setString(2, senha);
            
            int rowsAffected = pstm.executeUpdate();

            int saida = JOptionPane.showConfirmDialog(null, "Deseja excluir seu perfil?", "Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if (saida == JOptionPane.YES_OPTION) {
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Exclusão bem-sucedida!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Exclusão falhou. Verifique suas credenciais.");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Retornando...");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer login: " + e.getMessage());
            return false;
        }
        return false;
    }
}
