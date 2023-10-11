//EJERCICIO: CONVERSION DE TEMPERATURA
package ejercicioConversionTemperatura;
import java.util.Scanner;

public class ConversionTemperatura {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la temperatura: ");
        double tempIngresada = scanner.nextDouble();
        System.out.println("Ingrese la unidad de temperatura (C/F): ");
        char unidadTemperatura = scanner.next().charAt(0);

        double tempConvertida = 0.0;

        switch (unidadTemperatura) {
            case 'C':
                tempConvertida = (tempIngresada * 1.8) + 32;
                break;
            case 'F':
                tempConvertida = (tempIngresada - 32) / 1.8;
                break;
            default:
                System.out.println("La unidad de temperatura no es válida.");
                System.exit(1);
        }

        if (unidadTemperatura == 'C') {
            System.out.println("Temperatura en Farenheit: " + tempConvertida + "°F");
        } else {
            System.out.println("Temperatura en Celsius: " + tempConvertida + "°C");
        }

        scanner.close();
    }
}
