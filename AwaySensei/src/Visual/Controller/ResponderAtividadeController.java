/* 
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
package Visual.Controller; 
 
import Dominio.Aluno; 
import Dominio.Tarefa; 
import awaySensei.AtividadeVideo;
import com.jfoenix.controls.JFXButton; 
import com.jfoenix.controls.JFXTextArea; 
import com.jfoenix.controls.JFXTextField; 
import java.net.URL; 
import java.util.ResourceBundle; 
import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.fxml.Initializable; 
 
/** 
 * 
 * @author jeckson 
 */ 
public class ResponderAtividadeController implements Initializable { 
    @FXML 
    private JFXTextField textLinkTutor; 
    @FXML 
    private JFXTextArea textComTutor; 
    @FXML 
    private JFXTextField textLinkAluno; 
    @FXML 
    private JFXTextArea textComAluno; 
    @FXML 
    private JFXButton buttonCancelar; 
    @FXML 
    private JFXButton buttonSalvar; 
 
    private Aluno aluno; 
    private Tarefa tarefa; 
     
    public ResponderAtividadeController(Aluno aluno, Tarefa tarefa) { 
        this.aluno = aluno; 
        this.tarefa = tarefa; 
    }     
     
        /** 
     * Initializes the controller class. 
     */ 
    public void initialize(URL url, ResourceBundle rb) { 
        textLinkTutor.setDisable(true); 
        textComTutor.setDisable(true);
        textLinkAluno.setDisable(false);
        textLinkAluno.setDisable(false);
         
        textLinkTutor.setText(((AtividadeVideo)tarefa.getAtividade()).getLinkVideoTutor()); 
        textComTutor.setText(((AtividadeVideo)tarefa.getAtividade()).getComVideoTutor()); 
    }     
 
    @FXML 
    private void cancelar(ActionEvent event) { 
        ((JFXButton)event.getTarget()).getScene().getWindow().hide(); 
    } 
 
    @FXML 
    private void criarAtividade(ActionEvent event) { 
        if (textLinkAluno.getText().isEmpty() == false) { 
            ((AtividadeVideo)tarefa.getAtividade()).setLinkVideoAluno(textLinkAluno.getText()); 
            ((AtividadeVideo)tarefa.getAtividade()).setComVideoAluno(textComAluno.getText()); 
            tarefa.getAtividade().setConcluida(true);
            
            aluno.getCurso().getListaTarefasConcluidas().add(tarefa);
            aluno.getCurso().getListaTarefas().remove(tarefa);
            
            textLinkAluno.setDisable(true);
            textLinkAluno.setDisable(true);
            
            cancelar(event); 
        } 
    } 
}