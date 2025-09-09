public class OrdemCompra implements Ordem {
    private String ticker;
    private int quantidade;

    public OrdemCompra(String ticker, int quantidade) {
        this.ticker = ticker;
        this.quantidade = quantidade;
    }

    @Override
    public boolean executar(Mercado mercado, Investidor investidor) {
        Acao acao = mercado.getAcaoPorTicker(ticker);
        if (acao == null) {
            System.out.println("Ação " + ticker + " não encontrada no mercado.");
            return false;
        }
        double preco = acao.consultarPrecoAtual();
        return investidor.comprarAcao(acao, quantidade, preco);
    }
}
