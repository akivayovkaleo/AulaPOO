public class Item {
    protected String nome;
    protected RaridadeItem raridade;

    public Item(String nome, RaridadeItem raridade) {
        this.nome = nome;
        this.raridade = raridade;
    }

    public String getNome() {
        return nome;
    }

    public RaridadeItem getRaridade() {
        return raridade;
    }
}