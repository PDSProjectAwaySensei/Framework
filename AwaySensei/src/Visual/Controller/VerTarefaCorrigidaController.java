/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Tarefa;
import awaySensei.AvaliacaoComentario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author jeckson
 */
public class VerTarefaCorrigidaController implements Initializable {
    @FXML
    private JFXTextArea textAvaliacaoTutor;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private JFXButton buttonSalvar;

    Tarefa tarefa;
    public VerTarefaCorrigidaController(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonSalvar.setDisable(true);
        textAvaliacaoTutor.setText(((AvaliacaoComentario)tarefa.getAvaliacao()).getAvaliacaoTutor());
    }    
    
        @FXML
    private void cancelar(ActionEvent event) {
        ((JFXButton)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void salvarAvaliacao(ActionEvent event) {
        //Do Nothing
    }
}
