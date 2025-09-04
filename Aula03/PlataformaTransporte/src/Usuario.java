public class Usuario {
    private String nome;
    private String cpf;
    private double saldo;
    private String email;

    public Usuario(String nome, String cpf, double saldo, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
        this.email = email;
    }

    public boolean pagarPassagem(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getEmail() {
        return email;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}