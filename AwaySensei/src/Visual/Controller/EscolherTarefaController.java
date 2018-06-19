/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Curso;
import Dominio.Tarefa;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
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
public class EscolherTarefaController implements Initializable {

    @FXML
    private JFXListView listaTarefasConcluidas;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private JFXButton buttonSelecionarTarefa;

    Curso curso;
    public EscolherTarefaController(Curso curso) {
        this.curso = curso;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaTarefasConcluidas.getItems().clear();
        curso.getTarefasRespondidas().forEach((i) -> {
            listaTarefasConcluidas.getItems().add(i.getNomeTarefa());
        });
    }    

    @FXML
    private void cancelar(ActionEvent event) {
        ((JFXButton)event.getTarget()).getScene().getWindow().hide(); 
    }

    @FXML
    private void selecionarTarefa(ActionEvent event) throws IOException {
        if (curso.getTarefasRespondidas() != null && curso.getTarefasRespondidas().size() > 0) {
            Tarefa tarefa = curso.getTarefasRespondidas().get(listaTarefasConcluidas.getSelectionModel().getSelectedIndex());
            Main.getInstancia().telaAvaliarTarefa(curso, tarefa);
        }
    }
}
