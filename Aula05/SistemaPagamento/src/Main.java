import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FuncionarioHorista funcionarioHorista = new FuncionarioHorista("João Silva", "123.456.789-00", 20.0, 160);
        FuncionarioMensalista funcionarioMensalista = new FuncionarioMensalista("Maria Souza", "987.654.321-00", 3000.0);

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionarioHorista);
        funcionarios.add(funcionarioMensalista);

        double bonus = 500.0;

        for (Funcionario funcionario : funcionarios) {
            double salarioComBonus = funcionario.calcularSalario(bonus);
            System.out.println(funcionario);
            System.out.println("Salário (com bônus): R$" + salarioComBonus);
            System.out.println();
        }
    }
}
