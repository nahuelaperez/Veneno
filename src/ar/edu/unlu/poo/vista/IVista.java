package ar.edu.unlu.poo.vista;

import ar.edu.unlu.poo.controlador.Controlador;
import ar.edu.unlu.poo.modelo.Carta;

import java.util.ArrayList;

public interface IVista {
    void setControlador(Controlador controlador);

    void mostrarIniciarPartida(String jugadorActual, ArrayList<Carta> cartas);
}
