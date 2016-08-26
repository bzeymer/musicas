package webServer.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class Musica implements Serializable {

    private String nome;
    private String artista;
    private transient String nomeArquivo;

    
    public Musica(String x) {
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

    public String getAudio() {

        String audio = "";
        String aux = null;
        try {
            
            FileReader arquivo = new FileReader("dados/musicas/"+this.nomeArquivo);
            BufferedReader lerArquivo = new BufferedReader(arquivo);

            aux = lerArquivo.readLine();
            while (aux != null) {
                audio = audio + aux + "\n";

                aux = lerArquivo.readLine();
            }
            arquivo.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        
        return audio;
    }
}
