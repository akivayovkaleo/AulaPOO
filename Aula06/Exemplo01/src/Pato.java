public class Pato extends Animal{

    private String Quack;

    public Pato(int id, String especie, String cor, String quack) {
        super(id, especie, cor);
        this.Quack = quack;

    }

    public String getQuack() {
        return Quack;
    }

    public void setQuack(String quack) {
        Quack = quack;
    }
}
