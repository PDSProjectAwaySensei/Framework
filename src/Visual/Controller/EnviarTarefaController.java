/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Aluno;
import Dominio.Tarefa;
import Dominio.Tutor;
import Servico.Fachada;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author jeckson
 */
public class EnviarTarefaController implements Initializable {

    @FXML
    private JFXListView listaAlunos;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private JFXButton buttonSelecionarAlunos;
    
    private Tutor tutor;
    private Tarefa tarefa;

    public EnviarTarefaController(Tutor tutor, Tarefa tarefa) {
        this.tutor = tutor;
        this.tarefa = tarefa;        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tutor.getListaDeCursos().forEach((i) -> {
            listaAlunos.getItems().add(i.getAluno().getInformacaoPessoal().getNome());
        });
    }    

    @FXML
    private void cancelar(ActionEvent event) {
        ((JFXButton)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void selecionarAlunos(ActionEvent event) {
        ObservableList selectedIndices = listaAlunos.getSelectionModel().getSelectedIndices();
        ArrayList<Integer> selecionados = new ArrayList<>();
        for (Object i : selectedIndices){
            selecionados.add((Integer) i);
        }
        Fachada.getInstancia().enviarTarefa(tutor, tarefa, selecionados);

    }
    
}
