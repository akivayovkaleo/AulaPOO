public class Libelula extends Animal implements Voador{
    private String comerInseto;

    public String getComerInseto() {
        return comerInseto;
    }

    public void setComerInseto(String comerInseto) {
        this.comerInseto = comerInseto;
    }

    public Libelula(int id, String especie, String cor, String comerInseto) {
        super(id, especie, cor);
        this.comerInseto = comerInseto;

    }

    @Override
    public void voar() {

    }

    @Override
    public void pousar() {

    }

}
