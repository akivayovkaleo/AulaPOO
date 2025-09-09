import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    // Método estático para buscar produtos pelo nome
    public static List<Produto> buscarPorNome(String nome) {
        // Lista de produtos "pré-definida"
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "Camiseta", 29.99));
        produtos.add(new Produto(2, "Calça Jeans", 79.90));
        produtos.add(new Produto(3, "Tênis Esportivo", 120.50));
        produtos.add(new Produto(4, "Boné", 35.00));

        // Lista para armazenar os produtos encontrados
        List<Produto> encontrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(produto);
            }
        }

        return encontrados;
    }
}
