import java.util.*;

public class Subclasse {
    private String nome;
    private List<Habilidade> habilidades;

    public Subclasse(String nome) {
        this.nome = nome;
        this.habilidades = new ArrayList<>();
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        habilidades.add(habilidade);
    }

    public String getNome() {
        return nome;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }
}