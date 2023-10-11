package ejemploCopiaProfundaSinClonable;

class Persona {
    private String nombre;
    private int edad;
    private Documento documento;

    public Persona(String nombre, int edad, int nroDocumento) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = new Documento(nroDocumento);
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNroDocumento(int nroDocumento) {
        this.documento.setNumero(nroDocumento);
    }

    @Override
    public String toString() {
        return this.nombre + ", " + this.edad + ", " + this.documento.getNumero();
    }

    // Constructor de copia
    public Persona (Persona original) {
        this.nombre = original.nombre;
        this.edad = original.edad;
        this.documento = new Documento(original.documento.getNumero());
    }

    // Método construcción de copia
    public static Persona copiaProfunda (Persona original) {
        return new Persona(original);
    }

   
}