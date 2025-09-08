public class Flash extends Heroi {

    public Flash(String nome, int vida, int forca) {
        super(nome, vida, forca);
    }

    @Override
    public void usarPoder() {
        System.out.println(nome + " usou Super Velocidade!");
    }
}
