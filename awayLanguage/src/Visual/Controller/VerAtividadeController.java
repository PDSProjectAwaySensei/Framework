/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Tarefa;
import dominio.AtividadeQuestionario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import dominio.RespostaQuestionario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

/**
 *
 * @author jeckson
 */
public class VerAtividadeController implements Initializable{
    @FXML
    private JFXListView<VBox> listaQuestoes;
    @FXML 
    private JFXButton buttonCancelar; 
    @FXML 
    private JFXButton buttonSalvar; 
    
    Tarefa tarefa;
    public VerAtividadeController(Tarefa tarefa) {
        this.tarefa = tarefa;
    }    
    /** 
     * Initializes the controller class. 
     */ 
    public void initialize(URL url, ResourceBundle rb) { 
        buttonSalvar.setText("Avaliar");
         
        ArrayList<String> questoes = ((AtividadeQuestionario) tarefa.getAtividade()).getQuestoes();
        ArrayList<String> respostas = ((RespostaQuestionario) tarefa.getResposta()).getRespostas();
        
        for (int i = 0; i < questoes.size(); i++) {
            JFXTextField enunciado = new JFXTextField(questoes.get(i));
            JFXTextField resposta = new JFXTextField(respostas.get(i));
            enunciado.setEditable(true);
            resposta.setDisable(false);
            VBox box = new VBox();
            box.getChildren().addAll(enunciado, resposta);
            listaQuestoes.getItems().add(box);
        }
    }     
 
    @FXML 
    private void cancelar(ActionEvent event) { 
        ((JFXButton)event.getTarget()).getScene().getWindow().hide(); 
    }
    
    @FXML
    private void addQuestao(ActionEvent event) {}
 
    @FXML 
    private void salvarQuestionario(ActionEvent event) throws IOException {
        Main.getInstancia().atribuirNota(tarefa);
    }  
}