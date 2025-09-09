public class CartaoCredito implements MetodoPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " com Cartão de Crédito.");
    }
}
