public class Smartphone implements Ligavel, Conectavel, Configuravel {

    private boolean ligado = false;

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Smartphone ligado.");
    }

    @Override
    public void desligar() {
        ligado = false;
        System.out.println("Smartphone desligado.");
    }

    @Override
    public void conectar() {
        if (ligado) {
            System.out.println("Smartphone conectado à rede.");
        } else {
            System.out.println("Ligue o smartphone antes de conectar.");
        }
    }

    @Override
    public void configurar() {
        System.out.println("Smartphone configurado com: ");
    }
}