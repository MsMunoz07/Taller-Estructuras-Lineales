package arraylist;

import java.util.ArrayList;
import java.util.List;
import util.Ejercicio;
import util.LectorConsola;

/**
 * Ejercicio 7: ArrayList con los 20 primeros numeros pares.
 * Permite insertar un numero en su posicion ordenada y borrar un
 * valor solicitado al usuario.
 */
public class Ejercicio07Insertar implements Ejercicio {

    private static final int CANTIDAD = 20;

    @Override
    public String getTitulo() {
        return "Ejercicio 7: ArrayList ordenado, insertar y borrar";
    }

    @Override
    public void ejecutar() {
        List<Integer> pares = generarDatos();
        System.out.println("ArrayList inicial: " + pares);

        int numeroAInsertar = LectorConsola.leerEntero("Ingresa un numero para insertar: ");
        insertarOrdenado(pares, numeroAInsertar);
        System.out.println("ArrayList tras insertar: " + pares);

        int numeroABorrar = LectorConsola.leerEntero("Ingresa el numero que deseas borrar: ");
        boolean seBorro = pares.remove(Integer.valueOf(numeroABorrar));
        if (seBorro) {
            System.out.println("ArrayList tras borrar: " + pares);
        } else {
            System.out.println("Ese numero no estaba en la lista.");
        }
    }

    /** Genera los 20 primeros numeros pares en orden ascendente. */
    private List<Integer> generarDatos() {
        List<Integer> pares = new ArrayList<>();
        for (int i = 1; i <= CANTIDAD; i++) {
            pares.add(i * 2);
        }
        return pares;
    }

    /** Inserta un numero en la posicion que mantiene el orden ascendente. */
    private void insertarOrdenado(List<Integer> lista, int numero) {
        int posicion = 0;
        while (posicion < lista.size() && lista.get(posicion) < numero) {
            posicion++;
        }
        lista.add(posicion, numero);
    }
}
