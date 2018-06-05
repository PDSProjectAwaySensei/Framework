/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Aluno;
import Dominio.InformacaoPessoal;
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

    /* Tutor */
    @FXML
    private JFXTextField textTutorUsuario;
    @FXML
    private JFXTextField textTutorNome;
    @FXML
    private JFXTextField textTutorEmail;
    @FXML
    private JFXTextArea textTutorDescricao;
    
    @FXML
    private JFXButton buttonSair;
    @FXML
    private JFXButton buttonFaixa;
    @FXML
    private ImageView picTutor;

    @FXML
    private JFXButton buttonMudarTutor;
    
    @FXML
    private JFXListView listaTarefasAluno;

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
        desabilitarCampos();
        
        if (aluno.getCurso() != null){
            textTutorUsuario.setText(aluno.getCurso().getTutor().getIdentificacao().getUsuario());
            textTutorNome.setText(aluno.getCurso().getTutor().getInformacaoPessoal().getNome());
            textTutorEmail.setText(aluno.getCurso().getTutor().getInformacaoPessoal().getEmail());
            textTutorDescricao.setText(aluno.getCurso().getTutor().getInformacaoPessoal().getDescricao() );
        }
        
        if (aluno.getCurso() != null){
            aluno.getCurso().getListaTarefas().forEach((i) -> {
                listaTarefasAluno.getItems().add(i.getNomeTarefa() + " : " + i.getDescricao());
            });
        }
    }

    @FXML
    private void editarFoto(MouseEvent event) {
    }

    @FXML
    private void desbloquearPerfil(ActionEvent event) {
        if (togglePerfilEditavel.isSelected() ){
            desabilitarCampos();
        } else {
            desabilitarCampos();
            salvarPerfil();
        }
    }
    
    private void desabilitarCampos(){
        textUsuario.setDisable(!textUsuario.isDisabled());
        textNome.setDisable(!textNome.isDisabled());
        textEmail.setDisable(!textEmail.isDisabled());
        textDescricao.setDisable(!textDescricao.isDisabled());
    }
    
    private void salvarPerfil(){
        Aluno novo = aluno;
        InformacaoPessoal novoPerfil = new InformacaoPessoal(textNome.getText(),
                                                             textEmail.getText(),
                                                             textDescricao.getText());
        novo.setInformacaoPessoal(novoPerfil);
        novo.getIdentificacao().setUsuario(textUsuario.getText());
        
        Fachada fachada = Fachada.getInstancia();
        fachada.getUsuarioServico().salvarPerfil(aluno, novo);
        
        aluno = novo;
    }

    @FXML
    private void sair(ActionEvent event) throws IOException {
        Fachada fachada = Fachada.getInstancia();        
        fachada.telaInicial();
    }

    @FXML
    private void mudarTutor(ActionEvent event) throws IOException {
        Fachada fachada = Fachada.getInstancia();        
        fachada.telaMudarTutor(aluno);
    }
    
}
