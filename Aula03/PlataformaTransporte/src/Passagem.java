import java.time.LocalDateTime;

public class Passagem {
    private Veiculo veiculo;
    private Usuario usuario;
    private double valor;
    private LocalDateTime dataCompra;
    private LocalDateTime dataValidacao;
    private boolean validada;

    public Passagem(Veiculo veiculo, Usuario usuario, double valor) {
        this.veiculo = veiculo;
        this.usuario = usuario;
        this.valor = valor;
        this.dataCompra = LocalDateTime.now();
        this.validada = false;
    }

    public boolean validar() {
        if (!validada && usuario.pagarPassagem(valor)) {
            this.dataValidacao = LocalDateTime.now();
            this.validada = true;
            return veiculo.embarcarPassageiro();
        }
        return false;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public LocalDateTime getDataValidacao() {
        return dataValidacao;
    }

    public boolean isValidada() {
        return validada;
    }
}