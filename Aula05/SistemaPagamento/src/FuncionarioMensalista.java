public class FuncionarioMensalista extends Funcionario {
    private double salarioFixo;

    public FuncionarioMensalista(String nome, String cpf, double salarioFixo) {
        super(nome, cpf);
        this.salarioFixo = salarioFixo;
    }

    @Override
    public double calcularSalario() {
        return salarioFixo;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Mensalista | Salário Fixo: R$" + salarioFixo;
    }
}
