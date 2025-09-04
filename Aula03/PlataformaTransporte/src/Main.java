
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Plataforma de Gestão de Transportes Urbanos ===\n");


        Usuario usuario1 = new Usuario("João Silva", "123.456.789-00", 50.0, "joao@email.com");
        Usuario usuario2 = new Usuario("Maria Santos", "987.654.321-00", 30.0, "maria@email.com");

        System.out.println("Usuários cadastrados:");
        System.out.println("- " + usuario1.getNome() + " (Saldo: R$ " + String.format("%.2f", usuario1.getSaldo()) + ")");
        System.out.println("- " + usuario2.getNome() + " (Saldo: R$ " + String.format("%.2f", usuario2.getSaldo()) + ")\n");

        Administrador admin = new Administrador("Carlos Admin", "Transportes");
        System.out.println("Administrador: " + admin.getNome() + " (" + admin.getDepartamento() + ")\n");

        Onibus onibus1 = new Onibus("O-101", 40, "Linha 10", "Viação São José");
        Metro metro1 = new Metro("M-201", 300, "Linha Azul");
        Bicicleta bike1 = new Bicicleta("B-001", "Caloi Elite");

        System.out.println("Veículos cadastrados:");
        System.out.println("- " + onibus1.getTipo() + " " + onibus1.getId() + " (Capacidade: " + onibus1.getCapacidade() + ")");
        System.out.println("- " + metro1.getTipo() + " " + metro1.getId() + " (Capacidade: " + metro1.getCapacidade() + ")");
        System.out.println("- " + bike1.getTipo() + " " + bike1.getId() + " (Modelo: " + bike1.getModelo() + ")\n");

        Estacao estacao1 = new Estacao("Estação Central", "Linha Azul");
        Estacao estacao2 = new Estacao("Estação Norte", "Linha Azul");
        metro1.setEstacaoAtual(estacao1);

        System.out.println("Estações:");
        System.out.println("- " + estacao1.getNome() + " (" + estacao1.getLinha() + ")");
        System.out.println("- " + estacao2.getNome() + " (" + estacao2.getLinha() + ")\n");

        Passagem passagem1 = new Passagem(onibus1, usuario1, 4.50);
        Passagem passagem2 = new Passagem(metro1, usuario2, 5.00);
        Passagem passagem3 = new Passagem(bike1, usuario1, 2.00);

        boolean validada1 = passagem1.validar();
        boolean validada2 = passagem2.validar();
        boolean validada3 = passagem3.validar();

        System.out.println("Validação de passagens:");
        System.out.println("- Passagem ônibus: " + (validada1 ? "Validada" : "Falhou"));
        System.out.println("- Passagem metrô: " + (validada2 ? "Validada" : "Falhou"));
        System.out.println("- Passagem bicicleta: " + (validada3 ? "Validada" : "Falhou"));
        System.out.println("Saldo atual de " + usuario1.getNome() + ": R$ " + String.format("%.2f", usuario1.getSaldo()) + "\n");

        Monitoramento monitoramento = new Monitoramento();
        monitoramento.adicionarVeiculo(onibus1);
        monitoramento.adicionarVeiculo(metro1);
        monitoramento.adicionarVeiculo(bike1);

        onibus1.setAtrasoMinutos(15);
        metro1.setAtrasoMinutos(5);
        monitoramento.notificarAtraso(onibus1, 15);
        monitoramento.notificarAtraso(metro1, 5);

        System.out.println("\nVeículos com atraso:");
        for (Veiculo veiculo : monitoramento.getVeiculosComAtraso()) {
            System.out.println("- " + veiculo.getTipo() + " " + veiculo.getId() + " (" + veiculo.getAtrasoMinutos() + " min atraso)");
        }

        CalculadoraRota calculadora = new CalculadoraRota();
        List<Veiculo> veiculosRota = new ArrayList<>();
        veiculosRota.add(onibus1);
        veiculosRota.add(metro1);

        Rota rota = calculadora.calcularRotaOtima(veiculosRota, "Centro", "Zona Norte");
        System.out.println("\nRota calculada:");
        System.out.println("- Nome: " + rota.getNome());
        System.out.println("- Tempo estimado: " + rota.getTempoEstimado() + " minutos");
        System.out.println("- Custo total: R$ " + String.format("%.2f", rota.getCustoTotal()));
        System.out.println("- Veículos na rota:");
        for (Veiculo veiculo : rota.getVeiculos()) {
            System.out.println("  * " + veiculo.getTipo() + " " + veiculo.getId());
        }

        Relatorio relatorioLotação = admin.gerarRelatorio("Lotação", "Relatório de lotação dos veículos");
        relatorioLotação.adicionarRegistros(3);

        Relatorio relatorioManutencao = admin.gerarRelatorio("Manutenção", "Relatório de veículos em manutenção");
        relatorioManutencao.adicionarRegistros(1);

        System.out.println("\nRelatórios gerados por " + admin.getNome() + ":");
        for (Relatorio rel : admin.getRelatoriosGerados()) {
            System.out.println("- " + rel.getTipo() + ": " + rel.getDescricao() +
                    " (" + rel.getTotalRegistros() + " registros)");
        }

        System.out.println("\nInformações dos veículos:");
        System.out.println("- Ônibus " + onibus1.getId() + ": " + onibus1.getLotacaoAtual() + "/" + onibus1.getCapacidade() + " passageiros");
        System.out.println("- Metrô " + metro1.getId() + ": " + metro1.getLotacaoAtual() + "/" + metro1.getCapacidade() + " passageiros");
        System.out.println("- Bicicleta " + bike1.getId() + ": " + (bike1.isDisponivel() ? "Disponível" : "Em uso"));
    }
}