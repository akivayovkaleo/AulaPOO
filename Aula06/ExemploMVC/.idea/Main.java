import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o critério de pesquisa:");
        System.out.println("1 - Pesquisar por nome");
        System.out.println("2 - Pesquisar por preço (menor que)");
        System.out.print("Digite a opção desejada (1 ou 2): ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        String resultado = "";

        switch (opcao) {
            case 1:
                System.out.print("Digite o nome do produto para pesquisa: ");
                String nomeProduto = scanner.nextLine();
                resultado = ProdutoController.pesquisarProduto(nomeProduto);
                break;

            case 2:
                System.out.print("Digite o valor máximo para o preço: R$ ");
                double precoMaximo = scanner.nextDouble();
                resultado = ProdutoController.pesquisarPorPreco(precoMaximo);
                break;

            default:
                resultado = "Opção inválida!";
        }

        System.out.println("\nResultado da pesquisa:");
        System.out.println(resultado);
    }
}
