/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dominio.Aluno;
import Dominio.InformacaoPessoal;
import Dominio.Mensagem;
import Dominio.Tarefa;
import servico.Fachada;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListCell;
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
import javafx.util.Callback;

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
    @FXML
    private JFXButton buttonResponderTarefa;
    @FXML
    private JFXButton buttonRefazerTarefa;
    @FXML
    private JFXButton buttonCancelarTarefa;
    @FXML
    private JFXListView listaTarefasAlunoCorrigidas;
    @FXML
    JFXListView mensagens;
    @FXML
    private JFXButton btnEnviarMenssagem;
    @FXML
    private JFXTextArea msgTexto;
    
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
            textTutorUsuario.setText(aluno.getCurso().getTutor().getUsuario());
//            textTutorNome.setText(aluno.getCurso().getTutor().getInformacaoPessoal().getNome());
//            textTutorEmail.setText(aluno.getCurso().getTutor().getInformacaoPessoal().getEmail());
//            textTutorDescricao.setText(aluno.getCurso().getTutor().getInformacaoPessoal().getDescricao() );
        }
        
        if (aluno.getCurso() != null){
            aluno.getCurso().getTarefas().forEach((i) -> {
                listaTarefasAluno.getItems().add(i.getNomeTarefa() + " : " + i.getDescricao());
            });
        }
        
        if (aluno.getCurso() != null){
            aluno.getCurso().getTarefasCorrigidas().forEach((i) -> {
                listaTarefasAlunoCorrigidas.getItems().add(i.getNomeTarefa() + " : " + i.getDescricao());
            });
        }
        
        this.atualizarListaMenssagens();
        
        this.mensagens.setCellFactory(new Callback<JFXListView<Mensagem>, JFXListCell<Mensagem>>() {
            @Override
            public JFXListCell<Mensagem> call(JFXListView<Mensagem> param) {
                return new JFXListCell<Mensagem>() {
                    @Override
                    public void updateItem(Mensagem item, boolean empty) {
                        super.updateItem(item, empty);
                        
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            if (item.getRemetente() instanceof Aluno) {
                                this.setStyle("-fx-alignment: CENTER-RIGHT; -fx-control-inner-background: derive(palegreen, 50%);");
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
        Aluno novo = aluno;
        InformacaoPessoal novoPerfil = new InformacaoPessoal(textNome.getText(),
                                                             textEmail.getText(),
                                                             textDescricao.getText());
        novo.setInformacaoPessoal(novoPerfil);
        novo.getIdentificacao().setUsuario(textUsuario.getText());
        
        Fachada fachada = Fachada.getInstancia();
        fachada.getUsuarioServico().salvar(aluno, novo);
        
        aluno = novo;
    }

    @FXML
    private void sair(ActionEvent event) throws IOException {
        Main main = Main.getInstancia();        
        main.telaInicial();
    }

    @FXML
    private void mudarTutor(ActionEvent event) throws IOException {
        Main main = Main.getInstancia();        
        main.telaMudarTutor(aluno);
    }
    
    ///////////////////////////////////////////////////////////////////////////
    @FXML
    private void responderTarefa(ActionEvent event) throws IOException {
        Tarefa tarefa = aluno.getCurso().getTarefas().get(listaTarefasAluno.getSelectionModel().getSelectedIndex());
        Main.getInstancia().telaResponderTarefa(aluno, tarefa);
    }
    
    @FXML
    private void atualizarListaTarefas(ActionEvent event) throws IOException {
        listaTarefasAluno.getItems().clear();
        aluno.getCurso().getTarefas().forEach((i) -> {
            listaTarefasAluno.getItems().add(i.getNomeTarefa() + " : " + i.getDescricao());
        });
    }
    
    @FXML
    private void removerTarefa(ActionEvent event) throws IOException {
        //TODO
    }
    ////////////////////////////////////////////////////////////////////////////
    
    @FXML
    private void refazerTarefa(ActionEvent event) throws IOException {
        //TODO
    }
    @FXML
    private void verAvaliacao(ActionEvent event) throws IOException {
        Tarefa tarefa = aluno.getCurso().getTarefasCorrigidas().get(listaTarefasAlunoCorrigidas.getSelectionModel().getSelectedIndex());
        Main.getInstancia().telaVerAvaliacao(tarefa);
    }
    
    @FXML
    private void pagarCurso(ActionEvent event) throws IOException{
        Main.getInstancia().telaPagarCurso();
    }
    
    void atualizarListaMenssagens(){
        this.mensagens.getItems().clear();
        if (this.aluno.getCurso() != null) {
            if (this.aluno.getCurso().listMesagems() != null && this.aluno.getCurso().listMesagems().size() > 0) {
                this.aluno.getCurso().listMesagems().forEach((i) -> {
                    this.mensagens.getItems().add(i);
                });
            }
        }
    }
    
    @FXML
    private void enviarMenssagem(ActionEvent event) {
        Fachada.getInstancia().getAlunoServico().enviarMensagem(this.aluno, this.aluno.getCurso().getTutor(), this.msgTexto.getText());
        this.msgTexto.setText("");
        this.atualizarListaMenssagens();
    }
}
