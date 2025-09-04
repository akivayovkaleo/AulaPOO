
public abstract class Veiculo {
    protected String id;
    protected int capacidade;
    protected int lotacaoAtual;
    protected boolean emManutencao;
    protected int atrasoMinutos; // atraso em minutos

    public Veiculo(String id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
        this.lotacaoAtual = 0;
        this.emManutencao = false;
        this.atrasoMinutos = 0;
    }

    public abstract String getTipo();

    public boolean embarcarPassageiro() {
        if (lotacaoAtual < capacidade && !emManutencao) {
            lotacaoAtual++;
            return true;
        }
        return false;
    }

    public boolean desembarcarPassageiro() {
        if (lotacaoAtual > 0) {
            lotacaoAtual--;
            return true;
        }
        return false;
    }


    public String getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getLotacaoAtual() {
        return lotacaoAtual;
    }

    public boolean isEmManutencao() {
        return emManutencao;
    }

    public int getAtrasoMinutos() {
        return atrasoMinutos;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setLotacaoAtual(int lotacaoAtual) {
        this.lotacaoAtual = lotacaoAtual;
    }

    public void setEmManutencao(boolean emManutencao) {
        this.emManutencao = emManutencao;
    }

    public void setAtrasoMinutos(int atrasoMinutos) {
        this.atrasoMinutos = atrasoMinutos;
    }
}