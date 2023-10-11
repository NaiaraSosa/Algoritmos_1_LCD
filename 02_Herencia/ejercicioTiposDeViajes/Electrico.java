package ejercicioTiposDeViajes;

public class Electrico extends Viaje {

    public Electrico(Trayecto trayecto, int cantVagones, int cantMaxPasajeros) {
        super(trayecto, cantVagones, cantMaxPasajeros);
    }

    @Override // hay que implementar los métodos abstractos que está heredando la subclase
    public double tiempoDemora() {
        return ((trayecto.getDistancia()* trayecto.getCantEstaciones()) /2 );
    }
}

