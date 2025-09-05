import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Item> itens;
    private int capacidadeMaxima;

    public Inventario() {
        this.itens = new ArrayList<>();
        this.capacidadeMaxima = 20;
    }

    public boolean adicionarItem(Item item) {
        if (itens.size() < capacidadeMaxima) {
            itens.add(item);
            return true;
        }
        return false;
    }

    public boolean removerItem(Item item) {
        return itens.remove(item);
    }

    public List<Item> getItens() {
        return new ArrayList<>(itens);
    }

    public List<Equipamento> getEquipamentos() {
        List<Equipamento> equipamentos = new ArrayList<>();
        for (Item item : itens) {
            if (item instanceof Equipamento) {
                equipamentos.add((Equipamento) item);
            }
        }
        return equipamentos;
    }

    public List<Consumivel> getConsumiveis() {
        List<Consumivel> consumiveis = new ArrayList<>();
        for (Item item : itens) {
            if (item instanceof Consumivel) {
                consumiveis.add((Consumivel) item);
            }
        }
        return consumiveis;
    }
}