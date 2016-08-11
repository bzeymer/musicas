package model;

public class Album {

    private Integer id;
    private Artista artista;
    private String nome;
    private String ano;

    public Artista getArtista() {
        return artista;
    }

    public String getNome() {
        return nome;
    }

    public String getAno() {
        return ano;
    }

}
