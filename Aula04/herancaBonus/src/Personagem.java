public abstract class Personagem implements Combatente {
    protected String nome;
    protected int nivel;
    protected int experiencia;
    protected int forca;
    protected int destreza;
    protected int inteligencia;
    protected int vida;
    protected int vidaMaxima;
    protected int energia;
    protected int energiaMaxima;
    protected int danoFisico;
    protected int danoDeHabilidade;
    protected int chanceDeAcerto;
    protected int chanceDeCritico;
    protected int evasao;
    protected Arma armaEquipada;
    protected Armadura armaduraEquipada;
    protected Inventario inventario;
    protected int creditos;

    public Personagem(String nome, int forca, int destreza, int inteligencia) {
        this.nome = nome;
        this.nivel = 1;
        this.experiencia = 0;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.atualizarAtributos();
        this.inventario = new Inventario();
        this.creditos = 0;
    }

    protected void atualizarAtributos() {
        this.vidaMaxima = 50 + (forca * 10) + (nivel * 5);
        if (this.vida > this.vidaMaxima || this.vida == 0) {
            this.vida = this.vidaMaxima;
        }
        this.energiaMaxima = 30 + (inteligencia * 5) + (nivel * 3);
        if (this.energia > this.energiaMaxima) {
            this.energia = this.energiaMaxima;
        }
        this.danoFisico = forca * 2;
        this.danoDeHabilidade = inteligencia * 3;
        this.chanceDeAcerto = 80 + (destreza * 2);
        this.chanceDeCritico = destreza;
        this.evasao = destreza * 2;
    }

    public void ganharExperiencia(int exp) {
        experiencia += exp;
        if (experiencia >= nivel * 100) {
            experiencia -= nivel * 100;
            subirNivel();
        }
    }

    protected void subirNivel() {
        nivel++;
        atualizarAtributos();
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) vida = 0;
    }

    public void atacar(Combatente alvo) {
        int dano = danoFisico + (armaEquipada != null ? armaEquipada.getDanoBase() : 0);
        alvo.receberDano(dano);
    }

    public String getNome() { return nome; }
    public int getNivel() { return nivel; }
    public int getVida() { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getEnergia() { return energia; }
    public int getEnergiaMaxima() { return energiaMaxima; }
    public int getForca() { return forca; }
    public int getDestreza() { return destreza; }
    public int getInteligencia() { return inteligencia; }
    public Arma getArmaEquipada() { return armaEquipada; }
    public Armadura getArmaduraEquipada() { return armaduraEquipada; }
    public Inventario getInventario() { return inventario; }
    public int getCreditos() { return creditos; }
    public void adicionarCreditos(int valor) { creditos += valor; }
}