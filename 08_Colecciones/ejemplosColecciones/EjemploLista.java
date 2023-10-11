package ejemplosColecciones;
import java.util.ArrayList;
import java.util.List;

public class EjemploLista {
    public static void main(String[] args) {
        // Crear una lista de cadenas
        List<String> listaCadenas = new ArrayList<>();

        // Agregar elementos a la lista
        listaCadenas.add("Manzana");
        listaCadenas.add("Banana");
        listaCadenas.add("Cereza");

        // Acceder a elementos por índice
        String primeraFruta = listaCadenas.get(0);
        System.out.println("Primera fruta: " + primeraFruta);

        // Iterar a través de la lista
        for (String fruta : listaCadenas) {
            System.out.println(fruta);
        }
    }
}