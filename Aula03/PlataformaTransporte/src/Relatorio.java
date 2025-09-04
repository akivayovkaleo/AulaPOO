import java.time.LocalDateTime;

public class Relatorio {
    private String tipo;
    private String descricao;
    private Administrador geradoPor;
    private LocalDateTime dataGeracao;
    private int totalRegistros;

    public Relatorio(String tipo, String descricao, Administrador geradoPor) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.geradoPor = geradoPor;
        this.dataGeracao = LocalDateTime.now();
        this.totalRegistros = 0;
    }

    public void adicionarRegistros(int quantidade) {
        this.totalRegistros += quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Administrador getGeradoPor() {
        return geradoPor;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public int getTotalRegistros() {
        return totalRegistros;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }
}