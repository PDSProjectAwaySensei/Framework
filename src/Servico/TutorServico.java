/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Dominio.Tarefa;
import Dominio.Tutor;

/**
 *
 * @author jeckson
 */
class TutorServico {
    public void adicionarTarefa(Tutor tutor, Tarefa tarefa){
        tutor.getListaDeTarefasSalvas().add(tarefa);
    }
}
