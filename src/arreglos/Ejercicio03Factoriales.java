package arreglos;

import util.Ejercicio;
import util.GeneradorDatos;
import util.ImpresorConsola;
import util.LectorConsola;

/**
 * Ejercicio 3: se leen n numeros aleatorios y se calcula la factorial
 * de cada uno, guardando el resultado en un segundo arreglo.
 */
public class Ejercicio03Factoriales implements Ejercicio {

    private static final int MIN = 0;
    private static final int MAX = 15;

    @Override
    public String getTitulo() {
        return "Ejercicio 3: Factoriales de n numeros aleatorios";
    }

    @Override
    public void ejecutar() {
        int n = LectorConsola.leerEntero("¿Cuantos numeros deseas generar? ");

        int[] numeros = generarDatos(n);
        long[] factoriales = calcularFactoriales(numeros);
        imprimirResultados(numeros, factoriales);
    }

    private int[] generarDatos(int n) {
        return GeneradorDatos.generarEnteros(n, MIN, MAX);
    }

    /** Calcula la factorial de cada numero del arreglo recibido. */
    private long[] calcularFactoriales(int[] numeros) {
        long[] factoriales = new long[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            factoriales[i] = factorial(numeros[i]);
        }
        return factoriales;
    }

    /** Calcula n! de forma iterativa. */
    private long factorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    private void imprimirResultados(int[] numeros, long[] factoriales) {
        ImpresorConsola.imprimirArreglo("Numeros generados", numeros);
        ImpresorConsola.imprimirArreglo("Factoriales", factoriales);
    }
}
