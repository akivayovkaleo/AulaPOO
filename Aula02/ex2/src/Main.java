//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        motor motorV8 = new motor(5.0, 657, "Gasolina");
        motor motorV10 = new motor(6.0, 851, "Gasolina");

        carro carrV8 = new carro("Chevrolet","Camaro",2024, motorV8);

        carro carroV10 = new carro("Porshe","Spyder718",2024, motorV10);

        System.out.println("Carro 1");
        carrV8.exibir();
    }
}