public class FuncionarioHorista extends Funcionario {
    private double valorHora;
    private int horasTrabalhadas;

    public FuncionarioHorista(String nome, String cpf, double valorHora, int horasTrabalhadas) {
        super(nome, cpf);
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularSalario() {
        return valorHora * horasTrabalhadas;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Horista | Valor Hora: R$" + valorHora + " | Horas Trabalhadas: " + horasTrabalhadas;
    }
}
