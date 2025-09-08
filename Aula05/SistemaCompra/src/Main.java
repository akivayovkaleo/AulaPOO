public class Main {
    public static void main(String[] args) {
        ProdutoFisico produtoFisico1 = new ProdutoFisico("Camiseta", 50.0, 15.0);
        ProdutoFisico produtoFisico2 = new ProdutoFisico("Tênis", 200.0, 30.0);
        ProdutoDigital produtoDigital1 = new ProdutoDigital("Ebook de Java", 40.0);
        ProdutoDigital produtoDigital2 = new ProdutoDigital("Curso Online de Python", 150.0);

        Pedido pedido = new Pedido();
        pedido.adicionarItem(produtoFisico1);
        pedido.adicionarItem(produtoFisico2);
        pedido.adicionarItem(produtoDigital1);
        pedido.adicionarItem(produtoDigital2);

        pedido.exibirResumo();
    }
}
