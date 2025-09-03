public class PersonagemDeJogo {
    private String nome;
    private String tipo;
    private int vida;
    private int forca;
    public PersonagemDeJogo(String nome, String tipo, int vida, int forca) {
        this.nome = nome;
        this.tipo = tipo;
        this.vida = vida;
        this.forca = forca;
    }
    public void atacar() {
        String ataque = switch (this.tipo.toLowerCase()) {
            case "guerreiro" -> " ataca com sua espada!";
            case "mago" -> " lanca uma bola de fogo!";
            case "arqueiro" -> " dispara uma flecha precisa!";
            default -> " realiza um ataque basico!";
        };
        System.out.println(this.nome + ataque);
    }
    
    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nome + " recebeu " + dano + " de dano. Vida restante: " + this.vida);
    }
    public void exibirStatus() {
        System.out.println("Nome: " + this.nome + ", Tipo: " + this.tipo + ", Vida: " + this.vida);
    }
    public String getNome() {
        return nome;
    }
    public int getVida() {
        return vida;
    }
    public int getForca() {
        return forca;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void setForca(int forca) {
        this.forca = forca;
    }
}