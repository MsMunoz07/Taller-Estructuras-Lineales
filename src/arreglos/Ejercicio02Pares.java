package arreglos;

import util.Ejercicio;
import util.ImpresorConsola;

/**
 * Ejercicio 2: los 100 primeros numeros pares, inicializados por
 * programa, impresos en una sola linea y luego en 10 lineas.
 */
public class Ejercicio02Pares implements Ejercicio {

    private static final int CANTIDAD = 100;

    @Override
    public String getTitulo() {
        return "Ejercicio 2: Primeros 100 numeros pares";
    }

    @Override
    public void ejecutar() {
        int[] pares = generarDatos();
        imprimirEnUnaLinea(pares);
        imprimirEnDiezLineas(pares);
    }

    /** Genera los primeros CANTIDAD numeros pares: 2, 4, 6, 8... */
    private int[] generarDatos() {
        int[] pares = new int[CANTIDAD];
        for (int i = 0; i < CANTIDAD; i++) {
            pares[i] = (i + 1) * 2;
        }
        return pares;
    }

    private void imprimirEnUnaLinea(int[] pares) {
        ImpresorConsola.imprimirArreglo("Pares en una sola linea", pares);
    }

    /** Reparte los 100 elementos en 10 lineas de 10 elementos cada una. */
    private void imprimirEnDiezLineas(int[] pares) {
        System.out.println("Pares en 10 lineas:");
        int elementosPorLinea = CANTIDAD / 10;

        for (int linea = 0; linea < 10; linea++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Linea ").append(linea + 1).append(": ");

            for (int j = 0; j < elementosPorLinea; j++) {
                int indice = linea * elementosPorLinea + j;
                sb.append(pares[indice]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}