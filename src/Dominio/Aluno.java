package Dominio;

import Dominio.Identificacao;
import Dominio.InformacaoPessoal;

public class Aluno extends Usuario {
    private Curso curso;
    
    
    public Aluno(Identificacao identificacao, InformacaoPessoal informacaoPessoal) {
        super(identificacao, informacaoPessoal);
        curso = null;
    }

    public Aluno(Curso curso, Identificacao identificacao, InformacaoPessoal informacaoPessoal) {
        super(identificacao, informacaoPessoal);
        this.curso = curso;
    }
        
    
/*
	private Categoria progresso;

	private Curso curso;

	private Categoria categoria;
*/

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
