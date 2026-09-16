package util;

import java.util.Random;

/**
 * Métodos reutilizables para generar datos aleatorios.
 * Evita repetir la misma lógica en cada ejercicio.
 */
public class GeneradorDatos {

    private static final Random RANDOM = new Random();

    /** Genera un arreglo de enteros aleatorios entre min y max (inclusive). */
    public static int[] generarEnteros(int cantidad, int min, int max) {
        int[] datos = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            datos[i] = min + RANDOM.nextInt(max - min + 1);
        }
        return datos;
    }

    /** Genera una matriz de enteros aleatorios entre min y max (inclusive). */
    public static int[][] generarMatriz(int filas, int columnas, int min, int max) {
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = min + RANDOM.nextInt(max - min + 1);
            }
        }
        return matriz;
    }

    /** Un solo entero aleatorio entre min y max (inclusive). */
    public static int generarEntero(int min, int max) {
        return min + RANDOM.nextInt(max - min + 1);
    }
}
