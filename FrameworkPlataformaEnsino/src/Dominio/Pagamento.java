package Dominio;

public abstract class Pagamento {
    private int valor;
    private String data;
    private boolean status;

    public Pagamento(int valor, String data, boolean status) {
        this.valor = valor;
        this.data = data;
        this.status = status;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
