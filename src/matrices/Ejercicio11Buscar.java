package matrices;

import util.Ejercicio;
import util.GeneradorDatos;
import util.ImpresorConsola;
import util.LectorConsola;

/**
 * Ejercicio 11: genera una matriz de m x n con numeros aleatorios y
 * busca la primera posicion en la que aparece un numero dado.
 */
public class Ejercicio11Buscar implements Ejercicio {

    private static final int MIN = 1;
    private static final int MAX = 100;

    @Override
    public String getTitulo() {
        return "Ejercicio 11: Buscar un numero en una matriz";
    }

    @Override
    public void ejecutar() {
        int filas = LectorConsola.leerEntero("Numero de filas: ");
        int columnas = LectorConsola.leerEntero("Numero de columnas: ");

        int[][] matriz = generarDatos(filas, columnas);
        ImpresorConsola.imprimirMatriz("Matriz generada", matriz);

        int numeroBuscado = LectorConsola.leerEntero("Numero a buscar: ");
        buscarYMostrar(matriz, numeroBuscado);
    }

    private int[][] generarDatos(int filas, int columnas) {
        return GeneradorDatos.generarMatriz(filas, columnas, MIN, MAX);
    }

    /** Busca la primera aparicion del numero, recorriendo fila por fila. */
    private void buscarYMostrar(int[][] matriz, int numero) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == numero) {
                    System.out.println("Encontrado en la fila " + i + ", columna " + j);
                    return;
                }
            }
        }
        System.out.println("El numero " + numero + " no se encuentra en la matriz.");
    }
}