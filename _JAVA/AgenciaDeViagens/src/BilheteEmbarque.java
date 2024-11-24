public class BilheteEmbarque {
    private String numeroVoo;
    private String assento;

    public BilheteEmbarque(String numeroVoo, String assento) {
        this.numeroVoo = numeroVoo;
        this.assento = assento;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public String getAssento() {
        return assento;
    }

    public void mostrarBilhete() {
        System.out.println("Número do Voo: " + numeroVoo + ", Assento: " + assento);
    }
}

