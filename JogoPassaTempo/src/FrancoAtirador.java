public class FrancoAtirador extends Subclasse {
    public FrancoAtirador() {
        super("Franco-Atirador");
        adicionarHabilidade(new Habilidade("Tiro Preciso", "Ataque com chance crítica aumentada", 20, 20, 25));
        adicionarHabilidade(new Habilidade("Headshot", "Ataque certeiro com dano massivo", 21, 35, 30));
    }
}