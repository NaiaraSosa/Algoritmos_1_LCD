package ejercicioLaEscuela;
import java.util.Objects;

public class Materia {
    private String nombre;
    private int codigo;
    private boolean estado;

    public Materia (String nombre, int codigo, boolean estado) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }
    
    @Override
    public boolean equals (Object materia) {
        if (this == materia) {
            return true;
        }
        if (materia == null | this.getClass() != materia.getClass()) {
            return false;
        }
        Materia otraMateria = (Materia) materia;
        return this.codigo == otraMateria.codigo; 
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
