import java.util.*;

public class Batalha {
    private static Scanner scanner = new Scanner(System.in);

    public static void lutar(Personagem jogador, Inimigo inimigo) {
        System.out.println("\n=== BATALHA ===");
        System.out.println(jogador.getNome() + " VS " + inimigo.getNome());

        // Verificar contrato com Rei dos Deuses (só na masmorra final)
        if (inimigo instanceof Chefe && inimigo.getNome().equals("Deus Caído")) {
            if (jogador.getNivel() < 5) {
                ContratoDivino contrato = new ContratoDivino(
                        "Rei dos Deuses",
                        "Habilidade de copiar a última habilidade usada por um inimigo uma vez por batalha.",
                        5, 5, 5, 5, 5
                );
                jogador.receberContrato(contrato);
                System.out.println("O Rei dos Deuses oferece um contrato especial!");
            }
        }

        while (jogador.getVidaAtual() > 0 && inimigo.estaVivo()) {
            System.out.println("\n--- TURNO DO JOGADOR ---");
            System.out.println("Vida: " + jogador.getVidaAtual() + "/" + jogador.getVidaMax());
            System.out.println("Mana: " + jogador.getManaAtual() + "/" + jogador.getManaMax());
            System.out.println("Poder Divino: " + jogador.getPoderDivino());
            System.out.println("Vida do inimigo: " + inimigo.getVida() + "/" +
                    (inimigo instanceof Chefe ? ((Chefe)inimigo).getVidaMax() : inimigo.getVida()));

            System.out.println("\nEscolha sua ação:");
            System.out.println("1. Atacar");
            System.out.println("2. Usar Habilidade");
            System.out.println("3. Usar Poção");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    int danoFisico = jogador.getForca() + (jogador.getArma() != null ? jogador.getArma().getDano() : 0);
                    inimigo.tomarDano(danoFisico);
                    System.out.println(jogador.getNome() + " atacou e causou " + danoFisico + " de dano!");
                    break;

                case 2:
                    if (jogador.getHabilidadesEquipadas().isEmpty()) {
                        System.out.println("Você não tem habilidades equipadas!");
                        continue;
                    }

                    System.out.println("Escolha uma habilidade:");
                    int index = 1;
                    for (int i = 0; i < jogador.getHabilidadesEquipadas().size(); i++) {
                        Habilidade h = jogador.getHabilidadesEquipadas().get(i);
                        if (h != null) {
                            System.out.println(index + ". " + h.getNome() + " (Custo: " + h.getCustoMana() + " mana)");
                            index++;
                        }
                    }

                    int habilidadeEscolhida = scanner.nextInt();
                    index = 1;
                    Habilidade habilidadeSelecionada = null;
                    for (int i = 0; i < jogador.getHabilidadesEquipadas().size(); i++) {
                        Habilidade h = jogador.getHabilidadesEquipadas().get(i);
                        if (h != null) {
                            if (index == habilidadeEscolhida) {
                                habilidadeSelecionada = h;
                                break;
                            }
                            index++;
                        }
                    }

                    if (habilidadeSelecionada != null && jogador.getManaAtual() >= habilidadeSelecionada.getCustoMana()) {
                        int danoHabilidade = habilidadeSelecionada.getDanoBase() + jogador.getInteligencia();
                        inimigo.tomarDano(danoHabilidade);
                        jogador.setManaAtual(jogador.getManaAtual() - habilidadeSelecionada.getCustoMana());
                        System.out.println(jogador.getNome() + " usou " + habilidadeSelecionada.getNome() + " e causou " + danoHabilidade + " de dano!");
                    } else {
                        System.out.println("Mana insuficiente ou habilidade inválida!");
                        continue;
                    }
                    break;

                case 3:
                    if (jogador.temPocoes()) {
                        jogador.usarPocao(50);
                    } else {
                        System.out.println("Você não tem poções!");
                        continue;
                    }
                    break;

                default:
                    System.out.println("Ação inválida!");
                    continue;
            }

            if (!inimigo.estaVivo()) {
                System.out.println(inimigo.getNome() + " foi derrotado!");
                if (inimigo instanceof Chefe) {
                    System.out.println("Parabéns! Você derrotou o " + inimigo.getNome() + "!");
                    jogador.ganharXP(1000);
                } else {
                    jogador.ganharXP(100);
                }
                break;
            }

            System.out.println("\n--- TURNO DO INIMIGO ---");
            int danoInimigo = inimigo.getAtaque();
            jogador.setVidaAtual(jogador.getVidaAtual() - danoInimigo);
            System.out.println(inimigo.getNome() + " atacou e causou " + danoInimigo + " de dano!");

            if (jogador.getVidaAtual() <= 0) {
                System.out.println(jogador.getNome() + " foi derrotado!");
                jogador.morrer();
                break;
            }
        }
    }
}