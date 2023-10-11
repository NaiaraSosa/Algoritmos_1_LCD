package ejercicioTiposDeViajes;

abstract public class Viaje {

    protected Trayecto trayecto;
    protected int cantVagones;
    protected int cantMaxPasajeros;

    public Viaje(Trayecto trayecto, int cantVagones, int cantMaxPasajeros) {
        this.trayecto = trayecto;
        this.cantVagones = cantVagones;
        this.cantMaxPasajeros = cantMaxPasajeros;
    }

    abstract public double tiempoDemora(); // lo ponemos aca pero como abstracto (no lo definimos) porque asi nos aseguramos de que todas las subclases tengan si o si este metodo 
}