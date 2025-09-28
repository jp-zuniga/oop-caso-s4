import models.Automovil;
import models.Bicicleta;
import models.Combustible;
import models.Vehiculo;

public class SistemaVehiculos {
    public static void procesarVehiculos(Vehiculo[] vehiculos) {
        for (Vehiculo v : vehiculos) {
            v.mover();
            System.out.println(v.obtenerDetalles());

            // Verificar si el vehículo implementa la interfaz Combustible
            if (v instanceof Combustible) {
                ((Combustible) v).recargarCombustible();
                System.out.println("Nivel de combustible: " + ((Combustible) v).obtenerNivelCombustible());
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // Crear instancias de vehículos
        Vehiculo auto = new Automovil("Toyota", "Corolla", 2020, 40.0);
        Vehiculo bici = new Bicicleta("Trek", "Mountain", 2022, 21);
        Vehiculo moto = new models.Motocicleta("Honda", "CBR500R", 2021, 15.0, 500);

        // Probar polimorfismo
        System.out.println("------- Prueba de Vehículos -------");
        System.out.println("AUTOMÓVIL:");
        auto.mover();
        System.out.println(auto.obtenerDetalles());
        ((Combustible) auto).recargarCombustible();
        System.out.println("Nivel de combustible: " + ((Combustible) auto).obtenerNivelCombustible());

        System.out.println("\nBICI:");
        bici.mover();
        System.out.println(bici.obtenerDetalles());

        System.out.println("\nMOTOCICLETA:");
        moto.mover();
        System.out.println(moto.obtenerDetalles());
        ((Combustible) moto).recargarCombustible();
        System.out.println("Nivel de combustible: " + ((Combustible) moto).obtenerNivelCombustible());

        // Procesar un array de vehículos
        Vehiculo[] vehiculos = {auto, bici, moto};
        System.out.println("\n------- Prueba de Polimorfismo -------");
        procesarVehiculos(vehiculos);

    }
}