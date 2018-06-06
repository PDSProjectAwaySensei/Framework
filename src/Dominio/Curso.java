/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author jeck
 */
public class Curso {
    private Aluno aluno;
    //Tutor Não pode ser nulo
    private Tutor tutor;
    private Pagamento pagamento;
    private boolean status;
    private ArrayList<Tarefa> listaTarefas;
    private ArrayList<Tarefa> listaTarefasConcluidas;

    public Curso(Aluno aluno, Tutor tutor) {
        this.aluno = aluno;
        this.tutor = tutor;
        pagamento = null;
        status = false;
        listaTarefas = new ArrayList<>();
        listaTarefasConcluidas = new ArrayList<>();
    }
    
    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        if (tutor != null)
            this.tutor = tutor;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(ArrayList<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public ArrayList<Tarefa> getListaTarefasConcluidas() {
        return listaTarefasConcluidas;
    }

    public void setListaTarefasConcluidas(ArrayList<Tarefa> listaTarefasConcluidas) {
        this.listaTarefasConcluidas = listaTarefasConcluidas;
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
