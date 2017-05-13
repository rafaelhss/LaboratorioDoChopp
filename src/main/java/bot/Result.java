/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import java.io.Serializable;

/**
 *
 * @author ra21550273
 */
public class Result implements Serializable{
    private String texto;

    Result(String mensagemResposta) {
        texto = mensagemResposta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
