/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServer.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Breno
 */
public class Biblioteca implements Serializable {
    
    public List<Musica> musicas = new ArrayList<Musica>();

    public List<Musica> getMusicas() {
        return musicas;
    }

    public Musica getMusica(Integer id) {
        
        for (Musica musica : this.musicas) {
            
            if (musica.getId() == id) {
                
                return musica;
            }
            
        }
        
        return null;
    }
}
