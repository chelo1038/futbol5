package com.mycompany.proyectofinalfutbol5;

import javax.swing.JOptionPane;
import java.util.Random;

public class SimulacionPartidos {

    public static void simularPartido() {
        // Verificar si hay al menos dos equipos completos
        if (DatosGenerales.cantidadEquipos < 2) {
            JOptionPane.showMessageDialog(null, "No hay suficientes equipos completos para realizar la simulación.");
            return;
        }

        // Selección de equipos
        Equipos equipoA = seleccionarEquipo("Seleccione el primer equipo:");
        Equipos equipoB = seleccionarEquipo("Seleccione el segundo equipo:");
        if (equipoA == null || equipoB == null || equipoA.getIdEquipo() == equipoB.getIdEquipo()) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar dos equipos distintos.");
            return;
        }

        // Configuración de salida de mensajes
        String[] opciones = {"Consola", "JOptionPane"};
        int salidaSeleccionada = JOptionPane.showOptionDialog(
                null, 
                "Seleccione la salida de los mensajes:",
                "Configuración de Salida", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                opciones, 
                opciones[0]);
        
        boolean salidaConsola = (salidaSeleccionada == 0);

        // Variables para la simulación
        Random random = new Random();
        int golesEquipoA = 0, golesEquipoB = 0;
        int posesionEquipoA = 0, posesionEquipoB = 0; // Contadores de posesión
        String resumenPartido = "";

        // Simular 40 minutos del partido
        for (int minuto = 1; minuto <= 40; minuto++) {
            String mensaje = generarMensaje(random, equipoA, equipoB);

            // Actualizar goles si hay gol
            if (mensaje.length() >= 7 && mensaje.substring(0, 7).equals("¡Gol de")) {
                if (mensaje.contains(equipoA.getNombreEquipo())) {
                    golesEquipoA++;
                    equipoA.setGolesFavor(equipoA.getGolesFavor() + 1);
                    equipoB.setGolesContra(equipoB.getGolesContra() + 1);
                } else if (mensaje.contains(equipoB.getNombreEquipo())) {
                    golesEquipoB++;
                    equipoB.setGolesFavor(equipoB.getGolesFavor() + 1);
                    equipoA.setGolesContra(equipoA.getGolesContra() + 1);
                }
            }

            // Actualizar posesión
            if (mensaje.contains("controla el balón")) {
                if (mensaje.contains(equipoA.getNombreEquipo())) {
                    posesionEquipoA++;
                } else if (mensaje.contains(equipoB.getNombreEquipo())) {
                    posesionEquipoB++;
                }
            }

            // Imprimir en consola
            if (salidaConsola) {
                System.out.println("Minuto " + minuto + ": " + mensaje);
            }

            // Acumular el resumen
            resumenPartido += "Minuto " + minuto + ": " + mensaje + "\n";
        }

        // Calcular posesión en porcentaje
        equipoA.setPosecionBalon((posesionEquipoA * 100) / 40);
        equipoB.setPosecionBalon((posesionEquipoB * 100) / 40);

        // Actualizar estadísticas de partidos jugados y resultados
        equipoA.setPartidosJugados(equipoA.getPartidosJugados() + 1);
        equipoB.setPartidosJugados(equipoB.getPartidosJugados() + 1);

        if (golesEquipoA > golesEquipoB) {
            equipoA.setPartidosGanados(equipoA.getPartidosGanados() + 1);
            equipoB.setPartidosPerdidos(equipoB.getPartidosPerdidos() + 1);
        } else if (golesEquipoA < golesEquipoB) {
            equipoB.setPartidosGanados(equipoB.getPartidosGanados() + 1);
            equipoA.setPartidosPerdidos(equipoA.getPartidosPerdidos() + 1);
        } else {
            equipoA.setPartidosEmpatados(equipoA.getPartidosEmpatados() + 1);
            equipoB.setPartidosEmpatados(equipoB.getPartidosEmpatados() + 1);
        }

        // Mostrar el resultado final
        mostrarResultado(equipoA, equipoB, golesEquipoA, golesEquipoB, resumenPartido, salidaConsola);
    }

    private static Equipos seleccionarEquipo(String mensaje) {
        String listaEquipos = mensaje + "\n";
        for (int i = 0; i < DatosGenerales.cantidadEquipos; i++) {
            if (DatosGenerales.equipos[i] != null && DatosGenerales.equipos[i].getCantidadJugadores() == 7) {
                listaEquipos += DatosGenerales.equipos[i].getIdEquipo() + " - " + DatosGenerales.equipos[i].getNombreEquipo() + "\n";
            }
        }

        String seleccion = JOptionPane.showInputDialog(listaEquipos);
        if (seleccion == null) {
            return null;
        }

        int idEquipo = Integer.parseInt(seleccion);
        for (int i = 0; i < DatosGenerales.cantidadEquipos; i++) {
            if (DatosGenerales.equipos[i].getIdEquipo() == idEquipo) {
                return DatosGenerales.equipos[i];
            }
        }
        return null;
    }

    private static String generarMensaje(Random random, Equipos equipoA, Equipos equipoB) {
        int probabilidad = random.nextInt(100);

        if (probabilidad < 70) { // Mensajes de tránsito
            return generarMensajeTransito(random, equipoA, equipoB);
            // Mensajes de cambio
        } else if (probabilidad < 85) { 
            return generarMensajeCambio(random, equipoA, equipoB);
        } else { // Mensajes de acciones clave
            return generarMensajeAccionClave(random, equipoA, equipoB);
        }
    }

    private static String generarMensajeTransito(Random random, Equipos equipoA, Equipos equipoB) {
        int indiceEquipo = random.nextInt(2);
        Equipos equipo;
        if (indiceEquipo == 0) {
            equipo = equipoA;
        } else {
            equipo = equipoB;
        }

        Jugadores jugador = equipo.getTitularAleatorio();
        return jugador.getNombre() + " del equipo " + equipo.getNombreEquipo() + " controla el balón.";
    }

    private static String generarMensajeCambio(Random random, Equipos equipoA, Equipos equipoB) {
        int indiceEquipo = random.nextInt(2);
        Equipos equipo;
        if (indiceEquipo == 0) {
            equipo = equipoA;
        } else {
            equipo = equipoB;
        }

        Jugadores titular = equipo.getTitularAleatorio();
        Jugadores suplente = equipo.getSuplenteAleatorio();
        equipo.setCambiosRealisados(equipo.getCambiosRealisados() + 1);
        return "Cambio en " + equipo.getNombreEquipo() + ": " + titular.getNombre() + " sale, entra " + suplente.getNombre() + ".";
    }

    private static String generarMensajeAccionClave(Random random, Equipos equipoA, Equipos equipoB) {
        int indiceEquipo = random.nextInt(2);
        Equipos equipo;
        if (indiceEquipo == 0) {
            equipo = equipoA;
        } else {
            equipo = equipoB;
        }

        Jugadores jugador = equipo.getTitularAleatorio();
        return "¡Gol de " + jugador.getNombre() + " del equipo " + equipo.getNombreEquipo() + "!";
    }

    private static void mostrarResultado(Equipos equipoA, Equipos equipoB, int golesA, int golesB, String resumen, boolean consola) {
        String resultado = "Resultado Final:\n" +
                equipoA.getNombreEquipo() + ": " + golesA + " goles\n" +
                equipoB.getNombreEquipo() + ": " + golesB + " goles\n" +
                "Posesión del balón: \n" +
                equipoA.getNombreEquipo() + ": " + equipoA.getPosecionBalon() + "%\n" +
                equipoB.getNombreEquipo() + ": " + equipoB.getPosecionBalon() + "%\n" +
                "Resumen del partido:\n" + resumen;

        if (consola) {
            System.out.println(resultado);
        } else {
          
        }
    }
}


