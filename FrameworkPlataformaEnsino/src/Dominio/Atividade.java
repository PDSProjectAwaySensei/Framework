package Dominio;

public abstract class Atividade {
    private boolean resultado;
    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }
}
