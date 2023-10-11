package ejercicioTiposDeViajes;

public class AltaVelocidad extends Viaje{
    
    public AltaVelocidad(Trayecto trayecto, int cantVagones, int cantMaxPasajeros) {
        super(trayecto, cantVagones, cantMaxPasajeros);
    }

    @Override // hay que implementar los métodos abstractos que está heredando la subclase
    public double tiempoDemora() {
        return trayecto.getDistancia() / 10;
    }
}

