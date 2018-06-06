package Dominio;


public class Tarefa {
    private String nomeTarefa;
    private String descricao;
    private Atividade atividade;
    private Avaliacao avaliacao;

    public Tarefa(String nomeTarefa, String descricao, Atividade atividade) {
        this.nomeTarefa = nomeTarefa;
        this.descricao = descricao;
        this.atividade = atividade;
        this.avaliacao = null;
    }

    public Tarefa() { }

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

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    
}
