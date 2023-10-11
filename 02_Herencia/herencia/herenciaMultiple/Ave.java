package herencia.herenciaMultiple;
import herencia.Animal;

class Ave extends Animal implements Volador{
    public void volar(){
        System.out.println("El ave vuela en el cielo.");;
    }
}
