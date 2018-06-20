/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package Visual.Controller; 
 
import dominio.AtividadeQuestionario;
import Dominio.Aluno; 
import Dominio.Tarefa; 
import com.jfoenix.controls.JFXButton; 
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import dominio.RespostaQuestionario;
import java.net.URL; 
import java.util.ResourceBundle; 
import javafx.collections.ObservableList;
import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.fxml.Initializable; 
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
 
/** 
 * 
 * @author jeckson 
 */ 
public class ResponderQuestionarioController implements Initializable { 
    @FXML
    private JFXListView<VBox> listaQuestoes;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private Button buttonAddQuestao;
    @FXML
    private JFXButton buttonSalvar;    
 
    private Aluno aluno; 
    private Tarefa tarefa; 
     
    public ResponderQuestionarioController(Aluno aluno, Tarefa tarefa) { 
        this.aluno = aluno; 
        this.tarefa = tarefa; 
    }     
     
        /** 
     * Initializes the controller class. 
     */ 
    public void initialize(URL url, ResourceBundle rb) {
        buttonAddQuestao.setDisable(true);
        
        AtividadeQuestionario atividade = (AtividadeQuestionario) tarefa.getAtividade();
        for(String q : atividade.getQuestoes()){
            JFXTextField enunciado = new JFXTextField(q);
            JFXTextField resposta = new JFXTextField();
            enunciado.setDisable(true);
            resposta.setDisable(false);
            VBox box = new VBox();
            box.getChildren().addAll(enunciado, resposta);
            listaQuestoes.getItems().add(box);
        }
    }     
 
    @FXML 
    private void cancelar(ActionEvent event) { 
        ((JFXButton)event.getTarget()).getScene().getWindow().hide(); 
    } 
    
    @FXML
    private void addQuestao(ActionEvent event) {}
 
    @FXML 
    private void salvarQuestionario(ActionEvent event) {
        int i = 0;
        RespostaQuestionario respostas = new RespostaQuestionario();
        ObservableList<VBox> items = listaQuestoes.getItems();
        for(VBox box : items){
            //Get Resposta
            JFXTextField f = (JFXTextField) box.getChildren().get(1);
            respostas.addResposta(f.getText());
            f.setDisable(true);
            i++;
        }
        
        tarefa.setResposta(respostas);
        
        cancelar(event);
    } 
}