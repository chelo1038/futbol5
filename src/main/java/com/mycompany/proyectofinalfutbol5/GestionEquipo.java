package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class GestionEquipo {

    public static void gestionEquipos() {
        boolean equipoGestion = true;
        while (equipoGestion) {

            int menuEquipo = Integer.parseInt(JOptionPane.showInputDialog(
                    "╔══════════════ Gestión de Equipos ═════════════════╗\n"
                    + "      1- mostrar equipos  \n"
                    + "      2- agregar equipo\n"
                    + "      3- agregar jugador a un equipo \n"
                    + "      4- eliminar jugador de un equipo\n"
                    + "      5- volver al menú 🔚\n"
                    + "╚═════════════════════════════════════════════════╝"));
            switch (menuEquipo) {
                case 1:
                    mostrarEquipos();
                    break;
                case 2:
                    agregarEquipo();
                    break;
                case 3:
                    agregarJugadorEquipo();
                    break;
                case 4:
                    eliminarJugadorDeEquipo();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "volviendo al menu principal ");
                    equipoGestion = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "número incorrecto, intente nuevamente ");
            }
        }
    }

    public static void mostrarEquipos() {
        String listaEquipos = "Equipos registrados:\n";
        for (int i = 0; i < DatosGenerales.cantidadEquipos; i++) {
           // Obtener el arreglo de Equipos y guardarlos en equipo
            Equipos equipo =  DatosGenerales.equipos[i];
            
            listaEquipos += "ID equipo: " + equipo.getIdEquipo() + " nombre: " + equipo.getNombreEquipo() + "\n";
            listaEquipos += "Jugadores:\n";
            
            for (int j = 0; j < equipo.getCantidadJugadores(); j++) {
                Jugadores jugador = equipo.getJugadores()[j];
                listaEquipos += "ID: " + jugador.getID() + " Nombre: " + jugador.getNombre()
                        + " | Posición: " + jugador.getPosicion() + " | Estado: " + jugador.getEstado() + "\n";
            }
        }
        System.out.println(listaEquipos);

    }

    
    
   

// Una vez ingresado el nombre el nombre del equipo, se muestra un menú 
//(JOptionPane) con todos los jugadores que no pertenecen a ningún equipo. Se debe incluir una 
//opción adicional "Finalizar" que permite al usuario detener la adición de jugadores. 
    
    public static void agregarEquipo() {
        if (DatosGenerales.cantidadEquipos >= 10) {
            JOptionPane.showMessageDialog(null, "no se pueden agregar más equipos, la lista de equipos está llena ");
            return;
        }

        String nombreEquipo = JOptionPane.showInputDialog("ingrese el nombre del equipo");
        if (nombreEquipo == null) {
            JOptionPane.showMessageDialog(null, "el nombre del equipo no puede estar vacío");
            return;
        }

        // Crear el objeto con el paramettro nombre
        Equipos nuevoEquipo = new Equipos(nombreEquipo);
        
        // Agregar el equipo al arreglo
        DatosGenerales.equipos[DatosGenerales.cantidadEquipos] = nuevoEquipo; 
        // Incrementar la cantidad de equipos
        DatosGenerales.cantidadEquipos++; 

        JOptionPane.showMessageDialog(null, "Equipo agregado exitosamente:\n"
                + "ID: " + nuevoEquipo.getIdEquipo() + "\n"
                + "Nombre: " + nuevoEquipo.getNombreEquipo());
    }

    
    
        
    
    
    
  
     public static void agregarJugadorEquipo() {
    // Solicitar el ID del equipo al que se desea agregar un jugador
    String equipoID = JOptionPane.showInputDialog("Ingrese el ID del equipo al que desea agregar un jugador:");
    
    if (equipoID == null) {
        JOptionPane.showMessageDialog(null, "ID inválido.");
        return;
    }
    
   // Convertir el ID ingresado a entero
    int idEquipo = Integer.parseInt(equipoID); 

    // Buscar el equipo por su ID
    Equipos equipoSeleccionado = null;
    for (int i = 0; i < DatosGenerales.equipos.length; i++) {
        if (DatosGenerales.equipos[i] != null && DatosGenerales.equipos[i].getIdEquipo() == idEquipo) {
            // Asignar el equipo encontrado
            equipoSeleccionado = DatosGenerales.equipos[i]; 
            break;
        }
    }

    // Validar si el equipo fue encontrado
    if (equipoSeleccionado == null) {
        JOptionPane.showMessageDialog(null, "no se encontró un equipo con el ID proporcionado.");
        return;
    }

    
    
    
    
    
    // Verificar si el equipo tiene espacio (máximo 7 jugadores)
    if (equipoSeleccionado.getCantidadJugadores() >= 7) {
        JOptionPane.showMessageDialog(null, "el equipo ya tiene el máximo de 7 jugadores.");
        return;
    }

    // Construir la lista de jugadores sin equipo
    String listaJugadoresLibres = "Seleccione un jugador sin equipo:\n";
    int[] indicesLibres = new int[Jugadores.getJugadores().length];
    int contadorLibres = 0;

    for (int i = 0; i < Jugadores.getCantidadJugadores(); i++) {
        
        Jugadores jugador = Jugadores.getJugadores()[i];
        if (jugador != null && jugador.getEquipo() == null) { // Verificar jugadores realmente libres
            listaJugadoresLibres += contadorLibres + " - " + jugador.getNombre() + " (ID: " + jugador.getID() + ")\n";
            indicesLibres[contadorLibres++] = i; // Guardar índice del jugador libre
        }
    }

    // Validar si hay jugadores libres disponibles
    if (contadorLibres == 0) {
        JOptionPane.showMessageDialog(null, "No hay jugadores sin equipo disponibles.");
        return;
    }

    // Mostrar la lista de jugadores libres y solicitar la selección
    String seleccion = JOptionPane.showInputDialog(listaJugadoresLibres);
    if (seleccion == null ) { // Validar selección vacía
        JOptionPane.showMessageDialog(null, "Selección inválida.");
        return;
    }

    int indiceJugador = indicesLibres[Integer.parseInt(seleccion)]; // Obtener índice del jugador seleccionado
    Jugadores jugadorSeleccionado = Jugadores.getJugadores()[indiceJugador];

    // Determinar el estado del jugador en el equipo (Titular o Suplente)
    Estado estadoJugador;
    // Si hay menos de 5 jugadores, es Titular
    if (equipoSeleccionado.getCantidadJugadores() < 5) { 
        estadoJugador = Estado.Titular;
        // Si ya hay 5 jugadores, es Suplente
    } else { 
        estadoJugador = Estado.Suplente;
    }

    // Asignar al jugador al equipo
    jugadorSeleccionado.setEquipo(equipoSeleccionado); // Actualizar referencia al equipo
    jugadorSeleccionado.setEstado(estadoJugador); // Actualizar el estado del jugador
    equipoSeleccionado.agregarJugador(jugadorSeleccionado); // Agregar el jugador al equipo

    // Mostrar confirmación
    JOptionPane.showMessageDialog(null, "Jugador agregado exitosamente:\n"
            + "Nombre: " + jugadorSeleccionado.getNombre() + "\n"
            + "Posición: " + jugadorSeleccionado.getPosicion() + "\n"
            + "Estado: " + jugadorSeleccionado.getEstado());
}
     
     
     

 
    public static void eliminarJugadorDeEquipo() {

        String eliminarID = JOptionPane.showInputDialog("Ingrese el ID del equipo del que desea eliminar un jugador:");
        if (eliminarID == null) {
            JOptionPane.showMessageDialog(null, "ID inválido.");
            return;
        }

        int idEquipo = Integer.parseInt(eliminarID);
        Equipos equipoSeleccionado = null;

        // Buscar el equipo por ID
        for (int i = 0; i < DatosGenerales.equipos.length; i++) {
            if (DatosGenerales.equipos[i] != null && DatosGenerales.equipos[i].getIdEquipo() == idEquipo) {
                equipoSeleccionado = DatosGenerales.equipos[i];
                break;
            }
        }

        if (equipoSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "No se encontró un equipo con el ID proporcionado.");
            return;
        }

        if (equipoSeleccionado.getCantidadJugadores() == 0) {
            JOptionPane.showMessageDialog(null, "El equipo no tiene jugadores para eliminar.");
            return;
        }
        String listaJugadores = "Seleccione un jugador para eliminar:\n";
        Jugadores[] jugadoresEquipo = equipoSeleccionado.getJugadores();
        int[] indices = new int[equipoSeleccionado.getCantidadJugadores()];

        for (int i = 0; i < equipoSeleccionado.getCantidadJugadores(); i++) {
            Jugadores jugador = jugadoresEquipo[i];
            listaJugadores += i + " - " + jugador.getNombre() + " (ID: " + jugador.getID() + ")\n";
            indices[i] = i;
        }

        String seleccion = JOptionPane.showInputDialog(listaJugadores);
        if (seleccion == null ) {
            JOptionPane.showMessageDialog(null, "Selección inválida.");
            return;
        }

        int indiceSeleccionado = Integer.parseInt(seleccion);
        if (indiceSeleccionado < 0 || indiceSeleccionado >= equipoSeleccionado.getCantidadJugadores()) {
            JOptionPane.showMessageDialog(null, "Selección fuera de rango.");
            return;
        }

       
        Jugadores jugadorEliminado = jugadoresEquipo[indiceSeleccionado];
        jugadorEliminado.setEquipo(null);
        jugadorEliminado.setEstado(Estado.Libre);
        jugadorEliminado.setGolesAnotados(0);
        jugadorEliminado.setAccionesTotales(0);
        equipoSeleccionado.eliminarJugador(jugadorEliminado.getID());

        JOptionPane.showMessageDialog(null, "Jugador eliminado exitosamente:\n"
                + "Nombre: " + jugadorEliminado.getNombre() + "\n"
                + "ID: " + jugadorEliminado.getID() + "\n"
                + "Ahora es un jugador libre.");
    }

   

    
    
    
    
    
    
    
    
    
}
