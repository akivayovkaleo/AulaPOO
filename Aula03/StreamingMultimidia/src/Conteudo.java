public abstract class Conteudo {
    protected String titulo;
    protected int duracao;
    protected String genero;
    protected double avaliacaoMedia;
    protected int totalAvaliacoes;

    public Conteudo(String titulo, int duracao, String genero) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.genero = genero;
        this.avaliacaoMedia = 0.0;
        this.totalAvaliacoes = 0;
    }

    public abstract String getTipo();

    public void adicionarAvaliacao(double nota) {
        double novaMedia = (avaliacaoMedia * totalAvaliacoes + nota) / (totalAvaliacoes + 1);
        this.avaliacaoMedia = novaMedia;
        this.totalAvaliacoes++;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public double getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }
}