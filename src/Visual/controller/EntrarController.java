/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Servico.Fachada;

/**
 * FXML Controller class
 *
 * @author jeck
 */
public class EntrarController implements Initializable {

    @FXML
    private JFXButton buttonLogin;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private JFXTextField textUsuario;
    @FXML
    private JFXPasswordField textSenha;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void entrar(ActionEvent event) {
        Fachada fachada = Fachada.getInstancia();
        fachada.usuarioEntrar(textUsuario.getText(), textSenha.getText());
        
        this.textUsuario.clear();
        this.textSenha.clear();
    }

    @FXML
    private void cancelar(ActionEvent event) {
    }
    
}