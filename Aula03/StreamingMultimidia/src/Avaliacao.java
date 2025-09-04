public class Avaliacao {
    private Usuario usuario;
    private Conteudo conteudo;
    private int nota;
    private String comentario;
    private String data;

    public Avaliacao(Usuario usuario, Conteudo conteudo, int nota, String comentario) {
        this.usuario = usuario;
        this.conteudo = conteudo;
        this.nota = nota;
        this.comentario = comentario;
        this.data = java.time.LocalDate.now().toString();


        conteudo.adicionarAvaliacao(nota);
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public String getData() {
        return data;
    }
}