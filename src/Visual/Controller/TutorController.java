/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Tutor;
import Servico.Fachada;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author jeck
 */
public class TutorController implements Initializable {

    @FXML
    private ImageView picFoto;
    @FXML
    private JFXTextField textUsuario;
    @FXML
    private JFXTextField textNome;
    @FXML
    private JFXTextField textEmail;
    @FXML
    private JFXTextArea textDescricao;
    @FXML
    private JFXToggleButton togglePerfilEditavel;
    @FXML
    private JFXButton buttonSair;
    @FXML
    private JFXListView<?> treinos;
    @FXML
    private JFXListView<?> pupilos;
    
    
    private Tutor tutor;
    
    public TutorController(Tutor user){
        tutor = user;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textUsuario.setText(tutor.getIdentificacao().getUsuario());        
        textNome.setText(tutor.getInformacaoPessoal().getNome());        
        textEmail.setText(tutor.getInformacaoPessoal().getEmail());        
        textDescricao.setText(tutor.getInformacaoPessoal().getNome());
    }    

    @FXML
    private void editarFoto(MouseEvent event) {
    }

    @FXML
    private void desbloquearPerfil(ActionEvent event) {
    }

    @FXML
    private void sair(ActionEvent event) throws IOException {
        Fachada fachada = Fachada.getInstancia();        
        fachada.telaInicial();
    }

    @FXML
    private void adicionaTarefa(ActionEvent event) {
    }

    @FXML
    private void removeTarefa(ActionEvent event) {
    }
    
}
