/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Dados.AlunoDAOMemoria;
import Dados.TutorDAOMemoria;
import Dominio.Aluno;
import Dominio.Identificacao;
import Dominio.Mensagem;
import Dominio.Tarefa;
import Dominio.Tutor;
import java.util.ArrayList;

/**
 *
 * @author jeckson
 */
public class TutorServico {
    public void enviarTarefas(Identificacao aluno, ArrayList<Tarefa> tarefas, ArrayList<Aluno> selecionados){
        for (Aluno selecionado : selecionados) {
            for (Tarefa tarefa : tarefas) {
                selecionado.getCurso().addtarefa(tarefa);
            }
        }
    }
    
    public void enviarMensagem(Tutor tutor, Identificacao aluno, String texto){
        Mensagem mensagem = new Mensagem(tutor, AlunoDAOMemoria.getInstancia().getAluno(aluno), texto);
        AlunoDAOMemoria.getInstancia().getAluno(aluno).addMesagem(mensagem);
    }
    
    public void cadastrar (Tutor tutor){
        TutorDAOMemoria.getInstancia().inserirTutor(tutor);
    }
    
    public Tutor logar (Identificacao tutor) {
        return TutorDAOMemoria.getInstancia().getTutor(tutor);
    }
    
    public void novaTarefa(Tutor tutor,Tarefa novaTarefa){
        TutorDAOMemoria.getInstancia().getTutor(tutor.getIdentificacao()).addTarefa(novaTarefa);
    }
}
