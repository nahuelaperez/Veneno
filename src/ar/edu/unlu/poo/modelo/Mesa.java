package ar.edu.unlu.poo.modelo;


import ar.edu.unlu.rmimvc.observer.ObservableRemoto;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Mesa extends ObservableRemoto implements IMesa {
    private Baraja baraja;
    private ArrayList<Jugador> jugadores;

    private Pozo pozoOro;
    private Pozo pozoBasto;
    private Pozo pozoEspada;


    public Mesa() {
        this.baraja = new Baraja();
        this.jugadores = new ArrayList<>();
        this.pozoOro = new Pozo(new ArrayList<>());
        this.pozoBasto = new Pozo(new ArrayList<>());
        this.pozoEspada = new Pozo(new ArrayList<>());

    }

    @Override
    public Boolean nuevaPartida() throws RemoteException {
        if (jugadores.size() >= 2){
            darMano();
            primerTurno();
            this.notificarObservadores(Mensaje.Nueva_Partida);
            return true;
        }
        return false;
    }


    @Override
    public Carta sacarCarta() {
        return baraja.sacarCarta();
    }

    @Override
    public ArrayList<Carta> repartirMano() {
        ArrayList<Carta> mano = new ArrayList<>();
        for (int i = 1; i <=4 ; i++) {
            mano.add(sacarCarta());
        }
        return mano;
    }


    @Override
    public void darMano(){
        for (Jugador jugador: jugadores) {
            jugador.setMano(repartirMano());
        }
    }

    @Override
    public String turno(){
        for (Jugador jugador : jugadores){
            if (jugador.miTurno()){
                return jugador.getNombreJugador();
            }
        }
        return null;
    }

    private void primerTurno(){
        jugadores.get(0).setTurno();
    }

    @Override
    public String cambiarTurno(Integer JugadorActual){
        if (JugadorActual >= jugadores.size() - 1){
            JugadorActual = 0;
            jugadores.get(JugadorActual).setTurno();
            return jugadores.get(JugadorActual).getNombreJugador();
        } else {
            jugadores.get(JugadorActual+1).setTurno();
            return jugadores.get(JugadorActual+1).getNombreJugador();
        }

    }

    @Override
    public void JugadaCopa(Jugador jugador, Carta carta, Integer pozo) throws RemoteException {

         switch (pozo) {
            case 1 -> {
                if (pozoOro.agregarAlPozo(carta)) {
                    darPozoJugador(jugador, pozoOro);
                }
            }
            case 2 -> {
                if (pozoBasto.agregarAlPozo(carta)){
                    darPozoJugador(jugador,pozoBasto);
                }
            }
            case 3 -> {
                if (pozoEspada.agregarAlPozo(carta)){
                    darPozoJugador(jugador,pozoEspada);
                }
            }
        };
        this.notificarObservadores(Mensaje.Recoger_Pozo);
    }

    @Override
    public void jugada(Jugador jugador, Carta carta) throws RemoteException{
         switch (carta.getPalo()) {
            case ORO -> {
                if (pozoOro.agregarAlPozo(carta)) {
                    darPozoJugador(jugador, pozoOro);

                }

            }
            case BASTO -> {
                if (pozoBasto.agregarAlPozo(carta)){
                    darPozoJugador(jugador,pozoBasto);

                }
            }
            case ESPADA -> {
                if (pozoEspada.agregarAlPozo(carta)) {
                    darPozoJugador(jugador, pozoEspada);

                }
            }
        };
        this.notificarObservadores(Mensaje.Recoger_Pozo);
    };


    @Override
    public void darPozoJugador(Jugador jugador, Pozo pozo){
        jugador.setPozoJugador(pozo.recogerPozo());
    }

    @Override
    public void agregarJugador(String nombre) throws RemoteException{
        if (jugadores.size() <= 4){
            Jugador jugador = new Jugador(nombre);
            jugadores.add(jugador);
        }
        this.notificarObservadores(Mensaje.Nuevo_Jugador);
    }
    @Override
    public ArrayList<Jugador> obtenerJugadores() {
        return new ArrayList<>(jugadores);
    }

    @Override
    public Integer calcularPuntos(ArrayList<Carta> pilaCarta){
        Integer contador = 0;
        for (int i = 0; i < pilaCarta.size(); i++) {
            if (pilaCarta.get(i).getPalo().equals(Palo.COPA)){
                contador++;
            }
        }
        return contador;
    }

    @Override
    public void finRonda() throws RemoteException{
        for (Jugador jugador: jugadores){
         Integer puntos = jugador.getPuntos() + calcularPuntos(jugador.getPozoJugador());
            jugador.setPuntos(puntos);
            this.notificarObservadores(Mensaje.Fin_Ronda);
        }
    }

    @Override
    public void nuevaRonda() throws RemoteException{
        this.baraja = new Baraja();
        darMano();
        this.notificarObservadores(Mensaje.Nueva_Ronda);
    }

}
