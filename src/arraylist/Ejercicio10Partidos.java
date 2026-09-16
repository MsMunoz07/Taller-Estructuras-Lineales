package arraylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import util.Ejercicio;

/**
 * Ejercicio 10: lee partidos de futbol desde un archivo de texto y
 * agrega funcionalidades sobre el ArrayList resultante.
 */
public class Ejercicio10Partidos implements Ejercicio {

    private static final String RUTA_ARCHIVO = "data/PartidoLiga.txt";
    private static final String SEPARADOR = "::";

    @Override
    public String getTitulo() {
        return "Ejercicio 10: Partidos de futbol";
    }

    @Override
    public void ejecutar() {
        List<Partido> partidos = leerPartidos();

        if (partidos.isEmpty()) {
            System.out.println("No se pudieron leer partidos. Revisa la ruta del archivo.");
            return;
        }

        System.out.println("Total de partidos leidos: " + partidos.size());

        mostrarGanadosPorVisitante(partidos);
        contarVictoriasDe(partidos, "Barcelona");
        contarVictoriasLocal(partidos);
        eliminarNoEmpatesYMostrar(partidos);
    }

    /** Lee el archivo linea por linea y arma la lista de partidos. */
    private List<Partido> leerPartidos() {
        List<Partido> partidos = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.isBlank()) {
                    continue;
                }
                String[] partes = linea.split(SEPARADOR);
                String local = partes[0];
                String visitante = partes[1];
                int golesLocal = Integer.parseInt(partes[2]);
                int golesVisitante = Integer.parseInt(partes[3]);

                partidos.add(new Partido(local, visitante, golesLocal, golesVisitante));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return partidos;
    }

    /** Muestra los partidos donde el equipo visitante fue el ganador. */
    private void mostrarGanadosPorVisitante(List<Partido> partidos) {
        System.out.println("\n--- Partidos ganados por el visitante ---");
        for (Partido partido : partidos) {
            if (partido.ganoVisitante()) {
                System.out.println(partido);
            }
        }
    }

    /** Cuenta cuantas veces gano un equipo, sin importar si jugo de local o visitante. */
    private void contarVictoriasDe(List<Partido> partidos, String equipo) {
        int victorias = 0;
        for (Partido partido : partidos) {
            if (equipo.equals(partido.getGanador())) {
                victorias++;
            }
        }
        System.out.println("\n" + equipo + " gano " + victorias + " partidos.");
    }

    /** Cuenta cuantos partidos gano el equipo local. */
    private void contarVictoriasLocal(List<Partido> partidos) {
        int victoriasLocal = 0;
        for (Partido partido : partidos) {
            if (partido.ganoLocal()) {
                victoriasLocal++;
            }
        }
        System.out.println("\nPartidos ganados por el equipo local: " + victoriasLocal);
    }

    /** Elimina del ArrayList los partidos cuyo resultado no fue empate, y muestra lo que queda. */
    private void eliminarNoEmpatesYMostrar(List<Partido> partidos) {
        partidos.removeIf(partido -> !partido.esEmpate());

        System.out.println("\n--- Partidos que terminaron en empate ---");
        for (Partido partido : partidos) {
            System.out.println(partido);
        }
    }

    /**
     * Clase interna que representa un partido de futbol.
     * Vive aqui mismo, dentro de Ejercicio10Partidos, para mantener
     * todo en un solo archivo.
     */
    private static class Partido {

        private final String equipoLocal;
        private final String equipoVisitante;
        private final int golesLocal;
        private final int golesVisitante;

        Partido(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante) {
            this.equipoLocal = equipoLocal;
            this.equipoVisitante = equipoVisitante;
            this.golesLocal = golesLocal;
            this.golesVisitante = golesVisitante;
        }

        boolean esEmpate() {
            return golesLocal == golesVisitante;
        }

        boolean ganoLocal() {
            return golesLocal > golesVisitante;
        }

        boolean ganoVisitante() {
            return golesVisitante > golesLocal;
        }

        String getGanador() {
            if (ganoLocal()) {
                return equipoLocal;
            }
            if (ganoVisitante()) {
                return equipoVisitante;
            }
            return null;
        }

        @Override
        public String toString() {
            return equipoLocal + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante;
        }
    }
}