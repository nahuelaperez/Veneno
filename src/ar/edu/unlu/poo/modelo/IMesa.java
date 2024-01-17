package ar.edu.unlu.poo.modelo;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IMesa  extends IObservableRemoto {
    Boolean nuevaPartida() throws RemoteException;

    Carta sacarCarta();

    ArrayList<Carta> repartirMano();

    void darMano();

    String turno();

    String cambiarTurno(Integer JugadorActual);

    void JugadaCopa(Jugador jugador, Carta carta, Integer pozo) throws RemoteException;

    void jugada(Jugador jugador, Carta carta) throws RemoteException;

    void darPozoJugador(Jugador jugador, Pozo pozo);

    void agregarJugador(String nombre) throws RemoteException;

    ArrayList<Jugador> obtenerJugadores();

    Integer calcularPuntos(ArrayList<Carta> pilaCarta);

    void finRonda() throws RemoteException;

    void nuevaRonda() throws RemoteException;
}
