public class Produto extends ItemEstoque {

    public Produto(String nome, int quantidade, double preco) {
        super(nome, quantidade, preco);
    }

    public void adicionarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }

    public void adicionarEstoque(int quantidade, double descontoPorUnidade) {
        this.quantidade += quantidade;
        this.preco -= descontoPorUnidade;

    }
}
