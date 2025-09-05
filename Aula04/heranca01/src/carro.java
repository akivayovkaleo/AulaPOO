public class carro extends veiculo {

    private int cavalos;

    public carro(String marca, int ano, String modelo, String cor, double valor, String detalhes, int cavalos) {
        super(marca, ano, modelo, cor, valor, detalhes);
        this.cavalos = cavalos;
    }

    public int getCavalos() {
        return cavalos;
    }

    public void setCavalos(int cavalos) {
        this.cavalos = cavalos;
    }

    @Override
    public void detalhes() {
       super.detalhes();
        System.out.println("Cavalos: " + cavalos);
    }
}
