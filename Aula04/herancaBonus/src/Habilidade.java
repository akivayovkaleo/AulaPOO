public class Habilidade {
    private String nome;
    private int custoDeEnergia;
    private int danoBase;
    private TipoEfeitoStatus efeitoStatus;

    public Habilidade(String nome, int custoDeEnergia, int danoBase, TipoEfeitoStatus efeitoStatus) {
        this.nome = nome;
        this.custoDeEnergia = custoDeEnergia;
        this.danoBase = danoBase;
        this.efeitoStatus = efeitoStatus;
    }

    public String getNome() {
        return nome;
    }

    public int getCustoDeEnergia() {
        return custoDeEnergia;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public TipoEfeitoStatus getEfeitoStatus() {
        return efeitoStatus;
    }
}