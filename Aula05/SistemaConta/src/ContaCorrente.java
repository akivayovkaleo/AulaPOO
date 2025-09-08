public class ContaCorrente extends ContaBancaria {
    private final double taxaServico = 2.50;


    @Override
    public void depositar(double valor) {
        double valorComTaxa = valor - taxaServico;
        super.depositar(valorComTaxa);
        System.out.println("Taxa de serviço de R$" + taxaServico + " aplicada.");
    }
}
