package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;

public class Jugadores {

    private static Jugadores[] jugadores = new Jugadores[70];
    private static Equipos[] equipos = new Equipos[10];
    private static int contadorID = 10;
    private static int cantidadJugadores = 0;

    private int ID;
    private String nombre;
    private Posicion posicion;
    private Equipos equipo;
    private Estado estado;
    private int golesAnotados;
    private int accionesTotales;

    public Jugadores(String nombre, Posicion posicion, Equipos equipo, Estado estado, int golesAnotados, int accionesTotales) {
        this.ID = contadorID++;
        this.nombre = nombre;
        this.posicion = posicion;
        this.equipo = equipo;
        this.estado = estado;
        this.golesAnotados = golesAnotados;
        this.accionesTotales = accionesTotales;
    }

    public static Jugadores[] getJugadores() {
        return jugadores;
    }

    public static void setJugadores(Jugadores[] jugadores) {
        Jugadores.jugadores = jugadores;
    }

    public static Equipos[] getEquipos() {
        return equipos;
    }

    public static void setEquipos(Equipos[] equipos) {
        Jugadores.equipos = equipos;
    }

    public static int getContadorID() {
        return contadorID;
    }

    public static void setContadorID(int contadorID) {
        Jugadores.contadorID = contadorID;
    }

    public static int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public static void setCantidadJugadores(int cantidadJugadores) {
        Jugadores.cantidadJugadores = cantidadJugadores;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public int getAccionesTotales() {
        return accionesTotales;
    }

    public void setAccionesTotales(int accionesTotales) {
        this.accionesTotales = accionesTotales;
    }

    
    
    public static void inicializarJugadoresYAsignarEquipos() {
    Equipos equipo1 = new Equipos("Liga Deportiva");
    Equipos equipo2 = new Equipos("Saprissa");
    Equipos equipo3 = new Equipos("Heredia");

    DatosGenerales.equipos[0] = equipo1;
    DatosGenerales.equipos[1] = equipo2;
    DatosGenerales.equipos[2] = equipo3;
    DatosGenerales.cantidadEquipos = 3;

    // Jugadores Liga Deportiva
    jugadores[0] = new Jugadores("Gabriel Rojas", Posicion.Delantero, equipo1, Estado.Titular, 0, 0);
    equipo1.agregarJugador(jugadores[0]);

    jugadores[1] = new Jugadores("Josué Mora", Posicion.MedioCampista, equipo1, Estado.Titular, 0, 0);
    equipo1.agregarJugador(jugadores[1]);

    jugadores[2] = new Jugadores("Carlos Jiménez", Posicion.Defensa, equipo1, Estado.Titular, 0, 0);
    equipo1.agregarJugador(jugadores[2]);

    jugadores[3] = new Jugadores("Luis Pérez", Posicion.Defensa, equipo1, Estado.Titular, 0, 0);
    equipo1.agregarJugador(jugadores[3]);

    jugadores[4] = new Jugadores("Manuel Gómez", Posicion.Portero, equipo1, Estado.Titular, 0, 0);
    equipo1.agregarJugador(jugadores[4]);

    jugadores[5] = new Jugadores("David Ramírez", Posicion.Delantero, equipo1, Estado.Suplente, 0, 0);
    equipo1.agregarJugador(jugadores[5]);

    jugadores[6] = new Jugadores("Andrés Solís", Posicion.MedioCampista, equipo1, Estado.Suplente, 0, 0);
    equipo1.agregarJugador(jugadores[6]);

    // Jugadores Saprissa
    jugadores[7] = new Jugadores("Fernando Castro", Posicion.Delantero, equipo2, Estado.Titular, 0, 0);
    equipo2.agregarJugador(jugadores[7]);

    jugadores[8] = new Jugadores("Daniela Cruz", Posicion.MedioCampista, equipo2, Estado.Titular, 0, 0);
    equipo2.agregarJugador(jugadores[8]);

    jugadores[9] = new Jugadores("Sofía Hernández", Posicion.Defensa, equipo2, Estado.Titular, 0, 0);
    equipo2.agregarJugador(jugadores[9]);

    jugadores[10] = new Jugadores("Esteban Mora", Posicion.Defensa, equipo2, Estado.Titular, 0, 0);
    equipo2.agregarJugador(jugadores[10]);

    jugadores[11] = new Jugadores("Ricardo Blanco", Posicion.Portero, equipo2, Estado.Titular, 0, 0);
    equipo2.agregarJugador(jugadores[11]);

    jugadores[12] = new Jugadores("Marcelo Vega", Posicion.Delantero, equipo2, Estado.Suplente, 0, 0);
    equipo2.agregarJugador(jugadores[12]);

    jugadores[13] = new Jugadores("Andrea Rodríguez", Posicion.MedioCampista, equipo2, Estado.Suplente, 0, 0);
    equipo2.agregarJugador(jugadores[13]);

    // Jugadores Heredia
    jugadores[14] = new Jugadores("Diego Castro", Posicion.Delantero, equipo3, Estado.Titular, 0, 0);
    equipo3.agregarJugador(jugadores[14]);

    jugadores[15] = new Jugadores("María López", Posicion.MedioCampista, equipo3, Estado.Titular, 0, 0);
    equipo3.agregarJugador(jugadores[15]);

    jugadores[16] = new Jugadores("Juan Pablo Torres", Posicion.Defensa, equipo3, Estado.Titular, 0, 0);
    equipo3.agregarJugador(jugadores[16]);

    jugadores[17] = new Jugadores("Valeria Chacón", Posicion.Defensa, equipo3, Estado.Titular, 0, 0);
    equipo3.agregarJugador(jugadores[17]);

    jugadores[18] = new Jugadores("Alejandro Martínez", Posicion.Portero, equipo3, Estado.Titular, 0, 0);
    equipo3.agregarJugador(jugadores[18]);

    jugadores[19] = new Jugadores("Pablo Campos", Posicion.Delantero, equipo3, Estado.Suplente, 0, 0);
    equipo3.agregarJugador(jugadores[19]);

    jugadores[20] = new Jugadores("Lucía Fernández", Posicion.MedioCampista, equipo3, Estado.Suplente, 0, 0);
    equipo3.agregarJugador(jugadores[20]);

    // Jugadores sin equipo asignado
    jugadores[21] = new Jugadores("Lucas Vasques", Posicion.Delantero, null, Estado.Libre, 0, 0);
    jugadores[22] = new Jugadores("Cristiano Ronaldo", Posicion.MedioCampista, null, Estado.Libre, 0, 0);
    jugadores[23] = new Jugadores("Roberto Carlos", Posicion.MedioCampista, null, Estado.Libre, 0, 0);
    jugadores[24] = new Jugadores("Fabian Pérez", Posicion.MedioCampista, null, Estado.Libre, 0, 0);
    jugadores[25] = new Jugadores("Javier Pérez", Posicion.MedioCampista, null, Estado.Libre, 0, 0);
    jugadores[26] = new Jugadores("Lionel Messi", Posicion.MedioCampista, null, Estado.Libre, 0, 0);
    jugadores[27] = new Jugadores("Paul Pogba", Posicion.MedioCampista, null, Estado.Libre, 0, 0);
    jugadores[28] = new Jugadores("Pablo Alpizar", Posicion.MedioCampista, null, Estado.Libre, 0, 0);
    jugadores[29] = new Jugadores("Alonso Martínez", Posicion.Defensa, null, Estado.Libre, 0, 0);

    cantidadJugadores = 30;

    // Mostrar jugadores creados
    mostrarJugadores();
}



    public static Jugadores getJugadorPorID(int ID) {
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i] != null && jugadores[i].getID() == ID) {
                return jugadores[i];
            }
        }
        return null;
    }

    public static void agregarJugador(Jugadores jugador) {
        if (cantidadJugadores < jugadores.length) {
            jugadores[cantidadJugadores++] = jugador;
        } else {
            System.out.println("No se puede agregar más jugadores, el arreglo está lleno.");
        }
    }

    
    public static void agregarNuevoJugador() {
        //  Verificar si hay espacio para más jugadores
        if (cantidadJugadores >= jugadores.length) {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más jugadores, el arreglo está lleno.");
            return; 
        }

        //  Solicitar el nombre del jugador
        String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre completo del jugador:");
        if (nombreJugador == null) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            return; 
        }

        //  Seleccionar la posición del jugador usando JOptionPane con botones
        Posicion posicionJugador = seleccionarPosicion();
        if (posicionJugador == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una posición.");
            return;
        }

        //  Seleccionar el equipo usando un menú con los equipos disponibles
        Equipos equipoSeleccionado = seleccionarEquipo();

        //  Asignar el estado del jugador
        // null por defecto
        
        
        Estado estadoJugador; 
        if (equipoSeleccionado == null) {
            estadoJugador = Estado.Libre; // Si no selecciona equipo, el estado es Libre
        } else {
            // Verificar si el equipo tiene espacio para titulares o suplentes
            if (equipoSeleccionado.getCantidadJugadores() < 5) {
                estadoJugador = Estado.Titular;
            } else {
                estadoJugador = Estado.Suplente;
            }
        }

        
        //  Crear el objeto Jugadores y agregarlo al arreglo
        Jugadores nuevoJugador = new Jugadores(nombreJugador, posicionJugador, equipoSeleccionado, estadoJugador, 0, 0);
        jugadores[cantidadJugadores++] = nuevoJugador;
       // Incrementar la cantidad de jugadores

        //  mensaje de el jugador creado y los datos del jugador
            String mensaje = "Jugador agregado exitosamente:\n"
        + "ID: " + nuevoJugador.getID() + "\n"
        + "Nombre: " + nuevoJugador.getNombre() + "\n"
        + "Posición: " + nuevoJugador.getPosicion() + "\n";

     // Validar si equipoSeleccionado es null para asignar el nombre del equipo
      if (equipoSeleccionado != null) {
    mensaje += "Equipo: " + equipoSeleccionado.getNombreEquipo() + "\n";
    } else {
    mensaje += "Equipo: Ninguno\n";
     }

       mensaje += "Estado: " + nuevoJugador.getEstado() + "\n"
        + "Goles: " + nuevoJugador.getGolesAnotados();

// Mostrar el mensaje en un cuadro de diálogo
JOptionPane.showMessageDialog(null, mensaje);

    }

    private static Posicion seleccionarPosicion() {
        String[] opciones = {"Portero", "Defensa", "Mediocampista", "Delantero"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione la posición del jugador:",
                "Selección de Posición",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]);
        Posicion seleccionarPosicion = null;

        if (seleccion >= 0) {
            //recordar cambiar el values (no se puede usar)
            switch (seleccion) {
                case 0:
                    seleccionarPosicion = Posicion.Portero;
                    break;
                case 1:
                    seleccionarPosicion = Posicion.Defensa;
                    break;
                case 2:
                    seleccionarPosicion = Posicion.MedioCampista;
                    break;
                case 3:
                    seleccionarPosicion = Posicion.Delantero;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "debe seleccionar una posicion");
            }
        }
        // devuelve la posiscion seleccionada del switch
        return seleccionarPosicion;
    }

   
    
    
   private static Equipos seleccionarEquipo() {
    int cantidadEquipos = DatosGenerales.cantidadEquipos; 
    // Obtener cantidad total de equipos
    String[] opciones = new String[cantidadEquipos];  
   // Arreglo con nombres de equipos    
    Equipos[] equiposDisponibles = new Equipos[cantidadEquipos]; 
    // Arreglo con referencias a equipos
    int totalOpciones = 0;

    // Recorrer los equipos y filtrar los que tienen espacio disponible
    for (int i = 0; i < cantidadEquipos; i++) {
        Equipos equipo = DatosGenerales.equipos[i];
        if (equipo != null && equipo.getCantidadJugadores() < 7) {
            // guardarmos el nombre del equipo
            opciones[totalOpciones] = equipo.getNombreEquipo(); 
            // guardar referencia al equipo
            equiposDisponibles[totalOpciones] = equipo; 
            totalOpciones++;
        }
    }

    // Verificar si hay equipos disponibles
    if (totalOpciones == 0) {
        JOptionPane.showMessageDialog(null, "No hay equipos con espacio disponible.");
        return null;
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

    // Retornar el equipo seleccionado
    if (seleccion >= 0 && seleccion < totalOpciones) {
        return equiposDisponibles[seleccion]; // Devuelve la referencia del equipo seleccionado
    }

    // Si no selecciona nada
    JOptionPane.showMessageDialog(null, "No se seleccionó ningún equipo.");
    return null;
}

    
    
    
    
    
    
    
    
    
    
    
    
// debe mostrar los goles *************************************
    public static void mostrarJugadores() {
        String listaJugadores = "=== Lista de Jugadores ===\n";
        // Recorrer los jugadores que existen
        for (int i = 0; i < cantidadJugadores; i++) {
            Jugadores jugador = jugadores[i];
            // Asegurarse de que el jugador no sea nulo
            if (jugador != null) {

                //  ni me acuerdo por que lo comente pero seguro estaba malo 
                // String equipoNombre = (jugador.getEquipo() != null) && jugador.getEquipo().getNombreEquipo() : "Sin equipo";
                String equipoNombre;
                if (jugador.getEquipo() != null) {
                    equipoNombre = jugador.getEquipo().getNombreEquipo();
                } else {
                    equipoNombre = "sin equipo";
                }
                listaJugadores += "ID: " + jugador.getID() + "\n"
                        + "Nombre: " + jugador.getNombre() + "\n"
                        + "Posición: " + jugador.getPosicion() + "\n"
                        + "Equipo: " + equipoNombre + "\n"
                        + "Estado: " + jugador.getEstado() + "\n"
                        + "Goles: " + jugador.getGolesAnotados() + "\n"
                        + "-----------------------\n";
            }
        }

        if (cantidadJugadores == 0) {
            listaJugadores = "No hay jugadores registrados.";
        }

        System.out.println(listaJugadores);
    }

    public static void editarJugador() {
        String jugadorID = JOptionPane.showInputDialog("Ingrese el ID del jugador a editar:");
        if (jugadorID == null) {
            JOptionPane.showMessageDialog(null, "ID inválido.");
            return;
        }

        int idJugador = Integer.parseInt(jugadorID);
        Jugadores jugador = null;
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i] != null && jugadores[i].getID() == idJugador) {
                jugador = jugadores[i];
                break;
            }
        }

        if (jugador == null) {
            JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
            return;
        }

// *************falta acomodar el menu de botones para que sea similar a los que trabajamos**************
        String[] opciones = {"Editar Nombre", "Editar Posición", "Cancelar"};
        int seleccion = JOptionPane.showOptionDialog(null, "¿Qué desea editar?", "Editar Jugador",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        switch (seleccion) {
            case 0:
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del jugador:");
                if (nuevoNombre != null) {
                    // en teoria con el set se cambia el nombre correctamente
                    jugador.setNombre(nuevoNombre);

                    JOptionPane.showMessageDialog(null, "Nombre actualizado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
                }
                break;
            //deberia editar 
            case 1:
                Posicion nuevaPosicion = seleccionarPosicion();
                if (nuevaPosicion != null) {
                    jugador.setPosicion(nuevaPosicion);
                    JOptionPane.showMessageDialog(null, "Posición actualizada correctamente.");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Edición cancelada.");
        }
    }

    public static void eliminarJugador() {
        // Solicitar el ID del jugador
        String eliminarID = JOptionPane.showInputDialog("Ingrese el ID del jugador a eliminar ");
        if (eliminarID == null) {
            JOptionPane.showMessageDialog(null, "ID no válido ");
            return;
        }

        int idJugador = Integer.parseInt(eliminarID);
        boolean jugadorEliminado = false;

        // Buscar y eliminar al jugador
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i] != null && jugadores[i].getID() == idJugador) {
                // Verificar si el jugador tiene equipo
                if (jugadores[i].getEquipo() != null) {
                    JOptionPane.showMessageDialog(null, "No se puede eliminar el jugador porque está asignado a un equipo.");
                    return;
                }

                // Eliminar el jugador moviendo los elementos 
                for (int j = i; j < cantidadJugadores - 1; j++) {
                    jugadores[j] = jugadores[j + 1];
                }
                jugadores[--cantidadJugadores] = null; // Reducir cantidad y limpiar la última posición
                jugadorEliminado = true;
                break;
            }
        }

        // Confirmar resultado
        if (jugadorEliminado) {
            JOptionPane.showMessageDialog(null, "Jugador eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
        }
    }

}
