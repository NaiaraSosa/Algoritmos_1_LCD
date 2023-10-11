package introduccion;

public class Persona {
    //Atributos
    String nombre;
    int edad;
    double altura;

    //Método constructor
    public Persona (String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    //Método
    public void saludar() {
        System.out.println("Hola, soy " + nombre + ", tengo " + edad + " años y mido " + altura + " metros.");
    }

    public static void main(String[] args) {
        // Creamos una instancia de la clase Persona
        Persona juana = new Persona("Juana", 25, 1.71);
        juana.saludar();
    }    
};
