public class Habilidade {
    private String nome;
    private String descricao;
    private int id;
    private int custoMana;
    private int danoBase;

    public Habilidade(String nome, String descricao, int id, int custoMana, int danoBase) {
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
        this.custoMana = custoMana;
        this.danoBase = danoBase;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public int getDanoBase() {
        return danoBase;
    }
}