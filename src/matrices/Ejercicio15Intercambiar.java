package matrices;

import util.Ejercicio;
import util.GeneradorDatos;
import util.ImpresorConsola;
import util.LectorConsola;

/**
 * Ejercicio 15: genera una matriz de m x n (leidos por teclado) con
 * numeros aleatorios e intercambia la primera fila con la segunda.
 */
public class Ejercicio15Intercambiar implements Ejercicio {

    private static final int MIN = 1;
    private static final int MAX = 100;

    @Override
    public String getTitulo() {
        return "Ejercicio 15: Intercambiar primera y segunda fila";
    }

    @Override
    public void ejecutar() {
        int filas = LectorConsola.leerEntero("Numero de filas (minimo 2): ");
        int columnas = LectorConsola.leerEntero("Numero de columnas: ");

        if (filas < 2) {
            System.out.println("Se necesitan al menos 2 filas para intercambiar.");
            return;
        }

        int[][] matriz = generarDatos(filas, columnas);
        ImpresorConsola.imprimirMatriz("Matriz original", matriz);

        intercambiarPrimeraYSegundaFila(matriz);
        ImpresorConsola.imprimirMatriz("Matriz con filas intercambiadas", matriz);
    }

    private int[][] generarDatos(int filas, int columnas) {
        return GeneradorDatos.generarMatriz(filas, columnas, MIN, MAX);
    }

    private void intercambiarPrimeraYSegundaFila(int[][] matriz) {
        int[] filaTemporal = matriz[0];
        matriz[0] = matriz[1];
        matriz[1] = filaTemporal;
    }
}