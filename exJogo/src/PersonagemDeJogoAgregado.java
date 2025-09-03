public class PersonagemDeJogoAgregado {
    private String nome;
    private String tipo;
    private int vida;
    private int forca;
    private Arma arma;
    private PetMagico pet;

    public PersonagemDeJogoAgregado(String nome, String tipo, int vida, int forca, Arma arma, PetMagico pet) {
        this.nome = nome;
        this.tipo = tipo;
        this.vida = vida;
        this.forca = forca;
        this.arma = arma;
        this.pet = pet;
    }

    public void atacar(PersonagemDeJogoAgregado alvo, int tipoAtaque) {
        int danoBaseAtaque = 0;
        String descricaoAtaque = "";

        switch (this.tipo.toLowerCase()) {
            case "guerreiro" -> {
                switch (tipoAtaque) {
                    case 1 -> { danoBaseAtaque = 15; descricaoAtaque = "golpe forte com a espada"; }
                    case 2 -> { danoBaseAtaque = 10; descricaoAtaque = "ataque rápido com a espada"; }
                    case 3 -> { danoBaseAtaque = 7; descricaoAtaque = "ataque defensivo"; }
                    default -> { danoBaseAtaque = 10; descricaoAtaque = "ataque padrão"; }
                }
            }
            case "mago" -> {
                switch (tipoAtaque) {
                    case 1 -> { danoBaseAtaque = 20; descricaoAtaque = "bola de fogo"; }
                    case 2 -> { danoBaseAtaque = 15; descricaoAtaque = "raio congelante"; }
                    case 3 -> { danoBaseAtaque = 10; descricaoAtaque = "ataque mágico fraco"; }
                    default -> { danoBaseAtaque = 15; descricaoAtaque = "ataque mágico padrão"; }
                }
            }
            case "arqueiro" -> {
                switch (tipoAtaque) {
                    case 1 -> { danoBaseAtaque = 18; descricaoAtaque = "flecha perfurante"; }
                    case 2 -> { danoBaseAtaque = 12; descricaoAtaque = "flecha rápida"; }
                    case 3 -> { danoBaseAtaque = 8; descricaoAtaque = "ataque à distância fraco"; }
                    default -> { danoBaseAtaque = 12; descricaoAtaque = "ataque padrão"; }
                }
            }
            default -> {
                danoBaseAtaque = 8;
                descricaoAtaque = "ataque básico";
            }
        }

        int danoTotal = danoBaseAtaque + this.forca + this.arma.getDanoBase();

        System.out.println(this.nome + " " + descricaoAtaque + " usando " + this.arma.getNome() + ", causando " + danoTotal + " de dano.");
        alvo.receberDano(danoTotal);
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;
        System.out.println(this.nome + " recebeu " + dano + " de dano. Vida restante: " + this.vida);
    }

    public void usarPet() {
        if (pet == null || pet.isUsado()) {
            System.out.println("Pet não disponível ou já usado!");
            return;
        }

        if (pet.getTipo().equalsIgnoreCase("curador")) {
            this.vida += pet.getValor();
            System.out.println(this.nome + " usou " + pet.getNome() + " e recuperou " + pet.getValor() + " de vida.");
        } else if (pet.getTipo().equalsIgnoreCase("fortalecedor")) {
            this.forca += pet.getValor();
            System.out.println(this.nome + " usou " + pet.getNome() + " e aumentou " + pet.getValor() + " de força.");
        }
        pet.usar();
    }

    public boolean podeUsarPet() {
        return pet != null && !pet.isUsado();
    }

    public void exibirStatus() {
        System.out.println("Nome: " + this.nome + ", Tipo: " + this.tipo + ", Vida: " + this.vida + ", Força: " + this.forca + ", Arma: " + this.arma.getNome() + ", Pet: " + (pet != null ? pet.getNome() : "Nenhum"));
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

    public Arma getArma() {
        return arma;
    }

    public PetMagico getPet() {
        return pet;
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

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setPet(PetMagico pet) {
        this.pet = pet;
    }
}
