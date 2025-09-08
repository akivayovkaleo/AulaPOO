public class Main {
    public static void main(String[] args) {
        Hospede hospede = new Hospede("Maria Oliveira", "123.456.789-00", "(11) 98765-4321", "maria@example.com");
        System.out.println(hospede);

        Quarto quarto = new Quarto("Luxo", 300.0);
        ReservaPremium reservaPremium = new ReservaPremium("Maria Oliveira", "01/12/2025", "10/12/2025", 300.0, quarto);

        Servico spa = new Servico("Spa Relaxante", 150.0);
        Servico jantar = new Servico("Jantar à luz de velas", 200.0);
        reservaPremium.adicionarServicoExclusivo(spa);
        reservaPremium.adicionarServicoExclusivo(jantar);

        reservaPremium.exibirResumoReserva();

        int numeroDiarias = 10;
        double totalComDesconto = reservaPremium.calcularTotal(numeroDiarias, 15.0);
        System.out.println("Total com desconto: R$" + totalComDesconto);

        Pagamento pagamento = new Pagamento(totalComDesconto);
        pagamento.pagar();
    }
}
