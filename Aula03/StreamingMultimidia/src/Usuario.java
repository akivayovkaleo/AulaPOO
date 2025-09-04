import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private boolean isPremium;
    private List<Playlist> playlists;
    private List<Conteudo> historico;
    private Assinatura assinatura;
    private List<Avaliacao> avaliacoes;

    public Usuario(String nome, boolean isPremium) {
        this.nome = nome;
        this.isPremium = isPremium;
        this.playlists = new ArrayList<>();
        this.historico = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        if (isPremium) {
            this.assinatura = new Assinatura("Premium", 29.90);
        }
    }

    public void adicionarAoHistorico(Conteudo conteudo) {
        historico.add(conteudo);
    }

    public void criarPlaylist(String nome) {
        playlists.add(new Playlist(nome));
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public List<Conteudo> getHistorico() {
        return new ArrayList<>(historico);
    }

    public List<Playlist> getPlaylists() {
        return new ArrayList<>(playlists);
    }

    public List<Avaliacao> getAvaliacoes() {
        return new ArrayList<>(avaliacoes);
    }

    public String getNome() {
        return nome;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }
}