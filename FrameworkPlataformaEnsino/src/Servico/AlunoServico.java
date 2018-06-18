/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Dados.AlunoDAOMemoria;
import Dados.TutorDAOMemoria;
import Dominio.Aluno;
import Dominio.Tutor;
import Dominio.Curso;
import Dominio.Identificacao;
import Dominio.Mensagem;

/**
 *
 * @author jeck
 */
public abstract class AlunoServico {
    
    public void mudarTutor(Identificacao alunoIdentificacao, Identificacao tutorIdentificacao){
        
        //Paga o aluno no DAO pela sua identificação
        Aluno aluno = AlunoDAOMemoria.getInstancia().getAluno(alunoIdentificacao);
        
        if (aluno.getCurso() != null) {
            //Paga o tutor Anterior no DAO pela sua identificação
            Tutor tutorAntigo = TutorDAOMemoria.getInstancia().getTutor(aluno.getCurso().getTutor());
            
            //Remover aluno do tutor antigo SE houver
            if (aluno.getCurso() != null) {
                tutorAntigo.getListaDeCursos().remove(aluno.getCurso());
            }
        }
        
        //Paga o tutor Novo no DAO pela sua identificação
        Tutor tutorNovo = TutorDAOMemoria.getInstancia().getTutor(tutorIdentificacao);
        
        //remover remover tutor do aluno
        //adicionar novo tutor ao aluno
        Curso novoCurso = new Curso(alunoIdentificacao, tutorIdentificacao);
        aluno.setCurso(novoCurso);
        //adiconar aluno ao novo tutor
        tutorNovo.addCurso(novoCurso);
    }
    
    public void enviarMensagem(Aluno aluno, Identificacao tutor, String texto){
        Mensagem mensagem = new Mensagem(aluno, TutorDAOMemoria.getInstancia().getTutor(tutor), texto);
        TutorDAOMemoria.getInstancia().getTutor(tutor).addMesagem(mensagem);
    }
    
    public abstract boolean pagar(Identificacao aluno);
}
