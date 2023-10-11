package ejercicioFigurasGeometricas;

public class Rectangulo extends Figura {

    protected double base;
    protected double altura;
    
    public Rectangulo(String nombre, double base, double altura) {
        super(nombre);
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public void calcularArea () {
        System.out.println("Área del rectángulo " + nombre + ": " + (base*altura));
    }
}
