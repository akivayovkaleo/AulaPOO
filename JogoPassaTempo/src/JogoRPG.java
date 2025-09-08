import java.util.*;

public class JogoRPG {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Masmorra> masmorras = new ArrayList<>();
    private static Loja loja = new Loja();

    public static void main(String[] args) {
        System.out.println("=== BEM-VINDO AO RPG DE TIPO ===");

        Personagem jogador = criarPersonagem();

        criarMasmorras();

        boolean jogando = true;
        while (jogando) {
            mostrarMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    entrarMasmorra(jogador);
                    break;
                case 2:
                    batalhaPvP();
                    break;
                case 3:
                    acessarLoja(jogador);
                    break;
                case 4:
                    mostrarStatus(jogador);
                    break;
                case 5:
                    distribuirAtributos(jogador);
                    break;
                case 6:
                    equiparHabilidades(jogador);
                    break;
                case 7:
                    mostrarInventario(jogador);
                    break;
                case 0:
                    jogando = false;
                    System.out.println("Obrigado por jogar!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static Personagem criarPersonagem() {
        System.out.print("Digite o nome do seu personagem: ");
        String nome = scanner.nextLine();

        System.out.println("Escolha sua classe:");
        System.out.println("1. Guerreiro");
        System.out.println("2. Mago");
        System.out.println("3. Arqueiro");
        int classe = scanner.nextInt();

        Personagem personagem = null;
        switch (classe) {
            case 1:
                personagem = new Guerreiro(nome);
                break;
            case 2:
                personagem = new Mago(nome);
                break;
            case 3:
                personagem = new Arqueiro(nome);
                break;
            default:
                personagem = new Guerreiro(nome);
                break;
        }

        System.out.println("Personagem criado: " + personagem.getNome() + " - " + personagem.getClasse());
        return personagem;
    }

    private static void criarMasmorras() {
        Masmorra m1 = new Masmorra("Caverna Sombria", 5);
        m1.adicionarInimigo(new Inimigo("Goblin", 30, 5, TipoInimigo.NORMAL, Elemento.FOGO));
        m1.adicionarInimigo(new Inimigo("Lobo Selvagem", 40, 8, TipoInimigo.NORMAL, Elemento.AR));

        Masmorra m2 = new Masmorra("Torre do Mago", 50);
        m2.adicionarInimigo(new Inimigo("Aprendiz de Mago", 80, 15, TipoInimigo.MAGO, Elemento.AGUA));
        m2.adicionarInimigo(new Inimigo("Mago das Chamas", 120, 25, TipoInimigo.MAGO, Elemento.AGUA));
        m2.adicionarInimigo(new Chefe("Arquimago Malvado", 300, 40, TipoInimigo.FEITICEIRO, Elemento.AGUA));

        Masmorra m3 = new Masmorra("Abismo do Deus Caído", 100);
        m3.adicionarInimigo(new Inimigo("Anjo Caído", 200, 30, TipoInimigo.MORTO_VIVO, Elemento.LUZ));
        m3.adicionarInimigo(new Inimigo("Demônio Menor", 150, 25, TipoInimigo.MORTO_VIVO, Elemento.FOGO));
        m3.adicionarInimigo(new Chefe("Deus Caído", 1000, 60, TipoInimigo.MORTO_VIVO, Elemento.LUZ));

        masmorras.add(m1);
        masmorras.add(m2);
        masmorras.add(m3);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Entrar em Masmorra");
        System.out.println("2. Batalha PvP");
        System.out.println("3. Acessar Loja");
        System.out.println("4. Mostrar Status");
        System.out.println("5. Distribuir Atributos");
        System.out.println("6. Equipar Habilidades");
        System.out.println("7. Mostrar Inventário");
        System.out.println("0. Sair do Jogo");
        System.out.print("Escolha uma opção: ");
    }

    private static void entrarMasmorra(Personagem jogador) {
        System.out.println("\n=== MAS MORRAS DISPONÍVEIS ===");
        for (int i = 0; i < masmorras.size(); i++) {
            Masmorra m = masmorras.get(i);
            System.out.println((i+1) + ". " + m.getNome() + " (Nível recomendado: " + m.getNivelRecomendado() + ")");
        }
        System.out.print("Escolha uma masmorra: ");
        int escolha = scanner.nextInt();

        if (escolha > 0 && escolha <= masmorras.size()) {
            masmorras.get(escolha-1).entrar(jogador);

            // Verificar se todas as masmorras foram completadas
            boolean todasCompletadas = true;
            for (Masmorra m : masmorras) {
                if (!m.isCompletada() && m.getNivelRecomendado() != 100) {
                    todasCompletadas = false;
                    break;
                }
            }
            if (todasCompletadas) {
                jogador.setCompletouTodasMasmorras(true);
                jogador.verificarGatilhoExplorador();
            }
        } else {
            System.out.println("Masmorra inválida!");
        }
    }

    private static void batalhaPvP() {
        System.out.println("\n=== BATALHA PVP ===");
        System.out.print("Digite o nome do primeiro jogador: ");
        String nome1 = scanner.nextLine();
        Personagem p1 = new Guerreiro(nome1);
        p1.setNivel(100);

        System.out.print("Digite o nome do segundo jogador: ");
        String nome2 = scanner.nextLine();
        Personagem p2 = new Mago(nome2);
        p2.setNivel(100);

        Batalha.lutar(p1, p2);
    }

    private static void acessarLoja(Personagem jogador) {
        boolean naLoja = true;
        while (naLoja) {
            loja.mostrarEstoque();
            System.out.println("\n=== LOJA ===");
            System.out.println("1. Comprar Item");
            System.out.println("2. Vender Item");
            System.out.println("3. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número do item para comprar: ");
                    int itemComprar = scanner.nextInt();
                    System.out.println("Compra realizada!");
                    break;
                case 2:
                    System.out.print("Digite o número do item para vender: ");
                    int itemVender = scanner.nextInt();
                    System.out.println("Venda realizada!");
                    break;
                case 3:
                    naLoja = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void mostrarStatus(Personagem jogador) {
        System.out.println("\n=== STATUS DE " + jogador.getNome() + " ===");
        System.out.println("Classe: " + jogador.getClasse());
        if (jogador.getSubclasse() != null) {
            System.out.println("Subclasse: " + jogador.getSubclasse().getNome());
        }
        System.out.println("Nível: " + jogador.getNivel());
        System.out.println("XP: " + jogador.xp + "/" + jogador.xpParaProximoNivel);
        System.out.println("Vida: " + jogador.getVidaAtual() + "/" + jogador.getVidaMax());
        System.out.println("Mana: " + jogador.getManaAtual() + "/" + jogador.getManaMax());
        System.out.println("Força: " + jogador.getForca());
        System.out.println("Destreza: " + jogador.getDestreza());
        System.out.println("Inteligência: " + jogador.getInteligencia());
        System.out.println("Vitalidade: " + jogador.getVitalidade());
        System.out.println("Sorte: " + jogador.getSorte());
        System.out.println("Pontos de Atributo disponíveis: " + jogador.getPontosAtributo());
        System.out.println("Ouro: " + jogador.getOuro());
        if (jogador.getArma() != null) {
            System.out.println("Arma equipada: " + jogador.getArma().getNome());
        }
        if (jogador.contrato != null) {
            System.out.println("Contrato Divino: " + jogador.contrato.getDeus());
        }
    }

    private static void distribuirAtributos(Personagem jogador) {
        if (jogador.getPontosAtributo() <= 0) {
            System.out.println("Você não tem pontos de atributo para distribuir!");
            return;
        }

        System.out.println("\n=== DISTRIBUIR ATRIBUTOS ===");
        System.out.println("Pontos disponíveis: " + jogador.getPontosAtributo());
        System.out.println("1. Força");
        System.out.println("2. Destreza");
        System.out.println("3. Inteligência");
        System.out.println("4. Vitalidade");
        System.out.println("5. Sorte");
        System.out.print("Escolha um atributo (1-5): ");
        int atributo = scanner.nextInt();

        System.out.print("Quantos pontos deseja distribuir? ");
        int pontos = scanner.nextInt();

        String nomeAtributo = "";
        switch (atributo) {
            case 1: nomeAtributo = "forca"; break;
            case 2: nomeAtributo = "destreza"; break;
            case 3: nomeAtributo = "inteligencia"; break;
            case 4: nomeAtributo = "vitalidade"; break;
            case 5: nomeAtributo = "sorte"; break;
        }

        jogador.distribuirAtributo(nomeAtributo, pontos);
    }

    private static void equiparHabilidades(Personagem jogador) {
        if (jogador.getHabilidadesAprendidas().isEmpty()) {
            System.out.println("Você ainda não aprendeu nenhuma habilidade!");
            return;
        }

        System.out.println("\n=== HABILIDADES APRENDIDAS ===");
        for (int i = 0; i < jogador.getHabilidadesAprendidas().size(); i++) {
            Habilidade h = jogador.getHabilidadesAprendidas().get(i);
            System.out.println((i+1) + ". " + h.getNome() + " - " + h.getDescricao());
        }

        System.out.println("\n=== HABILIDADES EQUIPADAS ===");
        for (int i = 0; i < jogador.getHabilidadesEquipadas().size(); i++) {
            Habilidade h = jogador.getHabilidadesEquipadas().get(i);
            System.out.println("Slot " + (i+1) + ": " + (h != null ? h.getNome() : "Vazio"));
        }

        System.out.print("Escolha uma habilidade para equipar (1-" + jogador.getHabilidadesAprendidas().size() + "): ");
        int habilidade = scanner.nextInt();

        if (habilidade > 0 && habilidade <= jogador.getHabilidadesAprendidas().size()) {
            System.out.print("Em qual slot deseja equipar? (1-4): ");
            int slot = scanner.nextInt();

            if (slot > 0 && slot <= 4) {
                jogador.equiparHabilidade(slot-1, jogador.getHabilidadesAprendidas().get(habilidade-1));
            } else {
                System.out.println("Slot inválido!");
            }
        } else {
            System.out.println("Habilidade inválida!");
        }
    }

    private static void mostrarInventario(Personagem jogador) {
        System.out.println("\n=== INVENTÁRIO ===");
        if (jogador.inventario.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
            return;
        }

        for (int i = 0; i < jogador.inventario.size(); i++) {
            Item item = jogador.inventario.get(i);
            System.out.println((i+1) + ". " + item.getNome() + " (" + item.getRaridade() + ")");
        }
    }
}