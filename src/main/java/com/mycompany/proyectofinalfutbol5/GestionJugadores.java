package com.mycompany.proyectofinalfutbol5;
// ultima actualizacion 

import javax.swing.JOptionPane;

public class GestionJugadores {

    public static void gestionJugadores() {
        boolean jugadorGestion = true;
        while (jugadorGestion) {
            int codigo1 = Integer.parseInt(JOptionPane.showInputDialog(
                    "╔══════════════ Gestión de Jugadores ═════════════════╗\n"
                    + "       1- Mostrar jugadores. 🏃🏃\n"
                    + "       2- Agregar nuevo jugador. +🏃\n"
                    + "       3- Editar jugador. 🏃🏼‍\n"
                    + "       4- Eliminar jugador. ⚠\n"
                    + "       5- Volver al menu. 🔚\n"
                    + "╚═══════════════════════════════════════════════════╝"));

            
            
       
            
            switch (codigo1) { 
                case 1:
                  
                Jugadores.mostrarJugadores();
                    break;
                case 2:
            Jugadores.agregarNuevoJugador();
                    break;
                case 3:
                    editarJugador();
                    break;
                case 4:
                    Jugadores.eliminarJugador();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Volviendo al menu principal.");
                    jugadorGestion = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Número incorrecto, intente nuevamente.");
            }
        }
    }

    
    
 private static void editarJugador() {
    int idJugador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del jugador a editar: "));

    for (int i = 0; i < Jugadores.getCantidadJugadores(); i++) {
        
        // Obtener el arreglo de jugadores y guardarlos en jugadores
        Jugadores[] jugadores = Jugadores.getJugadores();
        
        if (jugadores[i].getID() == idJugador) {
           
            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
            jugadores[i].setNombre(nuevoNombre);

            Posicion nuevaPosicion = seleccionPosicion();
            jugadores[i].setPosicion(nuevaPosicion);

            Estado nuevoEstado = seleccionEstado();
            jugadores[i].setEstado(nuevoEstado);

            Equipos nuevoEquipo = seleccionarEquipo();
            jugadores[i].setEquipo(nuevoEquipo);

            JOptionPane.showMessageDialog(null, "Jugador editado con éxito.");
            return; 
        }
    }

    
    JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
}


    private static Posicion seleccionPosicion() {
    String[] opciones = {"Portero", "Defensa", "Mediocampista", "Delantero"};
    int seleccion = JOptionPane.showOptionDialog(
            null, 
            "Seleccione la posición del jugador:", 
            "Posición",
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opciones,
            opciones[0]);

    Posicion posicionSeleccionada = null;

    switch (seleccion) {
        case 0:
            posicionSeleccionada = Posicion.Portero;
            break;
        case 1:
            posicionSeleccionada = Posicion.Defensa;
            break;
        case 2:
            posicionSeleccionada = Posicion.MedioCampista;
            break;
        case 3:
            posicionSeleccionada = Posicion.Delantero;
            break;
        default:
            JOptionPane.showMessageDialog(null, "debe elegir una posición");
            break;
    }

    return posicionSeleccionada;
}


    private static Estado seleccionEstado() {
    String[] opciones = {"Titular", "Suplente", "Libre"};
    int seleccion = JOptionPane.showOptionDialog(
            null,
            "Seleccione el estado del jugador:", 
            "Estado",
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            opciones,
            opciones[0]);

    Estado estadoSeleccionado = null;

    switch (seleccion) {
        case 0:
            estadoSeleccionado = Estado.Titular;
            break;
        case 1:
            estadoSeleccionado = Estado.Suplente;
            break;
        case 2:
            estadoSeleccionado = Estado.Libre;
            break;
        default:
            estadoSeleccionado = null;
            break;
    }

    return estadoSeleccionado;
}
private static Equipos seleccionarEquipo() {
    int cantidadEquipos = DatosGenerales.cantidadEquipos;

    // Verificar si no hay equipos registrados
    if (cantidadEquipos == 0) {
        JOptionPane.showMessageDialog(null, "No hay equipos registrados.");
        return null;
    }
    
   // +1 para incluir "Ningún equipo"
    String[] opciones = new String[cantidadEquipos + 1]; 
    int totalOpciones = 0;

    // Llenar las opciones con equipos válidos directamente desde DatosGenerales.equipos
    for (int i = 0; i < cantidadEquipos; i++) {
        Equipos equipo = DatosGenerales.equipos[i];
        if (equipo != null && equipo.getCantidadJugadores() < 7) {
            opciones[totalOpciones] = equipo.getNombreEquipo();
            totalOpciones++;
        }
    }

    // Agregar la opción "Ningún equipo" al final
    opciones[totalOpciones] = "Ningún equipo";

    // Validar si no hay equipos válidos
    if (totalOpciones == 0) {
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "No hay equipos con espacio disponible. Seleccione una opción:",
                "Selección de equipo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Ningún equipo"}, // Solo un botón
                "Ningún equipo");
        return null; // Retornar null porque no hay equipos válidos
    }

    // Mostrar las opciones como botones
    int seleccion = JOptionPane.showOptionDialog(
            null,
            "Seleccione un equipo:",
            "Selección de equipo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opciones,
            opciones[0]);

    // Retornar el equipo seleccionado directamente desde DatosGenerales.equipos
    if (seleccion >= 0 && seleccion < totalOpciones) {
        for (int i = 0; i < cantidadEquipos; i++) {
            Equipos equipo = DatosGenerales.equipos[i];
            if (equipo != null && equipo.getNombreEquipo().equals(opciones[seleccion])) {
                return equipo;
            }
        }
    } else if (seleccion == totalOpciones) {
        JOptionPane.showMessageDialog(null, "No se asignará ningún equipo.");
        return null; // Retornar null si selecciona "Ningún equipo"
    }

    // Si no selecciona nada
    JOptionPane.showMessageDialog(null, "No se seleccionó ningún equipo.");
    return null;
}



}
