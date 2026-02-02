package e1;

public class Almirante implements Observador {
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Notificación para el almirante: " + mensaje);
    }
}