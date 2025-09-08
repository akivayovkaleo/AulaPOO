import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Item> itens;

    public Pedido() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.calcularPreco();
        }
        return total;
    }

    public void exibirResumo() {
        System.out.println("Resumo do Pedido:");
        for (Item item : itens) {
            System.out.println(item);
        }
        System.out.println("Total: R$" + calcularTotal());
    }
}
