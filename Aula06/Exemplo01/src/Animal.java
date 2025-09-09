public class Animal {
    protected int id = 0;
    protected String especie;
    protected String cor;
    protected int contador = 1;

    public Animal(int id, String especie, String cor) {
        contador++;
        id++;
        this.especie = especie;
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
