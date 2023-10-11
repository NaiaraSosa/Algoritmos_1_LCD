package ejercicioCajaContenedoraNumerica;

public class Main {
    public static void main(String[] args) {
        ContenedorNumerico <Integer> contenedorEntero = new ContenedorNumerico<>();
        //Contenedor <String> contenedorString = new Contenedor<>();

        // Agrego elemento
        contenedorEntero.agregar(20);
        // Lo visualizo
        contenedorEntero.visualizar();
        // Comparo con otro numero
        System.out.println("¿El número que contiene es igual a 30? " + contenedorEntero.comparar(30));
        // Chequeo si esta vacio
        System.out.println("El contenedor está vacio: " + contenedorEntero.verificarVacio());
        // Elimino el numero
        contenedorEntero.quitar();
        // Chequeo de nuevo si esta vacio2
        System.out.println("El contenedor está vacio: " + contenedorEntero.verificarVacio());
    }
}
