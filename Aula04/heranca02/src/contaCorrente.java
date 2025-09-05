public class contaCorrente extends contaBancaria {
    private double chequeEspecial;

    public contaCorrente(String titular, double saldo, double chequeEspecial) {
        super(titular, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void depositar(double valor) {
        super.depositar(valor);
        if (this.getSaldo() > chequeEspecial) {
            System.out.println("Atenção: saldo ultrapassa o limite do cheque especial de R$" + chequeEspecial);
        }
    }
}
