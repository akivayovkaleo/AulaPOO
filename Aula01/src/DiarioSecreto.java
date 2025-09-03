public class DiarioSecreto {
    private String dono;
    private String senha;
    private String texto;

    public DiarioSecreto(String dono, String senha) {
        this.dono = dono;
        this.senha = senha;
        this.texto = "";
    }

    public void escrever(String senhaDigitada, String texto) {
        if (this.senha.equals(senhaDigitada)) {
            this.texto = texto;
            System.out.println("Texto escrito com sucesso no diario de " + this.dono + ".");
        } else {
            System.out.println("Acesso negado");
        }
    }

    public void ler(String senhaDigitada) {
        if (this.senha.equals(senhaDigitada)) {
            System.out.println("Diario de " + this.dono + ": " + this.texto);
        } else {
            System.out.println("Acesso negado");
        }
    }

    public String getDono() {
        return dono;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}