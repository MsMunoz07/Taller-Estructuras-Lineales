package util;

/**
 * Métodos reutilizables para imprimir arreglos y matrices en consola.
 * Evita repetir bucles de impresión en cada ejercicio.
 */
public class ImpresorConsola {

    /** Imprime un arreglo de enteros en una sola línea, separado por espacios. */
    public static void imprimirArreglo(int[] arreglo) {
        StringBuilder sb = new StringBuilder();
        for (int valor : arreglo) {
            sb.append(valor).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    /** Imprime un arreglo de enteros con un título antes. */
    public static void imprimirArreglo(String titulo, int[] arreglo) {
        System.out.println(titulo + ":");
        imprimirArreglo(arreglo);
    }

    /** Imprime un arreglo de long (útil para factoriales, que crecen rápido). */
    public static void imprimirArreglo(String titulo, long[] arreglo) {
        System.out.println(titulo + ":");
        StringBuilder sb = new StringBuilder();
        for (long valor : arreglo) {
            sb.append(valor).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    /** Imprime una matriz de enteros con formato de filas y columnas. */
    public static void imprimirMatriz(String titulo, int[][] matriz) {
        System.out.println(titulo + ":");
        for (int[] fila : matriz) {
            StringBuilder sb = new StringBuilder();
            for (int valor : fila) {
                sb.append(String.format("%5d", valor));
            }
            System.out.println(sb.toString());
        }
    }

    /** Línea separadora, para que la salida de cada ejercicio no se mezcle. */
    public static void imprimirSeparador() {
        System.out.println("----------------------------------------");
    }
}
