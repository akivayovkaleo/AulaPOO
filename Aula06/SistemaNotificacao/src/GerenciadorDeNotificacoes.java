import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeNotificacoes {

    private List<Notificador> notificadores;

    public GerenciadorDeNotificacoes() {
        this.notificadores = new ArrayList<>();
    }

    public void registrarNotificador(Notificador notificador) {
        notificadores.add(notificador);
    }

    public void enviarParaTodos(String mensagem) {
        for (Notificador notificador : notificadores) {
            notificador.enviar(mensagem);
        }
    }
}
