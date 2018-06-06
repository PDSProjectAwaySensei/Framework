package Dominio;

import java.util.ArrayList;

public abstract class Usuario {
    private ArrayList<Mensagem> mensagens;
    private Identificacao identificacao;
    private InformacaoPessoal informacaoPessoal;

    public Usuario(Identificacao identificacao, InformacaoPessoal informacaoPessoal) {
        this.identificacao = identificacao;
        this.informacaoPessoal = informacaoPessoal;
        this.mensagens = new ArrayList<>();
    }

    public Identificacao getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Identificacao identificacao) {
        this.identificacao = identificacao;
    }

    public InformacaoPessoal getInformacaoPessoal() {
        return informacaoPessoal;
    }

    public void setInformacaoPessoal(InformacaoPessoal informacaoPessoal) {
        this.informacaoPessoal = informacaoPessoal;
    }
    
    public void addMesagem (Mensagem mensagem){
        this.mensagens.add(mensagem);
    }
    
    public ArrayList<Mensagem> listMesagems() {
        return this.mensagens;
    }
}
