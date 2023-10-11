package ejercicioComparacionEstudiantes;

public class Estudiante {
    private String nombre;
    private int edad;
    private int matricula;

    public Estudiante (String nombre, int edad, int matricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals (Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || this.getClass() != objeto.getClass()) {
            return false;
        }
        Estudiante otroEstudiante = (Estudiante) objeto; // Downcasting
        return this.matricula == otroEstudiante.matricula;
    }
}
