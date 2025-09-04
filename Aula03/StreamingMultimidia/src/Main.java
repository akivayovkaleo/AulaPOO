
import java.util.List;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        out.println("=== Sistema de Streaming Multimídia ===\n");

        // Criando usuários
        Usuario usuarioGratuito = new Usuario("Carlos Silva", false);
        Usuario usuarioPremium = new Usuario("Ana Costa", true);

        out.println("Usuários criados:");
        out.println("- " + usuarioGratuito.getNome() + " (Gratuito)");
        out.println("- " + usuarioPremium.getNome() + " (Premium)\n");

        // Criando conteúdos
        Filme filme1 = new Filme("Matrix", 136, "Ficção Científica", "Lana Wachowski", 1999);
        Filme filme2 = new Filme("O Poderoso Chefão", 175, "Drama", "Francis Ford Coppola", 1972);
        Serie serie1 = new Serie("Breaking Bad", 45, "Drama", 5, 62);
        Documentario doc1 = new Documentario("Cosmos", 60, "Ciência", "Astronomia", "National Geographic");
        Musica musica1 = new Musica("Bohemian Rhapsody", 6, "Rock", "Queen", "A Night at the Opera");

        out.println("Conteúdos disponíveis:");
        out.println("- " + filme1.getTitulo() + " (" + filme1.getTipo() + ")");
        out.println("- " + filme2.getTitulo() + " (" + filme2.getTipo() + ")");
        out.println("- " + serie1.getTitulo() + " (" + serie1.getTipo() + ")");
        out.println("- " + doc1.getTitulo() + " (" + doc1.getTipo() + ")");
        out.println("- " + musica1.getTitulo() + " (" + musica1.getTipo() + ")\n");

        // Criando serviço de recomendação
        Recomendador recomendador = new Recomendador();
        recomendador.adicionarConteudo(filme1);
        recomendador.adicionarConteudo(filme2);
        recomendador.adicionarConteudo(serie1);
        recomendador.adicionarConteudo(doc1);
        recomendador.adicionarConteudo(musica1);

        // Usuário gratuito assiste alguns conteúdos
        usuarioGratuito.adicionarAoHistorico(filme1);
        usuarioGratuito.adicionarAoHistorico(serie1);
        out.println(usuarioGratuito.getNome() + " assistiu: " + filme1.getTitulo() + " e " + serie1.getTitulo());

        // Usuário premium assiste mais conteúdos
        usuarioPremium.adicionarAoHistorico(filme1);
        usuarioPremium.adicionarAoHistorico(filme2);
        usuarioPremium.adicionarAoHistorico(doc1);
        out.println(usuarioPremium.getNome() + " assistiu: " + filme1.getTitulo() + ", " +
                filme2.getTitulo() + " e " + doc1.getTitulo());

        // Criando playlists
        usuarioPremium.criarPlaylist("Minha Lista");
        usuarioPremium.getPlaylists().get(0).adicionarConteudo(filme2);
        usuarioPremium.getPlaylists().get(0).adicionarConteudo(musica1);
        out.println("\n" + usuarioPremium.getNome() + " criou uma playlist com " +
                usuarioPremium.getPlaylists().get(0).getItens().size() + " itens");

        // Avaliações
        Avaliacao aval1 = new Avaliacao(usuarioPremium, filme1, 5, "Excelente filme!");
        Avaliacao aval2 = new Avaliacao(usuarioGratuito, serie1, 4, "Muito boa série");
        usuarioPremium.adicionarAvaliacao(aval1);
        usuarioGratuito.adicionarAvaliacao(aval2);

        out.println("\nAvaliações realizadas:");
        out.println("- " + aval1.getUsuario().getNome() + " avaliou " +
                aval1.getConteudo().getTitulo() + " com nota " + aval1.getNota());
        out.println("- " + aval2.getUsuario().getNome() + " avaliou " +
                aval2.getConteudo().getTitulo() + " com nota " + aval2.getNota());

        // Mostrando avaliações médias
        out.println("\nAvaliações médias:");
        out.println("- " + filme1.getTitulo() + ": " + String.format("%.1f", filme1.getAvaliacaoMedia()) +
                " (" + filme1.getTotalAvaliacoes() + " avaliações)");
        out.println("- " + serie1.getTitulo() + ": " + String.format("%.1f", serie1.getAvaliacaoMedia()) +
                " (" + serie1.getTotalAvaliacoes() + " avaliações)");

        // Recomendações
        out.println("\nRecomendações para " + usuarioPremium.getNome() + ":");
        List<Conteudo> recomendacoesPremium = recomendador.recomendarPorHistorico(usuarioPremium);
        for (Conteudo conteudo : recomendacoesPremium) {
            out.println("- " + conteudo.getTitulo() + " (" + conteudo.getTipo() + ")");
        }

        out.println("\nRecomendações para " + usuarioGratuito.getNome() + ":");
        List<Conteudo> recomendacoesGratuito = recomendador.recomendarPorHistorico(usuarioGratuito);
        for (Conteudo conteudo : recomendacoesGratuito) {
            out.println("- " + conteudo.getTitulo() + " (" + conteudo.getTipo() + ")");
        }

        // Informações da assinatura premium
        if (usuarioPremium.getAssinatura() != null) {
            out.println("\nAssinatura de " + usuarioPremium.getNome() + ":");
            out.println("- Tipo: " + usuarioPremium.getAssinatura().getTipo());
            out.println("- Valor: R$ " + String.format("%.2f", usuarioPremium.getAssinatura().getValorMensal()));
            out.println("- Ativa: " + (usuarioPremium.getAssinatura().isAtiva() ? "Sim" : "Não"));
        }
    }
}