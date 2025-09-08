import java.util.*;

public class Masmorra {
    private String nome;
    private int nivelRecomendado;
    private List<Inimigo> inimigos = new ArrayList<>();
    private boolean completada = false;

    public Masmorra(String nome, int nivelRecomendado) {
        this.nome = nome;
        this.nivelRecomendado = nivelRecomendado;
    }

    public void adicionarInimigo(Inimigo inimigo) {
        inimigos.add(inimigo);
    }

    public void entrar(Personagem p) {
        System.out.println(p.getNome() + " entrou na masmorra: " + nome);

        if (nivelRecomendado == 100) {
            p.setEntrouNaMasmorraFinal(true);
        }

        for (Inimigo i : inimigos) {
            System.out.println("Lutando contra " + i.getNome());
            i.tomarDano(p.getForca() * 5 + (p.getArma() != null ? p.getArma().getDano() : 0));
            p.verificarGatilhoConhecimento(i.getTipo());
            if (i instanceof Chefe) {
                System.out.println("Enfrentando o chefe " + i.getNome() + "!");
            }
        }

        completada = true;
        p.ganharXP(nivelRecomendado * 10);
        p.setVidaAtual(p.getVidaMax());
        p.setManaAtual(p.getManaMax());
        System.out.println(p.getNome() + " completou a masmorra!");

        if (nivelRecomendado == 100) {
            System.out.println("Parabéns! Você derrotou o Deus Caído!");
        }
    }

    public boolean isCompletada() {
        return completada;
    }

    public int getNivelRecomendado() {
        return nivelRecomendado;
    }

    public String getNome() {
        return nome;
    }
}