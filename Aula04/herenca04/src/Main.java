public class Main {
    public static void main(String[] args) {
        funcionario f = new funcionario("João", 25.0, 160);
        gerente g = new gerente("Maria", 30.0, 160, 2000.0);
        vendedor v = new vendedor("Carlos", 20.0, 160, 50000.0);

        System.out.println("Salário mensal do funcionário: R$" + f.calcular_salario_mensal());
        System.out.println("Salário mensal do gerente: R$" + g.calcular_salario_mensal());
        System.out.println("Salário mensal do vendedor: R$" + v.calcular_salario_mensal());
    }
}
