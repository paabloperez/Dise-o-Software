package e2;

public class EstrategiaDetallada implements Estrategia{

    @Override
    public void ejecutar(Accion acc) {
        System.out.println("Accion para cliente detallado: "+ acc);
    }
}
