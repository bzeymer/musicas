/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServerBusca.model;

import java.io.Serializable;

/**
 *
 * @author Breno
 */
public class Musica implements Serializable {

    private Integer id;
    private String nome;
    private String artista;
    private String audio;
    
    public Musica(String x) {
        this.id = Integer.parseInt(x);
        this.nome = x;
        this.artista = x;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }
    
    public String getAudio() {
        return audio;
    }
}
