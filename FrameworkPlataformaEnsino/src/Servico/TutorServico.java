/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Dominio.Aluno;
import Dominio.Mensagem;
import Dominio.Tarefa;
import Dominio.Tutor;
import java.util.ArrayList;

/**
 *
 * @author jeckson
 */
class TutorServico {
    public void adicionarTarefa(Tutor tutor, Tarefa tarefa){
        tutor.getListaDeTarefasSalvas().add(tarefa);
    }

    void removerTarefa(Tutor tutor, Tarefa tarefa) {
        tutor.getListaDeTarefasSalvas().remove(tarefa);
    }

    void enviarTarefa(Tutor tutor, Tarefa tarefa, ArrayList<Integer> selecionados) {
        for(int i : selecionados){
            tutor.getListaDeCursos().get(i).getListaTarefas().add(tarefa);
        }
    }
    
    public void enviarMensagem(Tutor tutor, Aluno aluno, String msg) {
        Fachada fachada = Fachada.getInstancia();
        
        fachada.getUsuarioServico().alunoDAO.getAluno(aluno.getIdentificacao()).addMesagem(new Mensagem(tutor, aluno, msg));
    }
}
