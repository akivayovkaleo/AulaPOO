public class PetMagico {
    private String nome;
    private String tipo; // "curador" ou "fortalecedor"
    private int valor;
    private boolean usado;

    public PetMagico(String nome, String tipo, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.usado = false;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }

    public boolean isUsado() {
        return usado;
    }

    public void usar() {
        this.usado = true;
    }
}
