public class Papagaio extends Animal{
    private String fala;

    public Papagaio(int id, String especie, String cor, String fala) {
        super(id, especie, cor);
        this.fala = "Papagaio";
    }

    public String getFala() {
        return fala;
    }

    public void setFala(String fala) {
        this.fala = fala;
    }
}
