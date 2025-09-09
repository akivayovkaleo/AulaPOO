public class EmailNotificador implements Notificador {
    @Override
    public void enviar(String mensagem) {
        System.out.println("[E-MAIL] Enviando mensagem: " + mensagem);
    }
}

