package ejercicioLaEscuela;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HistoriaAcademica {
    private  Map <Materia, Set<Double>> historiaAcademica;

    public HistoriaAcademica () {
        historiaAcademica = new HashMap<>();
    }

    public void agregarCalificaciones (Materia materia, Set<Double> calificaciones) {
        historiaAcademica.put(materia, calificaciones);
    }

    public double obtenerPromedio (Materia materia) {
        double total = 0;
        double promedio = 0.0;
        Set<Double> calificaciones = historiaAcademica.get(materia);
        for (double calificacion : calificaciones) {
            total +=  calificacion;
            int cantidadCalificaciones = calificaciones.size();
            promedio = total / cantidadCalificaciones;
        }
        return Math.round(promedio*100.0)/100.0;
    }

    public int obtenerAplazos() {
        int cantAplazos = 0;
        for (Set<Double> calificaciones : historiaAcademica.values()) {
            for (double calificacion : calificaciones) {
                if (calificacion < 2) {
                    cantAplazos += 1;
                }
            }
        }

        return cantAplazos;
    }

    public int obtenerCantidadMaterias () {
        return historiaAcademica.size();
    }

    public Set<Double> getCalificaciones (Materia materia) {
        return historiaAcademica.get(materia);
    }

    public Set<Materia> getMateriasCursadas() {
        return historiaAcademica.keySet();
    }
}    
