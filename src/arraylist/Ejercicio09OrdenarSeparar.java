package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.Ejercicio;
import util.GeneradorDatos;

/**
 * Ejercicio 9: genera 20 numeros aleatorios entre 1 y 100, los ordena
 * ascendente y descendentemente, y los separa en pares e impares.
 */
public class Ejercicio09OrdenarSeparar implements Ejercicio {

    private static final int CANTIDAD = 20;
    private static final int MIN = 1;
    private static final int MAX = 100;

    @Override
    public String getTitulo() {
        return "Ejercicio 9: Ordenar y separar pares/impares";
    }

    @Override
    public void ejecutar() {
        List<Integer> original = generarDatos();
        System.out.println("Lista original: " + original);

        List<Integer> ascendente = new ArrayList<>(original);
        Collections.sort(ascendente);
        System.out.println("Ordenada ascendente: " + ascendente);

        List<Integer> descendente = new ArrayList<>(original);
        Collections.sort(descendente, Collections.reverseOrder());
        System.out.println("Ordenada descendente: " + descendente);

        List<Integer> pares = filtrarPares(original);
        List<Integer> impares = filtrarImpares(original);
        System.out.println("Numeros pares: " + pares);
        System.out.println("Numeros impares: " + impares);
    }

    private List<Integer> generarDatos() {
        List<Integer> numeros = new ArrayList<>();
        for (int valor : GeneradorDatos.generarEnteros(CANTIDAD, MIN, MAX)) {
            numeros.add(valor);
        }
        return numeros;
    }

    private List<Integer> filtrarPares(List<Integer> numeros) {
        List<Integer> pares = new ArrayList<>();
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                pares.add(numero);
            }
        }
        return pares;
    }

    private List<Integer> filtrarImpares(List<Integer> numeros) {
        List<Integer> impares = new ArrayList<>();
        for (int numero : numeros) {
            if (numero % 2 != 0) {
                impares.add(numero);
            }
        }
        return impares;
    }
}