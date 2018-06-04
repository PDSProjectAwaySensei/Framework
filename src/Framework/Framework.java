/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import Servico.Fachada;

/**
 *
 * @author jeck
 */
public class Framework extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Fachada fachada = Fachada.getInstancia();
        fachada.iniciar(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}


/* Abrir a interface de Aluno DONE */ 
/* Adicionar Tutor e Curso DONE */
/* Abrir a interface de Tutor DONE*/
/* Adicionar demais classes DONE*/
/* Abrir janelas para todas as acoes */
/* Editar Perfil DONE */
/* Colocar Sensei no Aluno DONE */
/* Criar Tarefa */
/* Atualizar Lista de Tarefas */
/* Mandar Mensagem */

/* Passar o salvarPerfil para a fachada */
/* Quando o aluno concluir??*/