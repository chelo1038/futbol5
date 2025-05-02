package com.mycompany.proyectofinalfutbol5;
import java.util.Random;
public class Equipos {
    

    
    private static Equipos[] equipos = new Equipos[10];
    private static int contadorEquipos = 100;

    private int idEquipo;
    private String nombreEquipo;
    private Jugadores[] jugadores = new Jugadores[7];
    private int cantidadJugadores = 0;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;
    private int golesFavor;

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getPosecionBalon() {
        return posecionBalon;
    }

    public void setPosecionBalon(int posecionBalon) {
        this.posecionBalon = posecionBalon;
    }

    public int getCambiosRealisados() {
        return cambiosRealisados;
    }

    public void setCambiosRealisados(int cambiosRealisados) {
        this.cambiosRealisados = cambiosRealisados;
    }
    
    private int golesContra;
    private int posecionBalon;
    private int cambiosRealisados = 0;
    
    
    

    public Equipos(String nombreEquipo) {
        this.idEquipo = contadorEquipos++;
        this.nombreEquipo = nombreEquipo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public Jugadores[] getJugadores() {
        return jugadores;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }
    
    
   // para generar un titular random 
    
    
    public Jugadores getTitularAleatorio() {
    Random random = new Random();
    while (true) {
        //crear el random con el parametro de cantidad jugadores 
        int indice = random.nextInt(cantidadJugadores); 
        Jugadores jugador = jugadores[indice];
        if (jugador != null && jugador.getEstado() == Estado.Titular) {
            return jugador; 
        }
    }
}
    public Jugadores getSuplenteAleatorio() {
    Random random = new Random();
    while (true) {
        int indice = random.nextInt(cantidadJugadores); 
        Jugadores jugador = jugadores[indice];
        if (jugador != null && jugador.getEstado() == Estado.Suplente) {
            return jugador; 
        }
    }
}



    public void agregarJugador(Jugadores jugador) {
        if (cantidadJugadores < jugadores.length) {
            jugadores[cantidadJugadores++] = jugador;
        }
    }

    public boolean eliminarJugador(int idJugador) {
        for (int i = 0; i < cantidadJugadores; i++) {
            if (jugadores[i].getID() == idJugador) {
                // Desplazar jugadores
                for (int j = i; j < cantidadJugadores - 1; j++) {
                    jugadores[j] = jugadores[j + 1];
                }
                jugadores[--cantidadJugadores] = null;
                return true;
            }
        }
        return false;
    }


    public static void mostrarJugadores() {
        String listaEquipos = "Jugadores asignados a equipos:\n";

        for (Equipos equipo : equipos) {
            if (equipo != null) {
                listaEquipos += "Equipo: " + equipo.getNombreEquipo() + " (ID: " + equipo.getIdEquipo() + ")\n";
                for (int i = 0; i < equipo.getCantidadJugadores(); i++) {
                    Jugadores jugador = equipo.getJugadores()[i];
                    if (jugador != null) {
                        listaEquipos += "  - ID: " + jugador.getID()
                                + " | Nombre: " + jugador.getNombre()
                                + " | Posición: " + jugador.getPosicion()
                                + " | Estado: " + jugador.getEstado() + "\n";
                    }
                }
            }
        }

        System.out.println(listaEquipos);
    }

    public static int getCantidadEquipos() {
        int cantidad = 0;
        for (Equipos equipo : equipos) {
            if (equipo != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public static Equipos getEquipo(int index) {
        if (index >= 0 && index < equipos.length) {
            return equipos[index];
        }
        return null;
    }

    public static Equipos buscarEquipoPorId(int id) {
        for (Equipos equipo : equipos) {
            if (equipo != null && equipo.getIdEquipo() == id) {
                return equipo;
            }
        }
        return null;
    }
}
