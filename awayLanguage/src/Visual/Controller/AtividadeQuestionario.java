/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Atividade;
import java.util.ArrayList;

/**
 *
 * @author jeck
 */
public class AtividadeQuestionario extends Atividade{
    private ArrayList<Questao> questoes;

    public AtividadeQuestionario() {
        questoes = new ArrayList<Questao>();
    }

    public AtividadeQuestionario(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }

    public ArrayList<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }    
}
