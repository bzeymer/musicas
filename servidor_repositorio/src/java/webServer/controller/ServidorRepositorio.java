/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServer.controller;

import webServer.model.Biblioteca;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.NotFoundException;
import webServer.model.Musica;

/**
 *
 * @author Breno
 */
public class ServidorRepositorio extends BaseController {

    public static Biblioteca biblioteca = new Biblioteca();
    public static String json ="{\n" +
"  \"musicas\": [\n" +
"    {\n" +
"      \"id\": 1,\n" +
"      \"nome\": \"Sunday Bloody Sunday\",\n" +
"      \"artista\": \"U2\",\n" +
"      \"nomeArquivo\": \"Sunday_bloody_sunday.wav\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": 2,\n" +
"      \"nome\": \"Have You Ever Seen the Rain?\",\n" +
"      \"artista\": \"Creedence Clearwater Revival\",\n" +
"      \"nomeArquivo\": \"Have_you_ever_seen_the_rain.wav\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": 3,\n" +
"      \"nome\": \"The House of the Rising Sun\",\n" +
"      \"artista\": \"The Animals\",\n" +
"      \"nomeArquivo\": \"Sunday_bloody_sunday.wav\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": 4,\n" +
"      \"nome\": \"Starway to Heaven\",\n" +
"      \"artista\": \"Led Zeppelin\",\n" +
"      \"nomeArquivo\": \"Starway_to_heaven.wav\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": 5,\n" +
"      \"nome\": \"Free Bird\",\n" +
"      \"artista\": \"Lynyrd Skynyrd\",\n" +
"      \"nomeArquivo\": \"Free_bird.wav\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": 6,\n" +
"      \"nome\": \"Back in Black\",\n" +
"      \"artista\": \"AC/DC\",\n" +
"      \"nomeArquivo\": \"Back_in_black.wav\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": 7,\n" +
"      \"nome\": \"Smells Like Teen Spirit\",\n" +
"      \"artista\": \"Nirvana\",\n" +
"      \"nomeArquivo\": \"Smells_like_teen_spirit.wav\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": 8,\n" +
"      \"nome\": \"Comfortably Numb\",\n" +
"      \"artista\": \"Pink Floyd\",\n" +
"      \"nomeArquivo\": \"Comfortably_numb.wav\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": 9,\n" +
"      \"nome\": \"Smoke on the Water\",\n" +
"      \"artista\": \"U2\",\n" +
"      \"nomeArquivo\": \"Smoke_on_the_water.wav\"\n" +
"    },\n" +
"    {\n" +
"      \"id\": 10,\n" +
"      \"nome\": \"We Will Rock You\",\n" +
"      \"artista\": \"Queen\",\n" +
"      \"nomeArquivo\": \"We_will_rock_you.wav\"\n" +
"    }\n" +
"  ]\n" +
"}";

    public static String getMusica(Biblioteca biblioteca, Integer id) {

        if (id == null) {
            throw new IllegalArgumentException("É necessário um id para buscar a música.");
        }

        Musica musica = biblioteca.getMusica(id);

        if (musica == null) {

            throw new NotFoundException("A música com esse id não foi encontrada.");
        }
        
        File f = new File("DBDriverInfo.properties");
        System.out.println(f.getAbsolutePath());

        try {

            String arquivo = musica.getArquivo();
        } catch (IOException ex) {

            Logger.getLogger(ServidorRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            File f = new File(".");
        System.out.println(f.getAbsolutePath());
        }

        return null;
    }

    public static String baixarMusica(Integer id) {

        //criaJson();
        biblioteca = populaBiblioteca();
        String musica = getMusica(biblioteca, id);

        System.out.println(musica);
        return musica;
    }

    public static void criaJson() {
        
        Musica musica1 = new Musica("1");
        biblioteca.musicas.add(musica1);
        Musica musica2 = new Musica("2");
        biblioteca.musicas.add(musica2);
        Musica musica3 = new Musica("3");
        biblioteca.musicas.add(musica3);
        Musica musica4 = new Musica("4");
        biblioteca.musicas.add(musica4);
        Musica musica5 = new Musica("5");
        biblioteca.musicas.add(musica5);
        Musica musica6 = new Musica("6");
        biblioteca.musicas.add(musica6);
        Musica musica7 = new Musica("7");
        biblioteca.musicas.add(musica7);
        Musica musica8 = new Musica("8");
        biblioteca.musicas.add(musica8);
        Musica musica9 = new Musica("9");
        biblioteca.musicas.add(musica9);
        Musica musica10 = new Musica("10");
        biblioteca.musicas.add(musica10);
        
        Gson gson = new Gson();
        json = gson.toJson(biblioteca);
    }
    public static Biblioteca populaBiblioteca() {

        
        /*
        String nomeArquivo = "biblioteca.json";

        String aux = null;
        try {

            FileReader arquivo = new FileReader(nomeArquivo);
            BufferedReader lerArquivo = new BufferedReader(arquivo);

            aux = lerArquivo.readLine();
            while (aux != null) {
                json = json + aux;

                aux = lerArquivo.readLine();
            }
            arquivo.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        */
        
        Gson gson = new Gson();

        return gson.fromJson(json, Biblioteca.class);
    }

}
