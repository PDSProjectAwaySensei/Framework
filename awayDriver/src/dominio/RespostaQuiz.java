/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author José Carlos
 */
public class RespostaQuiz implements Dominio.Resposta{
    private ArrayList<Boolean> respostas;

    public RespostaQuiz() {
        respostas = new ArrayList<>();
    }

    public RespostaQuiz(ArrayList<Boolean> respostas) {
        this.respostas = respostas;
    }

    public ArrayList<Boolean> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<Boolean> respostas) {
        this.respostas = respostas;
    }
    
    public void addResposta(Boolean resp) {
        this.respostas.add(resp);
    }
}
