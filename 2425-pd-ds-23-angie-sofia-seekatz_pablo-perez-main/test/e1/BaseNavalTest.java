package e1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BaseNavalTest {

    private BaseNaval baseNaval;
    private Buque buqueActivo;
    private Buque buqueInactivo;

    @BeforeEach
    void setUp() {
        baseNaval = BaseNaval.getInstancia(1000000);
        buqueActivo = new DE("Rompetotos", TipoBuque.DE, EstadoBuque.ACTIVO, 10);
        buqueInactivo = new CV("Portacosas", TipoBuque.CV, EstadoBuque.HUNDIDO, 5);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void añadirBuque() {
        baseNaval.añadirBuque(buqueActivo);
        assertTrue(baseNaval.flotaActiva.contains(buqueActivo), "El buque debería haberse añadido a la flota activa.");
    }

    @Test
    void cambiarEstado() {
        baseNaval.añadirBuque(buqueActivo);
        baseNaval.cambiarEstado(buqueActivo, EstadoBuque.HUNDIDO);

        assertFalse(baseNaval.flotaActiva.contains(buqueActivo), "El buque no debería estar en la flota activa.");
        assertTrue(baseNaval.flotaInactiva.contains(buqueActivo), "El buque debería estar en la flota inactiva.");
    }

    @Test
    void listarActivos() {
        baseNaval.añadirBuque(buqueActivo);
        baseNaval.listarActivos();
    }

    @Test
    void listarInactivos() {
        baseNaval.añadirBuque(buqueInactivo);
        baseNaval.listarInactivos();
    }

    @Test
    void registrarIngreso() {
        double fondosAntes = baseNaval.getFondos();
        baseNaval.registrarIngreso(50000);

        assertEquals(fondosAntes + 50000, baseNaval.getFondos(), "Los fondos deberían haber aumentado en 50000.");    }

    @Test
    void registrarGasto() {
        double fondosAntes = baseNaval.getFondos();
        baseNaval.registrarGasto(100000);

        assertEquals(fondosAntes - 100000, baseNaval.getFondos(), "Los fondos deberían haber disminuido en 100000.");
    }

    @Test
    void getFondos() {
        assertEquals(1000000, baseNaval.getFondos(), "Los fondos iniciales deberían ser 1000000.");
    }

    @Test
    void getGastosPendientes() {
        assertEquals(0, baseNaval.getGastosPendientes(), "Los gastos pendientes deberían ser 0 al inicio.");
    }

    @Test
    void calcularRecompensa() {
        assertEquals(10000, baseNaval.calcularRecompensa(TipoBuque.DE), "La recompensa para un DE debería ser 10000.");
        assertEquals(50000, baseNaval.calcularRecompensa(TipoBuque.CV), "La recompensa para un CV debería ser 50000.");
    }

    @Test
    void registrarRecompensa() {
        baseNaval.añadirBuque(buqueActivo);
        double fondosAntes = baseNaval.getFondos();

        baseNaval.registrarRecompensa(buqueActivo);

        assertEquals(fondosAntes + 10000, baseNaval.getFondos(), "Los fondos deberían haber aumentado en la recompensa del buque.");
    }


    @Test
    void hayBuquesEnReparacion() {
        buqueActivo.cambiarEstado(EstadoBuque.EN_REPARACION);
        baseNaval.añadirBuque(buqueActivo);

        assertTrue(baseNaval.hayBuquesEnReparacion(), "Debería haber un buque en reparación.");
    }

    @Test
    void solicitarReparacion() {
        baseNaval.añadirBuque(buqueActivo);
        baseNaval.solicitarReparacion(buqueActivo, false);

        assertTrue(baseNaval.getGastosPendientes() > 0, "Los gastos pendientes deberían haberse registrado tras la reparación.");
    }
}
