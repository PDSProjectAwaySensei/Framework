/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;
import Dominio.Resposta;
import Dominio.Tarefa;

/**
 *
 * @author carlos emídio
 */
public abstract class TarefaServico {
    private Tarefa tarefa;

    public TarefaServico(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public TarefaServico() {
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
    
    public void responder(Resposta resposta) {
        this.tarefa.setResposta(resposta);
    }
    
    public abstract void avaliar ();
}
