public class Metro extends Veiculo {
    private String linha;
    private Estacao estacaoAtual;

    public Metro(String id, int capacidade, String linha) {
        super(id, capacidade);
        this.linha = linha;
    }

    @Override
    public String getTipo() {
        return "Metrô";
    }

    public String getLinha() {
        return linha;
    }

    public Estacao getEstacaoAtual() {
        return estacaoAtual;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public void setEstacaoAtual(Estacao estacaoAtual) {
        this.estacaoAtual = estacaoAtual;
    }
}