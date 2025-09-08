import java.util.*;

public abstract class Personagem {
    protected String nome;
    protected int nivel = 1;
    protected int xp = 0;
    protected int xpParaProximoNivel = 100;
    protected int forca, destreza, inteligencia, vitalidade, sorte;
    protected int vidaMax, manaMax;
    protected int vidaAtual, manaAtual;
    protected String classe;
    protected Subclasse subclasse = null;
    protected Arma arma = null;
    protected Armadura armadura = null;
    protected List<Item> inventario = new ArrayList<>();
    protected List<Habilidade> habilidadesAprendidas = new ArrayList<>();
    protected List<Habilidade> habilidadesEquipadas = new ArrayList<>(Arrays.asList(null, null, null, null));
    protected int pontosAtributo = 0;
    protected int ouro = 100;
    protected ContratoDivino contrato = null;
    protected Elemento elemento = Elemento.NEUTRO;
    protected int numeroRenascimentos = 0;
    protected int poderDivino = 0;
    protected List<Habilidade> habilidadesDivinas = new ArrayList<>();

    public Personagem(String nome, String classe, int forca, int destreza, int inteligencia, int vitalidade, int sorte) {
        this.nome = nome;
        this.classe = classe;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.vitalidade = vitalidade;
        this.sorte = sorte;
        this.vidaMax = this.vitalidade * 10;
        this.manaMax = this.inteligencia * 5;
        this.vidaAtual = this.vidaMax;
        this.manaAtual = this.manaMax;
        aprenderHabilidadesIniciais();
    }

    private void aprenderHabilidadesIniciais() {
        habilidadesAprendidas.add(new Habilidade("Ataque Básico", "Ataque físico básico", 1, 0, 5));
        habilidadesAprendidas.add(new Habilidade("Cura Menor", "Recupera um pouco de vida", 2, 10, 0));
    }

    public void ganharXP(int xp) {
        // Aumentar XP ganho se tiver contrato divino
        if (contrato != null) {
            xp = (int) (xp * 1.5); // 50% mais XP
        }

        this.xp += xp;
        while (this.xp >= this.xpParaProximoNivel && this.nivel < 100) {
            this.xp -= this.xpParaProximoNivel;
            this.nivel++;
            this.pontosAtributo += 5;
            this.xpParaProximoNivel = (int) (this.xpParaProximoNivel * 1.2);
            aprenderHabilidadePorNivel();
            verificarHabilidadesDivinas();
            subirNivel();
        }
    }

    private void subirNivel() {
        this.vidaAtual = this.vidaMax;
        this.manaAtual = this.manaMax;
        System.out.println(nome + " subiu para o nível " + nivel + "!");
        if (nivel == 20) {
            System.out.println(nome + " pode escolher uma subclasse!");
            escolherSubclasse();
        }
    }

    private void escolherSubclasse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha sua subclasse:");

        List<Subclasse> subclassesDisponiveis = new ArrayList<>();
        if (classe.equals("Guerreiro")) {
            subclassesDisponiveis.add(new Berserker());
            subclassesDisponiveis.add(new Paladino());
            subclassesDisponiveis.add(new EspadachimMagico());
        } else if (classe.equals("Mago")) {
            subclassesDisponiveis.add(new Arquimago());
            subclassesDisponiveis.add(new BruxoDasSombras());
        } else if (classe.equals("Arqueiro")) {
            subclassesDisponiveis.add(new FrancoAtirador());
            subclassesDisponiveis.add(new PatrulheiroDasMatas());
        }

        for (int i = 0; i < subclassesDisponiveis.size(); i++) {
            System.out.println((i+1) + ". " + subclassesDisponiveis.get(i).getNome());
        }

        System.out.print("Escolha uma subclasse (1-" + subclassesDisponiveis.size() + "): ");
        int escolha = scanner.nextInt();

        if (escolha >= 1 && escolha <= subclassesDisponiveis.size()) {
            evoluir(subclassesDisponiveis.get(escolha-1));
        }
    }

    public void evoluir(Subclasse sub) {
        if (nivel >= 20 && subclasse == null) {
            this.subclasse = sub;
            System.out.println(nome + " evoluiu para " + sub.getNome());
            habilidadesAprendidas.addAll(sub.getHabilidades());
        }
    }

    public void aprenderHabilidadePorNivel() {
        switch (nivel) {
            case 5:
                habilidadesAprendidas.add(new Habilidade("Defesa", "Aumenta a defesa temporariamente", 3, 15, 0));
                break;
            case 10:
                habilidadesAprendidas.add(new Habilidade("Ataque Poderoso", "Ataque com dano aumentado", 4, 20, 15));
                break;
            case 15:
                habilidadesAprendidas.add(new Habilidade("Cura Média", "Recupera vida moderada", 5, 25, 0));
                break;
            case 25:
                habilidadesAprendidas.add(new Habilidade("Ataque Elemental", "Ataque baseado no elemento do personagem", 6, 30, 25));
                break;
            case 35:
                habilidadesAprendidas.add(new Habilidade("Regeneração", "Recupera vida ao longo do tempo", 7, 40, 0));
                break;
            case 50:
                habilidadesAprendidas.add(new Habilidade("Explosão Arcana", "Ataque mágico em área", 8, 45, 35));
                break;
            case 75:
                habilidadesAprendidas.add(new Habilidade("Invocação", "Invoca um aliado para lutar", 9, 50, 0));
                break;
            case 100:
                habilidadesAprendidas.add(new Habilidade("Ataque Final", "Ataque devastador", 10, 60, 50));
                break;
        }
    }

    public void verificarHabilidadesDivinas() {
        // Adicionar habilidades divinas baseadas no poder divino
        if (poderDivino >= 10 && habilidadesDivinas.isEmpty()) {
            habilidadesDivinas.add(new Habilidade("Toque Divino", "Cura mágica poderosa", 100, 30, 0));
            System.out.println(nome + " aprendeu a habilidade divina: Toque Divino!");
        }

        if (poderDivino >= 20 && habilidadesDivinas.size() == 1) {
            habilidadesDivinas.add(new Habilidade("Julgamento Sagrado", "Ataque divino que ignora defesa", 101, 40, 40));
            System.out.println(nome + " aprendeu a habilidade divina: Julgamento Sagrado!");
        }

        if (poderDivino >= 30 && habilidadesDivinas.size() == 2) {
            habilidadesDivinas.add(new Habilidade("Proteção Divina", "Escudo que absorve dano", 102, 50, 0));
            System.out.println(nome + " aprendeu a habilidade divina: Proteção Divina!");
        }
    }

    public void equiparHabilidade(int slot, Habilidade habilidade) {
        if (slot >= 0 && slot < 4 && (habilidadesAprendidas.contains(habilidade) || habilidadesDivinas.contains(habilidade))) {
            habilidadesEquipadas.set(slot, habilidade);
            System.out.println(nome + " equipou " + habilidade.getNome() + " no slot " + (slot + 1));
        } else {
            System.out.println("Não foi possível equipar a habilidade.");
        }
    }

    public void distribuirAtributo(String atributo, int pontos) {
        if (pontos > pontosAtributo) {
            System.out.println("Pontos insuficientes!");
            return;
        }

        switch (atributo.toLowerCase()) {
            case "forca":
                forca += pontos;
                break;
            case "destreza":
                destreza += pontos;
                break;
            case "inteligencia":
                inteligencia += pontos;
                break;
            case "vitalidade":
                vitalidade += pontos;
                vidaMax = vitalidade * 10;
                break;
            case "sorte":
                sorte += pontos;
                break;
            case "poderdivino":
                poderDivino += pontos;
                verificarHabilidadesDivinas();
                break;
            default:
                System.out.println("Atributo inválido!");
                return;
        }

        pontosAtributo -= pontos;
        System.out.println(pontos + " pontos distribuídos em " + atributo);
    }

    public void equiparArma(Arma arma) {
        if (arma.podeEquipar(this)) {
            this.arma = arma;
            System.out.println(nome + " equipou " + arma.getNome());
        } else {
            System.out.println("Não pode equipar essa arma.");
        }
    }

    public void adicionarItem(Item item) {
        inventario.add(item);
    }

    public boolean temPocoes() {
        for (Item item : inventario) {
            if (item instanceof Pocao) {
                return true;
            }
        }
        return false;
    }

    public void usarPocao(int quantidade) {
        this.vidaAtual = Math.min(vidaMax, vidaAtual + quantidade);
        // Remover uma poção do inventário
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i) instanceof Pocao) {
                inventario.remove(i);
                break;
            }
        }
        System.out.println(nome + " usou uma poção e recuperou " + quantidade + " de vida.");
    }

    public void ganharOuro(int valor) {
        this.ouro += valor;
    }

    public void receberContrato(ContratoDivino contrato) {
        if (this.contrato == null) {
            this.contrato = contrato;
            this.poderDivino += 10; // Aumentar poder divino ao receber contrato
            // Aplicar bônus do contrato
            this.forca += contrato.getBonusForca();
            this.destreza += contrato.getBonusDestreza();
            this.inteligencia += contrato.getBonusInteligencia();
            this.vitalidade += contrato.getBonusVitalidade();
            this.sorte += contrato.getBonusSorte();

            // Atualizar vida e mana máximas
            this.vidaMax = this.vitalidade * 10;
            this.manaMax = this.inteligencia * 5;
            this.vidaAtual = this.vidaMax;
            this.manaAtual = this.manaMax;

            System.out.println(nome + " firmou contrato com " + contrato.getDeus());
            System.out.println("Todos os atributos aumentaram!");
            System.out.println("Poder Divino aumentou em 10 pontos!");
        }
    }

    public void morrer() {
        System.out.println(nome + " morreu!");
        numeroRenascimentos++;
        System.out.println("Você renasce com os mesmos atributos e nível!");
        this.vidaAtual = this.vidaMax;
        this.manaAtual = this.manaMax;
    }

    // Getters
    public int getNivel() { return nivel; }
    public int getVidaAtual() { return vidaAtual; }
    public int getManaAtual() { return manaAtual; }
    public String getNome() { return nome; }
    public String getClasse() { return classe; }
    public Subclasse getSubclasse() { return subclasse; }
    public Arma getArma() { return arma; }
    public int getForca() {
        return forca + (contrato != null ? contrato.getBonusForca() : 0);
    }
    public int getDestreza() {
        return destreza + (contrato != null ? contrato.getBonusDestreza() : 0);
    }
    public int getInteligencia() {
        return inteligencia + (contrato != null ? contrato.getBonusInteligencia() : 0);
    }
    public int getVitalidade() {
        return vitalidade + (contrato != null ? contrato.getBonusVitalidade() : 0);
    }
    public int getSorte() {
        return sorte + (contrato != null ? contrato.getBonusSorte() : 0);
    }
    public int getOuro() { return ouro; }
    public Elemento getElemento() { return elemento; }
    public void setElemento(Elemento elemento) { this.elemento = elemento; }
    public List<Habilidade> getHabilidadesAprendidas() { return habilidadesAprendidas; }
    public List<Habilidade> getHabilidadesEquipadas() { return habilidadesEquipadas; }
    public int getPontosAtributo() { return pontosAtributo; }
    public int getVidaMax() { return vidaMax; }
    public int getManaMax() { return manaMax; }
    public void setVidaAtual(int vida) { this.vidaAtual = Math.max(0, Math.min(vida, vidaMax)); }
    public void setManaAtual(int mana) { this.manaAtual = Math.max(0, Math.min(mana, manaMax)); }
    public void setNivel(int nivel) {
        if (nivel >= 1 && nivel <= 100) {
            this.nivel = nivel;
            this.xpParaProximoNivel = (int) (100 * Math.pow(1.2, nivel - 1));
            this.vidaMax = this.vitalidade * 10;
            this.manaMax = this.inteligencia * 5;
            this.vidaAtual = this.vidaMax;
            this.manaAtual = this.manaMax;
        }
    }
    public int getXP() { return xp; }
    public int getXPParaProximoNivel() { return xpParaProximoNivel; }
    public List<Item> getInventario() { return inventario; }
    public ContratoDivino getContrato() { return contrato; }
    public int getNumeroRenascimentos() { return numeroRenascimentos; }
    public int getPoderDivino() { return poderDivino; }
    public List<Habilidade> getHabilidadesDivinas() { return habilidadesDivinas; }
}