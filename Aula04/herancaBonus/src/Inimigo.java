public abstract class Inimigo implements Combatente {
    protected String nome;
    protected int nivel;
    protected int vida;
    protected int vidaMaxima;
    protected int danoFisico;
    protected int chanceDeAcerto;
    protected int evasao;

    public Inimigo(String nome, int nivel, int vida, int danoFisico) {
        this.nome = nome;
        this.nivel = nivel;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.danoFisico = danoFisico;
        this.chanceDeAcerto = 75 + nivel;
        this.evasao = nivel * 2;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }

    public void atacar(Combatente alvo) {
        alvo.receberDano(danoFisico);
    }

    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getNivel() { return nivel; }
}