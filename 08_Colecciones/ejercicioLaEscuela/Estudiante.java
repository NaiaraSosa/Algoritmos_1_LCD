package ejercicioLaEscuela;
import java.util.Objects;

public class Estudiante {
    private String nombre;
    private int matricula;
    private int edad;
    private HistoriaAcademica historiaAcademica;

    public Estudiante (String nombre, int matricula, int edad, HistoriaAcademica historiaAcademica) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.historiaAcademica = historiaAcademica;
    }
    
    public String getNombre() {
        return nombre;
    }

    public HistoriaAcademica getHistoriaAcademica() {
        return historiaAcademica;
    }

    @Override
    public boolean equals (Object estudiante) {
        if (this == estudiante) {
            return true;
        }
        if (estudiante == null | this.getClass() != estudiante.getClass()) {
            return false;
        }
        Estudiante otroEstudiante = (Estudiante) estudiante;
        return this.matricula == otroEstudiante.matricula; 
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
