public class veiculo {
    private String marca;
    private int ano;
    private String modelo;
    private String cor;
    private double valor;
    private String detalhes;

    public veiculo(String marca, int ano, String modelo, String cor, double valor, String detalhes) {
        this.marca = marca;
        this.ano = ano;
        this.modelo = modelo;
        this.cor = cor;
        this.valor = valor;
        this.detalhes = detalhes;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getDetalhes() {
        return detalhes;
    }
    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;

    }

    public void detalhes(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Ano: " + this.ano);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Cor: " + this.cor);
        System.out.println("Valor: " + this.valor);
        System.out.println("Detalhes: " + this.detalhes);
    }
}
