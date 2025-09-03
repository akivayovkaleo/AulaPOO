public class Main {
    public static void main(String[] args) {
//        System.out.println("Criando Personagens");
//
//        PersonagemDeJogo personagem1 = new PersonagemDeJogo("KaleoGuerra", "guerreiro", 100, 20);
//        PersonagemDeJogo personagem2 = new PersonagemDeJogo("KaleoMago", "mago", 80, 40);
//
//        System.out.println("Status Inicial:");
//        personagem1.exibirStatus();
//        personagem2.exibirStatus();
//
//        System.out.println("\nIniciando");
//        int turno = 1;
//
//        while (personagem1.getVida() > 0 && personagem2.getVida() > 0) {
//            System.out.println("\nTurno " + turno + " ");
//
//            personagem1.atacar();
//            personagem2.receberDano(personagem1.getForca());
//
//            if (personagem2.getVida() <= 0) {
//                break;
//            }
//
//            personagem2.atacar();
//            personagem1.receberDano(personagem2.getForca());
//
//            if (personagem1.getVida() <= 0) {
//                break;
//            }
//            turno++;
//        }
//
//        System.out.println("\nfim");
//        if (personagem1.getVida() > 0) {
//            System.out.println(personagem1.getNome() + " venceu a batalha!");
//        } else if (personagem2.getVida() > 0) {
//            System.out.println(personagem2.getNome() + " venceu a batalha!");
//        } else {
//            System.out.println("A batalha terminou em um empate");
//        }
//        System.out.println("\nStatus Final:");
//        personagem1.exibirStatus();
//        personagem2.exibirStatus();

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////
//                System.out.println("Bem Vindo");
//                PetVirtual meuPet = new PetVirtual("KaleoPet");
//                System.out.println("Voce ganhou um novo pet: " + meuPet.getNome());
//                meuPet.status();
//                System.out.println("\nBrincando um pouco");
//                meuPet.brincar();
//                meuPet.brincar();
//                meuPet.status();
//
//                System.out.println("lanche");
//                meuPet.alimentar();
//                meuPet.status();
//
//                System.out.println("\n pet ficando com fome");
//                meuPet.setFome(85);
//                meuPet.status();
//
//                System.out.println("\nbrincar com o pet com fome");
//                meuPet.brincar();
//                meuPet.status();
//
//                System.out.println("\nAlimentando");
//                meuPet.alimentar();
//                meuPet.alimentar();
//                meuPet.status();
//
//                System.out.println("\nBrincando");
//                meuPet.brincar();
//                meuPet.status();
        //////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////
                System.out.println(" Criando Playlist");
                PlaylistMusical minhaPlaylist = new PlaylistMusical("KaleoList");

                System.out.println("\nAdicionando Musicas");
                minhaPlaylist.adicionarMusica("Musica K");
                minhaPlaylist.adicionarMusica("Musica A");
                minhaPlaylist.adicionarMusica("Musica L");
                minhaPlaylist.adicionarMusica("Musica E");
                minhaPlaylist.adicionarMusica("Musica O");

                System.out.println("\nTocando todas as musicas em sequência");
                minhaPlaylist.tocarProxima();
                for (int i = 1; i < minhaPlaylist.getTotalMusicas(); i++) {
                    minhaPlaylist.tocarProxima();
                }

                System.out.println("\n Fim da demonstracao ");
                minhaPlaylist.mostrarMusicaAtual();
        ////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////
//        DiarioSecreto meuDiario = new DiarioSecreto("Kaleo", "12345");
//
//        System.out.println("Tentando ler o diario com senha errada:");
//        meuDiario.ler("senhaerrada");
//
//        System.out.println("\nEscrevendo no diario com senha correta:");
//        meuDiario.escrever("12345", "Hoje foi um dia incrivel!");
//
//        System.out.println("\nTentando ler o diario com senha correta:");
//        meuDiario.ler("12345");
//
//        System.out.println("\nTentando escrever com senha errada:");
//        meuDiario.escrever("abcde", "Este texto nao sera salvo.");
            ////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////
//        Lampada lampadaSala = new Lampada();
////
////        System.out.println("Estado inicial:");
////        lampadaSala.mostrarEstado();
////
////        System.out.println("\nTentando trocar a cor da lampada desligada:");
////        lampadaSala.trocarCor("azul");
////
////        System.out.println("\nLigando a lampada:");
////        lampadaSala.ligar();
////
////        System.out.println("Estado apos ligar:");
////        lampadaSala.mostrarEstado();
////
////        System.out.println("\nTrocando a cor da lampada ligada:");
////        lampadaSala.trocarCor("amarelo");
////        lampadaSala.mostrarEstado();
////
////        System.out.println("\nDesligando a lampada:");
////        lampadaSala.desligar();
////        lampadaSala.mostrarEstado();
////
////        System.out.println("\nTentando trocar a cor da lampada desligada novamente:");
////        lampadaSala.trocarCor("vermelho");
        ///////////////////////////////////////////////////
        ///////////////////////////////////////////////////
        RoboComEnergia robo = new RoboComEnergia("KaleoRobo");

        System.out.println("Status inicial:");
        robo.status();

        System.out.println("\nExecutando tarefas...");
        robo.executarTarefa("Limpar o chao");
        robo.executarTarefa("Organizar objetos");
        robo.status();

        System.out.println("\nExecutando mais tarefas...");
        robo.executarTarefa("Cozinhar");
        robo.executarTarefa("Lavar roupas");
        robo.status();

        System.out.println("\nTentando executar tarefa com pouca energia:");
        robo.executarTarefa("Explorar o territorio");

        System.out.println("\nRecarregando o robo:");
        robo.recarregar();
        robo.status();

        System.out.println("\nExecutando tarefa apos recarga:");
        robo.executarTarefa("Explorar o territorio");
        robo.status();


    }
}