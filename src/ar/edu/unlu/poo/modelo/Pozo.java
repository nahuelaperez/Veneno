package ar.edu.unlu.poo.modelo;

import java.util.ArrayList;

public class Pozo {

    private ArrayList<Carta> pozo;

    public Pozo(ArrayList<Carta> pozo) {
        this.pozo = pozo;
    }

    public ArrayList<Carta> recogerPozo() {//da el pozo al jugador
        ArrayList<Carta> auxiliar = new ArrayList<>(pozo);
        pozo.clear();
        return auxiliar;
    }
    public Boolean agregarAlPozo(Carta carta) {  // agrega una carta al pozo
        pozo.add(carta);
        return calcularPozo();
    }

    private Boolean calcularPozo() {
        Double puntosPozo = 0.0;
        for (Carta carta : pozo) {
            puntosPozo += asignarPuntos(carta);
        }
        if (puntosPozo >= 13) {
            return true;
        }
        else
            return false;
    }

    private Double asignarPuntos(Carta carta) { //asigna los puntos del pozo
        if (carta.getNumeroCarta() >= 1 && carta.getNumeroCarta() <= 9) {
            return (double) carta.getNumeroCarta();
        } else if (carta.getNumeroCarta() >= 10 && carta.getNumeroCarta() <= 12) {
            return 0.5;
        }
        return null;
    }


}
