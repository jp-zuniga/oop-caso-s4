package models;

public class Motocicleta extends Vehiculo implements Combustible, Mantenimiento {
    private double nivelCombustible;
    private int cilindrada;

    // Constructor "vacio" (tiene los atributos de Vehiculo)
    public Motocicleta(String marca, String modelo, int anio) {
        super(marca, modelo, anio);
    }

    // Constructor de todos los atributos
    public Motocicleta(String marca, String modelo, int anio, double nivelCombustible, int cilindrada) {
        super(marca, modelo, anio);
        this.nivelCombustible = nivelCombustible;
        this.cilindrada = cilindrada;
    }

    // Getters y Setters
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public double getNivelCombustible() {
        return nivelCombustible;
    }

    public void setNivelCombustible(double nivelCombustible) {
        this.nivelCombustible = nivelCombustible;
    }

    // Metodos de la interfaz Combustible
    @Override
    public void recargarCombustible() {
        nivelCombustible = 40.0;
        System.out.println("La motocicleta " + marca + " " + modelo + " ha sido recargada con combustible.");
    }

    // Metodo de la interfaz Mantenimiento
    @Override
    public void realizarMantenimiento() {
        System.out.println("Cambiando aceite de motocicleta...");
    }

    @Override
    public double obtenerNivelCombustible() {
        return nivelCombustible;
    }

    // Metodos de la clase Vehiculo
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", Combustible: " + nivelCombustible + " litros, Cilindrada: " + cilindrada + "cc";
    }

    @Override
    public void mover() {
        if (nivelCombustible > 0) {
            System.out.println("La motocicleta " + marca + " " + modelo + " está acelerando con " + cilindrada + "cc.");
            nivelCombustible -= 0.3;
        } else {
            System.out.println("La motocicleta " + marca + " " + modelo + " no tiene combustible.");
        }
    }
}
