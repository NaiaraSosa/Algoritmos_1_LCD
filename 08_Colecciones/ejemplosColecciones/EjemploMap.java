package ejemplosColecciones;
import java.util.HashMap;
import java.util.Map;

public class EjemploMap {
    public static void main(String[] args) {
        // Crear un mapa de nombres de frutas y sus cantidades
        Map<String, Integer> inventarioFrutas = new HashMap<>();

        // Agregar elementos al mapa
        inventarioFrutas.put("Manzana", 50);
        inventarioFrutas.put("Banana", 30);
        inventarioFrutas.put("Cereza", 25);
        inventarioFrutas.put("Cereza", 15); // Reemplaza el valor previo de Cereza

        // Obtener el valor asociado a una clave
        int cantidadManzanas = inventarioFrutas.get("Manzana");
        System.out.println("Cantidad de manzanas: " + cantidadManzanas);

        // Iterar a través del mapa con entrySet
        for (Map.Entry<String, Integer> entrada : inventarioFrutas.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue() + " unidades");
        }

        // Iterar a través del mapa con keySet
        for (String clave : inventarioFrutas.keySet()) {
            System.out.println(clave + ": " + inventarioFrutas.get(clave) + " unidades");
        }

        // Iterar a través del mapa con values
        int total = 0;
        for (Integer valor : inventarioFrutas.values()) {
            total += valor;
        }
        System.out.println("Frutas totales: " + total);
    }
}
