import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Online Educacional ===\n");

        // Criando alunos
        Aluno aluno1 = new Aluno("João Silva", "joao@email.com", "8A");
        Aluno aluno2 = new Aluno("Maria Santos", "maria@email.com", "8A");
        Aluno aluno3 = new Aluno("Pedro Oliveira", "pedro@email.com", "8B");

        System.out.println("Alunos criados:");
        System.out.println("- " + aluno1.getNome() + " (" + aluno1.getTurma() + ")");
        System.out.println("- " + aluno2.getNome() + " (" + aluno2.getTurma() + ")");
        System.out.println("- " + aluno3.getNome() + " (" + aluno3.getTurma() + ")\n");

        // Criando professor
        Professor professor = new Professor("Prof. Carlos", "Matemática", "carlos@escola.com");
        System.out.println("Professor: " + professor.getNome() + " (" + professor.getDisciplina() + ")\n");

        // Criando missões
        Missao missao1 = new Missao("Aventura Matemática", "Resolva problemas matemáticos para avançar", "Matemática", "Fácil");
        Missao missao2 = new Missao("Desafio Científico", "Teste seus conhecimentos em ciências", "Ciências", "Médio");

        // Criando questões
        Questao q1 = new Questao("Quanto é 2 + 2?", new String[]{"3", "4", "5", "6"}, 1, "Matemática");
        Questao q2 = new Questao("Quanto é 5 x 3?", new String[]{"12", "15", "18", "20"}, 1, "Matemática");
        Questao q3 = new Questao("Qual é o maior planeta do sistema solar?", new String[]{"Marte", "Júpiter", "Saturno", "Vênus"}, 1, "Ciências");

        missao1.adicionarQuestao(q1);
        missao1.adicionarQuestao(q2);
        missao2.adicionarQuestao(q3);

        // Adicionando recompensas
        missao1.adicionarRecompensa(new Recompensa("Moedas de Ouro", "100 moedas", 100));
        missao1.adicionarRecompensa(new Conquista("Matemático Iniciante", "Completou primeira missão de matemática", "1 missão"));

        missao2.adicionarRecompensa(new Recompensa("Cristais Mágicos", "50 cristais", 50));
        missao2.adicionarRecompensa(new Conquista("Cientista Júnior", "Completou missão de ciências", "1 missão"));

        professor.criarMissao(missao1);
        professor.criarMissao(missao2);

        System.out.println("Missões criadas pelo professor:");
        for (Missao missao : professor.getMissoesCriadas()) {
            System.out.println("- " + missao.getTitulo() + " (" + missao.getDificuldade() + ")");
        }

        // Alunos resolvendo missões
        System.out.println("\n=== Resolvendo Missões ===");

        // Aluno 1 resolve missão 1
        List<Integer> respostas1 = Arrays.asList(1, 1); // Respostas corretas
        if (missao1.resolverMissao(respostas1)) {
            aluno1.concluirMissao(missao1);
            System.out.println(aluno1.getNome() + " completou: " + missao1.getTitulo());
        }

        // Aluno 2 resolve missão 1 e 2
        if (missao1.resolverMissao(respostas1)) {
            aluno2.concluirMissao(missao1);
            System.out.println(aluno2.getNome() + " completou: " + missao1.getTitulo());
        }

        List<Integer> respostas2 = Arrays.asList(1); // Resposta correta para missão 2
        if (missao2.resolverMissao(respostas2)) {
            aluno2.concluirMissao(missao2);
            System.out.println(aluno2.getNome() + " completou: " + missao2.getTitulo());
        }

        // Exibindo progresso dos alunos
        System.out.println("\n=== Progresso dos Alunos ===");
        System.out.println(aluno1.getNome() + ":");
        System.out.println("  - Missões concluídas: " + aluno1.getTotalMissoesConcluidas());
        System.out.println("  - Pontuação total: " + aluno1.getPontuacaoTotal());
        System.out.println("  - Nível do personagem: " + aluno1.getPersonagem().getNivel());
        System.out.println("  - Conquistas: " + aluno1.getConquistas().size());

        System.out.println(aluno2.getNome() + ":");
        System.out.println("  - Missões concluídas: " + aluno2.getTotalMissoesConcluidas());
        System.out.println("  - Pontuação total: " + aluno2.getPontuacaoTotal());
        System.out.println("  - Nível do personagem: " + aluno2.getPersonagem().getNivel());
        System.out.println("  - Conquistas: " + aluno2.getConquistas().size());

        // Criando batalha colaborativa
        System.out.println("\n=== Batalha Colaborativa ===");
        Missao missaoBatalha = new Missao("Batalha dos Elementos", "Trabalhem juntos para derrotar o dragão matemático", "Matemática", "Difícil");
        Questao qBatalha1 = new Questao("Resolva: (15 + 25) / 2", new String[]{"15", "20", "25", "30"}, 1, "Matemática");
        Questao qBatalha2 = new Questao("Qual é a raiz quadrada de 144?", new String[]{"10", "11", "12", "13"}, 2, "Matemática");
        missaoBatalha.adicionarQuestao(qBatalha1);
        missaoBatalha.adicionarQuestao(qBatalha2);

        Batalha batalha = new Batalha("Dragão Matemático", missaoBatalha, 200);
        batalha.adicionarParticipante(aluno1);
        batalha.adicionarParticipante(aluno2);

        System.out.println("Batalha criada: " + batalha.getNome());
        System.out.println("Participantes: " + batalha.getParticipantes().size() + " alunos");
        System.out.println("Pontos de vida do inimigo: " + batalha.getPontosVidaMaximosInimigo());

        // Resolvendo batalha
        List<Integer> respostasBatalha = Arrays.asList(1, 2); // Respostas corretas
        if (batalha.resolverBatalha(respostasBatalha)) {
            System.out.println("Batalha vencida! Todos os participantes ganharam recompensas.");
        }

        // Criando ranking
        System.out.println("\n=== Ranking ===");
        List<Aluno> todosAlunos = Arrays.asList(aluno1, aluno2, aluno3);
        Ranking ranking = new Ranking("individual");
        ranking.atualizarRanking(todosAlunos);

        System.out.println("Top 3 Alunos:");
        List<Aluno> top3 = ranking.getTop10();
        int maxTop = Math.min(3, top3.size());
        for (int i = 0; i < maxTop; i++) {
            Aluno aluno = top3.get(i);
            System.out.println((i+1) + "º " + aluno.getNome() + " - " + aluno.getPontuacaoTotal() + " pontos");
        }

        // Ranking por turma - ajustado para usar o método correto
        System.out.println("\nRanking da Turma 8A:");
        List<Aluno> alunos8A = new ArrayList<>();
        for (Aluno aluno : todosAlunos) {
            if (aluno.getTurma().equals("8A")) {
                alunos8A.add(aluno);
            }
        }

        // Ordenar alunos da turma por pontuação
        alunos8A.sort((a1, a2) -> Integer.compare(a2.getPontuacaoTotal(), a1.getPontuacaoTotal()));

        for (int i = 0; i < alunos8A.size(); i++) {
            Aluno aluno = alunos8A.get(i);
            System.out.println((i+1) + "º " + aluno.getNome() + " - " + aluno.getPontuacaoTotal() + " pontos");
        }

        // Exibindo informações do personagem
        System.out.println("\n=== Personagem de " + aluno1.getNome() + " ===");
        Personagem personagem = aluno1.getPersonagem();
        System.out.println("Nome: " + personagem.getNome());
        System.out.println("Nível: " + personagem.getNivel());
        System.out.println("Experiência: " + personagem.getExperiencia() + "/" + personagem.getExperienciaParaProximoNivel());
        System.out.println("Vida: " + personagem.getPontosVida() + "/" + personagem.getPontosVidaMaximos());
        System.out.println("Habilidades: " + personagem.getHabilidades().size());
        for (String habilidade : personagem.getHabilidades()) {
            System.out.println("  - " + habilidade);
        }
    }
}