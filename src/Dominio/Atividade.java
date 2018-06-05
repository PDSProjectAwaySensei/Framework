package Dominio;

public abstract class Atividade {
    private boolean concluida;

    public Atividade() {
        this.concluida = false;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
