package ejercicioFigurasGeometricas;

public class Main {
    public static void main (String[] args) {
        Circulo mCirculo = new Circulo("Circulolo", 2);
        Rectangulo miRectangulo = new Rectangulo("Rectangulolo", 20, 10);

        mCirculo.calcularArea();
        miRectangulo.calcularArea();
    }
}
