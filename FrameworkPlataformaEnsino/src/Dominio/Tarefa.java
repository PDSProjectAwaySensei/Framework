package Dominio;


public class Tarefa {
    private String nomeTarefa;
    private String descricao;
    private Atividade atividade;
    private float resultado;
    private boolean corrigida;

    public Tarefa(String nomeTarefa, String descricao, Atividade atividade) {
        this.nomeTarefa = nomeTarefa;
        this.descricao = descricao;
        this.atividade = atividade;
        this.corrigida = false;
    }

    public Tarefa() {}

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public boolean isCorrigida() {
        return corrigida;
    }

    public void setCorrigida(boolean corrigida) {
        this.corrigida = corrigida;
    }
    
}
