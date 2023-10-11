package ejercicioAlquilandoVehiculos;

public class Moto extends Vehiculo{
    
    public Moto (String marca, String modelo, double precioBase) {
        super(marca, modelo, precioBase);
    }

    @Override
    public double calcularCostoAlquiler(int dias){
        double costoBase = super.calcularCostoAlquiler(dias);
        return costoBase*0.85;
    }
}
