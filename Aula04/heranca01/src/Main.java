public class Main {
    public static void main(String[] args) {
        carro c1 = new carro("Ford", 2022, "Mustang", "Vermelho", 2500.00, "Esportivo de luxo", 466);
        System.out.println(" Carro ");
        c1.detalhes();

        aviao a1 = new aviao("Boeing", 2015, "737", "Branco", 9500.00, "Aeronave comercial", "LATAM");
        System.out.println(" Avião");
        a1.detalhes();
    }
}
