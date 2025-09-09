public class Main {
    public static void main(String[] args) {
        Mercado mercado = new Mercado();

        Acao aapl = new Acao("AAPL", "Apple Inc.", 150);
        Acao googl = new Acao("GOOGL", "Alphabet Inc.", 2800);

        mercado.adicionarAcao(aapl);
        mercado.adicionarAcao(googl);

        Investidor investidor = new Investidor("Carlos", 10000);

        mercado.listarAcoes();

        Ordem ordemCompra = new OrdemCompra("AAPL", 20);
        Ordem ordemVenda = new OrdemVenda("AAPL", 5);

        mercado.executarOrdem(ordemCompra, investidor); // Compra 20 AAPL
        mercado.executarOrdem(ordemVenda, investidor);  // Vende 5 AAPL

        investidor.mostrarCarteira();

        System.out.println("Saldo disponível: " + investidor.consultarSaldo());
    }
}
