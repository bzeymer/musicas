/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServer.controller;

import webServer.model.Biblioteca;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Modifier;
import javax.ws.rs.NotFoundException;
import webServer.model.Musica;

/**
 *
 * @author Breno
 */
public class ServidorRepositorio {

    public static Biblioteca biblioteca = new Biblioteca();

    public static String getMusica(Biblioteca biblioteca, String nome) {

        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("É necessário um nome para buscar a música.");
        }

        Musica musica = biblioteca.getMusica(nome);

        if (musica == null) {

            throw new NotFoundException("A música com esse nome não foi encontrada.");
        }
        
        String json = "{\"musica\":{\"nome\":\""+musica.getNome()+"\",\"artista\":\""+musica.getArtista()+"\",\"audio\":\""+musica.getAudio()+"\"}}";
        
        return json;
    }

    public static String baixarMusica(String nome) {

        biblioteca = Biblioteca.popular();
        
        String musica = getMusica(biblioteca, nome);

        return musica;
    }

    public static String listarMusicas() {
        
        biblioteca = Biblioteca.popular();
        
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        return gson.toJson(biblioteca.musicas);
    }
    
    
}
