package ejemploCopiaProfundaSinClonable;

public class Documento implements Cloneable {
    private int numero;

    public Documento(int numero) {
        this.numero = numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
