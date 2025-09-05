public class Engenheiro extends Personagem {
    public Engenheiro(String nome) {
        super(nome, 8, 10, 15);
        this.armaEquipada = new PistolaDeEnergia();
        this.armaduraEquipada = new BlindagemAdaptativa();
    }

    @Override
    protected void subirNivel() {
        super.subirNivel();
        forca += 1;
        destreza += 1;
        inteligencia += 3;
        atualizarAtributos();
    }
}