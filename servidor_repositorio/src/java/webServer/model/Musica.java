package webServer.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;

public class Musica implements Serializable {

    private Integer id;
    private String nome;
    private String artista;
    private String nomeArquivo;

    
    public Musica(String x) {
        this.id = Integer.parseInt(x);
        this.nome = x;
        this.artista = x;
        this.nomeArquivo = x;
    }
    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public Integer getId() {
        return id;
    }

    public String getArquivo() throws IOException {

        String musica = "";

        FileReader f = new FileReader(this.nomeArquivo);
        BufferedReader fin = new BufferedReader(f);
        String aux = fin.readLine();
        while (aux != null) {

            musica.concat(aux);
            aux = fin.readLine();
        }

        return musica;
    }

}
