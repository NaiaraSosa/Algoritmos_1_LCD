// EJERCICIO: CONSTRUCTORES DE LIBRO
package ejercicioLibro;

import java.time.LocalDate;

public class Libro {
    String titulo;
    String autor;
    int añoPublicacion;

    public Libro (String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = LocalDate.now().getYear();
    }

    public Libro (String titulo, String autor, int añoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
    }

    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de publicación: " + añoPublicacion);
    }

    public static void main (String[] args) {
        // Creo libro sin año de publicacion especificado
        Libro libro1 = new Libro("All the bright places", "Jennifer Nieven");
        System.out.println("Libro 1:");
        libro1.mostrarDetalles();
        // Creo libro con año de publicacion especificado
        Libro libro2 = new Libro("El principito", "Antonio Levroi", 1957);
        System.out.println("\nLibro 2:");
        libro2.mostrarDetalles();

    }
}
