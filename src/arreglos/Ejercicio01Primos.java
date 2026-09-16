package arreglos;

import util.Ejercicio;
import util.ImpresorConsola;

/**
 * Ejercicio 1: arreglo inicializado directamente con los primeros
 * 10 números primos.
 */
public class Ejercicio01Primos implements Ejercicio {

    @Override
    public String getTitulo() {
        return "Ejercicio 1: Primeros 10 numeros primos";
    }

    @Override
    public void ejecutar() {
        int[] primos = generarDatos();
        imprimirResultado(primos);
    }

    private int[] generarDatos() {
        return new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    }

    private void imprimirResultado(int[] primos) {
        ImpresorConsola.imprimirArreglo("Primeros 10 numeros primos", primos);
    }
}


