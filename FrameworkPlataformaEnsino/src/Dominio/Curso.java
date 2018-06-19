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
    private ArrayList<Tarefa> tarefas;
    private final ArrayList<Mensagem> mensagens;
    public int debito;

    public Curso(Identificacao aluno, Identificacao tutor) {
        this.aluno = aluno;
        this.tutor = tutor;
        this.tarefas = new ArrayList<>();  
        this.mensagens = new ArrayList<>();
    }
    
    public Identificacao getTutor() {
        return this.tutor;
    }

    public void setTutor(Identificacao tutor) {
        if (tutor != null)
            this.tutor = tutor;
    }

    public ArrayList<Tarefa> getTarefas() {
        return this.tarefas;
    }
    
    public ArrayList<Tarefa> getTarefasRespondidas() {
        ArrayList<Tarefa> respondidas = new ArrayList<>();
        
        for (Tarefa tarefa : this.tarefas) {
            if (tarefa.getAtividade() != null) {
                respondidas.add(tarefa);
            }
        }
        return respondidas;
    }
    
    public ArrayList<Tarefa> getTarefasCorrigidas() {
        ArrayList<Tarefa> corrigidas = new ArrayList<>();
        
        for (Tarefa tarefa : this.tarefas) {
            if (tarefa.getAtividade().getResultado() >= 0) {
                corrigidas.add(tarefa);
            }
        }
        return corrigidas;
    }

    public void setListaTarefas(ArrayList<Tarefa> listaTarefas) {
        this.tarefas = listaTarefas;
    }

    public Identificacao getAluno() {
        return this.aluno;
    }

    public void setAluno(Identificacao aluno) {
        this.aluno = aluno;
    }
    
    public void addtarefa(Tarefa tarefa){
        this.tarefas.add(tarefa);
    }

    public int getDebito() {
        return debito;
    }

    public void setDebito(int debito) {
        this.debito = debito;
    }
    
    public void addMesagem (Mensagem mensagem){
        this.mensagens.add(mensagem);
    }
    
    public ArrayList<Mensagem> listMesagems() {
        return this.mensagens;
    }
}
