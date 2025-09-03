public class motor {
    private double clindrada;
    private int potenciaCv;
    private String tipoCombustivel;

    public motor(double clindrada, int potenciaCv, String tipoCombustivel) {
        this.clindrada = clindrada;
        this.potenciaCv = potenciaCv;
        this.tipoCombustivel = tipoCombustivel;
    }

    public double getClindrada() {
        return clindrada;
    }

    public void setClindrada(double clindrada) {
        this.clindrada = clindrada;
    }

    public int getPotenciaCv() {
        return potenciaCv;
    }

    public void setPotenciaCv(int potenciaCv) {
        this.potenciaCv = potenciaCv;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

}
