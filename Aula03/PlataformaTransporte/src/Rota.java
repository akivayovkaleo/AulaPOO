import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Rota {
    private String nome;
    private List<Veiculo> veiculos;
    private double tempoEstimado; // em minutos
    private double custoTotal;

    public Rota(String nome) {
        this.nome = nome;
        this.veiculos = new ArrayList<>();
        this.tempoEstimado = 0;
        this.custoTotal = 0;
    }

    public void adicionarVeiculo(Veiculo veiculo, double custo, double tempo) {
        veiculos.add(veiculo);
        this.custoTotal += custo;
        this.tempoEstimado += tempo;
    }


    public String getNome() {
        return nome;
    }

    public List<Veiculo> getVeiculos() {
        return new ArrayList<>(veiculos);
    }

    public double getTempoEstimado() {
        return tempoEstimado;
    }

    public double getCustoTotal() {
        return custoTotal;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTempoEstimado(double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }
}