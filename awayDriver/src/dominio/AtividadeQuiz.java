/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import Dominio.Atividade;
import Dominio.Resposta;
import Dominio.Tarefa;
import java.util.ArrayList;

/**
 *
 * @author jeck
 */
public class AtividadeQuiz extends Atividade{
    private ArrayList<String> questoes;
    private String respostas;

    public AtividadeQuiz() {
        questoes = new ArrayList<String>();
    }

    public AtividadeQuiz(ArrayList<String> questoes) {
        this.questoes = questoes;
    }

    public AtividadeQuiz(ArrayList<String> questoes, String respostas) {
        this.questoes = questoes;
        this.respostas = respostas;
    }
    
    public ArrayList<String> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(ArrayList<String> questoes) {
        this.questoes = questoes;
    }    

    public String getRespostas() {
        return respostas;
    }

    public void setRespostas(String respostas) {
        this.respostas = respostas;
    }

    public void autoAvaliar(Tarefa tarefa) {
        RespostaQuiz resposta = (RespostaQuiz) tarefa.getResposta();
        ArrayList<Boolean> respostasBool = resposta.getRespostas();
        
        String[] split = respostas.split("");
        int size = questoes.size();
        int acertos = 0;
        for (int i = 0; i < size; i++){
            if (((respostasBool.get(i) == true) && (split[i] == "1")) || ((respostasBool.get(i)) == false) && (split[i] == "0")){
                acertos++;
            }
        }
        
        tarefa.setResultado((acertos/size)*10);
    }
    
    
}
