// EJERCICIO: CREAR UNA CLASE Y UN OBJETO (método toString())
package ejercicioEstudiante;

public class Estudiante {
    private String nombre;
    private int edad;
    private String carrera;
    private String[] materias;

    public Estudiante(String nombre, int edad, String carrera, String[] materias) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.materias = materias;
    }

    // Metodo toString para mostrar informacion en formato cadena
    public String toString() {
        StringBuilder materiasString = new StringBuilder();
        for (String materia : materias) {
            materiasString.append(materia).append(", ");
        }
        if (materiasString.length() > 2) {
            materiasString.setLength(materiasString.length() - 2);
        }

        return "Estudiante\n" +
                "Nombre: " + nombre + "\n" +
                "Edad: " + edad +  "\n" +
                "Carrera: " + carrera +  "\n" +
                "Materias: " + materiasString.toString(); 
    }

    public static void main(String[] args) {
        String[] materias = {"Infraestructura", "Algoritmos 1", "Estadística"};
        Estudiante naiara = new Estudiante("Naiara", 20, "Ciencia de Datos", materias);
        System.out.println(naiara);
    }
}
