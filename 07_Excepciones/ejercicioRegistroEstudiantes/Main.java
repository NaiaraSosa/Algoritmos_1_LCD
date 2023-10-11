package ejercicioRegistroEstudiantes;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroEstudiantes registro = new RegistroEstudiantes();
        while (true) {
            try {
                System.out.println("Ingrese el nombre del estudiante:");
                String nombre = scanner.nextLine();
                if (nombre.equals("salir")) {
                    break;
                }
                System.out.println("Ingrese la edad del estudiante:");
                int edad = Integer.parseInt(scanner.nextLine());
                System.out.println("Ingrese el promedio del estudiante:");
                double promedio = Double.parseDouble(scanner.nextLine());
                registro.agregarEstudiante(nombre, edad, promedio);
            } catch (NombreInvalidoException | EdadInvalidaException | PromedioInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido para la edad.");
            }

        }
        
        System.out.println("Estudiantes registrados: ");
        for (Estudiante estudiante : registro.getRegistroEstudiantes()) {
            System.out.println(estudiante);
        }
        scanner.close();
    }
}
