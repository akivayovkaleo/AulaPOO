public class Main {
    public static void main(String[] args) {


        Smartphone smartphone = new Smartphone();
        Televisao televisao = new Televisao();
        LampadaInteligente lampadaInteligente = new LampadaInteligente();

        System.out.println("\nSmartphone");
        smartphone.ligar();
        smartphone.conectar();
        smartphone.configurar();
        smartphone.desligar();

        System.out.println("\nTelevisão");
        televisao.ligar();
        televisao.conectar();
        televisao.desligar();

        System.out.println("\nLâmpada Inteligente");
        lampadaInteligente.ligar();
        lampadaInteligente.conectar();
        lampadaInteligente.desligar();
    }
}
