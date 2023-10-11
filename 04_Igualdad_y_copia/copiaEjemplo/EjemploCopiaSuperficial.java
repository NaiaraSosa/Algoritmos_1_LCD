package copiaEjemplo;

public class EjemploCopiaSuperficial {
    public static void main(String[] args) {
        Persona juana = new Persona("Juana", 22, 12345678);
        Persona copiaJuana = juana.copiaSuperficial();

        System.out.println(juana);      // Juana, 22, 12345678
        System.out.println(copiaJuana); // Juana, 22, 12345678

        // Modificar un atributo primitivo no afecta al original
        copiaJuana.setEdad(33);
        // Modificar un atributo referencia sí afecta al original
        copiaJuana.setNroDocumento(87654321);
        
        System.out.println(juana);      // Juana, 22, 87654321
        System.out.println(copiaJuana); // Juana, 33, 87654321
    }
}