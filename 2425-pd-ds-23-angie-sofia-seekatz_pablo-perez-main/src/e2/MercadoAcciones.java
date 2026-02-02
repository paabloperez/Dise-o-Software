package e2;

import java.util.ArrayList;
import java.util.List;

public class MercadoAcciones{
    private List<Observador> observadores = new ArrayList<>();
    private List<Accion> acciones = new ArrayList<>();

    public void añadir(Observador observer) {
        observadores.add(observer);
    }

    public void eliminar(Observador observer) {
        observadores.remove(observer);
    }

    public void actualizarCliente(Accion acc) {
        for (Observador observar : observadores) {
            observar.actualizaObservador(acc);
        }
    }

    public void actualizarAccion(String symbol, double close, double high, double low, double volume) {
        Accion acc = new Accion(symbol, close, high, low, volume);
        acciones.add(acc);
        actualizarCliente(acc);
    }

}
