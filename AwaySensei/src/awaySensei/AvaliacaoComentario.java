/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awaySensei;

import Dominio.Avaliacao;

/**
 *
 * @author jeckson
 */
public class AvaliacaoComentario extends Avaliacao {    
    private String avaliacaoTutor;

    public AvaliacaoComentario(String avaliacaoTutor) {
        this.avaliacaoTutor = avaliacaoTutor;
    }

    public String getAvaliacaoTutor() {
        return avaliacaoTutor;
    }

    public void setAvaliacaoTutor(String avaliacaoTutor) {
        this.avaliacaoTutor = avaliacaoTutor;
    }
}
