/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Dominio.Aluno;
import Dominio.Tarefa;
import Dominio.Tutor;
import java.io.IOException;
import java.util.ArrayList;
import javafx.stage.Stage;

/**
 *
 * @author jeck
 */
public class Fachada {
    public static Fachada instancia;
    
    protected UsuarioServico usuarioServico;
    protected AlunoServico alunoServico;
    protected TutorServico tutorServico;
    
    private Stage stage;
    
    protected Fachada(){
        this.usuarioServico = new UsuarioServico();
        this.alunoServico = new AlunoServico();
        this.tutorServico = new TutorServico();
    }
    
    public static Fachada getInstancia(){
        if (instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }

    public UsuarioServico getUsuarioServico() {
        return this.usuarioServico;
    }

    public AlunoServico getAlunoServico() {
        return this.alunoServico;
    }
    
    public TutorServico getTutorServico() {
        return this.tutorServico;
    }

    public Boolean usuarioCadastrar(String usuario, String mail, String senha) {
        Boolean sucessoCadastro = this.usuarioServico.usuarioCadastrar(usuario, mail, senha);
        return sucessoCadastro;
    }
    
    public void mudarTutor(Aluno aluno, Tutor tutor) throws IOException{
        this.alunoServico.mudarTutor(aluno, tutor);
    }
    
    public void novaTarefa(Tutor tutor, Tarefa tarefa){
        this.tutorServico.adicionarTarefa(tutor, tarefa);
    }
    
    public void removerTarefa(Tutor tutor, Tarefa tarefa){
        this.tutorServico.removerTarefa(tutor, tarefa);
    }
    
    public void enviarTarefa(Tutor tutor, Tarefa tarefa, ArrayList<Integer> selecionados){
        this.tutorServico.enviarTarefa(tutor, tarefa, selecionados);
    }
    
}
