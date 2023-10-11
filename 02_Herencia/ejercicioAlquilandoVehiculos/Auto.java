package ejercicioAlquilandoVehiculos;

public class Auto extends Vehiculo {

    public Auto (String marca, String modelo, double precioBase) {
        super(marca, modelo, precioBase);
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        double costoBase = (super.calcularCostoAlquiler(dias));    
        return costoBase * 1.20;
    }
}
