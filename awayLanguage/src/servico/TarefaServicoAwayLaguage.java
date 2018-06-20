/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import Dominio.Tarefa;

/**
 *
 * @author José Carlos
 */
public class TarefaServicoAwayLaguage extends Servico.TarefaServico{
    private float resultado = 0;
    @Override
    public void avaliar(Tarefa tarefa) {
        tarefa.setResultado(new ResultadoPontuacao(this.resultado));
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }
}
