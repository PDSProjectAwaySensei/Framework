package Dominio;


public class Tarefa {
    private String nomeTarefa;
    private String descricao;
    private Atividade atividade;
    private Resposta resposta;
    private Resultado resultado;
    private boolean corrigida;
    private boolean concluida;

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

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public boolean isCorrigida() {
        return corrigida;
    }

    public void setCorrigida(boolean corrigida) {
        this.corrigida = corrigida;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
