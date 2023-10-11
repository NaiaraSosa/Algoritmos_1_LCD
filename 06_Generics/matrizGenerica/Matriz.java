package matrizGenerica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matriz<T> {
    List<List<T>> columnas; // Hay relaciones de asociacion y si es con celda iria celda en lugar de T y la T de arriba vuela
    Map<String, Integer> colLabels; // Diccionario que agarra una clave y lo matchea con un valor (asociacion)
    Map<String, Integer> rowLabels;

    public Matriz(int cantidadColumnas) {
        if (cantidadColumnas < 1) 
            throw new IllegalArgumentException("La longitud de columnas debe ser mayor a 0");
        columnas = new ArrayList<>();
        colLabels = new HashMap<>();
        rowLabels = new HashMap<>();
        for (int j=0; j < cantidadColumnas; j++) {
            columnas.add(j, new ArrayList<>());
            colLabels.put(String.valueOf(j), j);
        }
    }

    public Matriz(int cantidadColumnas, String[] etiquetas) {
        this(cantidadColumnas);
        if (cantidadColumnas != etiquetas.length) 
            throw new IllegalArgumentException("La longitud de etiquetas no coincide.");
        setEtiquetasColumnas(etiquetas);
    }

    public Matriz(T[][] matriz) {
        this(matriz[0].length);
        inicializarDesdeMatriz(matriz);
    }

    public Matriz(T[][] matriz, String[] etiquetasColumnas) {
        this(matriz[0].length, etiquetasColumnas);
        inicializarDesdeMatriz(matriz);
    }

    public Matriz(T[][] matriz, String[] etiquetasColumnas, String[] etiquetasFilas) {
        this(matriz, etiquetasColumnas);
        if (columnas.get(0).size() != etiquetasFilas.length)
            throw new IllegalArgumentException("La longitud de etiquetas de filas no coincide.");
        setEtiquetasFilas(etiquetasFilas);
    }

    public void setEtiquetasFilas (String[] etiquetas) {
        rowLabels.clear();
        for (int i=0; i < columnas.get(0).size(); i++) {
            rowLabels.put(etiquetas[i], i);
        }
    }

    public void setEtiquetasColumnas (String[] etiquetas) {
        colLabels.clear();
        for (int j=0; j < columnas.size(); j++) {
            colLabels.put(etiquetas[j], j);
        }
    }

    // Funciona pero dejo el del profesor
    /*private void inicializarDesdeMatriz(T[][] matriz) {
        for (int j = 0; j < columnas.size(); j++) {
            List<T> columna = new ArrayList<>();
            for (int i = 0; i < matriz.length; i++) {
                if (j < matriz[i].length) {
                    columna.add(matriz[i][j]);
                }
            }
            columnas.set(j, columna);
        }
    }*/ 
    
    private void inicializarDesdeMatriz(T[][] matriz) {
        for (int j = 0; j < columnas.size(); j++) {
            for (int i = 0; i < matriz.length; i++) {
                columnas.get(j).add(i, matriz[i][j]);
            }
        }  
        for (int i=0; i < columnas.get(0).size(); i++) {
            rowLabels.put(String.valueOf(i), i);
        }
    }
    
    public static <T> Matriz<T> crearDesdeMatriz(T[][] matriz) {
        return new Matriz<>(matriz);
    }

    public T getCelda(String fila, String columna) {
        return columnas.get(colLabels.get(columna)).get(rowLabels.get(fila)); // columnas[columna][fila]
    }

    public void setCelda(String fila, String columna, T valor) throws MiMatrizException{
        Integer indiceCol = colLabels.get(columna);
        if (indiceCol == null)
            throw new MiMatrizException("Columna inválida: " + columna);
        List<T> col = columnas.get(indiceCol);
        Integer indiceFila = rowLabels.get(fila);
        if (indiceFila == null)
            throw new MiMatrizException("Fila inválida: " + fila);
        col.set(indiceFila, valor);
        //columnas.get(colLabels.get(columna)).set(rowLabels.get(fila), valor)
    }

    @Override
    public String toString() {
        String out = "  | ";
        String sep = " | ";
        for (String label : colLabels.keySet()) {
            out += label + sep;
        }
        out += "\n";
        for(String fila : rowLabels.keySet()) {
            out += fila + sep;
            for (String columna : colLabels.keySet()) {
                out += getCelda(fila, columna);
                out += sep;
            }  
            out += "\n";
        }
        return out;
    }
}
