public class funcionario {
    protected String nome;
    protected double salario;
    protected int carga_horaria;

    public funcionario(String nome, double salario, int carga_horaria) {
        this.nome = nome;
        this.salario = salario;
        this.carga_horaria = carga_horaria;
    }

    public double calcular_salario_mensal() {
        return salario * carga_horaria;
    }
}
