package ejercicioPersonajesJuegoRol;

public abstract class Personaje {
    private String nombre;
    private int nivel;
    private int puntosVida;

    public Personaje (String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
    }

    public abstract void atacar(Personaje objetivo) ;

    public void recibirDaño (int daño) {
        puntosVida -= daño;
    }

    public abstract void defender(Personaje objetivo) ;

    public void suprimirDaño (int reduccion) {
        puntosVida += reduccion;
    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nivel: " + nivel);
        System.out.println("Puntos de Vida: " + puntosVida);
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }
}