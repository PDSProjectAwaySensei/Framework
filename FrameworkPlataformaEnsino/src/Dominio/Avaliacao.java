/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author jeckson
 */
public abstract class Avaliacao {
    private boolean avaliada;

    public Avaliacao() {
        this.avaliada = true;
    }

    public boolean isAvaliada() {
        return avaliada;
    }

    public void setAvaliada(boolean avaliada) {
        this.avaliada = avaliada;
    }
}
