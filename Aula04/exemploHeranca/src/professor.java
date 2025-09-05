public class professor extends pessoa {
    private String disciplina;
    private double salario;

    public professor(int id, String nome, String cpf, int idade, String sexo, String disciplina, double salario) {
        super(id, nome, cpf, idade, sexo);
        this.disciplina = disciplina;
        this.salario = salario;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
