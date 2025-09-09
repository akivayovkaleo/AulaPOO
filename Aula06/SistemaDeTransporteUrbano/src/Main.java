import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Carro carro = new Carro();
        Barco barco = new Barco();
        Hidroaviao hidroaviao = new Hidroaviao();

        List<Object> veiculos = new ArrayList<>();
        veiculos.add(carro);
        veiculos.add(barco);
        veiculos.add(hidroaviao);

        System.out.println("Execução dos Veículos");

        for (Object veiculo : veiculos) {
            System.out.println("\nVerificando veículo: " + veiculo.getClass().getSimpleName() + " ---");

            if (veiculo instanceof Terrestre) {
                ((Terrestre) veiculo).dirigir();
            }
            if (veiculo instanceof Aquatico) {
                ((Aquatico) veiculo).navegar();
            }
            if (veiculo instanceof Aereo) {
                ((Aereo) veiculo).voar();
            }
        }

        System.out.println("\nAções Detalhadas do Hidroavião");
        hidroaviao.dirigir();
        hidroaviao.navegar();
        hidroaviao.voar();
        hidroaviao.navegar();
        hidroaviao.pousarNaAgua();
        hidroaviao.navegar();
        hidroaviao.voar();
        hidroaviao.pousarNaPista();
        hidroaviao.dirigir();
    }
}
