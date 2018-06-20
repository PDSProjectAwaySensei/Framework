/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Tarefa;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author jeck
 */
public class CriarQuestionarioController implements Initializable {

    @FXML
    private JFXListView<VBox> listaQuestoes;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private Button buttonAddQuestao;
    @FXML
    private JFXButton buttonSalvar;
    
    private Tarefa tarefa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    public CriarQuestionarioController(Tarefa tarefa){
        this.tarefa = tarefa;
    }

    @FXML
    private void cancelar(ActionEvent event) {
        ((JFXButton)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void addQuestao(ActionEvent event) {
        VBox box = new VBox();
        JFXTextField j = new JFXTextField();
        j.setDisable(true);
        box.getChildren().addAll(new JFXTextField(), j);
        listaQuestoes.getItems().add(box);
        
    }

    @FXML
    private void salvarQuestionario(ActionEvent event) {
        ArrayList<Questao> questoes = new ArrayList<>();
        ObservableList<VBox> items = listaQuestoes.getItems();
        for (VBox box : items){
            ObservableList<Node> children = box.getChildren();
            JFXTextField i = (JFXTextField)children.get(0);
            JFXTextField j = (JFXTextField)children.get(1);
            
            Questao q = new Questao(i.getText(), j.getText());
            questoes.add(q);
        }
        
        if (questoes != null){
            AtividadeQuestionario atividade = new AtividadeQuestionario();
            atividade.setQuestoes(questoes);
            this.tarefa.setAtividade(atividade);
            cancelar(event);
        }
    }
    
}
