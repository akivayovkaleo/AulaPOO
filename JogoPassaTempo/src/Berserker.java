public class Berserker extends Subclasse {
    public Berserker() {
        super("Berserker");
        adicionarHabilidade(new Habilidade("Fúria Incontrolável", "Entra em fúria, aumentando dano mas perdendo defesa", 10, 0, 20));
        adicionarHabilidade(new Habilidade("Ataque Furioso", "Ataque devastador com chance de atordoar", 11, 30, 25));
    }
}