package com.enlatadosmg.structures;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.enlatadosmg.models.Vehiculo;

public class ColaVehiculosTest{

    @Test
    public void testEncolarYVerFrente() {
        ColaVehiculos cola = new ColaVehiculos();

        Vehiculo v1 = new Vehiculo("P100", "Toyota", "Hilux", "Blanco", 2024);
        Vehiculo v2 = new Vehiculo("P200", "Nissan", "Frontier", "Negro", 2023);

        cola.encolar(v1);
        cola.encolar(v2);

        Vehiculo frente = cola.verFrente();

        assertNotNull(frente);
        assertEquals("P100", frente.getPlaca());
        assertEquals("Toyota", frente.getMarca());
    }

    @Test
    public void testDesencolarFIFO() {
        ColaVehiculos cola = new ColaVehiculos();

        Vehiculo v1 = new Vehiculo("P100", "Toyota", "Hilux", "Blanco", 2024);
        Vehiculo v2 = new Vehiculo("P200", "Nissan", "Frontier", "Negro", 2023);

        cola.encolar(v1);
        cola.encolar(v2);

        Vehiculo primero = cola.desencolar();
        Vehiculo segundo = cola.desencolar();

        assertEquals("P100", primero.getPlaca());
        assertEquals("P200", segundo.getPlaca());
        assertNull(cola.desencolar());
    }

    @Test
    public void testBuscarVehiculo() {
        ColaVehiculos cola = new ColaVehiculos();

        Vehiculo v1 = new Vehiculo("P100", "Toyota", "Hilux", "Blanco", 2024);
        Vehiculo v2 = new Vehiculo("P200", "Nissan", "Frontier", "Negro", 2023);

        cola.encolar(v1);
        cola.encolar(v2);

        Vehiculo encontrado = cola.buscar("P200");

        assertNotNull(encontrado);
        assertEquals("Nissan", encontrado.getMarca());
        assertEquals("Frontier", encontrado.getModelo());
        assertNull(cola.buscar("P999"));
    }

    @Test
    public void testActualizarVehiculo() {
        ColaVehiculos cola = new ColaVehiculos();

        Vehiculo v1 = new Vehiculo("P100", "Toyota", "Hilux", "Blanco", 2024);
        cola.encolar(v1);

        Vehiculo actualizado = new Vehiculo("P100", "Mazda", "BT-50", "Rojo", 2025);

        boolean resultado = cola.actualizar("P100", actualizado);
        Vehiculo encontrado = cola.buscar("P100");

        assertTrue(resultado);
        assertNotNull(encontrado);
        assertEquals("Mazda", encontrado.getMarca());
        assertEquals("BT-50", encontrado.getModelo());
        assertEquals("Rojo", encontrado.getColor());
        assertEquals(2025, encontrado.getAnio());
    }

    @Test
    public void testEliminarVehiculo() {
        ColaVehiculos cola = new ColaVehiculos();

        Vehiculo v1 = new Vehiculo("P100", "Toyota", "Hilux", "Blanco", 2024);
        Vehiculo v2 = new Vehiculo("P200", "Nissan", "Frontier", "Negro", 2023);

        cola.encolar(v1);
        cola.encolar(v2);

        boolean eliminado = cola.eliminar("P100");

        assertTrue(eliminado);
        assertNull(cola.buscar("P100"));
        assertNotNull(cola.buscar("P200"));
    }

    @Test
    public void testListarVehiculos() {
        ColaVehiculos cola = new ColaVehiculos();

        Vehiculo v1 = new Vehiculo("P100", "Toyota", "Hilux", "Blanco", 2024);
        cola.encolar(v1);

        String listado = cola.listarVehiculos();

        assertTrue(listado.contains("P100"));
        assertTrue(listado.contains("Toyota"));
        assertTrue(listado.contains("Hilux"));
        assertTrue(listado.contains("Blanco"));
    }
}
