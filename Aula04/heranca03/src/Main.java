public class Main {
    public static void Main(String[] args) {
        retangulo r = new retangulo(5, 3);
        triangulo t = new triangulo(4, 6);

        System.out.println("Área do retângulo: " + r.calcular_area());
        System.out.println("Área do triângulo: " + t.calcular_area());
    }
}
