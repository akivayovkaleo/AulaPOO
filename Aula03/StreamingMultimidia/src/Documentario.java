public class Documentario extends Conteudo {
    private String tema;
    private String produtora;

    public Documentario(String titulo, int duracao, String genero, String tema, String produtora) {
        super(titulo, duracao, genero);
        this.tema = tema;
        this.produtora = produtora;
    }

    @Override
    public String getTipo() {
        return "Documentário";
    }

    public String getTema() {
        return tema;
    }

    public String getProdutora() {
        return produtora;
    }
}