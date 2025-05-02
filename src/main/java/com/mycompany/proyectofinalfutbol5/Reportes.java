package com.mycompany.proyectofinalfutbol5;

public class Reportes {

     public static void generarTablaEstadisticasEquipos(Equipos[] equipos) {
        // Crear la matriz para almacenar los datos de los equipos
        String[][] tabla = new String[equipos.length][10];

        // llenamos  la matriz con datos de los equipos
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] != null) {
                Equipos equipo = equipos[i];

                // Calcular diferencia de goles y puntos
                int diferenciaGoles = equipo.getGolesFavor() - equipo.getGolesContra();
                int puntos = (equipo.getPartidosGanados() * 3) + equipo.getPartidosEmpatados();

                // Asignar los valores a la matriz
                tabla[i][0] = "" + equipo.getIdEquipo(); // ID del equipo
                tabla[i][1] = "" + equipo.getNombreEquipo(); // Nombre del equipo
                tabla[i][2] = "" + equipo.getPartidosJugados(); // Partidos jugados
                tabla[i][3] = "" + equipo.getPartidosGanados(); // Partidos ganados
                tabla[i][4] = "" + equipo.getPartidosEmpatados(); // Partidos empatados
                tabla[i][5] = "" + equipo.getPartidosPerdidos(); // Partidos perdidos
                tabla[i][6] = "" + equipo.getGolesFavor(); // Goles a favor
                tabla[i][7] = "" + equipo.getGolesContra(); // Goles en contra
                tabla[i][8] = "" + diferenciaGoles; // Diferencia de goles
                tabla[i][9] = "" + puntos; // Puntos
            }
        }

        // Imprimir la tabla
        System.out.println("Tabla de Estadísticas de Equipos:");
        System.out.println("ID     Nombre          PJ      PG      PE     PP      GF      GC      DG    Puntos");
        System.out.println("----------------------------------------------------------------------------------------------");

        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i][0] != null) { // Verificar que la fila no esté vacía
                for (int j = 0; j < tabla[i].length; j++) {
                    // Imprimir cada valor de la fila con un formato básico
                    System.out.print(tabla[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
}
