/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

/**
 *
 * @author jeck
 */
class Questao {
    String enunciado;
    String resposta;

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Questao(String enunciado, String resposta) {
        this.enunciado = enunciado;
        this.resposta = resposta;
    }

    public Questao() {
        enunciado = "";
        resposta = "";
    }
    
    
}
