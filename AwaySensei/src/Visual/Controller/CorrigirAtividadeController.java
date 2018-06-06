/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Curso;
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
 * FXML Controller class
 *
 * @author jeckson
 */
public class CorrigirAtividadeController implements Initializable {

    @FXML
    private JFXTextArea textAvaliacaoTutor;
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
        if (textAvaliacaoTutor.getText().isEmpty() == false){
            tarefa.setAvaliacao(new AvaliacaoComentario(textAvaliacaoTutor.getText()));
            tarefa.getAvaliacao().setAvaliada(true);
            
            curso.getListaTarefasCorrigidas().add(tarefa);
            curso.getListaTarefasConcluidas().remove(tarefa);
            
            cancelar(event);
        }
    }
    
}
