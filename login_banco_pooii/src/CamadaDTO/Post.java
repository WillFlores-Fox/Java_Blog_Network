package CamadaDTO;

public class Post {
    
    String autor, conteudo;

    public Post() {
    }

    public Post(String autor, String conteudo) {
        this.autor = autor;
        this.conteudo = conteudo;
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
}
