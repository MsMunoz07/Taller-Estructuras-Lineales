package util;

import java.util.Scanner;

/**
 * Métodos reutilizables para leer datos del usuario desde consola,
 * usando un único Scanner compartido para todo el programa.
 */
public class LectorConsola {

    private static final Scanner SCANNER = new Scanner(System.in);

    /** Lee un entero, repitiendo la pregunta si el usuario escribe algo inválido. */
    public static int leerEntero(String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            String texto = SCANNER.nextLine().trim();
            try {
                valor = Integer.parseInt(texto);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingresa un número entero válido.");
            }
        }
        return valor;
    }

    /** Lee una línea de texto tal cual la escribe el usuario. */
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return SCANNER.nextLine();
    }
}