package ejercicioLaEscuela;
import java.util.List;
import java.util.Set;

public class Escuela {
    private List<Estudiante> estudiantes;
    private Set<Materia> materias;

    public Escuela (List<Estudiante> estudiantes, Set<Materia> materias) {
        this.estudiantes = estudiantes;
        this.materias = materias;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public Set<Materia> getMaterias() {
        return materias;
    }
}
