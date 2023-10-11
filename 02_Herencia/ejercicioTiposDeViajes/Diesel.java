package ejercicioTiposDeViajes;

public class Diesel extends Viaje {

    public Diesel(Trayecto trayecto, int cantVagones, int cantMaxPasajeros) {
        super(trayecto, cantVagones, cantMaxPasajeros);
    }

    @Override // hay que implementar los métodos abstractos que está heredando la subclase
    public double tiempoDemora() {
        return ((trayecto.getDistancia() * trayecto.getCantEstaciones())/2.0)
        + (trayecto.getCantEstaciones() + this.cantMaxPasajeros)/10.0;
    }
}
