/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Curso;
import Dominio.Tarefa;
import com.jfoenix.controls.JFXButton;
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
public class CorrigirAtividadeController implements Initializable {

    @FXML
    private JFXTextField pontos;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private JFXButton buttonSalvar;

    Curso curso;
    Tarefa tarefa;
    CorrigirAtividadeController(Curso curso, Tarefa tarefa) {
        this.curso = curso;
        this.tarefa = tarefa;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Do Nothing
    }    

    @FXML
    private void cancelar(ActionEvent event) {
        ((JFXButton)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void salvarAvaliacao(ActionEvent event) {
        if (pontos.getText().isEmpty() == false){
            tarefa.getAtividade().setResultado(Float.parseFloat(pontos.getText()));
            
            System.err.println("Nota atribuída:"+tarefa.getAtividade().getResultado());
            
            cancelar(event);
        }
    }
//    
}
