public class EspadachimMagico extends Subclasse {
    public EspadachimMagico() {
        super("Espadachim Mágico");
        adicionarHabilidade(new Habilidade("Lâmina Flamejante", "Ataque com espada imbuída de fogo", 19, 25, 30));
        adicionarHabilidade(new Habilidade("Tempestade de Gelo", "Ataque com espada imbuída de gelo", 20, 25, 30));
    }
}