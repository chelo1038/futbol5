package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class ProyectoFinalFutbol5 {

    public static void main(String[] args) {

        Jugadores.inicializarJugadoresYAsignarEquipos();

        boolean ejecutar = true;

        while (ejecutar) {

            String mensaje = "Seleccione una opción:";
            String[] opciones = {
                "1- Gestión de jugadores🏃",
                "2- Gestión de Equipos🏃🏃",
                "3- Simulación de Partidos🏃🏼‍🏃",
                "4- Reportes⚠",
                "5- Salir 🔚"
            };
            int codigo = JOptionPane.showOptionDialog(
                    null,
                    mensaje,
                    "Gestor de Partidos de Fútbol Cinco⚽",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (codigo) {
                case 0:
                    GestionJugadores.gestionJugadores();
                    break;
                case 1:
                    GestionEquipo.gestionEquipos();
                    break;
                case 2:
                    SimulacionPartidos.simularPartido();
                    JOptionPane.showMessageDialog(null, "Simulación de partidos en desarrollo.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Generando reportes...");
                     Reportes.generarTablaEstadisticasEquipos(DatosGenerales.equipos);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema, ¡hasta luego!");
                    ejecutar = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Si desea salir, seleccione la opción 5.");
            }
        }
    }
}
// esta es la prueba del primer commit 
