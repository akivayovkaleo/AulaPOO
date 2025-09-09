public class Investidor {
    private String nome;
    protected Carteira carteira;
    private double saldoDisponivel;

    public Investidor(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldoDisponivel = saldoInicial;
        this.carteira = new Carteira();
    }

    public boolean comprarAcao(Acao acao, int quantidade, double precoUnitario) {
        double custoTotal = quantidade * precoUnitario;
        if (saldoDisponivel >= custoTotal) {
            saldoDisponivel -= custoTotal;
            carteira.adicionarAcao(acao, quantidade, precoUnitario);
            System.out.println(nome + " comprou " + quantidade + " ações de " + acao.getTicker() + " por " + precoUnitario + " cada.");
            return true;
        } else {
            System.out.println(nome + " não tem saldo suficiente para comprar " + quantidade + " ações de " + acao.getTicker());
            return false;
        }
    }

    public boolean venderAcao(Acao acao, int quantidade, double precoUnitario) {
        boolean sucesso = carteira.removerAcao(acao, quantidade, precoUnitario);
        if (sucesso) {
            double valorVenda = quantidade * precoUnitario;
            saldoDisponivel += valorVenda;
            System.out.println(nome + " vendeu " + quantidade + " ações de " + acao.getTicker() + " por " + precoUnitario + " cada.");
            return true;
        } else {
            System.out.println(nome + " não tem ações suficientes para vender " + quantidade + " de " + acao.getTicker());
            return false;
        }
    }

    public double consultarSaldo() {
        return saldoDisponivel;
    }

    public void mostrarCarteira() {
        System.out.println("Carteira de " + nome + ":");
        carteira.mostrarDetalhes();
    }
}
