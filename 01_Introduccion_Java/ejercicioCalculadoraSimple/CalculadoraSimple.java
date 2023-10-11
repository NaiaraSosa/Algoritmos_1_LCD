//EJERCICIO: CALCULADORA SIMPLE
package ejercicioCalculadoraSimple;
import java.util.Scanner;

public class CalculadoraSimple {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer número: ");
        int numero1 = sc.nextInt();
        System.out.println("Ingrese el operador (+, -, *. /): ");
        char operador = sc.next().charAt(0); // para obtener primer caracter ingresado
        System.out.println("Ingrese el segundo número: ");
        int numero2 = sc.nextInt();

        int resultado = 0;

        switch (operador) {
            case '+':
                resultado = numero1 + numero2;
                break;
            case '-':
                resultado = numero1 - numero2;
                break;
            case '*':
                resultado = numero1 * numero2;
                break;
            case '/':
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    System.out.println("Error: No se puede dividir por 0.");
                    System.exit(1);
                }
                break;
            default:
                System.out.println("Operador no válido.");
                System.exit(1); //Debe terminar el programa si hay error
        } 

        System.out.println("El resultado de la operación es: " + resultado);
        sc.close();
    }

}
