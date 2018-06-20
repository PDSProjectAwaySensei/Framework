/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import Dominio.Tarefa;
import awaySensei.ResultadoNota;

/**
 *
 * @author José Carlos
 */
public class TarefaServicoAwaySensei extends Servico.TarefaServico{   
    private float resultado; 
        
    @Override
    public void avaliar(Tarefa tarefa) {
        tarefa.setResultado(new ResultadoNota(this.resultado));
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }
}
