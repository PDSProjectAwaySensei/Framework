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


/* Abrir a interface de Aluno */
/* Adicionar Tutor e Curso */
/* Abrir a interface de Tutor */
/* Adicionar demais classes */
/* Abrir janelas para todas as acoes */