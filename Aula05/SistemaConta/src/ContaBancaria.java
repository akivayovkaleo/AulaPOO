public class ContaBancaria {
    private double saldo;

    public ContaBancaria() {
        this.saldo = 0.0;
    }


    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado.");
    }


    public void depositar(double valor, String descricao) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado. Tipo: " + descricao);
    }


    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }


    public void sacar(double valor, double taxa) {
        double totalSaque = valor + taxa;
        if (saldo >= totalSaque) {
            saldo -= totalSaque;
            System.out.println("Saque de R$" + valor + " realizado com uma taxa de R$" + taxa);
        } else {
            System.out.println("Saldo insuficiente para o saque com taxa.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
