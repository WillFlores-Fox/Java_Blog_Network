package CamadaDTO;

import java.time.LocalDateTime;

public class Post {
    
    String autor, conteudo;
    LocalDateTime data;
    int id;

    public Post() {
    }

    public Post(String autor, String conteudo) {
        this.autor = autor;
        this.conteudo = conteudo;
    }

    public Post(int id, String autor, String conteudo, LocalDateTime data) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.data = data;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }
}
