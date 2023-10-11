package ejercicioListaGenerica;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

public class ListaGenerica <E> extends AbstractList<E> {
    private static final int CAPACIDAD_INICIAL = 10;
    private Object[] elementos;
    private int size = 0;

    public ListaGenerica() {
        elementos = new Object[CAPACIDAD_INICIAL]; // Puedo meter cualqur cosa aca
        size = 0;
    }

    @Override
    public E set (int index, E elemento) {
        elementos[index] = elemento;
        return elemento;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        return (E) elementos[index];
    }

    @Override
    public boolean add (E elemento) {
        if (size == elementos.length) {
            int nuevaCapacidad = elementos.length * 2;
            elementos = Arrays.copyOf(elementos, nuevaCapacidad);
        }
        set (size, elemento);
        size++;
        return true;
    }

    @Override
    public void add (int index, E elemento) {
        set(index, elemento);
        size++;
    }

    public void remover (int index) {
        int i = 0;
        boolean encontrado = false;
        while (i < size - 1) {
            if (encontrado || index == i) {
                encontrado = true;
                elementos[i] = elementos[i + 1];
            }
            i++;
        }
        if (encontrado || index == size - 1) {
            elementos[i] = null;
            size--;
        }
    }

    //Agrego los metodos de la superclase porq sino putea
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Unimplemented method 'addAll'");
    }

    public static void main(String[] args) {
        ListaGenerica<Integer> listaEnteros = new ListaGenerica<>();
        listaEnteros.add(1);
        listaEnteros.add(2);
        listaEnteros.add(2, 3);
        listaEnteros.add(5);
        //listaEnteros.remove(4);
        System.out.println(listaEnteros);
    }
}
