package ejercicioComparacionEstudiantes;

public class EstudianteGrado extends Estudiante {
    private String carreraGrado;

    public EstudianteGrado(String nombre, int edad, int matricula, String carerraGrado) {
        super(nombre, edad, matricula);
        this.carreraGrado = carerraGrado;
    }
    
    @Override
    public boolean equals (Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || this.getClass() != objeto.getClass()) {
            return false;
        }
        EstudianteGrado otroEstudianteGrado = (EstudianteGrado) objeto;
        return this.getMatricula() == otroEstudianteGrado.getMatricula() &&
            this.carreraGrado.equals(otroEstudianteGrado.carreraGrado);
    }
}
