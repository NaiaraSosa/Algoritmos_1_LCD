package ejercicioCalculadora;

public class PruebaCalculadoraAvanzada {
    public static void main (String[] args) {

        CalculadoraAvazada calculadora = new CalculadoraAvazada();

        System.out.println("Suma de enteros: " + calculadora.sumar(8, 4));
        System.out.println("Suma de doubles: " + calculadora.sumar(8.5, 4.5));
        System.out.println("Resta de enteros: " + calculadora.restar(8, 4));
        System.out.println("Resta de doubles: " + calculadora.restar(8.5, 4.5));
        System.out.println("Multiplicación de enteros: " + calculadora.multiplicar(8, 4));
        System.out.println("Multiplicación de doubles: " + calculadora.multiplicar(8.5, 4.5));
        System.out.println("División de enteros: " + calculadora.dividir(8, 4));
        System.out.println("División de doubles: " + calculadora.dividir(8.5, 4.5));
    }
}
