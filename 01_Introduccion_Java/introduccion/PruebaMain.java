package introduccion;
// EL MÉTODO MAIN
// La firma del método es la siguiente: public static void main(String[] args)
// En general sólo implementaremos este método en sólo una clase en nuestro programa, la cual será la clase a ejecutar.

public class PruebaMain {
    public static void main(String[] args) {
        for (int i=0; i < args.length; i++) {
            System.out.println("Argumento " + i + ": " + args[i]);
        }
    }
}

