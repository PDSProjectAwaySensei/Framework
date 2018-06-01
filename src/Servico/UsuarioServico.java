package Servico;

import Dados.AlunoDAO;
import Dados.AlunoDAOMemoria;
import Dominio.Usuario;
import dominio.usuario.Identificacao;

/**
 *
 * @author jeck
 */
public class UsuarioServico {
    AlunoDAO alunoDAO;

    public UsuarioServico() {
        this.alunoDAO = new AlunoDAOMemoria();
    }    
    
    Usuario usuarioEntrar(String usuario, String senha){
        Identificacao idEntrar = new Identificacao(usuario, senha);
        return (alunoDAO.getAluno(idEntrar));
    }
}
