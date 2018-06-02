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
    AlunoDAO alunoDAO;

    public UsuarioServico() {
        this.alunoDAO = new AlunoDAOMemoria();
        Aluno x = new Aluno(new Identificacao("alu", "123"), new InformacaoPessoal("", "", ""));
        alunoDAO.inserirAluno(x);
    }    
    
    Usuario usuarioEntrar(String usuario, String senha){
        usuario = usuario.replaceAll("//s", "");
        Identificacao idEntrar = new Identificacao(usuario, senha);
        return (alunoDAO.getAluno(idEntrar));
    }
}
