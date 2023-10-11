package ejercicioCajaContenedora;

public class Main {
    public static void main(String[] args) {
        Contenedor <String> contenedorEntero = new Contenedor<>();
        //Contenedor <String> contenedorString = new Contenedor<>();

        // Agrego elemento
        contenedorEntero.agregar("Chiki");
        // Lo visualizo
        contenedorEntero.visualizar();
        // Comparo con otro numero
        System.out.println("¿El nombre que contiene es igual a Eze? " + contenedorEntero.comparar("Eze"));
        // Chequeo si esta vacio
        System.out.println("El contenedor está vacio: " + contenedorEntero.verificarVacio());
        // Elimino el numero
        contenedorEntero.quitar();
        // Chequeo de nuevo si esta vacio2
        System.out.println("El contenedor está vacio: " + contenedorEntero.verificarVacio());
    }
}
