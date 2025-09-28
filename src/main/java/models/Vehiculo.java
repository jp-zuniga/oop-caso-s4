package models;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int anio;

    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    // Método abstracto que debe ser implementado por las subclases
    public abstract void mover();

    // Método que puede ser sobrescrito
    public String obtenerDetalles() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anio;
    }
}
