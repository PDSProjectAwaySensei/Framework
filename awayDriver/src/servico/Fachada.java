/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import Dominio.Aluno;
import Dominio.Identificacao;
import Dominio.Tarefa;
import Dominio.Tutor;
import Servico.AlunoServico;
import Servico.TarefaServico;
import Servico.TutorServico;
import Servico.UsuarioServico;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jeck
 */
public class Fachada {
    public static Fachada instancia;
    protected UsuarioServico usuarioServico;
    protected AlunoServico alunoServico;
    protected TutorServico tutorServico;
    protected TarefaServico tarefaServico;
    
    protected Fachada(){
        this.usuarioServico = new UsuarioServico();
        this.alunoServico = new AlunoServicoAwayLanguage();
        this.tutorServico = new TutorServico();
        this.tarefaServico = new TarefaServicoAwayLaguage();
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
        Boolean sucessoCadastro = this.usuarioServico.cadastrar(usuario, mail, senha);
        return sucessoCadastro;
    }
    
    public void mudarTutor(Identificacao aluno, Identificacao tutor) throws IOException{
        this.alunoServico.mudarTutor(aluno, tutor);
    }
    
    public void cadastrarTarefa(Tutor tutor, Tarefa novaTarefa) {
        this.tutorServico.novaTarefa(tutor, novaTarefa);
    }

    public void enviarTarefas(Identificacao identificacao, ArrayList<Tarefa> tarefas, ArrayList<Aluno> selecionados) {
        this.tutorServico.enviarTarefas(identificacao, tarefas, selecionados);
    }
}
