import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private List<Conteudo> itens;
    private boolean isPublica;

    public Playlist(String nome) {
        this.nome = nome;
        this.itens = new ArrayList<>();
        this.isPublica = true;
    }

    public void adicionarConteudo(Conteudo conteudo) {
        itens.add(conteudo);
    }

    public void removerConteudo(Conteudo conteudo) {
        itens.remove(conteudo);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public List<Conteudo> getItens() {
        return new ArrayList<>(itens);
    }

    public boolean isPublica() {
        return isPublica;
    }

    public void setPublica(boolean publica) {
        isPublica = publica;
    }
}