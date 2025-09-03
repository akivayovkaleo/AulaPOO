public class PetVirtual {
    private String nome;
    private int fome;
    private int felicidade;

    public PetVirtual(String nome) {
        this.nome = nome;
        this.fome = 50;
        this.felicidade = 50;
    }

    public void alimentar() {
        this.fome = this.fome - 20;
        if (this.fome < 0) {
            this.fome = 0;
        }
        System.out.println(nome + " foi alimentado! Fome diminuiu.");
    }

    public void brincar() {
        this.felicidade = this.felicidade + 15;
        if (this.felicidade > 100) {
            this.felicidade = 100;
        }
        System.out.println(nome + " brincou ");
        this.fome = this.fome + 10;
        if (this.fome > 100) {
            this.fome = 100;
        }
    }

    public void status() {
        System.out.println("Status do " + nome + " ");
        System.out.println("Fome: " + this.fome);
        System.out.println("Felicidade: " + this.felicidade);
        if (this.fome > 80) {
            System.out.println(nome + " esta com muita fome e triste.");
        }
        if (this.felicidade < 20) {
            System.out.println(nome + " esta muito triste...");
        } else if (this.felicidade > 80) {
            System.out.println(nome + " esta muito feliz!");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getFome() {
        return fome;
    }

    public int getFelicidade() {
        return felicidade;
    }

    public void setFelicidade(int felicidade) {
        if (felicidade < 0) {
            this.felicidade = 0;
        } else if (felicidade > 100) {
            this.felicidade = 100;
        } else {
            this.felicidade = felicidade;
        }
    }

    public void setFome(int fome) {
        if (fome < 0) {
            this.fome = 0;
        } else if (fome > 100) {
            this.fome = 100;
        } else {
            this.fome = fome;
        }
    }
}