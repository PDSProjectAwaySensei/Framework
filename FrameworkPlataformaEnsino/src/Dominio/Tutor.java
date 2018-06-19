package Dominio;

import java.util.ArrayList;

public class Tutor extends Usuario {
    private ArrayList<Curso> listaDeCursos;
    private ArrayList<Tarefa> tarefas;

    public Tutor(Identificacao identificacao, InformacaoPessoal informacaoPessoal) {
        super(identificacao, informacaoPessoal);
        this.listaDeCursos = new ArrayList<>();
        this.tarefas = new ArrayList<>();
    }

    public Tutor(ArrayList<Curso> listaDeCursos, ArrayList<Tarefa> listaDeTarefasSalvas, Identificacao identificacao, InformacaoPessoal informacaoPessoal) {
        super(identificacao, informacaoPessoal);
        this.listaDeCursos = listaDeCursos;
    }
    
    public ArrayList<Curso> getCursos() {
        return this.listaDeCursos;
    }

    public void setCursos(ArrayList<Curso> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }
    
    public void addCurso(Curso curso) {
        this.listaDeCursos.add(curso);
    }
    
    public void addTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
    }

    public ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
}
