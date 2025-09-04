public class Bicicleta extends Veiculo {
    private String modelo;
    private boolean disponivel;

    public Bicicleta(String id, String modelo) {
        super(id, 1); // Capacidade de 1 pessoa
        this.modelo = modelo;
        this.disponivel = true;
    }

    @Override
    public String getTipo() {
        return "Bicicleta";
    }

    @Override
    public boolean embarcarPassageiro() {
        if (disponivel && !emManutencao) {
            disponivel = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean desembarcarPassageiro() {
        disponivel = true;
        return true;
    }


    public String getModelo() {
        return modelo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}