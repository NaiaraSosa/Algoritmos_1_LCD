// EJERCICIO: CONTADOR DE PALABRAS

package ejercicioContadorPalabras;

import java.util.Scanner;
public class ContadorPalabras {
    public static void main (String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Ingrese una frase: ");
        String frase = scanner.nextLine();
        System.out.println("Ingrese un separador: ");
        String separador = scanner.nextLine();

        if (separador.isEmpty()) {
            separador = " ";
        }

        int resultado = contarPalabras (frase, separador);
        System.out.println("Cantidad de palabras: " + resultado);
        scanner.close();
    }

    public static int contarPalabras(String frase, String separador) {
        // Divide la cadena de texto en palabras usando el separador
        String [] palabras = frase.split(separador);

        // Filtra las palabras vacías
        int contador = 0;
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                contador++;
            }
        }
        return contador;
    }
}
