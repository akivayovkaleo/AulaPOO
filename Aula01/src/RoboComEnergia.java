public class RoboComEnergia {
    private String nome;
    private int energia;

    public RoboComEnergia(String nome) {
        this.nome = nome;
        this.energia = 100;
    }

    public void executarTarefa(String tarefa) {
        if (this.energia >= 10) {
            this.energia = this.energia - 10;
            System.out.println(this.nome + " executou a tarefa: " + tarefa);
        } else {
            System.out.println(this.nome + " nao tem energia suficiente para executar a tarefa: " + tarefa);
        }
    }

    public void recarregar() {
        this.energia = 100;
        System.out.println(this.nome + " foi recarregado. Energia: " + this.energia);
    }

    public void status() {
        System.out.println("Robo " + this.nome + " - Energia: " + this.energia);
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia < 0) {
            this.energia = 0;
        } else if (energia > 100) {
            this.energia = 100;
        } else {
            this.energia = energia;
        }
    }
}