public class PatrulheiroDasMatas extends Subclasse {
    public PatrulheiroDasMatas() {
        super("Patrulheiro das Matas");
        adicionarHabilidade(new Habilidade("Flecha Envenenada", "Ataque que causa dano ao longo do tempo", 22, 25, 20));
        adicionarHabilidade(new Habilidade("Camuflagem", "Torna-se invisível no ambiente natural", 23, 30, 0));
    }
}