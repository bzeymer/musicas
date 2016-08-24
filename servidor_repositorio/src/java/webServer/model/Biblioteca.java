/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServer.model;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    
    public static Biblioteca popular() {

        String nomeArquivo = "biblioteca.json";
        String json = "";
        String aux = null;
        try {
            
            FileReader arquivo = new FileReader("dados/"+nomeArquivo);
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
                
        Gson gson = new Gson();

        return gson.fromJson(json, Biblioteca.class);
    }
    
}
