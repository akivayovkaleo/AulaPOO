
public class Filme extends Conteudo {
    private String diretor;
    private int anoLancamento;

    public Filme(String titulo, int duracao, String genero, String diretor, int anoLancamento) {
        super(titulo, duracao, genero);
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String getTipo() {
        return "Filme";
    }

    // Getters
    public String getDiretor() {
        return diretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
}