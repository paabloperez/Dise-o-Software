package e2;

public class EstrategiaSimple implements Estrategia {
    @Override
    public void ejecutar(Accion accion) {
        System.out.println("Accion para cliente simple: "+ accion.getSimbolo() + " Cierre:" + accion.getCierre() + "%");
    }
}
