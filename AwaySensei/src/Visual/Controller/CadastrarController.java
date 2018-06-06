/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Servico.Fachada;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author jeck
 */
public class CadastrarController implements Initializable {

    @FXML
    private Button cancel;
    @FXML
    private Button buttonCadastrar;
    @FXML
    private Button buttonCancelar;
    @FXML
    private JFXTextField textUsuario;
    @FXML
    private JFXTextField textMail;
    @FXML
    private JFXPasswordField textSenha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cadastrar(ActionEvent event) throws IOException {
        Fachada fachada = Fachada.getInstancia();
        Boolean sucessoCadastro = fachada.usuarioCadastrar(textUsuario.getText(), textMail.getText(), textSenha.getText());
        if (sucessoCadastro){
            voltar();
        } else {
            //Nao deu certo
        }
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        voltar();
    }
    
    private void limparCampos(){
        this.textUsuario.clear();
        this.textMail.clear();
        this.textSenha.clear();
    }
    
    private void voltar() throws IOException{
        limparCampos();
        Main main = Main.getInstancia();        
        main.telaInicial();
    }
    
}
