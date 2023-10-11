package ejercicioTiposDeViajes;

public class Trayecto {

    private String origen;
    private String destino;
    private double distancia;
    private int cantEstaciones;

    public Trayecto(String origen, String destino, double distancia, int cantEstaciones) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.cantEstaciones = cantEstaciones;
    }

    public double getDistancia() {
        return this.distancia;
    }
    public int getCantEstaciones() {
        return this.cantEstaciones;
    }

}