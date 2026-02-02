package e2;

public class Cliente implements Observador{
    private Estrategia estrategia;

    public Cliente(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    @Override
    public void actualizaObservador(Accion accion) {
        estrategia.ejecutar(accion);
    }
}
