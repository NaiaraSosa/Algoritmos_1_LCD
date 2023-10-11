package ejemploCopiaProfundaSinClonable;

public class Main {
    public static void main(String[] args) {
        // Constructor de copia
        Persona naiara = new Persona("Naiara", 20, 44792224);
        Persona copiaNaiara = new Persona(naiara);
        // Probamos
        System.out.println("Original: " + naiara);       // Original: Naiara, 20, 44792224
        System.out.println("Copia: " + copiaNaiara);     // Copia: Naiara, 20, 44792224
        // Modificar un atributo primitivo no afecta al original
        copiaNaiara.setEdad(25);
        // Modificar un atributo referencia no afecta al original
        copiaNaiara.setNroDocumento(87654321);
        System.out.println("Original: " + naiara);        // Original: Naiara, 20, 44792224
        System.out.println("Copia modificada: " + copiaNaiara);      // Copia modificada: Naiara, 25, 87654321
        

        // Constructor de copia
        Persona ezequiel = new Persona("Ezequiel", 20, 44513456);
        Persona copiaEzequiel = Persona.copiaProfunda(ezequiel);
        // Probamos
        System.out.println("Original: " + ezequiel);       // Original: Ezequiel, 20, 44513456
        System.out.println("Copia: " + copiaEzequiel);     // Copia: Ezequiel, 20, 44513456
        // Modificar un atributo primitivo no afecta al original
        copiaEzequiel.setEdad(32);
        // Modificar un atributo referencia no afecta al original
        copiaEzequiel.setNroDocumento(12356985);
        System.out.println("Original: " + ezequiel);        // Original: Ezequiel, 20, 44513456
        System.out.println("Copia modificada: " + copiaEzequiel);      // Copia modificada: Ezequiel, 32, 12356985
    }
}
