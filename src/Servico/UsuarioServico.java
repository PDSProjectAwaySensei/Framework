package Servico;

import Dados.AlunoDAO;
import Dados.AlunoDAOMemoria;
import Dados.TutorDAOMemoria;
import Dominio.Aluno;
import Dominio.Usuario;
import Dominio.Identificacao;
import Dominio.InformacaoPessoal;
import Dominio.Tutor;

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
        
        Aluno x = new Aluno(new Identificacao("alu", "123"), 
                            new InformacaoPessoal("nome", "mail", "descricao"));
        Tutor y = new Tutor(new Identificacao("tut", "123"), 
                            new InformacaoPessoal("nome", "mail", "descricao"));
        alunoDAO.inserirAluno(x);
        tutorDAO.inserirTutor(y);
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
}
