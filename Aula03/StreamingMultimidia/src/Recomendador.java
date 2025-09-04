
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recomendador {
    private Map<String, List<Conteudo>> conteudosPorGenero;

    public Recomendador() {
        this.conteudosPorGenero = new HashMap<>();
    }

    public void adicionarConteudo(Conteudo conteudo) {
        conteudosPorGenero.computeIfAbsent(conteudo.getGenero(), k -> new ArrayList<>()).add(conteudo);
    }

    public List<Conteudo> recomendarPorHistorico(Usuario usuario) {
        List<Conteudo> recomendacoes = new ArrayList<>();

        // Contar gêneros assistidos
        Map<String, Integer> generosAssistidos = new HashMap<>();
        for (Conteudo conteudo : usuario.getHistorico()) {
            generosAssistidos.put(conteudo.getGenero(),
                    generosAssistidos.getOrDefault(conteudo.getGenero(), 0) + 1);
        }

        // Encontrar o gênero mais assistido
        String generoFavorito = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : generosAssistidos.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                generoFavorito = entry.getKey();
            }
        }

        // Recomendar conteúdos do gênero favorito
        if (generoFavorito != null && conteudosPorGenero.containsKey(generoFavorito)) {
            recomendacoes.addAll(conteudosPorGenero.get(generoFavorito));
        }

        return recomendacoes;
    }

    public List<Conteudo> getConteudosPorGenero(String genero) {
        return conteudosPorGenero.getOrDefault(genero, new ArrayList<>());
    }
}