/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Dominio.Aluno;
import Dominio.Tutor;
import Dominio.Curso;
import Dominio.Mensagem;

/**
 *
 * @author jeck
 */
public class AlunoServico {
    public void mudarTutor(Aluno aluno, Tutor tutor){
        //Remover aluno do tutor antigo SE houver
        if (aluno.getCurso() != null) {
            aluno.getCurso().getTutor().getListaDeCursos().remove(aluno.getCurso());
        }
        //remover remover tutor do aluno
        //adicionar novo tutor ao aluno
        Curso novoCurso = new Curso(aluno, tutor);
        aluno.setCurso(novoCurso);
        //adiconar aluno ao novo tutor
        tutor.getListaDeCursos().add(novoCurso);
    }

    public void enviarMensagem(Tutor tutor, Aluno aluno, String msg) {
        Fachada fachada = Fachada.getInstancia();
        
        fachada.getUsuarioServico().tutorDAO.getTutor(tutor.getIdentificacao()).addMesagem(new Mensagem(aluno, tutor, msg));
    }
}
