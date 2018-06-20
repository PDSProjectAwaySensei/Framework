/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Tarefa;
import awaySensei.AtividadeVideo;
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
public class CriarAtividadeController implements Initializable {

    @FXML
    private JFXTextField textLinkTutor;
    @FXML
    private JFXTextArea textComTutor;
    @FXML
    private JFXTextField textLinkAluno;
    @FXML
    private JFXTextArea textComAluno;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private JFXButton buttonSalvar;
    
    private Tarefa tarefa;

    public CriarAtividadeController(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textLinkAluno.setDisable(true);
        textComAluno.setDisable(true);
    }    

    @FXML
    private void cancelar(ActionEvent event) {
        ((JFXButton)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void criarAtividade(ActionEvent event) {
        if (textLinkTutor.getText().isEmpty() == false) {
            AtividadeVideo atividade = new AtividadeVideo(textLinkTutor.getText(), textComTutor.getText());
            this.tarefa.setAtividade(atividade);
            cancelar(event);
        }
    }
    
}
