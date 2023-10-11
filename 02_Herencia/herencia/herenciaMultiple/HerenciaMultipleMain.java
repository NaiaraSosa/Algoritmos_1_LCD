package herencia.herenciaMultiple;

public class HerenciaMultipleMain {
    public static void main(String[] args) {
        Ave miAve = new Ave();
        Pez miPez = new Pez();

        miAve.comer();
        miAve.volar();
        miPez.comer();
        miPez.nadar();
    }
}
