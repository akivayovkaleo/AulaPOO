public class Arma extends Item {
    private String classePermitida;
    private int dano;
    private Elemento elemento;

    public Arma(String nome, Raridade raridade, String classePermitida, int dano, Elemento elemento) {
        super(nome, raridade);
        this.classePermitida = classePermitida;
        this.dano = dano;
        this.elemento = elemento;
    }

    public boolean podeEquipar(Personagem p) {
        if (classePermitida.equals("Todas")) return true;
        if (p.getClasse().equals(classePermitida)) return true;
        if (p.getSubclasse() != null && p.getSubclasse().getNome().equals(classePermitida)) return true;
        return false;
    }

    public int getDano() {
        return dano;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public String getClassePermitida() {
        return classePermitida;
    }
}