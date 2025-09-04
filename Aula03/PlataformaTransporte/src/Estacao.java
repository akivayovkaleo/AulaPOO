public class Estacao {
    private String nome;
    private String linha;
    private boolean operacional;

    public Estacao(String nome, String linha) {
        this.nome = nome;
        this.linha = linha;
        this.operacional = true;
    }


    public String getNome() {
        return nome;
    }

    public String getLinha() {
        return linha;
    }

    public boolean isOperacional() {
        return operacional;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public void setOperacional(boolean operacional) {
        this.operacional = operacional;
    }
}