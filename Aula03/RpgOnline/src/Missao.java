import java.util.ArrayList;
import java.util.List;

public class Missao {
    private String titulo;
    private String descricao;
    private String disciplina;
    private String dificuldade; // "Fácil", "Médio", "Difícil"
    private List<Questao> questoes;
    private List<Recompensa> recompensas;
    private int experienciaRecompensa;
    private boolean emBatalha;

    public Missao(String titulo, String descricao, String disciplina, String dificuldade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.disciplina = disciplina;
        this.dificuldade = dificuldade;
        this.questoes = new ArrayList<>();
        this.recompensas = new ArrayList<>();
        this.experienciaRecompensa = calcularExperienciaPorDificuldade(dificuldade);
        this.emBatalha = false;
    }

    public void adicionarQuestao(Questao questao) {
        questoes.add(questao);
    }

    public void adicionarRecompensa(Recompensa recompensa) {
        recompensas.add(recompensa);
    }

    private int calcularExperienciaPorDificuldade(String dificuldade) {
        switch (dificuldade) {
            case "Fácil": return 50;
            case "Médio": return 100;
            case "Difícil": return 200;
            default: return 50;
        }
    }

    public boolean resolverMissao(List<Integer> respostas) {
        if (questoes.size() != respostas.size()) {
            return false;
        }

        for (int i = 0; i < questoes.size(); i++) {
            if (!questoes.get(i).verificarResposta(respostas.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void setEmBatalha(boolean emBatalha) {
        this.emBatalha = emBatalha;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public List<Questao> getQuestoes() {
        return new ArrayList<>(questoes);
    }

    public List<Recompensa> getRecompensas() {
        return new ArrayList<>(recompensas);
    }

    public int getExperienciaRecompensa() {
        return experienciaRecompensa;
    }

    public boolean isEmBatalha() {
        return emBatalha;
    }
}