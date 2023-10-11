package copiaEjemplo;

public class EjemploCopiaProfunda {
    public static void main(String[] args) {
        Persona juana = new Persona("Juana", 22, 12345678);
        Persona copiaJuana = juana.clone();

        System.out.println("Original: " + juana);       // Juana, 22, 12345678
        System.out.println("Copia: " + copiaJuana);     // Juana, 22, 12345678

        // Modificar un atributo primitivo no afecta al original
        copiaJuana.setEdad(33);
        // Modificar un atributo referencia no afecta al original
        copiaJuana.setNroDocumento(87654321);
        
        System.out.println("Original: " + juana);        // Juana, 22, 12345678
        System.out.println("Copia: " + copiaJuana);      // Juana, 33, 87654321
    }
}