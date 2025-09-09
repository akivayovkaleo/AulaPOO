import java.util.List;

public class ProdutoController {

    public static String pesquisarProduto(String nome) {
        List<Produto> produtosEncontrados = Produto.buscarPorNome(nome);

        if (produtosEncontrados.isEmpty()) {
            return "Nenhum produto encontrado com esse nome.";
        }

        StringBuilder resultado = new StringBuilder();
        for (Produto produto : produtosEncontrados) {
            resultado.append(produto.getNome())
                    .append(" - R$")
                    .append(String.format("%.2f", produto.getPreco()))
                    .append("\n");
        }

        return resultado.toString();
    }

    public static String pesquisarPorPreco(double precoMaximo) {
        List<Produto> produtosEncontrados = Produto.buscarPorPreco(precoMaximo);

        if (produtosEncontrados.isEmpty()) {
            return "Nenhum produto encontrado abaixo do preço de R$" + precoMaximo;
        }

        StringBuilder resultado = new StringBuilder();
        for (Produto produto : produtosEncontrados) {
            resultado.append(produto.getNome())
                    .append(" - R$")
                    .append(String.format("%.2f", produto.getPreco()))
                    .append("\n");
        }

        return resultado.toString();
    }
}
