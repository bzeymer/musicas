package model;

import java.io.Serializable;
import javax.sound.sampled.AudioInputStream;


public class Musica implements Serializable {

    private Integer id;
    private String nome;
    private Integer duracaoSegundos;
    private Integer tamanhoBytes;
    private String genero;
    private Artista artista;
    private Album album;
    private String nomeArquivo;

    public String getNome() {
        return nome;
    }

    public Integer getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public Integer getTamanhoBytes() {
        return tamanhoBytes;
    }

    public String getGenero() {
        return genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public Album getAlbum() {
        return album;
    }
    
    public String getNomeArquivo() {
        return nomeArquivo;
    }
    
    
        
}
