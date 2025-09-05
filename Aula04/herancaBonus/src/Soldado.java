public class Soldado extends Personagem {
    public Soldado(String nome) {
        super(nome, 15, 10, 5);
        this.armaEquipada = new RifleDePlasma();
        this.armaduraEquipada = new ExoesqueletoLeve();
    }

    @Override
    protected void subirNivel() {
        super.subirNivel();
        forca += 3;
        destreza += 1;
        inteligencia += 1;
        atualizarAtributos();
    }
}