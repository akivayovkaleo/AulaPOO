public class PushNotificador implements Notificador {
    @Override
    public void enviar(String mensagem) {
        System.out.println("[PUSH] Enviando notificação: " + mensagem);
    }
}
