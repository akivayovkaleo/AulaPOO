public class MulherMaravilha extends Heroi {

    public MulherMaravilha(String nome, int vida, int forca) {
        super(nome, vida, forca);
    }

    @Override
    public void usarPoder() {
        System.out.println(nome + " usou o Laço da Verdade!");
    }
}
