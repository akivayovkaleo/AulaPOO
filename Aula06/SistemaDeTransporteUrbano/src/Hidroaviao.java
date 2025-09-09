public class Hidroaviao implements Terrestre, Aquatico, Aereo {

    private enum Estado {
        NO_CHÃO,
        NA_AGUA,
        VOANDO
    }

    private Estado estadoAtual;

    public Hidroaviao() {
        this.estadoAtual = Estado.NO_CHÃO;
    }

    @Override
    public void dirigir() {
        if (estadoAtual == Estado.NO_CHÃO) {
            System.out.println("Hidroavião está taxiando na pista.");
        } else {
            System.out.println("Não é possível taxiá-lo fora da pista.");
        }
    }

    @Override
    public void navegar() {
        if (estadoAtual == Estado.NO_CHÃO) {
            System.out.println("Hidroavião saiu da pista e está navegando na água.");
            estadoAtual = Estado.NA_AGUA;
        } else if (estadoAtual == Estado.NA_AGUA) {
            System.out.println("Hidroavião continua navegando.");
        } else {
            System.out.println("Hidroavião não pode navegar enquanto está voando.");
        }
    }

    @Override
    public void voar() {
        if (estadoAtual == Estado.NO_CHÃO || estadoAtual == Estado.NA_AGUA) {
            System.out.println("Hidroavião decolando e começando a voar.");
            estadoAtual = Estado.VOANDO;
        } else if (estadoAtual == Estado.VOANDO) {
            System.out.println("Hidroavião já está voando.");
        }
    }

    public void pousarNaAgua() {
        if (estadoAtual == Estado.VOANDO) {
            System.out.println("Hidroavião pousando na água.");
            estadoAtual = Estado.NA_AGUA;
        } else {
            System.out.println("Hidroavião não está voando para pousar.");
        }
    }

    public void pousarNaPista() {
        if (estadoAtual == Estado.VOANDO) {
            System.out.println("Hidroavião pousando na pista.");
            estadoAtual = Estado.NO_CHÃO;
        } else {
            System.out.println("Hidroavião não está voando para pousar.");
        }
    }
}
