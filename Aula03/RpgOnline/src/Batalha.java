import java.util.ArrayList;
import java.util.List;

public class Batalha {
    private String nome;
    private List<Aluno> participantes;
    private Missao missao;
    private int pontosVidaInimigo;
    private int pontosVidaMaximosInimigo;
    private boolean concluida;

    public Batalha(String nome, Missao missao, int pontosVidaInimigo) {
        this.nome = nome;
        this.participantes = new ArrayList<>();
        this.missao = missao;
        this.pontosVidaInimigo = pontosVidaInimigo;
        this.pontosVidaMaximosInimigo = pontosVidaInimigo;
        this.concluida = false;
        this.missao.setEmBatalha(true);
    }

    public void adicionarParticipante(Aluno aluno) {
        if (!participantes.contains(aluno)) {
            participantes.add(aluno);
        }
    }

    public boolean resolverBatalha(List<Integer> respostas) {
        if (missao.resolverMissao(respostas)) {
            this.pontosVidaInimigo = 0;
            this.concluida = true;

            for (Aluno aluno : participantes) {
                aluno.concluirMissao(missao);
            }
            return true;
        }
        return false;
    }

    public void receberDano(int dano) {
        this.pontosVidaInimigo = Math.max(0, this.pontosVidaInimigo - dano);
        if (this.pontosVidaInimigo == 0) {
            this.concluida = true;
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Aluno> getParticipantes() {
        return new ArrayList<>(participantes);
    }

    public Missao getMissao() {
        return missao;
    }

    public int getPontosVidaInimigo() {
        return pontosVidaInimigo;
    }

    public int getPontosVidaMaximosInimigo() {
        return pontosVidaMaximosInimigo;
    }

    public boolean isConcluida() {
        return concluida;
    }
}