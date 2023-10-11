package ejercicioComparacionEstudiantes;

public class Main {
    public static void main(String[] args) {

        EstudianteGrado estudianteGrado1 = new EstudianteGrado("Ezequiel", 20, 500, "Ciencia de Datos");
        EstudianteGrado estudianteGrado2 = new EstudianteGrado("Naiara", 20, 1500, "Ciencia de Datos");
        EstudiantePosgrado estudiantePosgrado1 = new EstudiantePosgrado("Julian", 27, 2000, "Danza");
        EstudiantePosgrado estudiantePosgrado2 = new EstudiantePosgrado("Maia", 32, 2000, "Danza");
        // Comparación usando equals
        boolean sonIgualesGrado = estudianteGrado1.equals(estudianteGrado2);
        System.out.println("¿Son iguales los estudiante de grado? " + sonIgualesGrado); // false
        boolean sonIgualesPosgrado = estudiantePosgrado1.equals(estudiantePosgrado2);   // true
        System.out.println("¿Son iguales los estudiantes de posgrado? " + sonIgualesPosgrado);

        Estudiante estudiante1 = new Estudiante("Ana", 19, 200);
        Estudiante estudiante2 = new Estudiante("Mateo", 25, 200);
        // Comparación usando equals
        boolean sonIguales = estudiante1.equals(estudiante2);
        System.out.println("¿Son iguales los estudiantes? " + sonIguales);  // true

        // Comparacion de identidad (dos instancias distintas nunca serán el mismo objeto)
        boolean sonMismaReferencia = (estudiante1 == estudiante2);
        System.out.println("¿Son el mismo objeto? " + sonMismaReferencia);  // false

    }
}
