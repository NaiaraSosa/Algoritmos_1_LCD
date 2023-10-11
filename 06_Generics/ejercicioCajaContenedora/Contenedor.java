package ejercicioCajaContenedora;

public class Contenedor<T> {
    private T elemento;

    public Contenedor () {
        this.elemento = null;
    }


    public void agregar(T elemento) {
        this.elemento = elemento;
    }
    public void quitar() {
        this.elemento = null;
        System.out.println("Se ha quitado el elemento del contenedor.");
    }
    public boolean verificarVacio() {
        return elemento == null;
    }
    public void visualizar () {
        System.out.println("El contenedor contiene: " + elemento);
    }
    public boolean comparar (T otroElemento) {
        if (elemento == null) {
            return otroElemento == null;
        }
        return elemento.equals(otroElemento);
    }
}
