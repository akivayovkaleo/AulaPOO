public class vendedor extends funcionario {
    private double total_vendas;

    public vendedor(String nome, double salario, int carga_horaria, double total_vendas) {
        super(nome, salario, carga_horaria);
        this.total_vendas = total_vendas;
    }

    @Override
    public double calcular_salario_mensal() {
        return (salario * carga_horaria) + (0.05 * total_vendas);
    }
}
