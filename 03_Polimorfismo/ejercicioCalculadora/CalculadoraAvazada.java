// EJERCICIO SOBRECARGA

package ejercicioCalculadora;

public class CalculadoraAvazada {

    public int sumar(int a, int b) {
        return a+b;
    }

    public double sumar(double a, double b) {
        return a + b;
    }
    public int restar(int a, int b) {
        return a - b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public int multiplicar (int a, int b) {
        return a * b;
    }
    public double multiplicar(double a, double b) {
        return a * b;
    }

    public int dividir(int a, int b) {
        return a / b;
    }

    public double dividir(double a, double b) {
        return a / b;
    }
}
