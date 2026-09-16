package arreglos;

import util.Ejercicio;
import util.GeneradorDatos;
import util.ImpresorConsola;

/**
 * Ejercicio 4: lee 25 numeros aleatorios entre -50 y 50 y encuentra
 * el menor y el mayor del arreglo.
 */
public class Ejercicio04MinMax implements Ejercicio {

    private static final int CANTIDAD = 25;
    private static final int MIN = -50;
    private static final int MAX = 50;

    @Override
    public String getTitulo() {
        return "Ejercicio 4: Menor y mayor de 25 numeros aleatorios";
    }

    @Override
    public void ejecutar() {
        int[] numeros = generarDatos();
        int menor = encontrarMenor(numeros);
        int mayor = encontrarMayor(numeros);
        imprimirResultados(numeros, menor, mayor);
    }

    private int[] generarDatos() {
        return GeneradorDatos.generarEnteros(CANTIDAD, MIN, MAX);
    }

    private int encontrarMenor(int[] numeros) {
        int menor = numeros[0];
        for (int numero : numeros) {
            if (numero < menor) {
                menor = numero;
            }
        }
        return menor;
    }

    private int encontrarMayor(int[] numeros) {
        int mayor = numeros[0];
        for (int numero : numeros) {
            if (numero > mayor) {
                mayor = numero;
            }
        }
        return mayor;
    }

    private void imprimirResultados(int[] numeros, int menor, int mayor) {
        ImpresorConsola.imprimirArreglo("Numeros generados", numeros);
        System.out.println("Numero menor: " + menor);
        System.out.println("Numero mayor: " + mayor);
    }
}
