//EJERCICIO: SUMA DE NUMEROS PARES
package ejercicioSumaNumerosPares;

import java.util.Scanner;

public class SumaNumerosPares {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número positivo: ");
        int numero = sc.nextInt();

        int resultado = 0;
        
        if (numero > 0) {
            if (numero == 1) {
                System.out.println("La suma es 0.");
                System.exit(1);
            } else {
                for (int i = 2; i <= numero; i += 2) {
                    resultado += i;
                }
            }
        } else {
            System.out.println("El número debe ser positivo.");
            System.exit(1);
        }

        System.out.println("La suma de los números pares del 1 al " + numero + " es: " + resultado);
        sc.close();
    }
 }
