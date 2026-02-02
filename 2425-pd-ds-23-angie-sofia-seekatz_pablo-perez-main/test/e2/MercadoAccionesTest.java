package e2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;


class MercadoAccionesTest {
    private MercadoAcciones mercadoAcciones;
    private Cliente simpleCliente, detalladoCliente, concretoCliente;
    private Accion a1, a2, a3;
    private List<String> simbolos;

    @BeforeEach
    void setUp() {
        mercadoAcciones = new MercadoAcciones();

        simpleCliente = new Cliente(new EstrategiaSimple());
        detalladoCliente = new Cliente(new EstrategiaDetallada());

        a1 = new Accion("AAPL", 150, 155, 148, 1000000);
        a2 = new Accion("GOOG", 2800, 2850, 2750, 500000);
        a3 = new Accion("MSFT", 300, 310, 290, 800000);

    }

    @Test
    void testAttachAndNotifySimpleStrategy() {
        mercadoAcciones.añadir(simpleCliente);
        mercadoAcciones.actualizarAccion(a1.getSimbolo(), a1.getCierre(), a1.getMaximo(), a1.getMinimo(), a1.getVolumen());

        //Verificar que el mensaje en consola sea "Accion para cliente simple: AAPL Cierre:150.0%"
    }

    @Test
    void testAttachAndNotifyDetailedStrategy() {

        mercadoAcciones.añadir(detalladoCliente);
        mercadoAcciones.actualizarAccion(a2.getSimbolo(), a2.getCierre(), a2.getMaximo(), a2.getMinimo(), a2.getVolumen());


        // Verificar que el mensaje en consola sea "Accion para cliente detallado: Accion GOOG: Cierre 2800.0 Maximo:2850.0 Minimo:2750.0 Volumen:500000.0"
    }

    @Test
    void testAttachAndNotifySpecificStockStrategy() {
        List<String> simbolos = Arrays.asList("AAPL", "MSFT");
        concretoCliente = new Cliente(new EstrategiaConcreta(simbolos));

        mercadoAcciones.añadir(concretoCliente);

        mercadoAcciones.actualizarAccion(a1.getSimbolo(), a1.getCierre(), a1.getMaximo(), a1.getMinimo(), a1.getVolumen());
        mercadoAcciones.actualizarAccion(a2.getSimbolo(), a2.getCierre(), a2.getMaximo(), a2.getMinimo(), a2.getVolumen());
        mercadoAcciones.actualizarAccion(a3.getSimbolo(), a3.getCierre(), a3.getMaximo(), a3.getMinimo(), a3.getVolumen());

        // Verificar que solo se muestran AAPL y MSFT en consola.
    }

    @Test
    void testDetachClient() {
        mercadoAcciones.añadir(simpleCliente);

        mercadoAcciones.eliminar(simpleCliente);
        mercadoAcciones.actualizarAccion(a1.getSimbolo(), a1.getCierre(), a1.getMaximo(), a1.getMinimo(), a1.getVolumen());

        // No debería aparecer ninguna salida en consola.
    }

}