/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import servico.Fachada;

/**
 * FXML Controller class
 *
 * @author jeck
 */
public class InicioController implements Initializable {

    @FXML
    private Button buttonEntrar;
    @FXML
    private Button buttonCadastrar;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrirEntrar(ActionEvent event) throws IOException {
        Main main = Main.getInstancia();
        main.telaEntrar();
    }

    @FXML
    private void abrirCadastrar(ActionEvent event) throws IOException {
        Main main = Main.getInstancia();
        main.telaCadastrar();
    }
    
}
