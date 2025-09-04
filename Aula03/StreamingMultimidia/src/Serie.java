public class Serie extends Conteudo {
    private int temporadas;
    private int episodios;

    public Serie(String titulo, int duracao, String genero, int temporadas, int episodios) {
        super(titulo, duracao, genero);
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    @Override
    public String getTipo() {
        return "Série";
    }

    // Getters
    public int getTemporadas() {
        return temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }
}