/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Aluno;
import Dominio.Tutor;
import Servico.Fachada;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
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
 * @author jeck
 */
public class MudarTutorController implements Initializable {

    @FXML
    private JFXListView listaTutores;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private JFXButton buttonSelecionarTutor;
    
    private ArrayList<Tutor> tutores;
    private Aluno aluno;

    public MudarTutorController(ArrayList<Tutor> tutores, Aluno aluno) {
        this.tutores = tutores;
        this.aluno = aluno;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tutores.forEach((i) -> {
            listaTutores.getItems().add(i.getInformacaoPessoal().getNome());
        });
    }    

    @FXML
    private void cancelar(ActionEvent event) {
        ((JFXButton)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void selecionarTutor(ActionEvent event) throws IOException {
        Tutor novoTutor = tutores.get(listaTutores.getSelectionModel().getSelectedIndex());
        Fachada fachada = Fachada.getInstancia();
        fachada.mudarTutor(aluno, novoTutor);
        cancelar(event);
    }
    
}
