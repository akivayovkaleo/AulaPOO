import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String nome;
    private String disciplina;
    private String email;
    private List<Missao> missoesCriadas;

    public Professor(String nome, String disciplina, String email) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.email = email;
        this.missoesCriadas = new ArrayList<>();
    }

    public void criarMissao(Missao missao) {
        missoesCriadas.add(missao);
    }

    public List<Aluno> getAlunosPorTurma(List<Aluno> todosAlunos, String turma) {
        List<Aluno> alunosTurma = new ArrayList<>();
        for (Aluno aluno : todosAlunos) {
            if (aluno.getTurma().equals(turma)) {
                alunosTurma.add(aluno);
            }
        }
        return alunosTurma;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getEmail() {
        return email;
    }

    public List<Missao> getMissoesCriadas() {
        return new ArrayList<>(missoesCriadas);
    }
}