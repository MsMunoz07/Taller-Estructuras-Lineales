package arraylist;

import java.util.ArrayList;
import java.util.List;
import util.Ejercicio;
import util.GeneradorDatos;

/**
 * Ejercicio 6: genera numeros aleatorios entre -10 y 10 y los guarda
 * en un ArrayList hasta que se genera el numero 10 (centinela).
 * Luego muestra los numeros, la suma y el promedio.
 */
public class Ejercicio06Suma implements Ejercicio {

    private static final int MIN = -10;
    private static final int MAX = 10;
    private static final int VALOR_CENTINELA = 10;

    @Override
    public String getTitulo() {
        return "Ejercicio 6: ArrayList con centinela, suma y promedio";
    }

    @Override
    public void ejecutar() {
        List<Integer> numeros = generarDatos();
        int suma = calcularSuma(numeros);
        double promedio = calcularPromedio(numeros, suma);
        imprimirResultados(numeros, suma, promedio);
    }

    /** Genera numeros aleatorios hasta que sale el valor centinela (10). */
    private List<Integer> generarDatos() {
        List<Integer> numeros = new ArrayList<>();
        int numeroGenerado;

        do {
            numeroGenerado = GeneradorDatos.generarEntero(MIN, MAX);
            if (numeroGenerado != VALOR_CENTINELA) {
                numeros.add(numeroGenerado);
            }
        } while (numeroGenerado != VALOR_CENTINELA);

        return numeros;
    }

    private int calcularSuma(List<Integer> numeros) {
        int suma = 0;
        for (int numero : numeros) {
            suma += numero;
        }
        return suma;
    }

    private double calcularPromedio(List<Integer> numeros, int suma) {
        if (numeros.isEmpty()) {
            return 0;
        }
        return (double) suma / numeros.size();
    }

    private void imprimirResultados(List<Integer> numeros, int suma, double promedio) {
        System.out.println("Numeros leidos: " + numeros);
        System.out.println("Cantidad de numeros: " + numeros.size());
        System.out.println("Suma: " + suma);
        System.out.printf("Promedio: %.2f%n", promedio);
    }
}

