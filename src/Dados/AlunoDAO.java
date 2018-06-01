package Dados;

import Dominio.Aluno;
import dominio.usuario.Identificacao;
import java.util.ArrayList;

public interface AlunoDAO {
    public abstract Boolean inserirAluno(Aluno aluno);
    public abstract void removerAluno(Aluno aluno);
    public abstract void editarAluno(Aluno aluno1, Aluno aluno2);
    public abstract ArrayList<Aluno> listarAlunos();
    public abstract Aluno getAluno(Identificacao idEntrar);
}
