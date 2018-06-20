/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awaySensei;

import Dominio.Resultado;

/**
 *
 * @author Residentes
 */
public class ResultadoNota implements Resultado{
    private float nota;

    public ResultadoNota() {
    }

    public ResultadoNota(float nota) {
        this.nota = nota;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
