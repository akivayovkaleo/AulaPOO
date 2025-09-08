import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservaHotel {
    private String nomeCliente;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valorDiaria;
    private double valorServicosExtras;

    public ReservaHotel(String nomeCliente, String dataEntrada, String dataSaida, double valorDiaria) {
        this.nomeCliente = nomeCliente;
        this.valorDiaria = valorDiaria;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataEntrada = LocalDate.parse(dataEntrada, formatter);
        this.dataSaida = LocalDate.parse(dataSaida, formatter);
        this.valorServicosExtras = 0.0;
    }

    public double calcularTotal(int numeroDiarias) {
        return numeroDiarias * valorDiaria;
    }

    public double calcularTotal(int numeroDiarias, double desconto) {
        double total = numeroDiarias * valorDiaria;
        return total - (total * desconto / 100);
    }

    public double calcularTotal(int numeroDiarias, double desconto, double valorExtras) {
        double total = numeroDiarias * valorDiaria;
        this.valorServicosExtras = valorExtras;
        double totalComDesconto = total - (total * desconto / 100);
        return totalComDesconto + valorServicosExtras;
    }

    public void exibirResumoReserva() {
        System.out.println("Resumo da Reserva:");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Data de Entrada: " + dataEntrada);
        System.out.println("Data de Saída: " + dataSaida);
        System.out.println("Valor da Diária: R$" + valorDiaria);
        System.out.println("Valor dos Serviços Extras: R$" + valorServicosExtras);
        System.out.println("Total de Diárias: " + calcularNumeroDiarias() + " diárias.");
    }

    private int calcularNumeroDiarias() {
        return (int) (dataSaida.toEpochDay() - dataEntrada.toEpochDay());
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataEntrada = LocalDate.parse(dataEntrada, formatter);
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataSaida = LocalDate.parse(dataSaida, formatter);
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorServicosExtras() {
        return valorServicosExtras;
    }

    public void setValorServicosExtras(double valorServicosExtras) {
        this.valorServicosExtras = valorServicosExtras;
    }
}
