import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        contaCorrente cc = new contaCorrente("kaleo", 1000.0, 1500.0);
        contaPoupanca cp = new contaPoupanca("kaleo1", 2000.0, 0.05);

        System.out.println("Depósito na conta corrente:");
        System.out.print("Digite o valor: ");
        double valorCC = sc.nextDouble();
        cc.depositar(valorCC);
        cc.consultarSaldo();

        System.out.println();

        System.out.println("Depósito na conta poupança:");
        System.out.print("Digite o valor: ");
        double valorCP = sc.nextDouble();
        cp.depositar(valorCP);
        cp.aplicarJuros();
        cp.consultarSaldo();

        sc.close();
    }
}
