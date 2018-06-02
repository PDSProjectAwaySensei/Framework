package Dominio;

import Dominio.Identificacao;
import Dominio.InformacaoPessoal;
import java.util.ArrayList;

public abstract class Usuario {
    //private ArrayList<Mensagem> mensagens;
    private Identificacao identificacao;
    private InformacaoPessoal informacaoPessoal;

    public Usuario(Identificacao identificacao, InformacaoPessoal informacaoPessoal) {
        this.identificacao = identificacao;
        this.informacaoPessoal = informacaoPessoal;
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
}
