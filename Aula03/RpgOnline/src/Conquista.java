public class Conquista extends Recompensa {
    private String criterio;
    private String icone;

    public Conquista(String nome, String descricao, String criterio) {
        super(nome, descricao, 0);
        this.criterio = criterio;
        this.icone = icone;
    }

    // Getters
    public String getCriterio() {
        return criterio;
    }

    public String getIcone() {
        return icone;
    }

    // Setters
    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }
}