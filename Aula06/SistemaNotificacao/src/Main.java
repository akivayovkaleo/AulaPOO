public class Main {
    public static void main(String[] args) {
        Notificador email = new EmailNotificador();
        Notificador sms = new SmsNotificador();
        Notificador push = new PushNotificador();

        GerenciadorDeNotificacoes gerenciador = new GerenciadorDeNotificacoes();
        gerenciador.registrarNotificador(email);
        gerenciador.registrarNotificador(sms);
        gerenciador.registrarNotificador(push);
    }
}
