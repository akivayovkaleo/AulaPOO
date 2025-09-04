import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private String email;
    private String turma;
    private Personagem personagem;
    private List<Missao> missoesConcluidas;
    private List<Conquista> conquistas;

    public Aluno(String nome, String email, String turma) {
        this.nome = nome;
        this.email = email;
        this.turma = turma;
        this.personagem = new Personagem(nome);
        this.missoesConcluidas = new ArrayList<>();
        this.conquistas = new ArrayList<>();
    }

    public void concluirMissao(Missao missao) {
        missoesConcluidas.add(missao);
        personagem.ganharExperiencia(missao.getExperienciaRecompensa());

        for (Recompensa recompensa : missao.getRecompensas()) {
            if (recompensa instanceof Conquista) {
                conquistas.add((Conquista) recompensa);
            }
        }
    }

    public int getTotalMissoesConcluidas() {
        return missoesConcluidas.size();
    }

    public int getPontuacaoTotal() {
        int total = 0;
        for (Missao missao : missoesConcluidas) {
            total += missao.getExperienciaRecompensa();
        }
        return total;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTurma() {
        return turma;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public List<Missao> getMissoesConcluidas() {
        return new ArrayList<>(missoesConcluidas);
    }

    public List<Conquista> getConquistas() {
        return new ArrayList<>(conquistas);
    }
}