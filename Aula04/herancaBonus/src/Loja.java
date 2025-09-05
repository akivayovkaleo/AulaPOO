import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Item> itensDisponiveis;

    public Loja() {
        this.itensDisponiveis = new ArrayList<>();
        inicializarItens();
    }

    private void inicializarItens() {
        itensDisponiveis.add(new RifleDePlasma());
        itensDisponiveis.add(new ExoesqueletoLeve());
        itensDisponiveis.add(new PistolaDeEnergia());
        itensDisponiveis.add(new BlindagemAdaptativa());
    }

    public List<Item> getItensDisponiveis() {
        return new ArrayList<>(itensDisponiveis);
    }

    public boolean comprarItem(Personagem personagem, Item item) {
        if (itensDisponiveis.contains(item)) {
            int preco = calcularPreco(item);
            if (personagem.getCreditos() >= preco) {
                if (personagem.getInventario().adicionarItem(item)) {
                    personagem.adicionarCreditos(-preco);
                    itensDisponiveis.remove(item);
                    return true;
                }
            }
        }
        return false;
    }

    private int calcularPreco(Item item) {
        switch (item.getRaridade()) {
            case COMUM: return 50;
            case RARO: return 100;
            case EPICO: return 200;
            default: return 50;
        }
    }
}