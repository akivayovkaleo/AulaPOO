public class Inimigo {
    private String nome;
    private int vida, ataque;
    private TipoInimigo tipo;
    private Elemento fraqueza;

    public Inimigo(String nome, int vida, int ataque, TipoInimigo tipo, Elemento fraqueza) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.tipo = tipo;
        this.fraqueza = fraqueza;
    }

    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public String getNome() { return nome; }
    public TipoInimigo getTipo() { return tipo; }
    public Elemento getFraqueza() { return fraqueza; }

    public void tomarDano(int dano) {
        this.vida -= dano;
    }

    public boolean estaVivo() {
        return vida > 0;
    }
}