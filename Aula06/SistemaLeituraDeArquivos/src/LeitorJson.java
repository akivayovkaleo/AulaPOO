public class LeitorJson implements ArquivoLeitor {
    @Override
    public void ler() {
        System.out.println("Lendo conteúdo de um arquivo .json...");
        System.out.println("{\n  \"nome\": \"João\",\n  \"idade\": 28,\n  \"cidade\": \"BLUMENAU\"\n}");
    }
}
