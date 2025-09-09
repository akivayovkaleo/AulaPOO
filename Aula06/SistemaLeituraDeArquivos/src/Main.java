import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<ArquivoLeitor> leitores = new ArrayList<>();
        leitores.add(new LeitorTxt());
        leitores.add(new LeitorCsv());
        leitores.add(new LeitorJson());

        for (ArquivoLeitor leitor : leitores) {
            System.out.println("\n " + leitor.getClass().getSimpleName() + " ");
            leitor.ler();
        }
    }
}
