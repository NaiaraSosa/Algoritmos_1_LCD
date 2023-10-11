// EJERCICIO: CLASES Y MÉTODOS
package ejercicioRectangulo;

public class Rectangulo {
    double largo;
    double ancho;

    public Rectangulo (double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public void calculo_area() {
        double area = largo * ancho;
        System.out.println("El área del rectángulo es: " + area);
    }

    public void calculo_perimetro() { 
        double perimetro = (2*largo) + (2*ancho);
        System.out.println("El perímetro del rectángulo es: " + perimetro);
    }

    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo(8, 5);
        rectangulo.calculo_area();
        rectangulo.calculo_perimetro();
    }
}
