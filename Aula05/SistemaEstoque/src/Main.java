public class Main {
    public static void main(String[] args) {
        Produto arroz = new Produto("Arroz", 50, 5.00);
        Produto feijao = new Produto("Feijão", 30, 7.50);
        ProdutoPerecivel leite = new ProdutoPerecivel("Leite", 10, 4.00, 3); // perto da validade

        arroz.adicionarEstoque(20);
        feijao.adicionarEstoque(10, 1.00);
        leite.adicionarEstoque(10);

        arroz.mostrarInfo();
        feijao.mostrarInfo();
        leite.mostrarInfo();
    }
}
