public class Arma extends Equipamento {
    private int danoBase;

    public Arma(String nome, RaridadeItem raridade, int danoBase) {
        super(nome, raridade);
        this.danoBase = danoBase;
    }

    public int getDanoBase() {
        return danoBase;
    }
}