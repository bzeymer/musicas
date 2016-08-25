/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServerBusca.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import webServerBusca.model.Lobby;
import webServerBusca.model.Musica;
import webServerBusca.model.Sala;

/**
 *
 * @author Breno
 */
public class ServidorBusca {

    public static Lobby lobby = new Lobby();
    public static Boolean autenticado = false;

    public static String todasMusicas() {

        return listarMusicas();
    }

    public static String todasSalas() {

        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        String json = gson.toJson(lobby.getSalas());
        return json;
    }

    public static String conectar(String jsonSala, String senha) {

        Gson gson = new Gson();

        Sala sala = gson.fromJson(jsonSala, Sala.class);

        if (!lobby.autenticar(sala)) {

            return "Senha inválida.";
        }
        
        autenticado = true;
        return todasMusicas();
    }

    public static String addMusica(String nomeMusica) {
        
        if (!autenticado) {
            
            return "Autentique-se primeiro";
        }
        
        Gson gson = new Gson();

        Musica musica = gson.fromJson(buscarMusica(nomeMusica), Musica.class);

        Sala sala = lobby.getSalaAtiva();
        sala.addMusica(musica);
        return "Musica adicionada.";
    }
    
    public static String addSala(String nome, String senha) {
        
        Sala sala = new Sala(nome, new LinkedList<Musica>(), null, senha);
        
        lobby.addSala(sala);
        lobby.setSalaAtiva(sala);
        
        return "Sala adicionada.";
    }

    public static String play(Thread tPlayer, Player player) {

        if (!autenticado) {
            
            return "Autentique-se primeiro.";
        }
        
        if (tPlayer.isAlive()) {

            return "Playlist já está em reprodução.";
        } else {

            tPlayer = new Thread(player);
            tPlayer.start();
            return "Reproduzindo playlist.";
        }
    }

    public static String stop(Thread tPlayer, Player player) {

        if (!autenticado) {
            
            return "Autentique-se primeiro.";
        }
        
        if (tPlayer.isAlive()) {

            tPlayer.interrupt();
            return "Stop.";
        } else {

            return "Playlist já está em parada.";
        }
    }

    private static String buscarMusica(java.lang.String nomeMusica) {
        webserver.Repositorio_Service service = new webserver.Repositorio_Service();
        webserver.Repositorio port = service.getRepositorioPort();
        return port.buscarMusica(nomeMusica);
    }

    private static String listarMusicas() {
        webserver.Repositorio_Service service = new webserver.Repositorio_Service();
        webserver.Repositorio port = service.getRepositorioPort();
        return port.listarMusicas();
    }

   

}
