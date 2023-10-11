package polimorfismo.polimorfismoInclusion;

public class Main {
    public static void main(String[] args) {
        Figura figura0 = new Figura();
        Figura figura1 = new Circulo();
        Figura figura2 = new Rectangulo();
        Figura figura3 = new Triangulo();
        
        figura0.dibujar();  // Resultado: Dibujando una figura genérica. 
        figura1.dibujar();  // Resultado: Dibujando un círculo.
        figura2.dibujar();  // Resultado: Dibujando un rectángulo.
        figura3.dibujar();  // Resultado: Dibujando un triángulo.
    }
}
