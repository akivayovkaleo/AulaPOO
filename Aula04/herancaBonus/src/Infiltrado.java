public class Infiltrado extends Personagem {
    public Infiltrado(String nome) {
        super(nome, 10, 15, 8);
        this.armaEquipada = new LaminasCiberneticas();
        this.armaduraEquipada = new CamuflagemEnergetica();
    }

    @Override
    protected void subirNivel() {
        super.subirNivel();
        forca += 1;
        destreza += 3;
        inteligencia += 1;
        atualizarAtributos();
    }
}