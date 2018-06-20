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
 *
 * @author jeckson
 */
public class VerCorrecaoController implements Initializable {
    @FXML 
    private JFXTextField nota;
    @FXML
    private JFXButton add;
    
    Tarefa tarefa;

    public VerCorrecaoController(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.add.setText("Sair");
        this.nota.setText(""+((ResultadoPontuacao)this.tarefa.getResultado()).getNota());
        this.nota.setEditable(false);
    }    
    
    @FXML
    public void setNota(ActionEvent event) {
        ((JFXButton)event.getTarget()).getScene().getWindow().hide(); 
    }
    
    @FXML 
    private void cancelar(ActionEvent event) { 
        ((JFXButton)event.getTarget()).getScene().getWindow().hide(); 
    }
    
    @FXML
    private void salvarAvaliacao(ActionEvent event) {}
}
