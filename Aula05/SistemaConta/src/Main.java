public class Main {
    public static void main(String[] args) {

        ContaBancaria contaBancaria = new ContaBancaria();
        System.out.println("Saldo inicial da Conta Bancária: R$" + contaBancaria.getSaldo());

        contaBancaria.depositar(500);
        contaBancaria.depositar(200, "salário");
        contaBancaria.sacar(300);
        contaBancaria.sacar(100, 10);

        System.out.println("Saldo final da Conta Bancária: R$" + contaBancaria.getSaldo());

        ContaCorrente contaCorrente = new ContaCorrente();
        System.out.println("\nSaldo inicial da Conta Corrente: R$" + contaCorrente.getSaldo());


        contaCorrente.depositar(500);
        contaCorrente.depositar(200, "presente");
        contaCorrente.sacar(200);
        contaCorrente.sacar(100, 5);

        System.out.println("Saldo final da Conta Corrente: R$" + contaCorrente.getSaldo());
    }
}
