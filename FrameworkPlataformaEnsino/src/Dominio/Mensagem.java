package Dominio;

public class Mensagem {
    private Usuario remetente;
    private Usuario destinatario;
    private String mensagem;

    public Mensagem(Usuario remetente, Usuario destinatario, String mensagem) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
    }        
}
