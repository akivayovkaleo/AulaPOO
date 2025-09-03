//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        endereco enderecoDaPessoa = new endereco("Rua XV de Novembro", "1586", "Blumenau", "SC");

        pessoa p1 = new pessoa("Kaleo", 19, enderecoDaPessoa);

        System.out.println("Dados do pessoa: ");
        p1.exibirDados();

    }
}