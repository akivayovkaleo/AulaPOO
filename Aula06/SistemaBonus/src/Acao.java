import java.util.Map;
import java.util.TreeMap;

public class Acao {
    private String ticker;
    private String nome;
    private double precoAtual;
    private Map<String, Double> historicoPrecos;

    public Acao(String ticker, String nome, double precoInicial) {
        this.ticker = ticker;
        this.nome = nome;
        this.precoAtual = precoInicial;
        this.historicoPrecos = new TreeMap<>();
        historicoPrecos.put("2025-09-09", precoInicial);
    }

    public void atualizarPreco(String data, double novoPreco) {
        this.precoAtual = novoPreco;
        historicoPrecos.put(data, novoPreco);
    }

    public double consultarPrecoAtual() {
        return precoAtual;
    }

    public void mostrarHistorico() {
        System.out.println("Histórico de preços da ação " + ticker + ":");
        for (Map.Entry<String, Double> entry : historicoPrecos.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public String getTicker() {
        return ticker;
    }

    public String getNome() {
        return nome;
    }
}
