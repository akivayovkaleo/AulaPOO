public class Lampada {
    private boolean ligada;
    private String cor;

    public Lampada() {
        this.ligada = false;
        this.cor = "branco";
    }

    public void ligar() {
        this.ligada = true;
        System.out.println("Lampada ligada.");
    }

    public void desligar() {
        this.ligada = false;
        System.out.println("Lampada desligada.");
    }

    public void trocarCor(String novaCor) {
        if (this.ligada == true) {
            this.cor = novaCor;
            System.out.println("Cor da lampada trocada para " + this.cor + ".");
        } else {
            System.out.println("Nao e possivel trocar a cor de uma lampada desligada.");
        }
    }

    public void mostrarEstado() {
        if (this.ligada == true) {
            System.out.println("Lampada esta LIGADA, cor: " + this.cor);
        } else {
            System.out.println("Lampada esta DESLIGADA.");
        }
    }

    public boolean isLigada() {
        return ligada;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}