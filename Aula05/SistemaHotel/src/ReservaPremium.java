public class ReservaPremium extends ReservaHotel {
    private Quarto quartoPremium;
    private Servico[] servicosExclusivos;

    public ReservaPremium(String nomeCliente, String dataEntrada, String dataSaida, double valorDiaria, Quarto quartoPremium) {
        super(nomeCliente, dataEntrada, dataSaida, valorDiaria);
        this.quartoPremium = quartoPremium;
        this.servicosExclusivos = new Servico[5];
    }

    public void adicionarServicoExclusivo(Servico servico) {
        for (int i = 0; i < servicosExclusivos.length; i++) {
            if (servicosExclusivos[i] == null) {
                servicosExclusivos[i] = servico;
                break;
            }
        }
    }

    @Override
    public void exibirResumoReserva() {
        super.exibirResumoReserva();
        System.out.println("Quarto Premium: " + quartoPremium);
        System.out.println("Serviços Exclusivos:");
        for (Servico servico : servicosExclusivos) {
            if (servico != null) {
                System.out.println(servico);
            }
        }
    }
}
