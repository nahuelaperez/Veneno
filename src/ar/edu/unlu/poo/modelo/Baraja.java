package ar.edu.unlu.poo.modelo;

import java.util.ArrayList;

public class Baraja {

    private ArrayList<Carta> mazo;

    public Baraja() {
        this.mazo = crearBaraja();
    }

    private ArrayList<Carta> crearBaraja(){
        ArrayList<Carta> mazo = new ArrayList<>();
        for (Palo palo: Palo.values()
             ) {
            for (int i = 1; i < 13; i++) {
                mazo.add(new Carta(palo,i));
            }
        }
        return mazo;
    }

    public Carta sacarCarta() {
        if (mazo.isEmpty()) {
            return null;
        }
        int indiceCartaAleatoria = (int) (Math.random() * mazo.size());
        Carta cartaSacada = mazo.remove(indiceCartaAleatoria);
        return cartaSacada;
    }

}
