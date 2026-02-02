package e1;

import java.util.ArrayList;
import java.util.List;

//PATRON OBSERVADOR

public abstract class Buque {
    protected String nombre;
    protected TipoBuque tipo;
    protected EstadoBuque estado;
    protected int totalEjercicios;
    private List<Observador> observadores;


    public Buque(String nombre, TipoBuque tipo, EstadoBuque estado, int totalEjercicios){
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
        this.totalEjercicios = totalEjercicios;
        this.observadores = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public TipoBuque getTipo(){
        return tipo;
    }

    public EstadoBuque getEstado(){
        return estado;
    }

    public int getMisiones(){
        return totalEjercicios;
    }

    public void cambiarEstado(EstadoBuque nuevoEstado){
        this.estado = nuevoEstado;
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    private void notificarCambioDeEstado(String mensaje) {
        for (Observador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}
