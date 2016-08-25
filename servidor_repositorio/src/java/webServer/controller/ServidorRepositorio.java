/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServer.controller;

import webServer.model.Biblioteca;
import com.google.gson.Gson;
import javax.ws.rs.NotFoundException;
import webServer.model.Musica;

/**
 *
 * @author Breno
 */
public class ServidorRepositorio {

    public static Biblioteca biblioteca = new Biblioteca();

    public static String getMusica(Biblioteca biblioteca, Integer id) {

        if (id == null) {
            throw new IllegalArgumentException("É necessário um id para buscar a música.");
        }

        Musica musica = biblioteca.getMusica(id);

        if (musica == null) {

            throw new NotFoundException("A música com esse id não foi encontrada.");
        }
        
        String json = "{\"musica\":{\"id\":"+musica.getId()+",\"nome\":\""+musica.getNome()+"\",\"artista\":\""+musica.getArtista()+"\",\"audio\":\""+musica.getAudio()+"\"}}";
        
        return json;
    }

    public static String baixarMusica(Integer id) {

        biblioteca = Biblioteca.popular();
        
        String musica = getMusica(biblioteca, id);

        return musica;
    }

    public static String listarMusicas() {
        
        biblioteca = Biblioteca.popular();
        
        Gson gson = new Gson();
        return gson.toJson(biblioteca.musicas);
    }
}
