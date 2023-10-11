//Ejemplo con Tipos de Parámetros Diferente

package polimorfismo.polimorfismoSobrecarga;
public class Balanza {
    public double convertir(double libras) {
        return libras * 0.45359237;
    }
    
    public double convertir(double libras, String unidad) {
        if (unidad.equals("kg")) {
            return libras * 0.45359237;
        } else if (unidad.equals("g")) {
            return libras * 453.59237;
        } else {
            throw new IllegalArgumentException("Unidad no válida: " + unidad);
        }
    }
    
    public static void main(String[] args) {
        Balanza balanza = new Balanza();
        System.out.println("5 libras en kg: " + balanza.convertir(5));
        System.out.println("10 libras en g: " + balanza.convertir(10, "g"));
    }
}