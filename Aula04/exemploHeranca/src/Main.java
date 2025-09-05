public class Main {
    public static void main(String[] args) {
        aluno aluno1 = new aluno(1, "João", "123.456.789-00", 20, "Masculino", "A123", "Engenharia");
        professor professor1 = new professor(2, "Maria", "987.654.321-00", 35, "Feminino", "Matemática", 4500.00);
        diretor diretor1 = new diretor(3, "Carlos", "111.222.333-44", 50, "Masculino", "Administração", 8000.00);

        System.out.println("Aluno:");
        System.out.println("Nome: " + aluno1.getNome());
        System.out.println("Curso: " + aluno1.getCurso());
        System.out.println("Matrícula: " + aluno1.getMatricula());
        System.out.println();

        System.out.println("Professor:");
        System.out.println("Nome: " + professor1.getNome());
        System.out.println("Disciplina: " + professor1.getDisciplina());
        System.out.println("Salário: R$" + professor1.getSalario());
        System.out.println();

        System.out.println("Diretor:");
        System.out.println("Nome: " + diretor1.getNome());
        System.out.println("Setor: " + diretor1.getSetor());
        System.out.println("Bônus: R$" + diretor1.getBonus());
    }
}
