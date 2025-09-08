public class ProdutoFisico extends Item {
    private double frete;

    public ProdutoFisico(String nome, double preco, double frete) {
        super(nome, preco);
        this.frete = frete;
    }

    @Override
    public double calcularPreco() {
        return getPreco() + frete;
    }

    @Override
    public String toString() {
        return super.toString() + " | Frete: R$" + frete;
    }
}
