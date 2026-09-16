package matrices;

import util.Ejercicio;
import util.ImpresorConsola;

/**
 * Ejercicio 14: matriz de m x n con valores predeterminados (fijos),
 * de la cual se calcula la transpuesta.
 */
public class Ejercicio14Transpuesta implements Ejercicio {

    @Override
    public String getTitulo() {
        return "Ejercicio 14: Transpuesta de una matriz";
    }

    @Override
    public void ejecutar() {
        int[][] matriz = generarDatos();
        ImpresorConsola.imprimirMatriz("Matriz original", matriz);

        int[][] transpuesta = calcularTranspuesta(matriz);
        ImpresorConsola.imprimirMatriz("Matriz transpuesta", transpuesta);
    }

    /** Matriz de 3 filas x 4 columnas con valores fijos, como pide el enunciado. */
    private int[][] generarDatos() {
        return new int[][] {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
    }

    /**
     * La transpuesta de una matriz m x n es una matriz n x m donde
     * las filas pasan a ser columnas: transpuesta[j][i] = original[i][j].
     */
    private int[][] calcularTranspuesta(int[][] original) {
        int filas = original.length;
        int columnas = original[0].length;

        int[][] transpuesta = new int[columnas][filas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = original[i][j];
            }
        }
        return transpuesta;
    }
}

