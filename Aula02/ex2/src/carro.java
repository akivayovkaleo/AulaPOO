public class carro {

    private String marca;
    private String modelo;
    private int anoFabricacao;
    private motor motor;

    public carro(String marca, String modelo, int anoFabricacao, motor motor) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.motor = motor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public motor getMotor() {
        return motor;
    }

    public void setMotor(motor motor) {
        this.motor = motor;
    }
    public void exibir(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano de fabricacao: " + anoFabricacao);
        System.out.println("Potência: " + motor.getPotenciaCv());
        System.out.println("Cilindrada " + motor.getClindrada());
        System.out.println("Tipo combustivel " + motor.getTipoCombustivel());
    }

}
