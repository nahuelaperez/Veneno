package ar.edu.unlu.poo.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Jugador implements Serializable {

    private ArrayList<Carta> mano;
    private String nombreJugador;

    private Integer puntos;

    private Boolean turno;

    private ArrayList<Carta> pozoJugador;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.turno = false;
        this.puntos = 0;
        this.mano = new ArrayList<>();
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    public ArrayList<Carta> getPozoJugador() {
        return pozoJugador;
    }

    public void setTurno() {
        this.turno = true;
    }

    public boolean miTurno() {
        return turno;
    }

    public void setPozoJugador(ArrayList<Carta> pozoJugador) {
        this.pozoJugador.addAll(pozoJugador);
    }
}
