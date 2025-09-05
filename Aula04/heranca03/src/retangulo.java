public class retangulo extends figuraGeometrica {
    private double base;
    private double altura;

    public retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcular_area() {
        return base * altura;
    }
}
