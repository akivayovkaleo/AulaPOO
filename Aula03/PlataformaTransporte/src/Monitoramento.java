
import java.util.ArrayList;
import java.util.List;

public class Monitoramento {
    private List<Veiculo> veiculos;
    private List<Usuario> usuariosNotificados;

    public Monitoramento() {
        this.veiculos = new ArrayList<>();
        this.usuariosNotificados = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void notificarAtraso(Veiculo veiculo, int minutosAtraso) {
        if (veiculo.getAtrasoMinutos() > 0) {
            System.out.println("🔔 Notificação: " + veiculo.getTipo() + " " + veiculo.getId() +
                    " está atrasado em " + minutosAtraso + " minutos.");
        }
    }

    public void notificarAlteracaoRota(Veiculo veiculo, String novaRota) {
        System.out.println("🔔 Notificação: " + veiculo.getTipo() + " " + veiculo.getId() +
                " teve alteração de rota para: " + novaRota);
    }

    public List<Veiculo> getVeiculosComAtraso() {
        List<Veiculo> veiculosComAtraso = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getAtrasoMinutos() > 0) {
                veiculosComAtraso.add(veiculo);
            }
        }
        return veiculosComAtraso;
    }

    public List<Veiculo> getVeiculosEmManutencao() {
        List<Veiculo> veiculosManutencao = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.isEmManutencao()) {
                veiculosManutencao.add(veiculo);
            }
        }
        return veiculosManutencao;
    }
}