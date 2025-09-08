public class Armadura extends Item {
    private int defesa;

    public Armadura(String nome, Raridade raridade, int defesa) {
        super(nome, raridade);
        this.defesa = defesa;
    }

    public int getDefesa() {
        return defesa;
    }
}