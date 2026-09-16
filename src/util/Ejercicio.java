package util;

/**
 * Contrato que deben cumplir todos los ejercicios del taller.
 * Cada ejercicio se muestra en el menú con su título y se ejecuta
 * de forma independiente.
 * 
 * //promesa pa cualquier clase q diga implements, acuerdate maicol
 */
public interface Ejercicio {

    String getTitulo();

    void ejecutar();
}