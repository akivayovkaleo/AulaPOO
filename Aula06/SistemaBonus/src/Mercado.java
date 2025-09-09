import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Mercado {
    private Map<String, Acao> acoesDisponiveis;

    public Mercado() {
        this.acoesDisponiveis = new HashMap<>();
    }

    public void adicionarAcao(Acao acao) {
        acoesDisponiveis.put(acao.getTicker(), acao);
    }

    public Acao getAcaoPorTicker(String ticker) {
        return acoesDisponiveis.get(ticker);
    }

    public void executarOrdem(Ordem ordem, Investidor investidor) {
        boolean sucesso = ordem.executar(this, investidor);
        if (sucesso) {
            System.out.println("Ordem executada com sucesso.");
        } else {
            System.out.println("Falha ao executar a ordem.");
        }
    }

    public void listarAcoes() {
        System.out.println("Ações disponíveis no mercado:");
        for (Acao acao : acoesDisponiveis.values()) {
            System.out.println(acao.getTicker() + " - " + acao.getNome() + "  Preço Atual: " + acao.consultarPrecoAtual());
        }
    }

    public void atualizarPrecos() {
        Random rand = new Random();
        for (Acao acao : acoesDisponiveis.values()) {
            double variacao = (rand.nextDouble() * 10) - 5;
            double novoPreco = acao.consultarPrecoAtual() * (1 + variacao / 100);
            String data = "2025-09-09";
            acao.atualizarPreco(data, novoPreco);
        }
        System.out.println("Preços atualizados no mercado.");
    }
}
