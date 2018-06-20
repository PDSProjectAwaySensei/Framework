/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import Dominio.Resultado;

/**
 *
 * @author Residentes
 */
public class ResultadoPontuacao implements Resultado{
    private float nota;

    public ResultadoPontuacao() {
    }

    public ResultadoPontuacao(float nota) {
        this.nota = nota;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
