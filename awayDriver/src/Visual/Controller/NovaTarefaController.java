/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Atividade;
import Dominio.Tarefa;
import Dominio.Tutor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import servico.Fachada;

/**
 * FXML Controller class
 *
 * @author jeckson
 */


public class NovaTarefaController implements Initializable {
    private Tutor tutor;
    private Tarefa tarefa;
    private Atividade atividade;
    
    @FXML
    private JFXTextField textNomeTarefa;
    @FXML
    private JFXTextArea textDescricao;
    @FXML
    private JFXButton buttonCriarAtividade;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private JFXButton buttonCriarTarefa;

    public NovaTarefaController(Tutor tutor, Tarefa tarefa) {
        this.tutor = tutor;
        this.tarefa = tarefa;
    }

    /**
     * Initializes the controller class.
     */
    
    

    @FXML
    private void criarAtividade(ActionEvent event) throws IOException {
        buttonCriarAtividade.setStyle("-fx-background-color: transparent;");
        
        Stage stageNovaAtividade = new Stage();
        FXMLLoader loaderTelaNovaAtividade = (new FXMLLoader(getClass().getResource("/Visual/fxml/CriarQuestionario.fxml")));
        loaderTelaNovaAtividade.setController(new CriarQuizController(tarefa));
        stageNovaAtividade.setScene(new Scene(loaderTelaNovaAtividade.load()));
        stageNovaAtividade.show();
        
        // PONTO FLEXÍVEL        
    }

    @FXML
    private void cancelar(ActionEvent event) {
        ((JFXButton)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void criarTarefa(ActionEvent event) {
        
        if (tarefa.getAtividade() != null){
            // Inserir Tarefa no Sensei
            tarefa.setNomeTarefa(textNomeTarefa.getText());
            tarefa.setDescricao(textDescricao.getText());
            Fachada.getInstancia().cadastrarTarefa(tutor, tarefa);
            cancelar(event);
        } else {
            //Não Criar Tarefa
            buttonCriarAtividade.setStyle("-fx-background-color: red;");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (tarefa.getNomeTarefa() != null)
            textNomeTarefa.setText(tarefa.getNomeTarefa());
        if (tarefa.getDescricao() != null)
            textDescricao.setText(tarefa.getDescricao());
    }
    
}
