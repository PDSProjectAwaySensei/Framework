/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awaySensei;

import Dominio.Atividade;

/**
 *
 * @author jeckson
 */
public class AtividadeVideo extends Atividade{
    private String linkVideoTutor;
    private String ComVideoTutor;
    private String linkVideoAluno;
    private String ComVideoAluno;

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

    public String getLinkVideoAluno() {
        return linkVideoAluno;
    }

    public void setLinkVideoAluno(String linkVideoAluno) {
        this.linkVideoAluno = linkVideoAluno;
    }

    public String getComVideoAluno() {
        return ComVideoAluno;
    }

    public void setComVideoAluno(String ComVideoAluno) {
        this.ComVideoAluno = ComVideoAluno;
    }
    
    
}
