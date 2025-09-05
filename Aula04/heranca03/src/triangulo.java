public class triangulo extends figuraGeometrica {
    private double base;
    private double altura;

    public triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcular_area() {
        return (base * altura) / 2;
    }
}
