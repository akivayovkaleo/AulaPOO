public class Superman extends Heroi {

    public Superman(String nome, int vida, int forca) {
        super(nome, vida, forca);
    }

    @Override
    public void usarPoder() {
        System.out.println(" usou Super Força!");
    }
}
