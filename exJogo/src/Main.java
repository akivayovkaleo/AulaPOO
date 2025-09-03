import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Batalha RPG ===");

        System.out.println("Jogador 1, digite seu nome:");
        String nome1 = scanner.nextLine();
        System.out.println("Jogador 1, escolha sua classe (guerreiro, mago, arqueiro):");
        String classe1 = lerClasse(scanner);

        System.out.println("Jogador 2, digite seu nome:");
        String nome2 = scanner.nextLine();
        System.out.println("Jogador 2, escolha sua classe (guerreiro, mago, arqueiro):");
        String classe2 = lerClasse(scanner);

        Arma arma1 = criarArmaPorClasse(classe1);
        Arma arma2 = criarArmaPorClasse(classe2);

        System.out.println("\nEscolha um pet para " + nome1 + ":");
        PetMagico pet1 = escolherPet(scanner);

        System.out.println("\nEscolha um pet para " + nome2 + ":");
        PetMagico pet2 = escolherPet(scanner);

        PersonagemDeJogoAgregado personagem1 = new PersonagemDeJogoAgregado(nome1, classe1, 150, 15, arma1, pet1);
        PersonagemDeJogoAgregado personagem2 = new PersonagemDeJogoAgregado(nome2, classe2, 150, 15, arma2, pet2);

        System.out.println("\nStatus Inicial:");
        personagem1.exibirStatus();
        personagem2.exibirStatus();

        int turno = 1;

        while (personagem1.getVida() > 0 && personagem2.getVida() > 0) {
            System.out.println("\n--- Turno " + turno + " ---");

            executarTurno(scanner, personagem1, personagem2);
            if (personagem2.getVida() <= 0) break;

            executarTurno(scanner, personagem2, personagem1);
            if (personagem1.getVida() <= 0) break;

            turno++;
        }

        System.out.println("\n--- Fim da batalha ---");
        if (personagem1.getVida() > 0) {
            System.out.println(personagem1.getNome() + " venceu!");
        } else if (personagem2.getVida() > 0) {
            System.out.println(personagem2.getNome() + " venceu!");
        } else {
            System.out.println("Empate!");
        }

        System.out.println("\nStatus final:");
        personagem1.exibirStatus();
        personagem2.exibirStatus();

        scanner.close();
    }

    private static void executarTurno(Scanner scanner, PersonagemDeJogoAgregado atacante, PersonagemDeJogoAgregado defensor) {
        System.out.println(atacante.getNome() + ", escolha sua ação:");
        System.out.println("1 - Atacar");
        if (atacante.podeUsarPet()) System.out.println("2 - Usar Pet (" + atacante.getPet().getTipo() + ")");
        else System.out.println("2 - Usar Pet (Já usado)");

        int acao = 0;
        while (acao != 1 && acao != 2) {
            System.out.print("Digite 1 ou 2: ");
            try {
                acao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                acao = 0;
            }
            if (acao == 2 && !atacante.podeUsarPet()) {
                System.out.println("Você já usou o pet, escolha outra ação.");
                acao = 0;
            }
        }

        if (acao == 1) {
            System.out.println("Escolha o tipo de ataque:");
            System.out.println("1 - Ataque Forte");
            System.out.println("2 - Ataque Rápido");
            System.out.println("3 - Ataque Defensivo");
            int tipoAtaque = 0;
            while (tipoAtaque < 1 || tipoAtaque > 3) {
                System.out.print("Digite 1, 2 ou 3: ");
                try {
                    tipoAtaque = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    tipoAtaque = 0;
                }
            }
            atacante.atacar(defensor, tipoAtaque);
        } else if (acao == 2) {
            atacante.usarPet();
        }
    }

    private static String lerClasse(Scanner scanner) {
        String classe = "";
        while (!(classe.equalsIgnoreCase("guerreiro") || classe.equalsIgnoreCase("mago") || classe.equalsIgnoreCase("arqueiro"))) {
            System.out.print("Digite uma classe válida: ");
            classe = scanner.nextLine().toLowerCase();
        }
        return classe;
    }

    private static Arma criarArmaPorClasse(String classe) {
        return switch (classe) {
            case "guerreiro" -> new Arma("Espada Longa", "corte", 20);
            case "mago" -> new Arma("Cajado Arcano", "magia", 15);
            case "arqueiro" -> new Arma("Arco Longo", "perfuração", 18);
            default -> new Arma("Punho", "briga", 5);
        };
    }

    private static PetMagico escolherPet(Scanner scanner) {
        System.out.println("Escolha o tipo do pet:");
        System.out.println("1 - Curador (+30 de vida)");
        System.out.println("2 - Fortalecedor (+10 de força)");
        int opcao = 0;
        while (opcao != 1 && opcao != 2) {
            System.out.print("Digite 1 ou 2: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcao = 0;
            }
        }
        if (opcao == 1) {
            return new PetMagico("Fada Curadora", "curador", 30);
        } else {
            return new PetMagico("Lobo Guerreiro", "fortalecedor", 10);
        }
    }
}
