public class Musica extends Conteudo {
    private String artista;
    private String album;

    public Musica(String titulo, int duracao, String genero, String artista, String album) {
        super(titulo, duracao, genero);
        this.artista = artista;
        this.album = album;
    }

    @Override
    public String getTipo() {
        return "Música";
    }

    // Getters
    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }
}