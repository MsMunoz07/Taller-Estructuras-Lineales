package arraylist;

import java.util.ArrayList;
import java.util.List;
import util.Ejercicio;
import util.GeneradorDatos;

/**
 * Ejercicio 8: genera 100 numeros aleatorios entre 1 y 20, calcula
 * cuantas veces aparece cada uno y encuentra el mas frecuente.
 */
public class Ejercicio08Frecuencia implements Ejercicio {

    private static final int CANTIDAD = 100;
    private static final int MIN = 1;
    private static final int MAX = 20;

    @Override
    public String getTitulo() {
        return "Ejercicio 8: Frecuencia de numeros en ArrayList";
    }

    @Override
    public void ejecutar() {
        List<Integer> numeros = generarDatos();
        int[] frecuencias = calcularFrecuencias(numeros);
        imprimirTabla(frecuencias);
        imprimirMasFrecuente(frecuencias);
    }

    private List<Integer> generarDatos() {
        List<Integer> numeros = new ArrayList<>();
        for (int valor : GeneradorDatos.generarEnteros(CANTIDAD, MIN, MAX)) {
            numeros.add(valor);
        }
        return numeros;
    }

    /**
     * Cuenta cuantas veces aparece cada numero entre MIN y MAX.
     * frecuencias[k] representa cuantas veces aparecio el numero k.
     */
    private int[] calcularFrecuencias(List<Integer> numeros) {
        int[] frecuencias = new int[MAX + 1];
        for (int numero : numeros) {
            frecuencias[numero]++;
        }
        return frecuencias;
    }

    private void imprimirTabla(int[] frecuencias) {
        System.out.println("Numero | Frecuencia");
        for (int numero = MIN; numero <= MAX; numero++) {
            System.out.printf("%-6d | %d%n", numero, frecuencias[numero]);
        }
    }

    private void imprimirMasFrecuente(int[] frecuencias) {
        int numeroMasFrecuente = MIN;
        for (int numero = MIN; numero <= MAX; numero++) {
            if (frecuencias[numero] > frecuencias[numeroMasFrecuente]) {
                numeroMasFrecuente = numero;
            }
        }
        System.out.println("El numero que mas se repite es " + numeroMasFrecuente
                + " con " + frecuencias[numeroMasFrecuente] + " apariciones.");
    }
}