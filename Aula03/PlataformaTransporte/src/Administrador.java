
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private String nome;
    private String departamento;
    private List<Relatorio> relatoriosGerados;

    public Administrador(String nome, String departamento) {
        this.nome = nome;
        this.departamento = departamento;
        this.relatoriosGerados = new ArrayList<>();
    }

    public Relatorio gerarRelatorio(String tipo, String descricao) {
        Relatorio relatorio = new Relatorio(tipo, descricao, this);
        relatoriosGerados.add(relatorio);
        return relatorio;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public List<Relatorio> getRelatoriosGerados() {
        return new ArrayList<>(relatoriosGerados);
    }
}