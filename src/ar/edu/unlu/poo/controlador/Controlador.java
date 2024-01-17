package ar.edu.unlu.poo.controlador;

import ar.edu.unlu.poo.modelo.*;
import ar.edu.unlu.poo.vista.IVista;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;
import java.util.ArrayList;


public class Controlador implements IControladorRemoto {

    private IMesa modelo;

    private IVista vista;

    private Jugador jugador;

    private String jugadorActual;

    private Integer turnoActual;

    private ArrayList<Jugador> jugadores;

    private boolean partida = false;

    private ArrayList<Carta> mano;

    public Controlador(IVista vista) {
        this.vista = vista;
        this.vista.setControlador(this);
    }


@Override
    public void actualizar(IObservableRemoto modelo, Object cambio) throws RemoteException {
    if (cambio instanceof Mensaje){
        switch ((Mensaje) cambio){

            case Nueva_Partida ->{
                partida = true;
                mano = jugador.getMano();
                jugadorActual = this.modelo.turno();
                turnoActual = 0;
                this.vista.mostrarIniciarPartida(jugadorActual,mano);
            }

            case Nuevo_Jugador -> {
                jugadores = this.modelo.obtenerJugadores();
            }

            case Tirar_Carta -> {


            }

        }

        }
    }
    public void cambiarTurno() {
        jugadorActual = modelo.cambiarTurno(turnoActual);
        if (turnoActual >= jugadores.size() - 1) turnoActual = 0;
        else turnoActual++;
    }

    @Override
    public <T extends IObservableRemoto> void setModeloRemoto(T modeloRemoto) throws RemoteException {
    this.modelo = (IMesa) modeloRemoto;
    }


}
