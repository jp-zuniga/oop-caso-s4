public class SistemaVehiculos {
    public static void main(String[] args) {
        // Crear instancias de vehículos
        Vehiculo auto = new Automovil("Toyota", "Corolla", 2020, 40.0);
        Vehiculo bici = new Bicicleta("Trek", "Mountain", 2022, 21);

        // Probar polimorfismo
        auto.mover();
        System.out.println(auto.obtenerDetalles());
        ((Combustible) auto).recargarCombustible();
        System.out.println("Nivel de combustible: " + ((Combustible) auto).obtenerNivelCombustible());

        bici.mover();
        System.out.println(bici.obtenerDetalles());
    }
}