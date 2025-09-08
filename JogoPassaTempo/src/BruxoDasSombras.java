public class BruxoDasSombras extends Subclasse {
    public BruxoDasSombras() {
        super("Bruxo das Sombras");
        adicionarHabilidade(new Habilidade("Toque Sombrio", "Drena vida do inimigo", 18, 25, 20));
        adicionarHabilidade(new Habilidade("Manto das Sombras", "Torna-se invisível por alguns segundos", 19, 30, 0));
    }
}