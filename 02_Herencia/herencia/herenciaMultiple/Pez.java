package herencia.herenciaMultiple;
import herencia.Animal;

class Pez extends Animal implements Nadador {
    public void nadar() {
        System.out.println("El pez nada en el agua.");
    }
}
