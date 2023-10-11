package ejercicioTiposDeViajes;
public class Main {

    public static void main (String[] args) {
        Trayecto bariloche = new Trayecto("Buenos Aires", "Bariloche", 1500, 5);
        Viaje barilocheDiesel = new Diesel(bariloche, 10, 500); 
        System.out.println("El trayecto con Diesel tarda " + barilocheDiesel.tiempoDemora() + " minutos.");

        Viaje barilocheElectrico = new Electrico(bariloche, 10, 500);
        System.out.println("El trayecto con Electrico tarda " + barilocheElectrico.tiempoDemora() + " minutos.");

        Viaje barilocheRapido = new AltaVelocidad(bariloche, 10, 500);
        System.out.println("El trayecto con Rapido tarda " + barilocheRapido.tiempoDemora() + " minutos.");
    }
}
