/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Atividade;
import Dominio.Tarefa;
import Dominio.Tutor;
import Servico.Fachada;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author jeckson
 */


public class NovaTarefaController implements Initializable {
    private Tutor tutor;
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

    /**
     * Initializes the controller class.
     */

    @FXML
    private void criarAtividade(ActionEvent event) {
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }

    @FXML
    private void criarTarefa(ActionEvent event) {
        if (atividade != null){
            Tarefa novaTarefa = new Tarefa(textNomeTarefa.getText(), 
                                           textDescricao.getText(), atividade);
            // Inserir Tarefa no Sensei
            Fachada.getInstancia().novaTarefa(tutor, novaTarefa);
            cancelar(event);
        } else {
            //Não Criar Tarefa
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
