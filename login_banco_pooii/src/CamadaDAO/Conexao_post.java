package CamadaDAO;

import CamadaDTO.Post;
import CamadaDTO.login;
import CamadaDTO.usuarioLogado;
import javax.swing.JOptionPane;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Conexao_post {
    
    public boolean cadastrar(Post post) {
        LocalDateTime agora = LocalDateTime.now();
        
        Connection conn = Conexao_banco.conector();
        
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
            return false;
        }
        
        String sql = "INSERT INTO postagens (autor, conteudo, data) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, post.getAutor());
            pstm.setString(2, post.getConteudo());
            pstm.setTimestamp(3, Timestamp.valueOf(agora));
            
            int rowsAffected = pstm.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Postagem criada com sucesso!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao criar postagem.");
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar postagem: " + e.getMessage());
            return false;
        }
    }
    
    public boolean excluir(Post post) {
        Connection conn = Conexao_banco.conector();
        
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
            return false;
        }
        
        String sql = "DELETE FROM postagens WHERE autor = ? OR ?";
        
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, usuarioLogado.getUsuario().getUsuario());
            pstm.setString(2, usuarioLogado.getNome().getNome());
            
            int rowsAffected = pstm.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Postagens apagadas com sucesso!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao apagar postagens.");
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao apagar postagens: " + e.getMessage());
            return false;
        }
    }
    
    public List<Post> listar() {
        Connection conn = Conexao_banco.conector();
        List<Post> lista = new ArrayList<>();
        
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
            return lista;
        }
        
        String sql = "SELECT autor, conteudo, data FROM postagens ORDER BY data DESC";
        
        try (PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {
            
            while (rs.next()) {
                Post post = new Post();
                post.setAutor(rs.getString("autor"));
                post.setConteudo(rs.getString("conteudo"));
                post.setData(rs.getTimestamp("data").toLocalDateTime());
                
                lista.add(post);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar postagens: " + e.getMessage());
        }
        
        return lista;
    }
}