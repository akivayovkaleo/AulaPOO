public class ProdutoDigital extends Item {

    public ProdutoDigital(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double calcularPreco() {
        return getPreco();
    }
}
