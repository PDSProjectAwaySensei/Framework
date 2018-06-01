package Dados;

import Dominio.Aluno;
import dominio.usuario.Identificacao;
import java.util.ArrayList;

public class AlunoDAOMemoria implements AlunoDAO{
    private ArrayList<Aluno> alunos;

    public AlunoDAOMemoria() {
        this.alunos = new ArrayList<>();
    }
    
    @Override
    public Boolean inserirAluno(Aluno aluno) {
        if (getAluno(aluno.getIdentificacao()) == null){
            alunos.add(aluno);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    @Override
    public void editarAluno(Aluno antigo, Aluno novo) {
        alunos.set(alunos.indexOf(antigo),novo);
    }

    @Override
    public ArrayList<Aluno> listarAlunos(){
        return alunos;
    }
    
    @Override
    public Aluno getAluno(Identificacao idEntrar){
        for (Aluno i : alunos){
            if  (i.getIdentificacao().equals(idEntrar)){
                return i;
            }
        }
        return null;
    }
}
