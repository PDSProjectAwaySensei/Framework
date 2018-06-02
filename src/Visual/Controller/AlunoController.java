/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Aluno;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author jeck
 */
public class AlunoController implements Initializable {

    @FXML
    private ImageView picFoto;
    
    /* Perfil */
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
    private JFXButton buttonFaixa;
    @FXML
    private ImageView picTutor;
    @FXML
    private Label textTutorNome;
    @FXML
    private JFXButton buttonMudarTutor;

    private Aluno aluno;

    public AlunoController(Aluno user) {
        aluno = user;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        textUsuario.setText(aluno.getIdentificacao().getUsuario());        
        textNome.setText(aluno.getInformacaoPessoal().getNome());        
        textEmail.setText(aluno.getInformacaoPessoal().getEmail());        
        textDescricao.setText(aluno.getInformacaoPessoal().getNome());
    }

    @FXML
    private void editarFoto(MouseEvent event) {
    }

    @FXML
    private void desbloquearPerfil(ActionEvent event) {
    }

    @FXML
    private void sair(ActionEvent event) {
    }

    @FXML
    private void mudarTutor(ActionEvent event) {
    }
    
}
