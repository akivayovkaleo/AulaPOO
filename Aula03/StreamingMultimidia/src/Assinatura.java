import java.time.LocalDate;

public class Assinatura {
    private String tipo;
    private double valorMensal;
    private LocalDate dataInicio;
    private boolean ativa;

    public Assinatura(String tipo, double valorMensal) {
        this.tipo = tipo;
        this.valorMensal = valorMensal;
        this.dataInicio = LocalDate.now();
        this.ativa = true;
    }

    // === GETTERS ===
    public String getTipo() {
        return tipo;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public boolean isAtiva() {
        return ativa;
    }

    // === SETTERS ===
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    // Métodos adicionais
    public void renovar() {
        this.dataInicio = LocalDate.now();
        this.ativa = true;
    }

    public void cancelar() {
        this.ativa = false;
    }
}