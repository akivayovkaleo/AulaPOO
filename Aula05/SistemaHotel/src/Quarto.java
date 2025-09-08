public class Quarto {
    private String tipo;
    private double precoDiaria;

    public Quarto(String tipo, double precoDiaria) {
        this.tipo = tipo;
        this.precoDiaria = precoDiaria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    @Override
    public String toString() {
        return "Quarto: " + tipo + " | Preço da Diária: R$" + precoDiaria;
    }
}
