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
    private Identificacao aluno;
    private Identificacao tutor;
    private boolean status;
    private ArrayList<Tarefa> listaTarefas;

    public Curso(Identificacao aluno, Identificacao tutor) {
        this.aluno = aluno;
        this.tutor = tutor;
        this.status = false;
        this.listaTarefas = new ArrayList<>();        
    }
    
    public Identificacao getTutor() {
        return this.tutor;
    }

    public void setTutor(Identificacao tutor) {
        if (tutor != null)
            this.tutor = tutor;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<Tarefa> getListaTarefas() {
        return this.listaTarefas;
    }
    
    public ArrayList<Tarefa> getListaTarefasCorrigidas() {
        ArrayList<Tarefa> corrigidas = new ArrayList<>();
        
        for (Tarefa tarefa : this.listaTarefas) {
            if (tarefa.isCorrigida()) {
                corrigidas.add(tarefa);
            }
        }
        return corrigidas;
    }

    public void setListaTarefas(ArrayList<Tarefa> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public Identificacao getAluno() {
        return this.aluno;
    }

    public void setAluno(Identificacao aluno) {
        this.aluno = aluno;
    }
    
    public void addtarefa(Tarefa tarefa){
        this.listaTarefas.add(tarefa);
    }
}
