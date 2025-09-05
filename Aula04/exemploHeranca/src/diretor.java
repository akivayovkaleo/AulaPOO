public class diretor extends pessoa {
    private String setor;
    private double bonus;

    public diretor(int id, String nome, String cpf, int idade, String sexo, String setor, double bonus) {
        super(id, nome, cpf, idade, sexo);
        this.setor = setor;
        this.bonus = bonus;
    }

    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
