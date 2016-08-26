/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServerBusca.model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Breno
 */
public class Sala implements Serializable{

    

    private String nomeSala;
    private LinkedList<Musica> playlist;
    private Musica musicaAtual;
    private transient String senha;

    public Sala(String nomeSala, LinkedList<Musica> playlist, Musica musicaAtual, String senha) {
        this.nomeSala = nomeSala;
        this.playlist = playlist;
        this.musicaAtual = musicaAtual;
        this.senha = senha;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public LinkedList<Musica> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(LinkedList<Musica> playlist) {
        this.playlist = playlist;
    }

    public Musica getMusicaAtual() {
        return musicaAtual;
    }

    public void setMusicaAtual(Musica musicaAtual) {
        this.musicaAtual = musicaAtual;
    }

    public void addMusica(Musica musica) {
        
        this.playlist.add(musica);
    }
    
    public void nextTrack() {
        
        if (!this.playlist.isEmpty()){
            this.musicaAtual = this.playlist.removeFirst();
        } else {
            this.musicaAtual = null;
        }
    }

    public String getSenha() {
        return senha;
    }
    
    
    
    
    
}
