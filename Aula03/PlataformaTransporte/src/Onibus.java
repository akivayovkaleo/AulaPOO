
public class Onibus extends Veiculo {
    private String linha;
    private String empresa;

    public Onibus(String id, int capacidade, String linha, String empresa) {
        super(id, capacidade);
        this.linha = linha;
        this.empresa = empresa;
    }

    @Override
    public String getTipo() {
        return "Ônibus";
    }


    public String getLinha() {
        return linha;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}