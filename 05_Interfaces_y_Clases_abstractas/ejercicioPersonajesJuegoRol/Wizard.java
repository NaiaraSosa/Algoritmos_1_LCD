package ejercicioPersonajesJuegoRol;

public class Wizard extends Personaje implements AtaqueDistancia {
    
    public Wizard (String nombre, int nivel, int puntosVida) {
        super(nombre, nivel, puntosVida);
    }
    
    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(this.getNombre() + " ataca a " + objetivo.getNombre() + " y le quita 3 puntos de vida."); 
        objetivo.recibirDaño(3);
        this.mostrarEstado();
        objetivo.mostrarEstado();
    }

    @Override
    public void defender(Personaje objetivo) {
        System.out.println(this.getNombre() + " se defiende y reduce 3 puntos el daño recibido.");
        this.suprimirDaño(3);
        this.mostrarEstado();
        objetivo.mostrarEstado();
    }

    @Override
    public void atacarADistancia (Personaje objetivo) {
        System.out.println(this.getNombre() + " lanza un ataque a distancia a " + objetivo.getNombre() + " y le quita 3 puntos de vida.");
        objetivo.recibirDaño(3);
        this.mostrarEstado();
        objetivo.mostrarEstado();
    }
}
