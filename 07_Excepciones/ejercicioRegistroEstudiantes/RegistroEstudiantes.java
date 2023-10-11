package ejercicioRegistroEstudiantes;
import java.util.ArrayList;
import java.util.List;

public class RegistroEstudiantes{
    private List<Estudiante> registroEstudiantes;

   
    public RegistroEstudiantes(){
        registroEstudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(String nombre, int edad, double promedio) throws NombreInvalidoException, EdadInvalidaException, PromedioInvalidoException {
        if (nombre == null || nombre.isEmpty()) {
            throw new NombreInvalidoException("El nombre del estudiante ingresado no puede ser vacío o nulo.");
        }
        if (edad <0 || edad > 120) {
            throw new EdadInvalidaException("La edad del estudiante debe estar entre 0 y 120.");
        }
        if (promedio < 0.0 || promedio > 10.0) {
            throw new PromedioInvalidoException("El promedio del estudiante debe estar entre 0 y 10.");
        }
        Estudiante estudiante = new Estudiante(nombre, edad, promedio);
        registroEstudiantes.add(estudiante);
        System.out.println("Estudiante " + nombre + " agregado al registro.");
    }
    
    public List<Estudiante> getRegistroEstudiantes() {
        return registroEstudiantes;
    }

}    

