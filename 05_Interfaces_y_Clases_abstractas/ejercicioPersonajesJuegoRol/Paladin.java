package ejercicioPersonajesJuegoRol;

public class Paladin extends Personaje {
    
    public Paladin (String nombre, int nivel, int puntosVida) {
        super(nombre, nivel, puntosVida);
    }
    
    @Override
    public void atacar (Personaje objetivo) {
        System.out.println(this.getNombre() + " ataca a " + objetivo.getNombre() + " y le quita 5 puntos de vida.");
        objetivo.recibirDaño(5);
        this.mostrarEstado();
        objetivo.mostrarEstado();
    }

    @Override
    public void defender (Personaje objetivo) {
        System.out.println(this.getNombre() + " se defiende y reduce 2 puntos el daño recibido.");
        this.suprimirDaño(2);
        this.mostrarEstado();
        objetivo.mostrarEstado();
    }
}
