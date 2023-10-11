package ejercicioComparacionEstudiantes;

public class EstudiantePosgrado extends Estudiante {
    private String carreraPosgrado;

    public EstudiantePosgrado (String nombre, int edad, int matricula, String carreraPosgrado) {
        super(nombre, edad, matricula);
        this.carreraPosgrado = carreraPosgrado;
    }

    @Override
    public boolean equals (Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || this.getClass() != objeto.getClass()) {
            return false;
        }
        EstudiantePosgrado otroEstudiantePosgrado = (EstudiantePosgrado) objeto;
        return this.getMatricula() == otroEstudiantePosgrado.getMatricula() &&
            this.carreraPosgrado.equals(otroEstudiantePosgrado.carreraPosgrado);
    }
}
