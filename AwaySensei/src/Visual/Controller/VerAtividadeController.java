/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Tarefa;
import awaySensei.AtividadeVideo;
import awaySensei.RespostaVideo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author jeckson
 */
public class VerAtividadeController implements Initializable{
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
    
    Tarefa tarefa;
    public VerAtividadeController(Tarefa tarefa) {
        this.tarefa = tarefa;
    }    
    /** 
     * Initializes the controller class. 
     */ 
    public void initialize(URL url, ResourceBundle rb) { 
        textLinkTutor.setDisable(true); 
        textComTutor.setDisable(true);
        textComAluno.setDisable(true);
        buttonSalvar.setDisable(true);
         
        textLinkTutor.setText(((AtividadeVideo)tarefa.getAtividade()).getLinkVideoTutor()); 
        textComTutor.setText(((AtividadeVideo)tarefa.getAtividade()).getComVideoTutor());
        textLinkAluno.setText(((RespostaVideo)tarefa.getResposta()).getLinkVideo());
        textComAluno.setText(((RespostaVideo)tarefa.getResposta()).getComentario());
    }     
 
    @FXML 
    private void cancelar(ActionEvent event) { 
        ((JFXButton)event.getTarget()).getScene().getWindow().hide(); 
    } 
 
    @FXML 
    private void criarAtividade(ActionEvent event) { 
        //
    }    
}