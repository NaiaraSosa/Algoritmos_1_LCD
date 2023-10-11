//EJERCICIO: TABLA DE MULTIPLICAR
package ejercicioTablaMultiplicar;

import java.util.Scanner;

public class TablaMultiplicar {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        int numeroIngresado = scanner.nextInt();

        System.out.println("Tabla de multiplicar del " + numeroIngresado + ": ");

        for (int i = 1; i <=10; i++ ) {
            int resultadoTabla = numeroIngresado * i;
            System.out.println(numeroIngresado + " x " + i + " = " + resultadoTabla);
        }
        scanner.close();
    }
}
