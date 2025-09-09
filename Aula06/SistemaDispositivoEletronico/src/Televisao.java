public class Televisao implements Ligavel, Conectavel {

    private boolean ligado = false;

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Televisão ligada.");
    }

    @Override
    public void desligar() {
        ligado = false;
        System.out.println("Televisão desligada.");
    }

    @Override
    public void conectar() {
        if (ligado) {
            System.out.println("Televisão conectada à rede.");
        } else {
            System.out.println("Ligue a televisão antes de conectar.");
        }
    }
}
