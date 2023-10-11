package ejemplosColecciones;
import java.util.LinkedList;
import java.util.Queue;

public class EjemploCola {
    public static void main(String[] args) {
        // Crear una cola de números enteros
        Queue<Integer> colaNumeros = new LinkedList<>();

        // Agregar elementos a la cola (al final de la linkedlist)
        colaNumeros.offer(10);
        colaNumeros.offer(20);
        colaNumeros.offer(30);

        // Acceder y eliminar elementos de la cola
        int primerNumero = colaNumeros.poll(); // Retira y devuelve el primer elemento
        System.out.println("Primer número en la cola: " + primerNumero);

        // Iterar a través de la cola
        for (int numero : colaNumeros) {
            System.out.println(numero);
        }
    }
}
