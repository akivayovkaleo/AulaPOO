public class aviao extends veiculo {

    private String companhia;

    public aviao(String marca, int ano, String modelo, String cor, double valor, String detalhes, String companhia) {
        super(marca, ano, modelo, cor, valor, detalhes);
        this.companhia = companhia;

    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    @Override
    public void detalhes() {
        super.detalhes();
        System.out.println("Companhia: " + companhia);
    }
}
