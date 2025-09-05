public class gerente extends funcionario {
    private double bonus;

    public gerente(String nome, double salario, int carga_horaria, double bonus) {
        super(nome, salario, carga_horaria);
        this.bonus = bonus;
    }

    @Override
    public double calcular_salario_mensal() {
        return (salario * carga_horaria) + bonus;
    }
}
