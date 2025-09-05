import java.util.Scanner;

public class MotorDoJogo {
    private Personagem jogador;
    private Loja loja;
    private Scanner scanner;
    private int missaoAtual;

    public MotorDoJogo() {
        this.loja = new Loja();
        this.scanner = new Scanner(System.in);
        this.missaoAtual = 1;
    }

    public void iniciarJogo() {
        escolherPersonagem();

        boolean jogando = true;
        while (jogando) {
            mostrarMenuPrincipal();
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    mostrarStatus();
                    break;
                case 2:
                    acessarLoja();
                    break;
                case 3:
                    iniciarMissao();
                    break;
                case 4:
                    jogando = false;
                    break;
            }
        }
    }

    private void escolherPersonagem() {
        System.out.println("Escolha sua classe:");
        System.out.println("1. Soldado");
        System.out.println("2. Engenheiro");
        System.out.println("3. Infiltrado");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o nome do seu personagem:");
        String nome = scanner.nextLine();

        switch (escolha) {
            case 1:
                jogador = new Soldado(nome);
                break;
            case 2:
                jogador = new Engenheiro(nome);
                break;
            case 3:
                jogador = new Infiltrado(nome);
                break;
        }
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n--- HUB PRINCIPAL ---");
        System.out.println("1. Ver Status e Equipar Itens");
        System.out.println("2. Ir para a Loja");
        System.out.println("3. Iniciar Próxima Missão");
        System.out.println("4. Sair");
    }

    private void mostrarStatus() {
        System.out.println("\n--- STATUS ---");
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Nível: " + jogador.getNivel());
        System.out.println("Vida: " + jogador.getVida() + "/" + jogador.getVidaMaxima());
        System.out.println("Energia: " + jogador.getEnergia() + "/" + jogador.getEnergiaMaxima());
        System.out.println("Força: " + jogador.getForca());
        System.out.println("Destreza: " + jogador.getDestreza());
        System.out.println("Inteligência: " + jogador.getInteligencia());
        System.out.println("Créditos: " + jogador.getCreditos());
    }

    private void acessarLoja() {
        System.out.println("\n--- LOJA ---");
        System.out.println("Seus créditos: " + jogador.getCreditos());

        for (int i = 0; i < loja.getItensDisponiveis().size(); i++) {
            Item item = loja.getItensDisponiveis().get(i);
            System.out.println((i + 1) + ". " + item.getNome() + " - Preço: " + calcularPreco(item));
        }

        System.out.println("0. Voltar");
        int escolha = scanner.nextInt();

        if (escolha > 0 && escolha <= loja.getItensDisponiveis().size()) {
            Item itemEscolhido = loja.getItensDisponiveis().get(escolha - 1);
            if (loja.comprarItem(jogador, itemEscolhido)) {
                System.out.println("Item comprado com sucesso!");
            } else {
                System.out.println("Não foi possível comprar o item.");
            }
        }
    }

    private int calcularPreco(Item item) {
        switch (item.getRaridade()) {
            case COMUM: return 50;
            case RARO: return 100;
            case EPICO: return 200;
            default: return 50;
        }
    }

    private void iniciarMissao() {
        System.out.println("\n--- MISSÃO " + missaoAtual + " ---");

        for (int i = 0; i < 3; i++) {
            Inimigo inimigo = criarInimigo(missaoAtual, i);
            if (!iniciarCombate(inimigo)) {
                System.out.println("Missão fracassada!");
                return;
            }
        }

        System.out.println("Missão " + missaoAtual + " completa!");
        jogador.adicionarCreditos(100 * missaoAtual);
        jogador.ganharExperiencia(50 * missaoAtual);
        missaoAtual++;
    }

    private Inimigo criarInimigo(int missao, int fase) {
        if (missao == 1) {
            if (fase == 0) return new DroneDeCombate();
            if (fase == 1) return new DroneDeCombate();
            return new MutanteFeral();
        } else if (missao == 2) {
            if (fase == 0) return new MutanteFeral();
            if (fase == 1) return new MutanteFeral();
            return new SentinelaCibernetica();
        } else {
            if (fase == 0) return new SentinelaCibernetica();
            if (fase == 1) return new SentinelaCibernetica();
            return new SentinelaCibernetica();
        }
    }

    private boolean iniciarCombate(Inimigo inimigo) {
        System.out.println("Um " + inimigo.getNome() + " apareceu!");

        while (jogador.estaVivo() && inimigo.estaVivo()) {
            System.out.println("\n" + jogador.getNome() + " - Vida: " + jogador.getVida() + "/" + jogador.getVidaMaxima());
            System.out.println(inimigo.getNome() + " - Vida: " + inimigo.getVida() + "/" + inimigo.getVidaMaxima());
            System.out.println("1. Atacar");
            System.out.println("2. Usar Habilidade");

            int escolha = scanner.nextInt();

            if (escolha == 1) {
                jogador.atacar(inimigo);
                System.out.println(jogador.getNome() + " atacou " + inimigo.getNome());
            }

            if (inimigo.estaVivo()) {
                inimigo.atacar(jogador);
                System.out.println(inimigo.getNome() + " atacou " + jogador.getNome());
            }
        }

        if (jogador.estaVivo()) {
            System.out.println("Inimigo derrotado!");
            jogador.adicionarCreditos(25);
            return true;
        } else {
            return false;
        }
    }
}