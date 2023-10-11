//EJERCICIO: INGRESO Y SALIDA
package ejercicioEntradaSalida.entrada;
import java.util.Scanner;

public class EntradaConsola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // El parámetro indica de dónde procederá la fuente de datos
        System.out.println("Ingrese el número de entradas: ");
        int cantidadEntradas = scanner.nextInt(); // Lee valores int introducidos por el usuario
        scanner.nextLine(); //Limpia el buffer

        //Solicitar y mostrar entradas del usuario
        for (int i = 1; i <= cantidadEntradas; i++) {
            System.out.println("Entrada " + i + ": ");
            String entrada = scanner.nextLine();
            ejercicioEntradaSalida.salida.SalidaConsola.mostrar(entrada);
        }

        scanner.close(); 
    }
}