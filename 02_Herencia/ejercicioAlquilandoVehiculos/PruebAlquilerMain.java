package ejercicioAlquilandoVehiculos;

public class PruebAlquilerMain {
    public static void main(String[] args) {
        Vehiculo mVehiculo = new Vehiculo("Toyota", "Cien", 500);
        Auto miAuto = new Auto("Ford", "Fiesta", 500);
        Moto miMoto = new Moto("Popa", "Lola", 500);

        System.out.println("El costo de alquiler de mi vehículo es de: " + mVehiculo.calcularCostoAlquiler(3));
        System.out.println("El costo de alquiler de mi auto es de: " + miAuto.calcularCostoAlquiler(3));
        System.out.println("El costo de alquiler de mi moto es de: " + miMoto.calcularCostoAlquiler(3));
    }
}
