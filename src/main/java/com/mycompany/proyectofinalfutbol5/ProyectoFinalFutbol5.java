package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class ProyectoFinalFutbol5 {

    public static void main(String[] args) {
        // Inicialización de jugadores y equipos
        Jugadores.inicializarJugadores();  // Inicializa los jugadores
        Equipos.inicializarJugadoresYAsignarEquipos();  // Inicializa los equipos y asigna jugadores

        boolean ejecutar = true;

        while (ejecutar) {
            // Menú de opciones
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
                    GestionJugadores.gestionJugadores();  // Menú de gestión de jugadores
                    break;
                case 1:
                    GestionEquipo.gestionEquipos();  // Menú de gestión de equipos
                    break;
                case 2:
                    // Simulación de partidos (pendiente de implementación)
                    JOptionPane.showMessageDialog(null, "Simulación de partidos en desarrollo.");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Generando reportes...");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema, ¡hasta luego!");
                    ejecutar = false;  // Termina el bucle y sale del programa
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Si desea salir, seleccione la opción 5.");
            }
        }
    }
}
