public class LeitorCsv implements ArquivoLeitor {
    @Override
    public void ler() {
        System.out.println("Lendo conteúdo de um arquivo .csv...");
        System.out.println("Nome,Idade,Cidade\nAna,30,São Paulo\nCarlos,25,Rio de Janeiro");
    }
}
