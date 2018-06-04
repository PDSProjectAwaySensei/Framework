/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Dominio.Aluno;
import Dominio.Tarefa;
import Dominio.Tutor;
import Dominio.Usuario;
import Visual.Controller.AlunoController;
import Visual.Controller.TutorController;
import Visual.Controller.MudarTutorController;
import Visual.Controller.NovaTarefaController;
import java.io.IOException;
import java.lang.String;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
        usuarioServico = new UsuarioServico();
        alunoServico = new AlunoServico();
        tutorServico = new TutorServico();
    }
    
    public static Fachada getInstancia(){
        if (instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }

    public UsuarioServico getUsuarioServico() {
        return usuarioServico;
    }

    public AlunoServico getAlunoServico() {
        return alunoServico;
    }
    
    public TutorServico getTutorServico() {
        return tutorServico;
    }
    
    public void iniciar(Stage primaryStage) throws IOException{
        stage = primaryStage;
        telaInicial();
    }
    
    public void telaInicial() throws IOException{
        Scene telaInicial;
        telaInicial = new Scene((new FXMLLoader(getClass().getResource("/Visual/fxml/Inicio.fxml")).load()));
        stage.setScene(telaInicial);
        stage.show();
    }
    
    public void telaEntrar() throws IOException{
        Scene telaEntrar;
        telaEntrar = new Scene((new FXMLLoader(getClass().getResource("/Visual/fxml/Entrar.fxml")).load()));
        stage.setScene(telaEntrar);
        stage.show();
    }
    
    public void telaCadastrar() throws IOException{
        Scene telaCadastrar;
        telaCadastrar = new Scene((new FXMLLoader(getClass().getResource("/Visual/fxml/Cadastrar.fxml")).load()));
        stage.setScene(telaCadastrar);
        stage.show();
    }
    
    public void usuarioEntrar(String usuario, String senha) throws IOException{
        Usuario user;
        user = usuarioServico.usuarioEntrar(usuario, senha);
 
        if (user != null){
            if (user instanceof Aluno){
                FXMLLoader loaderTelaAluno = (new FXMLLoader(getClass().getResource("/Visual/fxml/Aluno.fxml")));
                loaderTelaAluno.setController(new AlunoController((Aluno) user));
                Scene telaAluno = new Scene(loaderTelaAluno.load());
                stage.setScene(telaAluno);
                stage.show();
            } else if (user instanceof Tutor){
                FXMLLoader loaderTelaTutor = (new FXMLLoader(getClass().getResource("/Visual/fxml/Tutor.fxml")));
                loaderTelaTutor.setController(new TutorController((Tutor) user));
                Scene telaTutor = new Scene(loaderTelaTutor.load());
                stage.setScene(telaTutor);
                stage.show();
            }
        }
    }

    public Boolean usuarioCadastrar(String usuario, String mail, String senha) {
        Boolean sucessoCadastro = usuarioServico.usuarioCadastrar(usuario, mail, senha);
        return sucessoCadastro;
    }

    public void telaMudarTutor(Aluno aluno) throws IOException {
        Stage stageListaTutores = new Stage();
        FXMLLoader loaderTelaMudarTutor = (new FXMLLoader(getClass().getResource("/Visual/fxml/MudarTutor.fxml")));
        loaderTelaMudarTutor.setController(new MudarTutorController(usuarioServico.getTutores(), aluno));
        stageListaTutores.setScene(new Scene(loaderTelaMudarTutor.load()));
        stageListaTutores.show();
    }
    
    public void mudarTutor(Aluno aluno, Tutor tutor) throws IOException{
        alunoServico.mudarTutor(aluno, tutor);
        //Desloga o Aluno apos mudar Sensei
        telaEntrar();
    }

    public void telaNovaTarefa(Tutor tutor) throws IOException {
        Stage stageNovaTarefa = new Stage();
        FXMLLoader loaderTelaNovaTarefa = (new FXMLLoader(getClass().getResource("/Visual/fxml/NovaTarefa.fxml")));
        loaderTelaNovaTarefa.setController(new NovaTarefaController(tutor));
        stageNovaTarefa.setScene(new Scene(loaderTelaNovaTarefa.load()));
        stageNovaTarefa.show();
    }
    
    public void novaTarefa(Tutor tutor, Tarefa tarefa){
        tutorServico.adicionarTarefa(tutor, tarefa);
    }
}
