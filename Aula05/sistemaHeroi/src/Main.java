public class Main {
    public static void main(String[] args) {
        Heroi[] herois = {
                new Superman("Superman", 1000, 5000),
                new MulherMaravilha("Mulher Maravilha", 900, 4000),
                new Flash("Flash", 800, 4500)
        };

//for (Heroi heroi : herois) {
//           heroi.usarPoder();
//        }

        Superman.usarPoder();
        MulherMaravilha.usarPoder();
        Flash.usarPoder();    }
}
