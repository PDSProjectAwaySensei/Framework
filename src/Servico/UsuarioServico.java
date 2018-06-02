package Servico;

import Dados.AlunoDAO;
import Dados.AlunoDAOMemoria;
import Dominio.Aluno;
import Dominio.Usuario;
import Dominio.Identificacao;
import Dominio.InformacaoPessoal;

/**
 *
 * @author jeck
 */
public class UsuarioServico {
    AlunoDAOMemoria alunoDAO;

    public UsuarioServico() {
        this.alunoDAO = new AlunoDAOMemoria();
        Aluno x = new Aluno(new Identificacao("alu", "123"), new InformacaoPessoal("alunofirst", "", ""));
        alunoDAO.inserirAluno(x);
    }    
    
    Aluno usuarioEntrar(String usuario, String senha){
        usuario = usuario.replaceAll("//s", "");
        Identificacao idEntrar = new Identificacao(usuario, senha);
        Aluno logado = (alunoDAO.getAluno(idEntrar));
        if (logado == null) System.out.println("nulo");
        else System.out.println("Logou Suesso");
        return logado;
    }
}
