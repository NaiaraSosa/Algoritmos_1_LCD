package ejercicioLaEscuela;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Creo un set de las materas
        Materia matematica = new Materia("Matematica", 001, true);
        Materia aleman = new Materia("Aleman", 002, true);
        Materia ingles = new Materia("Inglés", 003, true);
        Materia arte = new Materia("Arte", 004, false);
        Materia lengua = new Materia("Lengua", 000, false);
        Set<Materia> materias = new HashSet<>();
        materias.add(matematica);
        materias.add(aleman);
        materias.add(ingles);
        materias.add(arte);
        // Creo algunos diccionarios de historias academicas
        HistoriaAcademica historiaAcademicaNaiara = new HistoriaAcademica();
        Set<Double> calificacionesMatematicaNaiara = new HashSet<Double>();
        calificacionesMatematicaNaiara.add(9.0);
        calificacionesMatematicaNaiara.add(8.5);
        calificacionesMatematicaNaiara.add(7.0);
        Set<Double> calificacionesAlemanNaiara = new HashSet<Double>();
        calificacionesAlemanNaiara.add(1.5);
        calificacionesAlemanNaiara.add(6.5);
        calificacionesAlemanNaiara.add(9.0);
        historiaAcademicaNaiara.agregarCalificaciones(matematica, calificacionesMatematicaNaiara);
        historiaAcademicaNaiara.agregarCalificaciones(aleman, calificacionesAlemanNaiara);

        HistoriaAcademica historiaAcademicaCamila = new HistoriaAcademica();
        Set<Double> calificacionesLenguaCamila = new HashSet<Double>();
        calificacionesLenguaCamila.add(9.0);
        calificacionesLenguaCamila.add(1.5);
        calificacionesLenguaCamila.add(7.0);
        Set<Double> calificacionesInglesCamila = new HashSet<Double>();
        calificacionesInglesCamila.add(5.0);
        calificacionesInglesCamila.add(1.5);
        calificacionesInglesCamila.add(9.0);
        historiaAcademicaCamila.agregarCalificaciones(lengua, calificacionesLenguaCamila);
        historiaAcademicaCamila.agregarCalificaciones(ingles, calificacionesInglesCamila);

        HistoriaAcademica historiaAcademicaEzequiel = new HistoriaAcademica();
        Set<Double> calificacionesAlemanEzequiel = new HashSet<Double>();
        calificacionesAlemanEzequiel.add(9.0);
        calificacionesAlemanEzequiel.add(8.5);
        calificacionesAlemanEzequiel.add(7.0);
        Set<Double> calificacionesArteEzequiel = new HashSet<Double>();
        calificacionesArteEzequiel.add(5.0);
        calificacionesArteEzequiel.add(6.5);
        calificacionesArteEzequiel.add(9.0);
        historiaAcademicaEzequiel.agregarCalificaciones(aleman, calificacionesAlemanEzequiel);
        historiaAcademicaEzequiel.agregarCalificaciones(arte, calificacionesArteEzequiel);
        // Creo una lista de estudiantes
        Estudiante naiara = new Estudiante("Naiara", 2500, 20, historiaAcademicaNaiara);
        Estudiante camila = new Estudiante("Camila", 5000, 21, historiaAcademicaCamila);
        Estudiante ezequiel = new Estudiante("Ezequiel", 2500, 20, historiaAcademicaEzequiel);
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(naiara);
        estudiantes.add(camila);
        estudiantes.add(ezequiel);
        // Creo una escuela con estudiantes y materias
        Escuela escuela = new Escuela(estudiantes, materias);
        for (Estudiante estudiante : escuela.getEstudiantes()) {
            HistoriaAcademica historiaAcademica = estudiante.getHistoriaAcademica();
            System.out.println("El estudiante " + estudiante.getNombre() + " cursó las siguientes materias: ");
            for (Materia materia : historiaAcademica.getMateriasCursadas()) {
                if (materias.contains(materia) == false) {
                    System.out.println("La materiad " + materia.getNombre() + " no existe en la escuela.");
                    break;
                }
                System.out.println("Materia: " + materia.getNombre());
                System.out.println("Calificaciones: " + historiaAcademica.getCalificaciones(materia));
                System.out.println("Promedio: " + historiaAcademica.obtenerPromedio(materia));
            }
            System.out.println("Cantidad de aplazos: " + historiaAcademica.obtenerAplazos());
            System.out.println("Cantidad de materias cursadas: " + historiaAcademica.obtenerCantidadMaterias());
        }
    }
}
