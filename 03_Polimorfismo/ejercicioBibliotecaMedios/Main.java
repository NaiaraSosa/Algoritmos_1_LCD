package ejercicioBibliotecaMedios;

public class Main {
    public static void main (String[] args) {
        Medio [] medios = new Medio[3];
        medios[0] = new Libro("All the bright Places", "Jennifer Nieven");
        medios[1] = new Pelicula("La La Land", "Damien Chazelle");
        medios[2] = new Musica("TV", "Bille Eilish");

        for (Medio medio : medios) {
            medio.reproducir();
        }

        
    }
}
