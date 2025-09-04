public class Questao {
    private String enunciado;
    private String[] opcoes;
    private int respostaCorreta;
    private String categoria;

    public Questao(String enunciado, String[] opcoes, int respostaCorreta, String categoria) {
        this.enunciado = enunciado;
        this.opcoes = opcoes;
        this.respostaCorreta = respostaCorreta;
        this.categoria = categoria;
    }

    public boolean verificarResposta(int resposta) {
        return resposta == respostaCorreta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String[] getOpcoes() {
        return opcoes.clone();
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public String getCategoria() {
        return categoria;
    }
}