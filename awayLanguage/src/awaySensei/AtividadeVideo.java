/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awaySensei;

import Dominio.Atividade;
import Dominio.Resposta;

/**
 *
 * @author jeckson
 */
public class AtividadeVideo extends Atividade{
    private String linkVideoTutor;
    private String ComVideoTutor;
    private RespostaVideo resposta;

    public AtividadeVideo(String linkVideoTutor, String ComVideoTutor) {
        super();
        this.linkVideoTutor = linkVideoTutor;
        this.ComVideoTutor = ComVideoTutor;        
    }

    public String getLinkVideoTutor() {
        return linkVideoTutor;
    }

    public void setLinkVideoTutor(String linkVideoTutor) {
        this.linkVideoTutor = linkVideoTutor;
    }

    public String getComVideoTutor() {
        return ComVideoTutor;
    }

    public void setComVideoTutor(String ComVideoTutor) {
        this.ComVideoTutor = ComVideoTutor;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(RespostaVideo resposta) {
        this.resposta = resposta;
    }
}
