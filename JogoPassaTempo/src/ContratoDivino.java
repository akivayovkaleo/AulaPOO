public class ContratoDivino {
    private String deus;
    private String descricao;
    private int bonusForca, bonusDestreza, bonusInteligencia, bonusVitalidade, bonusSorte;

    public ContratoDivino(String deus, String descricao, int bonusForca, int bonusDestreza,
                          int bonusInteligencia, int bonusVitalidade, int bonusSorte) {
        this.deus = deus;
        this.descricao = descricao;
        this.bonusForca = bonusForca;
        this.bonusDestreza = bonusDestreza;
        this.bonusInteligencia = bonusInteligencia;
        this.bonusVitalidade = bonusVitalidade;
        this.bonusSorte = bonusSorte;
    }

    public String getDeus() {
        return deus;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getBonusForca() {
        return bonusForca;
    }

    public int getBonusDestreza() {
        return bonusDestreza;
    }

    public int getBonusInteligencia() {
        return bonusInteligencia;
    }

    public int getBonusVitalidade() {
        return bonusVitalidade;
    }

    public int getBonusSorte() {
        return bonusSorte;
    }
}