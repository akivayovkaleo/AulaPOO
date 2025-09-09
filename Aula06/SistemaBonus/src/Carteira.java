import java.util.HashMap;
import java.util.Map;

public class Carteira {

    private class Posicao {
        int quantidade;
        double precoMedioCompra;

        Posicao(int quantidade, double precoMedioCompra) {
            this.quantidade = quantidade;
            this.precoMedioCompra = precoMedioCompra;
        }
    }

    private Map<String, Posicao> acoesPosse;

    public Carteira() {
        acoesPosse = new HashMap<>();
    }

    public void adicionarAcao(Acao acao, int quantidade, double precoCompra) {
        String ticker = acao.getTicker();
        if (acoesPosse.containsKey(ticker)) {
            Posicao pos = acoesPosse.get(ticker);
            int novaQuantidade = pos.quantidade + quantidade;
            double novoPrecoMedio = ((pos.precoMedioCompra * pos.quantidade) + (precoCompra * quantidade)) / novaQuantidade;
            pos.quantidade = novaQuantidade;
            pos.precoMedioCompra = novoPrecoMedio;
        } else {
            acoesPosse.put(ticker, new Posicao(quantidade, precoCompra));
        }
    }

    public boolean removerAcao(Acao acao, int quantidade, double precoVenda) {
        String ticker = acao.getTicker();
        if (acoesPosse.containsKey(ticker)) {
            Posicao pos = acoesPosse.get(ticker);
            if (pos.quantidade >= quantidade) {
                pos.quantidade -= quantidade;
                if (pos.quantidade == 0) {
                    acoesPosse.remove(ticker);
                }
                return true;
            }
        }
        return false;
    }

    public double calcularValorTotal(Map<String, Acao> acoesMercado) {
        double total = 0;
        for (Map.Entry<String, Posicao> entry : acoesPosse.entrySet()) {
            String ticker = entry.getKey();
            Posicao pos = entry.getValue();
            Acao acao = acoesMercado.get(ticker);
            if (acao != null) {
                total += pos.quantidade * acao.consultarPrecoAtual();
            }
        }
        return total;
    }

    public double calcularLucroPrejuizo(Map<String, Acao> acoesMercado) {
        double lucroPrejuizo = 0;
        for (Map.Entry<String, Posicao> entry : acoesPosse.entrySet()) {
            String ticker = entry.getKey();
            Posicao pos = entry.getValue();
            Acao acao = acoesMercado.get(ticker);
            if (acao != null) {
                lucroPrejuizo += pos.quantidade * (acao.consultarPrecoAtual() - pos.precoMedioCompra);
            }
        }
        return lucroPrejuizo;
    }

    public void mostrarDetalhes() {
        System.out.println("Ações na carteira:");
        for (Map.Entry<String, Posicao> entry : acoesPosse.entrySet()) {
            Posicao pos = entry.getValue();
            System.out.println("Ticker: " + entry.getKey() + " - Quantidade: " + pos.quantidade + " - Preço Médio: " + pos.precoMedioCompra);
        }
    }
}
