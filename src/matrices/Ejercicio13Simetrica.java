package matrices;

import util.Ejercicio;
import util.GeneradorDatos;
import util.ImpresorConsola;
import util.LectorConsola;

/**
 * Ejercicio 13: genera una matriz cuadrada de n x n, determina si es
 * simetrica e imprime los valores de las cuatro esquinas.
 */
public class Ejercicio13Simetrica implements Ejercicio {

    private static final int MIN = -20;
    private static final int MAX = 20;

    @Override
    public String getTitulo() {
        return "Ejercicio 13: Matriz simetrica y esquinas";
    }

    @Override
    public void ejecutar() {
        int n = LectorConsola.leerEntero("Tamaño de la matriz (n x n): ");

        int[][] matriz = generarDatos(n);
        ImpresorConsola.imprimirMatriz("Matriz generada", matriz);

        boolean simetrica = esSimetrica(matriz);
        System.out.println("¿Es simetrica? " + (simetrica ? "Si" : "No"));

        imprimirEsquinas(matriz);
    }

    private int[][] generarDatos(int n) {
        return GeneradorDatos.generarMatriz(n, n, MIN, MAX);
    }

    /** Una matriz es simetrica si matriz[i][j] siempre es igual a matriz[j][i]. */
    private boolean esSimetrica(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] != matriz[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void imprimirEsquinas(int[][] matriz) {
        int n = matriz.length;
        System.out.println("Esquina superior izquierda: " + matriz[0][0]);
        System.out.println("Esquina superior derecha: " + matriz[0][n - 1]);
        System.out.println("Esquina inferior izquierda: " + matriz[n - 1][0]);
        System.out.println("Esquina inferior derecha: " + matriz[n - 1][n - 1]);
    }
}