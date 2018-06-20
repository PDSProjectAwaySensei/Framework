/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import Dados.AlunoDAOMemoria;
import Dominio.Identificacao;

/**
 *
 * @author Residentes
 */
public class AlunoServicoAwayLanguage extends Servico.AlunoServico{

    @Override
    public boolean pagar(Identificacao aluno) {
        if (AlunoDAOMemoria.getInstancia().getAluno(aluno).getCurso().getDebito() >= 0) {
            AlunoDAOMemoria.getInstancia().getAluno(aluno).getCurso().setDebito(0);
            
            return true;
        }
        
        return false;
    }
}
