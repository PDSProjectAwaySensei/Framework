package Dominio;

public class Mensagem {
    private boolean lida;
    private final Usuario remetente;
    private final Usuario destinatario;
    private final String mensagem;

    public Mensagem(Usuario remetente, Usuario destinatario, String mensagem) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
    }        
}
