import java.util.ArrayList;
import java.util.List;

public class GerenciadorMissoes {
    private List<Missao> missoesDisponiveis;
    private List<Batalha> batalhasAtivas;

    public GerenciadorMissoes() {
        this.missoesDisponiveis = new ArrayList<>();
        this.batalhasAtivas = new ArrayList<>();
    }

    public void adicionarMissao(Missao missao) {
        missoesDisponiveis.add(missao);
    }

    public void criarBatalha(Batalha batalha) {
        batalhasAtivas.add(batalha);
    }

    public List<Missao> getMissoesPorDisciplina(String disciplina) {
        List<Missao> resultado = new ArrayList<>();
        for (Missao missao : missoesDisponiveis) {
            if (missao.getDisciplina().equals(disciplina)) {
                resultado.add(missao);
            }
        }
        return resultado;
    }

    public List<Missao> getMissoesPorDificuldade(String dificuldade) {
        List<Missao> resultado = new ArrayList<>();
        for (Missao missao : missoesDisponiveis) {
            if (missao.getDificuldade().equals(dificuldade)) {
                resultado.add(missao);
            }
        }
        return resultado;
    }

    public List<Batalha> getBatalhasAtivas() {
        return new ArrayList<>(batalhasAtivas);
    }

    // Getters
    public List<Missao> getMissoesDisponiveis() {
        return new ArrayList<>(missoesDisponiveis);
    }
}