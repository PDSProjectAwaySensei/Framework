/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Dominio.Aluno;
import Dominio.Usuario;
import Visual.Controller.AlunoController;
import java.io.IOException;
import java.lang.String;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jeck
 */
public class Fachada {
    public static Fachada instancia;
    
    protected UsuarioServico usuarioServico;
    
    private Stage stage;
    
    protected Fachada(){
        usuarioServico = new UsuarioServico();
    }
    
    public static Fachada getInstancia(){
        if (instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }
    
    public void iniciar(Stage primaryStage) throws IOException{
        //FXMLLoader telaInicial = new FXMLLoader(getClass().getResource("/visual/fxml/Inicio.fxml"));
        stage = primaryStage;
        Scene telaInicial;
        telaInicial = new Scene((new FXMLLoader(getClass().getResource("/Visual/fxml/Inicio.fxml")).load()));
        stage.setScene(telaInicial);
        stage.show();
    }
    
    public void telaEntrar() throws IOException{
        Scene telaEntrar;
        telaEntrar = new Scene((new FXMLLoader(getClass().getResource("/Visual/fxml/Entrar.fxml")).load()));
        stage.setScene(telaEntrar);
        stage.show();
    }
    
    public void usuarioEntrar(String usuario, String senha) throws IOException{
        Aluno user;
        user = usuarioServico.usuarioEntrar(usuario, senha);
        if (user != null){
            if (user instanceof Aluno){
                FXMLLoader loaderTelaAluno = (new FXMLLoader(getClass().getResource("/Visual/fxml/Aluno.fxml")));
                loaderTelaAluno.setController(new AlunoController(user));
                Scene telaAluno = new Scene(loaderTelaAluno.load());
                stage.setScene(telaAluno);
                stage.show();
            }// else if (user instanceof Tutor)
        }
    }
}
