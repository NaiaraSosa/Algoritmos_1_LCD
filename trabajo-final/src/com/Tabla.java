package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import excepciones.*;

/**
 * La clase Tabla permite generar una estructura de datos.
 * 
 * @author Grupo4 - Giorgetti, Nicolás - Molena, Ivana - Sosa, Naiara - Strika,
 *         Camila - Vazquez, Lucía
 * @version 0.9
 * @see <a href=https://www.taylorswift.com/ /> It's me, hi, I'm the Dataframe,
 *      it's me </a>
 */

public class Tabla {
    private List<Columna> tabla;
    private List<String> headers;
    private List<String> order;
    private Map<String, Integer> colLabels = new LinkedHashMap<>();
    private Map<String, Integer> rowLabels = new LinkedHashMap<>();
    private List<String> lineas = null;

    /**
     * Crea una tabla dada una matriz de Strings
     * 
     * @param tiposDato  Array de Strings con los tipos de datos de las columnas, en
     *                   orden.
     * @param datos      Los datos en un Array de Array de Strings
     * @param hasHeaders true si datos tiene los headers en la fila 1, false de lo
     *                   contrario. Si es falso la tabla se crea un headers
     *                   numéricos secuenciales
     */
    protected Tabla(String[] tiposDato, String[][] datos, boolean hasHeaders, String delimiter) {
        List<String> lineas = new LinkedList<>();
        StringBuffer sb;
        for (String[] c : datos) {
            sb = new StringBuffer();
            for (int i = 0; i < c.length; i++) {
                sb.append(c[i] + delimiter); // no me juzguen
            }
            String str = sb.toString();
            lineas.add(str);
        }
        try {
            if (hasHeaders) {
                if (!lineas.isEmpty()) {
                    String[] encabezados = lineas.get(0).split(delimiter);
                    List<String> headers = new ArrayList<>();
                    for (int j = 0; j < encabezados.length; j++) {
                        headers.add(encabezados[j]);
                        colLabels.put(headers.get(j), j);
                    }
                    lineas.remove(0);
                    this.headers = headers;
                }
            } else {
                List<String> headers = new ArrayList<>();
                for (int j = 0; j < lineas.get(0).split(delimiter).length; j++) {
                    colLabels.put(String.valueOf(j), j);
                    headers.add(String.valueOf(j));
                }
                this.headers = headers;
            }
            String[][] data = CSVUtils.parserCSV(lineas, tiposDato.length, delimiter);
            if (data.length <= 0) {
                throw new IllegalArgumentException("No se encontraron datos en el archivo CSV.");
            }
            tabla = new ArrayList<>();
            for (String tipoDato : tiposDato) {
                Columna columna = new Columna(tipoDato, data.length);
                tabla.add(columna);
            }
            llenarTabla(data, tiposDato);
            List<String> order = new ArrayList<>();
            for (int k = 0; k < tabla.get(0).size(); k++) {
                rowLabels.put(String.valueOf(k), k);
                order.add(String.valueOf(k));
            }
            this.order = order;
        } catch (InvalidDataTypeException e) {
            e.printStackTrace();
            System.err.println("Chequear los tipos de datos.");
        } catch (IllegalConstructorException e) {
            e.printStackTrace();
            System.err.println("Check for aproppiate constructor");
        }
        this.lineas = lineas;
    }

    /**
     * Constructor de una tabla desde un archivo CSV sin encabezados.
     * 
     * @param tiposDato String[] indicando los tipos de dato
     * @param datos     List<String> Con los datos para cargar en tabla
     * 
     */
    protected Tabla(String[] tiposDato, String filename, String delimiter) {
        try {
            lineas = CSVUtils.leerCSV(filename);
            if (lineas.get(0).split(delimiter).length != tiposDato.length) {
                throw new IncorrectHeaderCountException(
                        "La cantidad de columnas y tipos de datos no coinciden.");
            }
            List<String> headers = new ArrayList<>();
            for (int j = 0; j < lineas.get(0).split(delimiter).length; j++) {
                colLabels.put(String.valueOf(j), j);
                headers.add(String.valueOf(j));
            }
            this.headers = headers;
            for (int j = 0; j < lineas.get(0).split(delimiter).length; j++) {
                colLabels.put(String.valueOf(j), j);
                headers.add(String.valueOf(j));
            }
            this.headers = headers;
            String[][] datos = CSVUtils.parserCSV(lineas, tiposDato.length, delimiter);
            if (datos.length <= 0) {
                throw new IllegalArgumentException(
                        "No se encontraron datos en el archivo CSV.");
            }
            tabla = new ArrayList<>();
            for (String tipoDato : tiposDato) {
                Columna columna = new Columna(tipoDato, datos.length);
                tabla.add(columna);
            }
            llenarTabla(datos, tiposDato);
            List<String> order = new ArrayList<>();
            for (int k = 0; k < tabla.get(0).size(); k++) {
                rowLabels.put(String.valueOf(k), k);
                order.add(String.valueOf(k));
            }
            this.order = order;
        } catch (IOException e) {
            System.err.println(e + " \nNo puedo avanzar sin archivo");
            System.exit(1);
        } catch (InvalidDataTypeException e) {
            e.printStackTrace();
            System.err.println("Chequear los tipos de datos.");
            System.exit(1);
        } catch (IncorrectHeaderCountException e) {
            e.printStackTrace();
            System.err.println("Check data type array");
            System.exit(1);
        }
    }

    /**
     * Constructor de una tabla desde un archivo CSV con headers
     * 
     * @param tiposDato  String[] indicando los tipos de dato
     * @param fileName   String con el path hacia el archivo
     * @param hasHeaders boolean de si el archivo tiene headers o no
     */
    protected Tabla(String[] tiposDato, String fileName, boolean hasHeaders, String delimiter) {
        try {
            lineas = CSVUtils.leerCSV(fileName);
            if (lineas.get(0).split(delimiter).length != tiposDato.length) {
                throw new IncorrectHeaderCountException(
                        "La cantidad de columnas y tipos de datos no coinciden.");
            }
            if (hasHeaders) {
                if (!lineas.isEmpty()) {
                    String[] encabezados = lineas.get(0).split(delimiter);
                    List<String> headers = new ArrayList<>();

                    for (int j = 0; j < encabezados.length; j++) {
                        headers.add(encabezados[j]);
                        colLabels.put(headers.get(j), j);
                    }
                    lineas.remove(0);
                    this.headers = headers;
                }
            } else {
                throw new IllegalConstructorException(
                        "Si no tiene headers, use el constructor apropiado");
            }
            String[][] datos = CSVUtils.parserCSV(lineas, tiposDato.length, delimiter);
            if (datos.length <= 0) {
                throw new IllegalArgumentException(
                        "No se encontraron datos en el archivo CSV.");
            }
            tabla = new ArrayList<>();
            for (String tipoDato : tiposDato) {
                Columna columna = new Columna(tipoDato, datos.length);
                tabla.add(columna);
            }
            llenarTabla(datos, tiposDato);
            List<String> order = new ArrayList<>();
            for (int k = 0; k < tabla.get(0).size(); k++) {
                rowLabels.put(String.valueOf(k), k);
                order.add(String.valueOf(k));
            }
            this.order = order;
        } catch (IOException e) {
            System.err.println(e + " \nNo puedo avanzar sin archivo");
            System.exit(1);
        } catch (InvalidDataTypeException e) {
            e.printStackTrace();
            System.err.println("Chequear los tipos de datos.");
            System.exit(1);
        } catch (IncorrectHeaderCountException e) {
            e.printStackTrace();
            System.err.println("Check data type array");
            System.exit(1);
        } catch (IllegalConstructorException e) {
            e.printStackTrace();
            System.err.println("Check for aproppiate constructor");
            System.exit(1);
        }
    }

    /**
     * Crea una tabla especificando keys para las columnas.
     * @deprecated, por lo tanto no se recomienda su uso y en versiones
     * futuras este constructor va a ser removido
     * Se queda por valor histórico (?)
     * 
     * @param tiposDato  lista de tipos de datos
     * @param fileName   path al archivo csv
     * @param hasHeaders si el archivo tiene headers
     * @param hasRowKey  si las filas del archivo tienen una clave
     * @param columnaKey la key de la columna que debe ser tratada como clave
     */
    @Deprecated
    protected Tabla(String[] tiposDato, String fileName,
            boolean hasHeaders, boolean hasRowKey, int columnaKey) {

        try {
            lineas = CSVUtils.leerCSV(fileName);
            if (lineas.get(0).split(",").length != tiposDato.length) {
                throw new IncorrectHeaderCountException(
                        "La cantidad de columnas y tipos de datos no coinciden.");
            }
            if (hasHeaders) {
                if (!lineas.isEmpty()) {
                    String[] encabezados = lineas.get(0).split(",");
                    List<String> headers = new ArrayList<>();

                    for (int j = 0; j < encabezados.length; j++) {
                        headers.add(encabezados[j]);
                        colLabels.put(headers.get(j), j);
                    }
                    lineas.remove(0);
                    this.headers = headers;
                }
            } else {
                throw new IllegalConstructorException(
                        "Si no tiene headers, use el constructor apropiado.");
            }
            String[][] datos = CSVUtils.parserCSV(lineas, tiposDato.length, ",");
            if (datos.length <= 0) {
                throw new IllegalArgumentException("No se encontraron datos en el archivo CSV.");
            }
            tabla = new ArrayList<>();
            for (String tipoDato : tiposDato) {
                Columna columna = new Columna(tipoDato, datos.length);
                tabla.add(columna);
            }
            llenarTabla(datos, tiposDato);
            if (hasRowKey) {
                List<String> order = new ArrayList<>();
                int i = 0;
                for (Celda celda : tabla.get(columnaKey).getCeldas()) {
                    rowLabels.put(String.valueOf(celda.getContenido()), i);
                    order.add(String.valueOf(celda.getContenido()));
                }
                if (order.size() == rowLabels.keySet().size()) {
                    this.order = order;
                } else {
                    throw new IllegalLabelException("La columna dada no es una key");
                }
            } else {
                throw new IllegalConstructorException("Si no tiene clave, use el constructor apropiado");
            }
        } catch (IOException e) {
            System.err.println(e + " \nNo puedo avanzar sin archivo");
            System.exit(1);
        } catch (InvalidDataTypeException e) {
            e.printStackTrace();
            System.err.println("Check data types");
            System.exit(1);
        } catch (IncorrectHeaderCountException e) {
            e.printStackTrace();
            System.err.println("Check data type array");
            System.exit(1);
        } catch (IllegalConstructorException e) {
            e.printStackTrace();
            System.err.println("Check for aproppiate constructor");
            System.exit(1);
        } catch (IllegalLabelException e) {
            e.printStackTrace();
            System.err.println("Check if the given column is actually a key");
            System.exit(1);
        }
    }

    /**
     * Genera una tabla vacía
     * Esto es utilizado para un shallowCopy
     * 
     */
    protected Tabla() {
        this.tabla = new ArrayList<>();
        this.headers = new ArrayList<>();
        this.order = new ArrayList<>();
        this.colLabels = new LinkedHashMap<>();
        this.rowLabels = new LinkedHashMap<>();
        this.lineas = new ArrayList<>();
    }

    /**
     * Crea una tabla usando una tabla
     * Esto es utilizado par aun un deep copy
     * 
     * @param t tabla a copiar
     */
    private Tabla(Tabla t) {
        List<Columna> ct = new ArrayList<>();
        List<String> ht = new ArrayList<>();
        List<String> ot = new ArrayList<>();
        Map<String, Integer> colT = new LinkedHashMap<>();
        Map<String, Integer> rowT = new LinkedHashMap<>();
        List<String> lt = new ArrayList<>();
        for (Columna c : t._dameTabla()) {
            ct.add((Columna) c.clone());
        }
        this.tabla = ct;
        for (String h : t._dameHeaders()) {
            ht.add(h.toString());
        }
        this.headers = ht;
        for (String h : t._dameOrder()) {
            ot.add(h.toString());
        }
        this.order = ot;
        for (Map.Entry<String, Integer> entry : t._dameColLabels().entrySet()) {
            colT.put(entry.getKey(), entry.getValue());
        }
        this.colLabels = colT;
        for (Map.Entry<String, Integer> entry : t._dameRowLabels().entrySet()) {
            rowT.put(entry.getKey(), entry.getValue());
        }
        this.rowLabels = rowT;
        for (String l : t._dameLineas()) {
            lt.add(l.toString());
        }
        this.lineas = lt;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        // detecto del ancho de columna
        int[] anchoColumna = new int[headers.size()];

        // Obtener el orden de las filas
        List<String> orderFilas = order;

        // Calcular la longitud máxima de cada columna
        for (int i = 0; i < headers.size(); i++) {
            String header = headers.get(i);
            anchoColumna[i] = Math.max(anchoColumna[i], header.length());
        }

        // Agregar labels de columna si hay
        for (int i = 0; i < headers.size(); i++) {
            String header = headers.get(i);
            out.append(String.format("%" + (anchoColumna[i] + 6) + "s", centrarTexto(header)));
        }
        out.append("\n");

        // Agregar divisiones entre las columnas
        for (int i = 0; i < headers.size(); i++) {
            out.append(String.format("%-" + (anchoColumna[i] + 8) + "s", "").replace(' ', '-'));
        }
        out.append("\n");
        // if (cantFilas() > 20) {
        if (orderFilas.size() > 50) {
            // Iterar y agregar filas en el orden especificado
            for (int rowIndex = 0; rowIndex < 5; rowIndex++) {
                String filaKey = orderFilas.get(rowIndex);
                if (!rowLabels.containsKey(filaKey)) {
                    throw new IllegalArgumentException("La fila con la clave " + filaKey + " no existe en la tabla.");
                }
                // Agregar la etiqueta de fila
                out.append(String.format("%-" + 8 + "s", filaKey));
                for (int i = 0; i < headers.size(); i++) {
                    String header = headers.get(i);
                    int columnIndex = colLabels.get(header);
                    Celda celda = tabla.get(columnIndex).getCelda(Integer.valueOf(filaKey));
                    String contenido = (celda.getContenido() == null) ? "NA" : String.valueOf(celda.getContenido());
                    out.append(String.format("%-" + (anchoColumna[i] + 6) + "s", contenido));
                }
                out.append("\n");
            }
            // Si hay más de 20 filas, agregar tres puntos suspensivos y mostrar las últimas
            // 5 filas
            out.append("... (y otras " + (orderFilas.size() - 10) + " filas)\n");

            for (int rowIndex = orderFilas.size() - 5; rowIndex < orderFilas.size(); rowIndex++) {
                String filaKey = orderFilas.get(rowIndex);

                if (!rowLabels.containsKey(filaKey)) {
                    throw new IllegalArgumentException("La fila con la clave " + filaKey + " no existe en la tabla.");
                }
                // Agregar la etiqueta de fila
                out.append(String.format("%-" + 8 + "s", filaKey));
                for (int i = 0; i < headers.size(); i++) {
                    String header = headers.get(i);
                    int columnIndex = colLabels.get(header);
                    Celda celda = tabla.get(columnIndex).getCelda(Integer.valueOf(filaKey));
                    String contenido = (celda.getContenido() == null) ? "NA" : String.valueOf(celda.getContenido());
                    contenido = contenido.length() > 40 ? contenido.substring(0, 37) + "..." : contenido;
                    out.append(String.format("%-" + (anchoColumna[i] + 6) + "s", contenido));
                }
                out.append("\n");
            }
        } else {

            for (String filaKey : orderFilas) {
                if (!rowLabels.containsKey(filaKey)) {
                    throw new IllegalArgumentException("La fila con la clave " + filaKey + " no existe en la tabla.");
                }

                int rowIndex = rowLabels.get(filaKey);

                // Agregar la etiqueta de fila
                out.append(String.format("%-" + 8 + "s", filaKey));

                for (int i = 0; i < headers.size(); i++) {
                    String header = headers.get(i);
                    int columnIndex = colLabels.get(header); // Obtener el índice de la columna a partir del header
                    Celda celda = tabla.get(columnIndex).getCelda(rowIndex);
                    String contenido = (celda.getContenido() == null) ? "NA" : String.valueOf(celda.getContenido());
                    contenido = contenido.length() > 40 ? contenido.substring(0, 37) + "..." : contenido;
                    out.append(String.format("%-" + (anchoColumna[i] + 6) + "s", contenido));
                }
                out.append("\n");
            }
        }
        return out.toString();
    }

    /**
     * Da una representación de la tabla en una string
     * 
     * @param headers   true if you want headers
     * @param delimiter the delimiter of the csv. "defaults" to ,
     * @return a String representation
     */
    protected String toString(boolean headers, String delimiter) {
        if (delimiter == null) {
            delimiter = ",";
        }
        StringBuilder out = new StringBuilder();
        int count = 0;
        if (headers == true) {
            for (String label : colLabels.keySet()) {
                count++;
                if (count < colLabels.keySet().size()) {
                    out.append(label).append(delimiter);
                } else {
                    out.append(label);
                }
            }
            out.append("\n");
        }
        for (int fila = 0; fila < cantFilas(); fila++) {
            for (int columna = 0; columna < tabla.size(); columna++) {
                Celda celda = tabla.get(columna).getCelda(fila);
                if (columna != tabla.size() - 1) {
                    out.append(celda.getContenido()).append(delimiter);
                } else {
                    out.append(celda.getContenido());
                }
            }
            out.append("\n");
        }
        return out.toString();
    }

    /**
     * Devuelve cantidad de columas en la tabla
     * 
     * @deprecated To be removed
     * @return cantidad de columnas
     */
    @Deprecated
    public int countColumns() {
        return this._dameTabla().size();
    }

    /**
     * Devuelve la columna con la etiqueta especificada.
     * 
     * @param key String -> la clave de la Columna
     */
    public Columna getColumna(String key) {
        if (!this._dameColLabels().containsKey(key)) {
            throw new IllegalArgumentException("No existe la columna '" + key + "' en la tabla.");
        }
        return this._dameTabla().get(colLabels.get(key));
    }

    /**
     * Devuelve la fila con la etiqueta especificada.
     * 
     * @param key String -> la clave de la Fila
     */
    public Fila getFila(String key) {
        if (!this._dameRowLabels().containsKey(key)) {
            throw new IllegalArgumentException("No existe la fila '" + key + "' en la tabla.");
        }
        Fila fila = new Fila();
        for (Columna col : tabla) {
            Celda celda = col.getCelda(rowLabels.get(key));
            fila.addCelda(celda);
        }
        return fila;
    }

    /**
     * Devuelve la celda con las etiqueta especificada.
     * 
     * @param keyFila    String key de la fila
     * @param keyColumna String key de la columna
     */
    public Celda getCelda(String keyFila, String keyColumna) {
        if (!colLabels.containsKey(keyColumna)) {
            throw new IllegalArgumentException("No existe la columna '" + keyColumna + "' en la tabla.");
        }
        if (!rowLabels.containsKey(keyFila)) {
            throw new IllegalArgumentException("No existe la fila '" + keyFila + "' en la tabla.");
        }
        return tabla.get(colLabels.get(keyColumna)).getCelda(rowLabels.get(keyFila));
    }

    /**
     * Setea una columna nueva, manteniendo la etiqueta.
     * 
     * @param newColumna
     * @param key
     */
    public void setColumna(Columna newColumna, String key) {
        if (newColumna.size() != cantFilas()) {
            throw new LengthMismatchException("El tamaño de la columna nueva no coincide con la cantidad de filas.");
        }
        if (!colLabels.containsKey(key)) {
            throw new IllegalLabelException("La columna '" + key + "' no existe en la tabla.");
        }
        int indiceActual = colLabels.get(key);
        for (int i = 0; i < cantFilas(); i++) {
            tabla.get(indiceActual).getCeldas().set(i, newColumna.getCelda(i));
        }
    }

    /**
     * Setea una columna, generando una nueva etiqueta.
     * 
     * @param newColumna
     * @param oldKey
     * @param newKey
     */
    public void setColumna(Columna newColumna, String oldKey, String newKey) {
        if (colLabels.containsKey(newKey)) {
            throw new IllegalLabelException(
                    "La nueva etiqueta ya corresponde a otra columna y no puede ser duplicada.");
        }
        setColumna(newColumna, oldKey);
        int indiceViejo = colLabels.get(oldKey);
        colLabels.remove(oldKey);
        colLabels.put(newKey, indiceViejo);
        headers.set(indiceViejo, newKey);
    }

    /**
     * Setea la fila manteniendo la etiqueta.
     * 
     * @param newFila
     * @param key
     */
    public void setFila(Fila newFila, String key) {
        if (newFila.size() != tabla.size()) {
            throw new LengthMismatchException("El tamaño de la fila nueva no coincide con la cantidad de columnas.");
        }
        if (!rowLabels.containsKey(key)) {
            throw new IllegalLabelException("La fila " + key + " no existe en la tabla.");
        }
        int indiceActual = rowLabels.get(key);
        for (int i = 0; i < newFila.size(); i++) {
            tabla.get(i).getCeldas().set(indiceActual, newFila.getCelda(i));
        }
    }

    /**
     * Reemplaza el contenido de una fila por una nueva, cambia la label sirve solo
     * para rowkeys no numericas, sino no tiene sentido
     * 
     * @param newFila
     * @param oldKey
     * @param newKey
     */
    public void setFila(Fila newFila, String oldKey, String newKey) {
        if (rowLabels.containsKey(newKey)) {
            throw new IllegalLabelException("La nueva etiqueta ya corresponde a otra fila y no puede ser duplicada.");
        }
        setFila(newFila, oldKey);
        int indiceViejo = rowLabels.get(oldKey);
        rowLabels.remove(oldKey);
        rowLabels.put(newKey, indiceViejo);
        order.set(indiceViejo, newKey);
    }

    /**
     * Reemplaza el contenido de una celda
     * 
     * @param keyFila    String key de la Fila
     * @param keyColumna String key de la Columna
     * @param value      valor a ser reemplazado
     * @throws InvalidDataTypeException
     *                                  Si el tipo de dato de value no corresponde
     *                                  con el de la columna, tirra este error
     */
    public void setCelda(String keyFila, String keyColumna, Celda newCelda) {
        Celda celda = getCelda(keyFila, keyColumna);
        // System.out.println(celda);
        // Verifica si la celda tiene un contenido actual y si no son compatibles tira
        // una excepción
        if (celda.getContenido() != null) {
            if (!celda.getClass().equals(newCelda.getClass())) {
                throw new InvalidDataTypeException("El contenido de la celda es del tipo " + celda.getClass()
                        + " y la nueva celda es " + newCelda.getClass() + ".");
            }
        }
        celda.setContenido(newCelda.getContenido());
    }

    /**
     * Agrego una columna al final de la tabla sin header
     * 
     * @deprecated porque deberia estar siempre un header
     *             En futuras versiones deberia ser removido. no es recomendable su
     *             uso
     * @param nuevaCol
     */
    @Deprecated
    public void addColumna(Columna nuevaCol) {
        tabla.add(nuevaCol);
        colLabels.put(String.valueOf(ultimoIndice()), ultimoIndice());
        headers.add(String.valueOf(tabla.size()));
    }

    /**
     * Agrego una columna al final de la tabla con label (header)
     * 
     * @param nuevaCol Columna a agregar
     * @param label    label de la columna
     */
    public void addColumna(Columna nuevaCol, String label) {
        if (nuevaCol.size() != cantFilas()) {
            throw new IllegalArgumentException(
                    "La cantidad de datos de la columna no corresponde con el tamaño de la tabla.");
        }
        if (colLabels.containsKey(label)) {
            throw new IllegalLabelException("Ya existe una columna con ese nombre");
        }
        tabla.add(nuevaCol);
        colLabels.put(label, ultimoIndice());
        headers.add(label);
    }

    /**
     * Borro una columna dada una key
     * 
     * @param key key de la Columna a eliminar
     */
    public void removeColumna(String key) {
        if (!colLabels.containsKey(key)) {
            throw new IllegalLabelException("Este encabezado no existe");
        }
        int index = colLabels.get(key);
        tabla.remove(index);
        for (String header : headers) {
            if (colLabels.get(header) > index) {
                colLabels.put(header, colLabels.get(header) - 1);
                colLabels.remove(key);
            }
        }
        headers.remove(index);
    }

    /**
     * Agrego una fila a la tabla
     * 
     * @param nuevaFila Fila a agregar
     */
    public void addFila(Fila nuevaFila) {
        if (nuevaFila.size() != tabla.size()) {
            throw new IllegalArgumentException(
                    "La cantidad de datos de la fila no corresponde con el tamaño de la tabla.");
        }
        if (contieneFila(nuevaFila)) {
            throw new IllegalLibraryUse("No se permite duplicar las filas.");
        }
        for (int i = 0; i < tabla.size(); i++) {
            Celda celdaActual = tabla.get(i).getCeldas().get(i);
            Celda celdaNueva = nuevaFila.getCelda(i);

            if (celdaActual.getContenido() != null
                    && !celdaActual.getClass().equals(celdaNueva.getClass())) {
                throw new InvalidDataTypeException("El tipo de dato de la nueva fila en la columna " + (i + 1)
                        + " no coincide con el tipo de dato de la tabla.");
            }

            tabla.get(i).addCelda(nuevaFila.getCeldas().get(i));
        }
        rowLabels.put(String.valueOf(cantFilas() - 1), cantFilas() - 1);
        order.add(String.valueOf(cantFilas() - 1));
    }

    /**
     * Borro una fila dada una key
     * 
     * @param key Key de la fila a eliminar
     */
    public void removeFila(String key) {
        if (!rowLabels.containsKey(key)) {
            throw new IllegalArgumentException("No existe la fila " + key + ".");
        }
        int rowIndex = rowLabels.get(key);
        for (Columna col : tabla) {
            col.removeCelda(rowLabels.get(key));
            order.remove(key);
        }
        for (String row : order) {
            if (rowLabels.get(row) > rowIndex) {
                rowLabels.put(row, rowLabels.get(row) - 1);
            }
        }
    }

    /**
     * Muestra en stdout una tabla con información
     * "Nombre", "NonNull", "TipoDato"
     * Adicionalmente Muestra la cantidad de columnas y cantidad de filas
     */
    public void infoBasica() {
        TablaUtils.doBasic(this);
    }

    /**
     * Copia la tabla en otra tabla. La nueva tabla es independiente de la original
     * entonces
     * copia != original == true
     * 
     * @return Tabla nueva
     */
    public Tabla deepCopy() {
        return new Tabla(this);
    }

    /**
     * Devuelve una copia superficial de la tabla
     * 
     * @return Tabla nueva (copia superficial)
     */
    public Tabla shallowCopy() {
        Tabla t = new Tabla();
        t.tabla = this.tabla;
        t.headers = this.headers;
        t.order = this.order;
        t.colLabels = this.colLabels;
        t.rowLabels = this.rowLabels;
        t.lineas = this.lineas;
        return t;
    }

    /** Muestra las primeras 10 líneas de la tabla */
    public void head() {
        TablaUtils.head(this);
    }

    /**
     * Muestra las primeras n líneas de la tabla
     * 
     * @param n filas de la tabla a mostrar
     */
    public void head(int n) {
        // TODO: Heads grandes a veces hacen una "race condition" con cortar la tabla
        TablaUtils.head(this, n);
    }

    /**
     * Muestra las últimas 10 filas de la tabla
     */
    public void tail() {
        TablaUtils.tail(this);
    }

    /**
     * Muestra las últimas n filas de la tabla
     * 
     * @param n
     */
    public void tail(int n) {
        TablaUtils.tail(this, n);
    }

    /**
     * Ordena la tabla dada una cantidad de columnas
     * 
     * @param columnas
     * @return Una tabla ordenada
     */
    public Tabla sort(String[] columnas) {
        return TablaUtils.doSort(this, columnas);
    }

    /**
     * Filtra dado un preodicado
     * 
     * @param condicion
     * @return Tabla filtrada
     */
    public Tabla filtrar(Predicate<Fila> condicion) {
        return TablaUtils.filtrar(this, condicion);
    }

    /**
     * Seleccionar columnas y filas
     * 
     * @param etiquetaFilas ------------------
     * 
     */
    public Tabla seleccionar(String[] etiquetaColumnas, String[] etiquetaFilas) {
        return TablaUtils.seleccionar(this, etiquetaColumnas, etiquetaFilas);
    }

    /**
     * Seleccionar columnas
     * 
     * @param etiquetaColumnas
     * @return Tabla reducida
     */
    public Tabla seleccionarColumnas(String[] etiquetaColumnas) {
        return TablaUtils.seleccionarColumnas(this, etiquetaColumnas);
    }

    /**
     * Seleccionar filas
     * 
     * @param etiquetaFilas
     * @return Tabla reducida
     */
    public Tabla seleccionarFilas(String[] etiquetaFilas) {
        return TablaUtils.seleccionarFilas(this, etiquetaFilas);
    }

    /**
     * Concatena
     * 
     * @param other Otra Tabla
     * @return
     */
    public Tabla concatenarTabla(Tabla other) {
        return TablaUtils.concatenate(this, other);
    }

    /**
     * Genera un sample de la tabla
     * 
     * @param porcentaje
     * @return
     */
    public Tabla sample(int porcentaje) {
        return TablaUtils.doSample(this, porcentaje);
    }

    protected List<Columna> _dameTabla() {
        return this.tabla;
    }

    protected List<String> _dameHeaders() {
        return this.headers;
    }

    protected List<String> _dameOrder() {
        return this.order;
    }

    protected Map<String, Integer> _dameColLabels() {
        return this.colLabels;
    }

    protected Map<String, Integer> _dameRowLabels() {
        return this.rowLabels;
    }

    protected List<String> _dameLineas() {
        return this.lineas;
    }

    private void llenarTabla(String[][] datos, String[] tiposDato) throws InvalidDataTypeException {
        for (int index_columna = 0; index_columna < tiposDato.length; index_columna++) {
            Columna columna = tabla.get(index_columna);

            if (!columna.sonMismosTipos()) {
                throw new InvalidDataTypeException(
                        "Los tipos de datos en la columna no coinciden.");
            }
            for (int index_fila = 0; index_fila < datos.length; index_fila++) {
                Celda celda = columna.getCelda(index_fila);
                String valor = datos[index_fila][index_columna];
                if (valor != null) {
                    // Si el tipo de dato es Boolean lo convierte y asigna a una celda.
                    if (tiposDato[index_columna].equals("Boolean")) {
                        valor = valor.replaceAll("\\s", ""); // remove whitespace
                        boolean valorBoolean = Boolean.parseBoolean(valor);
                        celda.setContenido(valorBoolean);
                        // Si el tipo de dato es Number lo convierte y asigna a una celda.
                    } else if (tiposDato[index_columna].equals("Number")) {
                        valor = valor.replaceAll("\\s", ""); // remove whitespaces on Numbers
                        try {
                            if (valor.contains(".")) {
                                Double valorDouble = Double.parseDouble(valor);
                                celda.setContenido(valorDouble);
                            } else {
                                Integer valorInteger = Integer.parseInt(valor);
                                celda.setContenido(valorInteger);
                            }
                        } catch (NumberFormatException e) {
                            throw new InvalidDataTypeException("Valor: " + valor + " no pudo ser parseado.");
                        }
                        // Si el tipo de dato es String lo convierte y asigna a una celda.
                    } else if (tiposDato[index_columna].equals("String")) {
                        celda.setContenido(valor);
                    }

                    // Verificar si los tipos de las celdas son iguales NO FUNCIONA
                    if (!columna.sonMismosTipos()) {
                        throw new InvalidDataTypeException("Los tipos de datos en la columna no coinciden.");
                    }

                } else {
                    columna.fillNA();
                }
            }
        }
    }

    // Método para centrar el texto en una columna
    protected String centrarTexto(String texto) {
        int anchoTotal = 15; // Puedes ajustar el ancho deseado
        int padding = (anchoTotal - texto.length()) / 2;
        return String.format("%" + (padding + texto.length()) + "s", texto);
    }

    // --METODOS
    // UTILES--------------------------------------------------------------------------------------------------
    protected int cantFilas() {
        /**
         * Devuelve la cantidad de filas en la tabla.
         */
        return tabla.get(0).size();
    }

    private int ultimoIndice() {
        return tabla.size() - 1;
    }

    private boolean contieneFila(Fila fila) {
        for (String rowKey : order) {
            Fila row = getFila(rowKey);
            if (fila.equals(row)) {
                return true;
            }
        }
        return false;
    }

    public void setTabla(List<Columna> tabla) {
        this.tabla = tabla;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public void setOrder(List<String> order) {
        this.order = order;
    }

    public void setColLabels(Map<String, Integer> colLabels) {
        this.colLabels = colLabels;
    }

    public void setRowLabels(Map<String, Integer> rowLabels) {
        this.rowLabels = rowLabels;
    }

    public void setLineas(List<String> lineas) {
        this.lineas = lineas;

    }

}
