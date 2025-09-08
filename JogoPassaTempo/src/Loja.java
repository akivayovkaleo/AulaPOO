import java.util.*;

public class Loja {
    private List<Item> estoque = new ArrayList<>();

    public Loja() {
        estoque.add(new Arma("Espada de Ferro", Raridade.COMUM, "Guerreiro", 10, Elemento.NEUTRO));
        estoque.add(new Arma("Cajado de Madeira", Raridade.COMUM, "Mago", 8, Elemento.NEUTRO));
        estoque.add(new Arma("Arco Curto", Raridade.COMUM, "Arqueiro", 9, Elemento.NEUTRO));
        estoque.add(new Armadura("Armadura de Couro", Raridade.COMUM, 5));
        estoque.add(new Pocao("Poção Menor de Vida", Raridade.COMUM, 50));
    }

    public void adicionarItem(Item item) {
        estoque.add(item);
    }

    public void comprar(Personagem p, Item item) {
        if (estoque.contains(item) && p.getOuro() >= 100) {
            p.adicionarItem(item);
            p.ganharOuro(-100);
            estoque.remove(item);
            System.out.println(p.getNome() + " comprou " + item.getNome());
        } else {
            System.out.println("Não foi possível comprar o item.");
        }
    }

    public void vender(Personagem p, Item item) {
        if (p.inventario.contains(item)) {
            p.inventario.remove(item);
            p.ganharOuro(50);
            estoque.add(item);
            System.out.println(p.getNome() + " vendeu " + item.getNome());
        } else {
            System.out.println("Item não encontrado no inventário.");
        }
    }

    public void mostrarEstoque() {
        System.out.println("=== Estoque da Loja ===");
        for (int i = 0; i < estoque.size(); i++) {
            Item item = estoque.get(i);
            System.out.println((i+1) + ". " + item.getNome() + " (" + item.getRaridade() + ") - 100 ouro");
        }
    }
}