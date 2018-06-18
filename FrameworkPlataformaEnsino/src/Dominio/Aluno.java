package Dominio;

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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
