package ejercicioBibliotecaMedios;

    
public class Libro extends Medio {
    protected String titulo;
    protected String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override    
    public void reproducir() {
        System.out.println("Reproduciendo Libro: " + titulo + " de " + autor);
    }
}

