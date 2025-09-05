public class contaPoupanca extends contaBancaria {
    private double taxaJuros;

    public contaPoupanca(String titular, double saldo, double taxaJuros) {
        super(titular, saldo);
        this.taxaJuros = taxaJuros;
    }

    public void aplicarJuros() {
        this.saldo += this.saldo * taxaJuros;
    }
}
