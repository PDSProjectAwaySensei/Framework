package Servico;

import Dados.AlunoDAO;
import Dados.AlunoDAOMemoria;
import Dados.TutorDAOMemoria;
import Dominio.Aluno;
import Dominio.Usuario;
import Dominio.Identificacao;
import Dominio.InformacaoPessoal;
import Dominio.Tutor;
import java.util.ArrayList;

/**
 *
 * @author jeck
 */
public class UsuarioServico {
    AlunoDAOMemoria alunoDAO;
    TutorDAOMemoria tutorDAO;

    public UsuarioServico() {
        this.alunoDAO = new AlunoDAOMemoria();
        this.tutorDAO = new TutorDAOMemoria();
        
        criarTestes();
    }    
    
    Usuario usuarioEntrar(String usuario, String senha){
        usuario = usuario.replaceAll("//s", "");
        Identificacao idEntrar = new Identificacao(usuario, senha);
        
        //try Aluno
        Usuario logado = (alunoDAO.getAluno(idEntrar));
        //try Tutor
        if (logado == null)
            logado = (tutorDAO.getTutor(idEntrar));
        
        return logado;
    }
    
    //Cadastra Alunos apenas
    Boolean usuarioCadastrar(String usuario, String mail, String senha) {
        //Validar Formato Email, Limpar Usuario, Conferir Senha
        Aluno novoAluno = new Aluno(new Identificacao(usuario, senha), 
                                    new InformacaoPessoal("", mail, ""));
        return alunoDAO.inserirAluno(novoAluno);
    }
    
    public void salvarPerfil(Usuario antigo, Usuario novo){
        if (antigo instanceof  Aluno && novo instanceof Aluno){
            alunoDAO.editarAluno((Aluno) antigo, (Aluno) novo);
        } else if (antigo instanceof  Tutor && novo instanceof Tutor){
            tutorDAO.editarTutor((Tutor) antigo, (Tutor) novo);
        }
    }
    
    public ArrayList<Tutor> getTutores(){
        return tutorDAO.listarTutores();
    }

    private void criarTestes() {        
        Aluno x = new Aluno(new Identificacao("aluno", "123"), 
                            new InformacaoPessoal("Aluno de Testes", "@t.com", "Aqui fica a Descrição do Aluno!"));
        Tutor y = new Tutor(new Identificacao("tutor", "123"), 
                            new InformacaoPessoal("Tutor da Silva", "tutoria@awaySensei.com.br", "Professor de Testes do awaySensei."));
        Tutor z = new Tutor(new Identificacao("tutor2", "123"), 
                            new InformacaoPessoal("Segundo Tutor de Testes", "tutoria@awaySensei.com.br", "Professor de Testes do awaySensei."));
        Tutor a = new Tutor(new Identificacao("francisco", "francisco"), 
                            new InformacaoPessoal("Francisco Soarez da Silva", "francisco@awaySensei.com.br", "Professor de alto nível do awaySensei."));
        Aluno b = new Aluno(new Identificacao("alu", "123"), 
                            new InformacaoPessoal("Pedro Pereira Pedroso", "ppp@gmail.com", "Aluno do awaySensei!"));
        alunoDAO.inserirAluno(x);
        tutorDAO.inserirTutor(y);
        tutorDAO.inserirTutor(z);
        tutorDAO.inserirTutor(a);
        alunoDAO.inserirAluno(b);
    }
}
