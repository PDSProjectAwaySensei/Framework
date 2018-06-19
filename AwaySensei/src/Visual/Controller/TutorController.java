/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dados.TutorDAOMemoria;
import Dominio.Curso;
import Dominio.InformacaoPessoal;
import Dominio.Mensagem;
import Dominio.Tarefa;
import Dominio.Tutor;
import servico.Fachada;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

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
    private JFXListView alunos;
    @FXML
    private JFXListView mensagens;
    @FXML
    private JFXListView conversas;
    @FXML
    private JFXButton btnEnviarMensagem;
    @FXML
    private JFXTextArea msgTexto;
    
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
        
        this.atualizarListaTarefas();
        this.atualizarListaAlunos();
        this.atualizarConversas();
        this.tarefas.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    
        this.mensagens.setCellFactory(new Callback<JFXListView<Mensagem>, JFXListCell<Mensagem>>() {
            @Override
            public JFXListCell<Mensagem> call(JFXListView<Mensagem> param) {
                return new JFXListCell<Mensagem>() {
                    @Override
                    public void updateItem(Mensagem item, boolean empty) {
                        super.updateItem(item, empty);
                        
                        this.setWrapText(true);
                        
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            if (item.getRemetente() instanceof Tutor) {
                                setStyle("-fx-alignment: CENTER-RIGHT; -fx-control-inner-background: derive(palegreen, 50%);");
                            } else {
                                this.setStyle("-fx-alignment: CENTER-LEFT;");
                            }
                            
                            setText(item.getMensagem());
                        }
                    }
                };
            }
        });
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
        fachada.getUsuarioServico().salvar(tutor, novo);
        
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
//        Tarefa tarefa = tutor.getListaDeTarefasSalvas().remove(tarefas.getSelectionModel().getSelectedIndex());
//        Main.getInstancia().telaNovaTarefa(tutor, tarefa);
    }

    @FXML
    private void removerTarefa(ActionEvent event) {
//        Fachada.getInstancia().removerTarefa(tutor,
//            tutor.getListaDeTarefasSalvas().get(tarefas.getSelectionModel().getSelectedIndex()));        
    }
    
    @FXML
    private void enviarTarefa(ActionEvent event) throws IOException {
        
        ArrayList<Tarefa> selecionadas = new ArrayList<>();
        
        for (Object selectedIndice : tarefas.getSelectionModel().getSelectedIndices()) {
            selecionadas.add(tutor.getTarefas().get((Integer)selectedIndice));
        }
        
        Main.getInstancia().telaEnviarTarefa(tutor, selecionadas);
    }
    
    @FXML
    private void atualizarListaTarefas(ActionEvent event) {
        atualizarListaTarefas();
    }
    
    @FXML
    private void corrigirTarefas(ActionEvent event) throws IOException {
        if (tutor.getCursos().get(alunos.getSelectionModel().getSelectedIndex()).getTarefasRespondidas().size() > 0) {
            Curso curso = tutor.getCursos().get(alunos.getSelectionModel().getSelectedIndex());
            Main.getInstancia().telaEscolherTarefas(curso);
        }
    }
    
    void atualizarListaTarefas(){
        this.tarefas.getItems().clear();
        TutorDAOMemoria tutorDAO = TutorDAOMemoria.getInstancia();
        
        this.tutor.getTarefas().forEach((i) -> {
            this.tarefas.getItems().add(i.getNomeTarefa() + " : " + i.getDescricao());
        });
    }
    
    void atualizarListaAlunos(){
        this.alunos.getItems().clear();
        this.tutor.getCursos().forEach((i) -> {
            this.alunos.getItems().add("Aluno: "+i.getAluno().getUsuario());
        });
    } 
    
    void atualizarMenssagens(int index){
        this.mensagens.getItems().clear();
        this.tutor.getCursos().get(index).listMesagems().forEach((i) -> {
            this.mensagens.getItems().add(i);
        });
    }
    
    void atualizarConversas(){
        this.conversas.getItems().clear();
        
        for (Curso curso : this.tutor.getCursos()) {
            this.conversas.getItems().add(curso.getAluno().getUsuario());
        }
    }
    
    
    @FXML
    private void conversaSelecionada(){
        if (this.conversas.getSelectionModel().getSelectedIndex() >= 0) {
            this.atualizarMenssagens(this.conversas.getSelectionModel().getSelectedIndex());
        }
    }
    
    @FXML
    private void enviarMenssagem(ActionEvent event) {
        if (this.msgTexto.getText().length() > 0) {
            Fachada.getInstancia().getTutorServico().enviarMensagem(this.tutor, this.tutor.getCursos().get(this.conversas.getSelectionModel().getSelectedIndex()).getAluno(), this.msgTexto.getText());
            this.msgTexto.setText("");
            this.atualizarMenssagens(this.conversas.getSelectionModel().getSelectedIndex());
        }
    }
}
