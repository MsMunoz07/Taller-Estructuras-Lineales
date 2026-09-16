package arreglos;

import util.Ejercicio;
import util.GeneradorDatos;
import util.ImpresorConsola;

/**
 * Ejercicio 5: genera 20 numeros aleatorios e invierte los digitos
 * de cada uno, guardando el resultado en un segundo arreglo.
 */
public class Ejercicio05Invertidos implements Ejercicio {

    private static final int CANTIDAD = 20;
    private static final int MIN = -999;
    private static final int MAX = 999;

    @Override
    public String getTitulo() {
        return "Ejercicio 5: Invertir digitos de 20 numeros aleatorios";
    }

    @Override
    public void ejecutar() {
        int[] numeros = generarDatos();
        int[] invertidos = invertirTodos(numeros);
        imprimirResultados(numeros, invertidos);
    }

    private int[] generarDatos() {
        return GeneradorDatos.generarEnteros(CANTIDAD, MIN, MAX);
    }

    private int[] invertirTodos(int[] numeros) {
        int[] invertidos = new int[numeros.length];
        for (int i = 0; i < numeros.length; i++) {
            invertidos[i] = invertirDigitos(numeros[i]);
        }
        return invertidos;
    }

    /** Invierte los digitos de un numero, respetando su signo. */
    private int invertirDigitos(int numero) {
        boolean esNegativo = numero < 0;
        int valorAbsoluto = Math.abs(numero);

        int invertido = 0;
        while (valorAbsoluto > 0) {
            int ultimoDigito = valorAbsoluto % 10;
            invertido = invertido * 10 + ultimoDigito;
            valorAbsoluto = valorAbsoluto / 10;
        }

        return esNegativo ? -invertido : invertido;
    }

    private void imprimirResultados(int[] numeros, int[] invertidos) {
        ImpresorConsola.imprimirArreglo("Numeros originales", numeros);
        ImpresorConsola.imprimirArreglo("Numeros invertidos", invertidos);
    }
}
