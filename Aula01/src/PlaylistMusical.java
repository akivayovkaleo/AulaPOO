import java.util.ArrayList;

public class PlaylistMusical {
    private String nome;
    private String musicaAtual;
    private ArrayList<String> musicas;
    private int indiceAtual;
    public PlaylistMusical(String nome) {
        this.nome = nome;
        this.musicaAtual = null;
        this.musicas = new ArrayList<String>();
        this.indiceAtual = -1;
    }
    public void adicionarMusica(String musica) {
        this.musicas.add(musica);
        System.out.println("Musica '" + musica + "' adicionada a playlist '" + this.nome + "'.");
        if (this.musicas.size() == 1 && this.indiceAtual == -1) {
            this.indiceAtual = 0;
            this.musicaAtual = musica;
            System.out.println("Tocando a primeira musica: " + this.musicaAtual);
        }
    }

    public void tocarProxima() {
        this.indiceAtual = this.indiceAtual + 1;
        this.musicaAtual = this.musicas.get(this.indiceAtual);
        System.out.println("Tocando agora: " + this.musicaAtual);
    }

    public void mostrarMusicaAtual() {
            System.out.println("Musica atual na playlist '" + this.nome + "': " + this.musicaAtual);
    }

    public String getNome() {
        return nome;
    }

    public int getTotalMusicas() {
        return this.musicas.size();
    }
}