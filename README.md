# Caso de Estudio

Repositorio para el caso de estudio asignado en la semana 4 de la asignatura Metodología y Programación Orientada a Objetos I.

## Integrantes

- Joaquín Alberto Pérez Zúñiga
- Alicia Massiel Estrada Acevedo
- Enrique José Taleno Núñez
- Kevin Alexander Browne Barbosa
- Angie Zarela Rodríguez Cano

## Análisis del Código Inicial

### Herencia en `Automovil` y `Bicicleta`

La herencia se utiliza para crear una relación "is-a" entre las clases.

```java
public class Automovil extends Vehiculo implements Combustible { }

public class Bicicleta extends Vehiculo { }
```

Ambas comparten los atributos `marca`, `modelo` y `anio` comúnes entre cualquier tipo de vehículo, y heredan el método `obtenerDetalles()` que se puede sobreescribir para modelar comportamientos específicos.

### Polimorfismo en `mover()` y `obtenerDetalles()`

El polimorfismo permite tratar objetos de diferentes clases de manera uniforme a través de una interfaz común. En este caso, podemos tratar diferentes tipos de vehículos de la misma manera a través de la clase base Vehiculo, pero cada uno mantiene su comportamiento específico:

```java
Vehiculo auto = new Automovil("Toyota", "Corolla", 2020, 40.0);
Vehiculo bici = new Bicicleta("Trek", "Mountain", 2022, 21);

// Mismo método, comportamientos diferentes
auto.mover();  // Java decide en tiempo de ejecución llamar a Automovil.mover()
bici.mover();  // Java decide en tiempo de ejecución llamar a Bicicleta.mover()
```

### Uso de `super`

La palabra super se utiliza para:

#### a) Llamar al constructor de la clase padre:

```java
public Automovil(String marca, String modelo, int anio, double nivelCombustible) {
    super(marca, modelo, anio);  // Llama a Vehiculo(marca, modelo, anio)
    this.nivelCombustible = nivelCombustible;
}
```

#### b) Acceder a métodos de la clase padre:

```java
// En `Bicicleta`:
@Override
public String obtenerDetalles() {
    return super.obtenerDetalles() + ", Marchas: " + numeroMarchas;
}
```

### Rol de `Combustible`

La interfaz `Combustible` define un contrato para vehículos que requieren combustible; por lo tanto, `Bicicleta` no necesita implementar el comportamiento de `Combustible`. Un `Automovil` si, entonces debe implementar la interfaz y sus métodos:

```java
public class Automovil extends Vehiculo implements Combustible { }
```

## Reflexión

El polimorfismo es una característica que facilita que un sistema sea fácil de ampliar sin necesidad de modificar el código ya existente. En un diseño orientado a objetos, todos los tipos de vehículos heredan de una clase base llamada `Vehiculo` y, si es necesario, implementan la interfaz `Combustible`. Gracias a esto, el método `procesarVehiculos()` trabaja sobre el tipo abstracto `Vehiculo`, llamando a funciones como `mover()` u `obtenerDetalles()` sin importar de qué clase específica provenga el objeto. Si en el futuro se necesita agregar un nuevo tipo de vehículo, como un `Camión` o una `Patineta`, basta con que este herede de `Vehiculo` y defina los métodos requeridos. Así, el sistema puede procesarlo sin cambios en la lógica principal, reduciendo el mantenimiento y permitiendo que el software crezca de forma ordenada y escalable.
