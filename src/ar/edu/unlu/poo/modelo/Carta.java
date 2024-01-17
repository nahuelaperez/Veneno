package ar.edu.unlu.poo.modelo;

public class Carta {

    private Palo palo;

    private int numeroCarta;

    public Carta(Palo palo,int numeroCarta) {
        this.palo = palo;
        this.numeroCarta = numeroCarta;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public Integer getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(Integer numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

}
