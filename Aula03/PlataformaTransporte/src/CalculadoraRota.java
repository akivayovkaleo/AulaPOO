
import java.util.List;

public class CalculadoraRota {

    public Rota calcularRotaOtima(List<Veiculo> veiculos, String origem, String destino) {
        Rota rota = new Rota("Rota de " + origem + " para " + destino);


        double custoBase = 5.0;
        double tempoBase = 30.0;

        for (Veiculo veiculo : veiculos) {
            if (!veiculo.isEmManutencao()) {
                rota.adicionarVeiculo(veiculo, custoBase, tempoBase);
                custoBase += 2.0;
                tempoBase += 15.0;
            }
        }

        return rota;
    }

    public double calcularTempoTotal(Rota rota) {
        return rota.getTempoEstimado();
    }

    public double calcularCustoTotal(Rota rota) {
        return rota.getCustoTotal();
    }
}