public class ProdutoPerecivel extends Produto {
    private int diasValidade;

    public ProdutoPerecivel(String nome, int quantidade, double preco, int diasValidade) {
        super(nome, quantidade, preco);
        this.diasValidade = diasValidade;
    }

    @Override
    public void adicionarEstoque(int quantidade) {
        if (diasValidade < 5) {
            System.out.println(nome + " está perto da validade. Estoque não adicionado.");
        } else {
            super.adicionarEstoque(quantidade);
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Dias para validade: " + diasValidade);

    }
}
