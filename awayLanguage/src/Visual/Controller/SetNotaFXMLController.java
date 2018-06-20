/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Tarefa;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import servico.ResultadoPontuacao;

/**
 * FXML Controller class
 *
 * @author José Carlos
 */
public class SetNotaFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    private JFXTextField nota;
    
    Tarefa tarefa;

    public SetNotaFXMLController(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    public void setNota(ActionEvent event) {
        this.tarefa.setResultado(new ResultadoPontuacao(Float.parseFloat(this.nota.getText())));
        
        ((JFXButton)event.getTarget()).getScene().getWindow().hide(); 
    }
}
