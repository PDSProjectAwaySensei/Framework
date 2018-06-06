/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.InformacaoPessoal;
import Dominio.Tarefa;
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
    private JFXListView tarefas;
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
        desabilitarCampos();
        
        atualizarListaTarefas();
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
        Tutor novo = tutor;
        InformacaoPessoal novoPerfil = new InformacaoPessoal(textNome.getText(),
                                                             textEmail.getText(),
                                                             textDescricao.getText());
        novo.setInformacaoPessoal(novoPerfil);
        novo.getIdentificacao().setUsuario(textUsuario.getText());
        
        Fachada fachada = Fachada.getInstancia();
        fachada.getUsuarioServico().salvarPerfil(tutor, novo);
        
        tutor = novo;
    }

    @FXML
    private void sair(ActionEvent event) throws IOException {
        Main.getInstancia().telaInicial();
    }

    @FXML
    private void adicionaTarefa(ActionEvent event) throws IOException {
        Main.getInstancia().telaNovaTarefa(tutor, new Tarefa());
    }
    
    @FXML
    private void editarTarefa(ActionEvent event) throws IOException{
        Tarefa tarefa = tutor.getListaDeTarefasSalvas().remove(tarefas.getSelectionModel().getSelectedIndex());
        Main.getInstancia().telaNovaTarefa(tutor, tarefa);
    }

    @FXML
    private void removerTarefa(ActionEvent event) {
        Fachada.getInstancia().removerTarefa(tutor,
                tutor.getListaDeTarefasSalvas().get(tarefas.getSelectionModel().getSelectedIndex()));        
    }
    
    @FXML
    private void enviarTarefa(ActionEvent event) throws IOException {
        Tarefa tarefa = tutor.getListaDeTarefasSalvas().get(tarefas.getSelectionModel().getSelectedIndex());
        Main.getInstancia().telaEnviarTarefa(tutor, tarefa);
    }
    
    @FXML
    private void atualizarListaTarefas(ActionEvent event) {
        atualizarListaTarefas();
    }
    
    void atualizarListaTarefas(){
        tarefas.getItems().clear();
        tutor.getListaDeTarefasSalvas().forEach((i) -> {
            tarefas.getItems().add(i.getNomeTarefa() + " : " + i.getDescricao());
        });
    }
    
}
