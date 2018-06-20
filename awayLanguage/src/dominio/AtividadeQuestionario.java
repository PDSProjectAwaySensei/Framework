/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import Dominio.Atividade;
import java.util.ArrayList;

/**
 *
 * @author jeck
 */
public class AtividadeQuestionario extends Atividade{
    private ArrayList<String> questoes;

    public AtividadeQuestionario() {
        this.questoes = new ArrayList<String>();        
    }

    public AtividadeQuestionario(ArrayList<String> questoes) {
        this.questoes = questoes;
    }

    public ArrayList<String> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(ArrayList<String> questoes) {
        this.questoes = questoes;
    }    
}
