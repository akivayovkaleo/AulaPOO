import java.util.*;

public class Chefe extends Inimigo {
    private List<Habilidade> habilidades;

    public Chefe(String nome, int vida, int ataque, TipoInimigo tipo, Elemento fraqueza) {
        super(nome, vida, ataque, tipo, fraqueza);
        this.habilidades = new ArrayList<>();
        habilidades.add(new Habilidade("Ataque Especial", "Ataque poderoso do chefe", 100, 0, ataque * 2));
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }
}