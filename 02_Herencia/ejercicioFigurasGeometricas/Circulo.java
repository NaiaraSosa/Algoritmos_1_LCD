package ejercicioFigurasGeometricas;

public class Circulo extends Figura {

    protected double radio;
    
    public Circulo (String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public void calcularArea() {
        System.out.println("Área del círculo " + nombre + ": " + ((Math.PI)* (radio*radio)));
    }
}
