public class LampadaInteligente implements Ligavel, Conectavel, Configuravel {

    private boolean ligado = false;

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("Lâmpada inteligente ligada.");
    }

    @Override
    public void desligar() {
        ligado = false;
        System.out.println("Lâmpada inteligente desligada.");
    }

    @Override
    public void conectar() {
        if (ligado) {
            System.out.println("Lâmpada inteligente conectada.");
        } else {
            System.out.println("Ligue a lâmpada antes de conectar.");
        }
    }

    @Override
    public void configurar(){
        System.out.println("Configurando configuracao.");
    }
}
