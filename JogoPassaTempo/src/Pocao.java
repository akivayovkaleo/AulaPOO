public class Pocao extends Item {
    private int cura;

    public Pocao(String nome, Raridade raridade, int cura) {
        super(nome, raridade);
        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }
}