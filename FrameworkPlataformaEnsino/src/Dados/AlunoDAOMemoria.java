package Dados;

import Dominio.Aluno;
import Dominio.Identificacao;
import java.util.ArrayList;

public class AlunoDAOMemoria implements AlunoDAO{
    public static AlunoDAOMemoria instancia;
    private ArrayList<Aluno> alunos;

    private AlunoDAOMemoria() {
        this.alunos = new ArrayList<>();
    }
    
    public static AlunoDAOMemoria getInstancia() {
        if (instancia == null) {
            instancia = new AlunoDAOMemoria();
        }
        
        return instancia;
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
