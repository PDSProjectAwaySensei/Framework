package Dados;

import Dominio.Aluno;
import Dominio.Identificacao;
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
            if  (i.getIdentificacao().getUsuario().equals(idEntrar.getUsuario())){
                if (i.getIdentificacao().getUsuario().equals(idEntrar.getUsuario())){
                    return i;
                }
            }
        }
        return null;
    }
}
