package app;

import java.util.ArrayList;
import java.util.List;
import arreglos.Ejercicio01Primos;
import arreglos.Ejercicio02Pares;
import arreglos.Ejercicio03Factoriales;
import arreglos.Ejercicio04MinMax;
import arreglos.Ejercicio05Invertidos;
import arraylist.Ejercicio06Suma;
import arraylist.Ejercicio07Insertar;
import arraylist.Ejercicio08Frecuencia;
import arraylist.Ejercicio09OrdenarSeparar;
import arraylist.Ejercicio10Partidos;
import matrices.Ejercicio11Buscar;
import matrices.Ejercicio12DiagonalSecundaria;
import matrices.Ejercicio13Simetrica;
import matrices.Ejercicio14Transpuesta;
import util.Ejercicio;
import util.LectorConsola;


/**
 * Menú principal del taller. Permite ejecutar cualquiera de los
 * ejercicios registrados en la lista, sin necesidad de cambiar de
 * clase principal.
 */
public class Main {

    public static void main(String[] args) {
        List<Ejercicio> ejercicios = registrarEjercicios();
        mostrarMenu(ejercicios);
    }

    /**
     * Aquí se registran todos los ejercicios del taller.
     * A medida que resolvamos cada uno, se agrega una línea como:
     *     ejercicios.add(new Ejercicio02Pares());
     */
    private static List<Ejercicio> registrarEjercicios() {
        List<Ejercicio> ejercicios = new ArrayList<>();

        ejercicios.add(new Ejercicio01Primos());
        ejercicios.add(new Ejercicio02Pares());
        ejercicios.add(new Ejercicio03Factoriales());
        ejercicios.add(new Ejercicio04MinMax());
        ejercicios.add(new Ejercicio05Invertidos());
        ejercicios.add(new Ejercicio06Suma());
        ejercicios.add(new Ejercicio07Insertar());
        ejercicios.add(new Ejercicio08Frecuencia());
        ejercicios.add(new Ejercicio09OrdenarSeparar());
        ejercicios.add(new Ejercicio10Partidos());
        ejercicios.add(new Ejercicio11Buscar());
        ejercicios.add(new Ejercicio12DiagonalSecundaria());
        ejercicios.add(new Ejercicio13Simetrica());
        ejercicios.add(new Ejercicio14Transpuesta());
        

        
    



        







        return ejercicios;
    }

    private static void mostrarMenu(List<Ejercicio> ejercicios) {
        int opcion;
        do {
            System.out.println();
            System.out.println("=== Taller de Estructuras Lineales ===");

            if (ejercicios.isEmpty()) {
                System.out.println("(Todavía no hay ejercicios registrados)");
            }

            for (int i = 0; i < ejercicios.size(); i++) {
                System.out.println((i + 1) + ". " + ejercicios.get(i).getTitulo());
            }
            System.out.println("0. Salir");

            opcion = LectorConsola.leerEntero("Selecciona un ejercicio: ");

            if (opcion >= 1 && opcion <= ejercicios.size()) {
                System.out.println();
                ejercicios.get(opcion - 1).ejecutar();
            } else if (opcion != 0) {
                System.out.println("Opción inválida, intenta de nuevo.");
            }

        } while (opcion != 0);

        System.out.println("¡Hasta pronto!");
    }
}
