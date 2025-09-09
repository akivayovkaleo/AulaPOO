import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MetodoPagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new CartaoCredito());
        pagamentos.add(new PayPal());
        pagamentos.add(new Pix());

        double[] valores = {150.00, 89.90, 25.50};

        System.out.println("Pagamentos");

        for (int i = 0; i < pagamentos.size(); i++) {
            MetodoPagamento metodo = pagamentos.get(i);
            double valor = valores[i];

            System.out.println("\n " + metodo.getClass().getSimpleName() + " ");
            metodo.processarPagamento(valor);
        }
    }
}
