package matrizGenerica;

public class Main {
    public static void main(String[] args) {
        Integer[][] m1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };
        String[] cols = {"A", "B", "C", "D"};
        String[] filas = {"X", "Y"};
        Matriz<Integer> miMatriz = new Matriz<>(m1, cols, filas);
        miMatriz.setCelda("X", "K", 9); //Columna inválida: K
        System.out.println(miMatriz);
        System.out.println((miMatriz.getCelda("X", "C")));
    }
}
