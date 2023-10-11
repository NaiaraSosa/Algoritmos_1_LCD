package ejemplosColecciones;
import java.util.HashSet;
import java.util.Set;

public class EjemploConjunto {
    public static void main(String[] args) {
        // Crear un conjunto de números enteros
        Set<Integer> conjuntoNumeros = new HashSet<>();

        // Agregar elementos al conjunto
        conjuntoNumeros.add(10);
        conjuntoNumeros.add(20);
        conjuntoNumeros.add(10); // Intento de duplicado, se ignora

        // Iterar a través del conjunto (sin garantía de orden)
        for (int numero : conjuntoNumeros) {
            System.out.println(numero);
        }
    }
}
