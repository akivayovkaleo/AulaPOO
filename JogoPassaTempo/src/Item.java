public abstract class Item {
    protected String nome;
    protected Raridade raridade;

    public Item(String nome, Raridade raridade) {
        this.nome = nome;
        this.raridade = raridade;
    }

    public String getNome() {
        return nome;
    }

    public Raridade getRaridade() {
        return raridade;
    }
}