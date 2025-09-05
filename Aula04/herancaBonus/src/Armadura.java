public class Armadura extends Equipamento {
    private int valorDefesa;
    private int bonusVida;

    public Armadura(String nome, RaridadeItem raridade, int valorDefesa, int bonusVida) {
        super(nome, raridade);
        this.valorDefesa = valorDefesa;
        this.bonusVida = bonusVida;
    }

    public int getValorDefesa() {
        return valorDefesa;
    }

    public int getBonusVida() {
        return bonusVida;
    }
}