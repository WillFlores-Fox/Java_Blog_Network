package CamadaDTO;

public class usuarioLogado {

    private static login usuarioAtual;
    private static login NomeAtual;
    private static login IdAtual;
    private static login Senha;

    public static void setUsuario(login usuario) {
        usuarioAtual = usuario;
    }
    
    public static void setNome(login nome){
        NomeAtual = nome;
    }

    public static login getUsuario() {
        return usuarioAtual;
    }    
    
    public static login getNome() {
        return NomeAtual;
    }

    public static login getIdAtual() {
        return IdAtual;
    }

    public static void setIdAtual(login IdAtual) {
        usuarioLogado.IdAtual = IdAtual;
    }

    public static void limparUsuario() {
        usuarioAtual = null;
        NomeAtual = null;
        IdAtual = null;
        Senha = null;
    }

    public static boolean estaLogado() {
        return usuarioAtual != null;
    }

    public static login getSenha() {
        return Senha;
    }

    public static void setSenha(login Senha) {
        usuarioLogado.Senha = Senha;
    }
}
