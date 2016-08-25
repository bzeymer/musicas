/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServerBusca.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Modifier;
import webServerBusca.model.Lobby;
import webServerBusca.model.Musica;
import webServerBusca.model.Sala;

/**
 *
 * @author Breno
 */
public class ServidorBusca {

    public static Lobby lobby = new Lobby();
    
    public static String todasMusicas() {
        
        return listarMusicas();
    }
    
    public static String todasSalas() {
        
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        String json = gson.toJson(lobby.getSalas());
        return json;
    }
    
    public static String conectar(String jsonSala, String senha){
        
        Gson gson = new Gson();
        
        Sala sala = gson.fromJson(jsonSala, Sala.class);
        
        if (!lobby.autenticar(sala)) {
            
            return null;
        }
        
        return todasMusicas();   
    }
    
    public static void addmusica(String jsonMusicaPedida) {
        
        Gson gson = new Gson();
        
        Musica musicaPedida = gson.fromJson(jsonMusicaPedida, Musica.class);
        
        String jsonMusica = baixarMusica(musicaPedida.getId());
        
        Musica musica = gson.fromJson(jsonMusica, Musica.class);
        
        Sala sala = lobby.getSalaAtiva();
        sala.addMusica(musica);
    }
        
    
    private static String baixarMusica(java.lang.Integer id) {
        webserver.Repositorio_Service service = new webserver.Repositorio_Service();
        webserver.Repositorio port = service.getRepositorioPort();
        return port.baixarMusica(id);
    }

    private static String listarMusicas() {
        webserver.Repositorio_Service service = new webserver.Repositorio_Service();
        webserver.Repositorio port = service.getRepositorioPort();
        return port.listarMusicas();
    }


    
    
}
