package matrices;

import util.Ejercicio;
import util.GeneradorDatos;
import util.ImpresorConsola;
import util.LectorConsola;

/**
 * Ejercicio 12: genera una matriz cuadrada de n x n con numeros entre
 * -50 y 50, y calcula la suma de la diagonal secundaria (opuesta a
 * la principal).
 */
public class Ejercicio12DiagonalSecundaria implements Ejercicio {

    private static final int MIN = -50;
    private static final int MAX = 50;

    @Override
    public String getTitulo() {
        return "Ejercicio 12: Suma de la diagonal secundaria";
    }

    @Override
    public void ejecutar() {
        int n = LectorConsola.leerEntero("Tamaño de la matriz (n x n): ");

        int[][] matriz = generarDatos(n);
        ImpresorConsola.imprimirMatriz("Matriz generada", matriz);

        int suma = calcularSumaDiagonalSecundaria(matriz);
        System.out.println("Suma de la diagonal secundaria: " + suma);
    }

    private int[][] generarDatos(int n) {
        return GeneradorDatos.generarMatriz(n, n, MIN, MAX);
    }

    /**
     * La diagonal secundaria va de la esquina superior derecha a la
     * inferior izquierda: en la fila i, la columna correspondiente
     * es (n - 1 - i).
     */
    private int calcularSumaDiagonalSecundaria(int[][] matriz) {
        int n = matriz.length;
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += matriz[i][n - 1 - i];
        }
        return suma;
    }
}
