public class aluno extends pessoa {
    private String matricula;
    private String curso;

    public aluno(int id, String nome, String cpf, int idade, String sexo, String matricula, String curso) {
        super(id, nome, cpf, idade, sexo);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }
}
