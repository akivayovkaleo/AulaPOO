import java.util.ArrayList;
import java.util.List;

public class Personagem {
    private String nome;
    private int nivel;
    private int experiencia;
    private int experienciaParaProximoNivel;
    private List<String> habilidades;
    private int pontosVida;
    private int pontosVidaMaximos;

    public Personagem(String nome) {
        this.nome = nome;
        this.nivel = 1;
        this.experiencia = 0;
        this.experienciaParaProximoNivel = 100;
        this.habilidades = new ArrayList<>();
        this.pontosVida = 100;
        this.pontosVidaMaximos = 100;
        this.habilidades.add("Resolução Básica");
    }

    public void ganharExperiencia(int experienciaGanha) {
        this.experiencia += experienciaGanha;

        // Verificar se sobe de nível
        while (this.experiencia >= this.experienciaParaProximoNivel) {
            subirNivel();
        }
    }

    private void subirNivel() {
        this.nivel++;
        this.experiencia -= this.experienciaParaProximoNivel;
        this.experienciaParaProximoNivel = (int) (this.experienciaParaProximoNivel * 1.5);
        this.pontosVidaMaximos += 20;
        this.pontosVida = this.pontosVidaMaximos;

        // Adicionar nova habilidade a cada 3 níveis
        if (this.nivel % 3 == 0) {
            this.habilidades.add("Habilidade Nível " + this.nivel);
        }
    }

    public boolean receberDano(int dano) {
        this.pontosVida -= dano;
        return this.pontosVida <= 0;
    }

    public void curar(int pontos) {
        this.pontosVida = Math.min(this.pontosVida + pontos, this.pontosVidaMaximos);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getExperienciaParaProximoNivel() {
        return experienciaParaProximoNivel;
    }

    public List<String> getHabilidades() {
        return new ArrayList<>(habilidades);
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public int getPontosVidaMaximos() {
        return pontosVidaMaximos;
    }
}