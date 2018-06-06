/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Aluno;
import Dominio.Curso;
import Dominio.Tarefa;
import Dominio.Tutor;
import Dominio.Usuario;
import Servico.Fachada;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * CAMADA DE WORKFLOW
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

    void telaResponderTarefa(Aluno aluno, Tarefa tarefa) throws IOException {
        Stage stageResponderAtividade = new Stage(); 
        FXMLLoader loaderTelaResponderAtividade = (new FXMLLoader(getClass().getResource("/awaySensei/CriarAtividade.fxml"))); 
        loaderTelaResponderAtividade.setController(new ResponderAtividadeController(aluno, tarefa)); 
        stageResponderAtividade.setScene(new Scene(loaderTelaResponderAtividade.load()));
        stageResponderAtividade.show();
    }
    
    void telaEscolherTarefas(Curso curso) throws IOException{
        Stage stageEscolherTarefas = new Stage();
        FXMLLoader loaderTelaEscolherTarefas = (new FXMLLoader(getClass().getResource("/Visual/fxml/EscolherTarefa.fxml")));
        loaderTelaEscolherTarefas.setController(new EscolherTarefaController(curso));
        stageEscolherTarefas.setScene(new Scene(loaderTelaEscolherTarefas.load()));
        stageEscolherTarefas.show();
    }

    public void telaAvaliarTarefa(Curso curso, Tarefa tarefa) throws IOException {
        //Abrir Tarefa Bloqueada
        Stage stageVerAtividade = new Stage(); 
        FXMLLoader loaderTelaVerAtividade = (new FXMLLoader(getClass().getResource("/awaySensei/CriarAtividade.fxml"))); 
        loaderTelaVerAtividade.setController(new VerAtividadeController(tarefa)); 
        stageVerAtividade.setScene(new Scene(loaderTelaVerAtividade.load()));
        stageVerAtividade.show();
        
        //Abrir Tela de Corrigir
        Stage stageCorrigirTarefa = new Stage();
        FXMLLoader loaderTelaCorrigirTarefa = (new FXMLLoader(getClass().getResource("/awaySensei/CorrigirAtividade.fxml")));
        loaderTelaCorrigirTarefa.setController(new CorrigirAtividadeController(curso, tarefa));
        stageCorrigirTarefa.setScene(new Scene(loaderTelaCorrigirTarefa.load()));
        stageCorrigirTarefa.show();
    }

    void telaVerAvaliacao(Tarefa tarefa) throws IOException {
        Stage stageVerTarefaCorrigida = new Stage();
        FXMLLoader loaderTelaVerTarefaCorrigida = (new FXMLLoader(getClass().getResource("/awaySensei/CorrigirAtividade.fxml")));
        loaderTelaVerTarefaCorrigida.setController(new VerTarefaCorrigidaController(tarefa));
        stageVerTarefaCorrigida.setScene(new Scene(loaderTelaVerTarefaCorrigida.load()));
        stageVerTarefaCorrigida.show();
    }

    void telaPagarCurso() throws IOException {
        Stage stagePagamento = new Stage();
        FXMLLoader loaderPagamento = (new FXMLLoader(getClass().getResource("/Visual/fxml/telaPagamento.fxml")));
        stagePagamento.setScene(new Scene(loaderPagamento.load()));
        stagePagamento.show();
    }
}
