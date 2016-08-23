/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServer.controller;

import webServer.model.Biblioteca;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.ws.rs.NotFoundException;
import webServer.model.Musica;

/**
 *
 * @author Breno
 */
public class ServidorRepositorio extends BaseController {

    public static Biblioteca biblioteca = new Biblioteca();
    public static String json = "";

    public static AudioInputStream getMusica(Biblioteca biblioteca, Integer id) throws UnsupportedAudioFileException, IOException {

        if (id == null) {
            throw new IllegalArgumentException("É necessário um id para buscar a música.");
        }

        Musica musica = biblioteca.getMusica(id);

        if (musica == null) {

            throw new NotFoundException("A música com esse id não foi encontrada.");
        }
        
        AudioInputStream arquivo = AudioSystem.getAudioInputStream(musica.getAudio());
           
        return arquivo;
    }

    public static AudioInputStream baixarMusica(Integer id) throws UnsupportedAudioFileException, IOException {

        biblioteca = Biblioteca.popular();
        
        AudioInputStream musica = getMusica(biblioteca, id);

        return musica;
    }

    public static void criaJson() {
                     
        Gson gson = new Gson();
        json = gson.toJson(biblioteca);
    }
    

}
