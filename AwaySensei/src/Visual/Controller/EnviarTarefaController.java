/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.Controller;

import Dados.AlunoDAO;
import Dados.AlunoDAOMemoria;
import Dominio.Aluno;
import Dominio.Identificacao;
import Dominio.Tarefa;
import Dominio.Tutor;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import servico.Fachada;

/**
 * FXML Controller class
 *
 * @author jeckson
 */
public class EnviarTarefaController implements Initializable {

    @FXML
    private JFXListView listaAlunos;
    @FXML
    private JFXButton buttonCancelar;
    @FXML
    private JFXButton buttonSelecionarAlunos;
    
    private Tutor tutor;
    private ArrayList<Tarefa> tarefas;
    private ArrayList<Identificacao> alunos;

    public EnviarTarefaController(Tutor tutor, ArrayList<Tarefa> tarefas) {
        this.tutor = tutor;
        this.tarefas = tarefas;
        this.alunos = new ArrayList<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tutor.getListaDeCursos().forEach((i) -> {
            listaAlunos.getItems().add(i.getAluno().getUsuario());
            this.alunos.add(i.getAluno());
        });
    }    

    @FXML
    private void cancelar(ActionEvent event) {
        ((JFXButton)event.getTarget()).getScene().getWindow().hide();
    }

    @FXML
    private void selecionarAlunos(ActionEvent event) {
        ObservableList selectedIndices = listaAlunos.getSelectionModel().getSelectedIndices();
        
        ArrayList<Aluno> alunos = new ArrayList<>();
        for (Object i : selectedIndices){
            alunos.add(AlunoDAOMemoria.instancia.getAluno(this.alunos.get((Integer)i)));
        }
        
        Fachada.getInstancia().enviarTarefas(tutor.getIdentificacao(), tarefas, alunos);
    }
    
}
