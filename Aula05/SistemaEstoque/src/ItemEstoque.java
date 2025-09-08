public class ItemEstoque {
    protected String nome;
    protected int quantidade;
    protected double preco;

    public ItemEstoque(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public void mostrarInfo() {
        System.out.println("Produto: " + nome);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preço: R$ " + preco);
    }

    public void adicionarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }
}
