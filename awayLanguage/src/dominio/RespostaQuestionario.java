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
public class RespostaQuestionario implements Dominio.Resposta{
    private ArrayList<String> respostas;

    public RespostaQuestionario() {
        respostas = new ArrayList<>();
    }

    public RespostaQuestionario(ArrayList<String> respostas) {
        this.respostas = respostas;
    }

    public ArrayList<String> getRespostas() {
        return respostas;
    }

    public void setRespostas(ArrayList<String> respostas) {
        this.respostas = respostas;
    }
    
    public void addResposta(String resp) {
        this.respostas.add(resp);
    }
}
