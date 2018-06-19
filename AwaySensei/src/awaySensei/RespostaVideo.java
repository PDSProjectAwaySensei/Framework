/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awaySensei;

import Dominio.Resposta;

/**
 *
 * @author Residentes
 */
public class RespostaVideo implements Resposta{
    private String linkVideo;
    private String Comentario;

    public RespostaVideo() {
    }

    public RespostaVideo(String linkVideo, String Comentario) {
        this.linkVideo = linkVideo;
        this.Comentario = Comentario;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }
}
