/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Aluno;
import Dominio.Tarefa;
import Dominio.Tutor;
import Dominio.Usuario;
import Servico.Fachada;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author oem
 */
public class Main {
    public static Main instancia;
    private Stage stage;
    
    protected Main(){}
    
    public static Main getInstancia(){
        if (instancia == null){
            instancia = new Main();
        }
        return instancia;
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
        Fachada fachada = Fachada.getInstancia();
        user = fachada.getUsuarioServico().usuarioEntrar(usuario, senha);
 
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
    
    public void telaMudarTutor(Aluno aluno) throws IOException {
        Stage stageListaTutores = new Stage();
        FXMLLoader loaderTelaMudarTutor = (new FXMLLoader(getClass().getResource("/Visual/fxml/MudarTutor.fxml")));
        
        Fachada fachada = Fachada.getInstancia();
        
        loaderTelaMudarTutor.setController(new MudarTutorController(fachada.getUsuarioServico().getTutores(), aluno));
        stageListaTutores.setScene(new Scene(loaderTelaMudarTutor.load()));
        stageListaTutores.show();
    }
  
    public void telaNovaTarefa(Tutor tutor, Tarefa tarefa) throws IOException {
        Stage stageNovaTarefa = new Stage();
        FXMLLoader loaderTelaNovaTarefa = (new FXMLLoader(getClass().getResource("/Visual/fxml/NovaTarefa.fxml")));
        loaderTelaNovaTarefa.setController(new NovaTarefaController(tutor, tarefa));
        stageNovaTarefa.setScene(new Scene(loaderTelaNovaTarefa.load()));
        stageNovaTarefa.show();
    }
    
    public void telaEnviarTarefa(Tutor tutor, Tarefa tarefa) throws IOException{
        Stage stageEnviarTarefa = new Stage();
        FXMLLoader loaderTelaEnviarTarefa = (new FXMLLoader(getClass().getResource("/Visual/fxml/EnviarTarefa.fxml")));
        loaderTelaEnviarTarefa.setController(new EnviarTarefaController(tutor, tarefa));
        stageEnviarTarefa.setScene(new Scene(loaderTelaEnviarTarefa.load()));
        stageEnviarTarefa.show();
    }
}
