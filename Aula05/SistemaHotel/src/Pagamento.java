public class Pagamento {
    private double valorTotal;
    private boolean pago;

    public Pagamento(double valorTotal) {
        this.valorTotal = valorTotal;
        this.pago = false;
    }

    public void pagar() {
        if (!pago) {
            System.out.println("Pagamento realizado de R$" + valorTotal);
            pago = true;
        } else {
            System.out.println("Pagamento já realizado.");
        }
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
