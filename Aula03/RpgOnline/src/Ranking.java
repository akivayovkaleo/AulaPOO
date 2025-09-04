import java.util.*;

public class Ranking {
    private List<Aluno> alunos;
    private String tipo; // "individual" ou "turma"

    public Ranking(String tipo) {
        this.alunos = new ArrayList<>();
        this.tipo = tipo;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        ordenarPorPontuacao();
    }

    public void atualizarRanking(List<Aluno> todosAlunos) {
        this.alunos.clear();
        this.alunos.addAll(todosAlunos);
        ordenarPorPontuacao();
    }

    private void ordenarPorPontuacao() {
        alunos.sort((a1, a2) -> Integer.compare(a2.getPontuacaoTotal(), a1.getPontuacaoTotal()));
    }

    public List<Aluno> getTop10() {
        return new ArrayList<>(alunos.subList(0, Math.min(10, alunos.size())));
    }

    public List<Aluno> getRankingPorTurma(String turma) {
        List<Aluno> rankingTurma = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.getTurma().equals(turma)) {
                rankingTurma.add(aluno);
            }
        }
        rankingTurma.sort((a1, a2) -> Integer.compare(a2.getPontuacaoTotal(), a1.getPontuacaoTotal()));
        return rankingTurma;
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }

    public String getTipo() {
        return tipo;
    }
}