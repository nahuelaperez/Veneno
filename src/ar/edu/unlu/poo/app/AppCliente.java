package ar.edu.unlu.poo.app;

import ar.edu.unlu.poo.controlador.Controlador;
import ar.edu.unlu.poo.vista.IVista;
import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.Util;
import ar.edu.unlu.rmimvc.cliente.Cliente;

import javax.swing.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

    public class AppCliente {

        public static void main(String[] args) {
            ArrayList<String> ips = Util.getIpDisponibles();
            String ip = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione la IP en la que escuchará peticiones el cliente", "IP del cliente",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    ips.toArray(),
                    null
            );
            String port = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el puerto en el que escuchará peticiones el cliente", "Puerto del cliente",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    9999
            );
            String ipServidor = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione la IP en la corre el servidor", "IP del servidor",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    null
            );
            String portServidor = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el puerto en el que corre el servidor", "Puerto del servidor",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    8888
            );
            IVista vista = new VistaConsola(controlador);
            Controlador controlador = new Controlador(vista);
            Cliente c = new Cliente(ip, Integer.parseInt(port), ipServidor, Integer.parseInt(portServidor));
            vista.iniciar();
            try {
                c.iniciar(controlador);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (RMIMVCException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }


