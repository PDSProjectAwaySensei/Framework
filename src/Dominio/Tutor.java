package Dominio;

import java.util.ArrayList;

public class Tutor extends Usuario {
    private ArrayList<Curso> listaDeCursos;
    private ArrayList<Tarefa> listaDeTarefasSalvas;

    public Tutor(Identificacao identificacao, InformacaoPessoal informacaoPessoal) {
        super(identificacao, informacaoPessoal);
    }

    public ArrayList<Curso> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(ArrayList<Curso> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

    public ArrayList<Tarefa> getListaDeTarefasSalvas() {
        return listaDeTarefasSalvas;
    }

    public void setListaDeTarefasSalvas(ArrayList<Tarefa> listaDeTarefasSalvas) {
        this.listaDeTarefasSalvas = listaDeTarefasSalvas;
    }

}
