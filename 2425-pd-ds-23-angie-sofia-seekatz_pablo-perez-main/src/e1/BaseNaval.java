package e1;


import java.util.ArrayList;
import java.util.List;

//SINGLETON

public class BaseNaval {
    List<Buque> flotaActiva;
    List<Buque> flotaInactiva;
    double fondos;
    double gastosPendientes;

    private static BaseNaval instancia;

    private BaseNaval(double fondosIniciales){
        this.flotaActiva = new ArrayList<>();
        this.flotaInactiva = new ArrayList<>();
        this.fondos = fondosIniciales;
        this.gastosPendientes = 0.0;
    }

    public static BaseNaval getInstancia(double fondosIniciales) {
        if (instancia == null) {
            instancia = new BaseNaval(fondosIniciales);
        }
        return instancia;
    }

    public void añadirBuque(Buque buque){
        flotaActiva.add(buque);
        System.out.println("Nuevo buque añadido: " + buque.nombre);
    }

    public void cambiarEstado(Buque buque, EstadoBuque nuevoEstado){
        if (!flotaActiva.contains(buque)){
            System.out.println("El buque no está en la flota activa.");
            return;
        }

        buque.cambiarEstado(nuevoEstado);
        if (nuevoEstado == EstadoBuque.HUNDIDO || nuevoEstado == EstadoBuque.DESMANTELADO) {
            flotaActiva.remove(buque);
            flotaInactiva.add(buque);
        }
        System.out.println("El estado de " + buque.getNombre() + " ha sido cambiado a " + nuevoEstado);
    }

    public void listarActivos(){
        System.out.println("Buques activos: \n");
        for (Buque buque : flotaActiva){
            System.out.println("Nombre: " + buque.getNombre() + " | Tipo: " + buque.getTipo() + " | Estado " + buque.getEstado());
        }
    }

    public void listarInactivos(){
        System.out.println("Buques inactivos: \n");
        for (Buque buque : flotaInactiva){
            System.out.println("Nombre: " + buque.getNombre() + " | Razón: " + buque.getEstado() + " | Misiones: " + buque.getMisiones());
        }
    }

    public void registrarIngreso(double cantidad){
        fondos+=cantidad;
        System.out.println("Fondos aumentaron: " + cantidad + " | Fondos disponibles: " + fondos);
    }

    public void registrarGasto(double cantidad){
        if (fondos>cantidad){
            fondos -= cantidad;
            System.out.println("Gasto registrado: " + cantidad + " | Fondos disponibles: " + fondos);
        }else{
            System.out.println("Fondos insuficientes para asumir el gasto.");
        }
    }

    public double getFondos(){
        return fondos;
    }

    public double getGastosPendientes() {
        return gastosPendientes;
    }

    public double calcularRecompensa(TipoBuque tipo) {
        switch (tipo) {
            case DE, DD -> { return 10000; }
            case CL, AV -> { return 20000; }
            case CA, CV -> { return 50000; }
            case BB -> { return 100000; }
            default -> { return 0; }
        }
    }

    public void registrarRecompensa(Buque buque) {
        double recompensa = calcularRecompensa(buque.getTipo());
        registrarIngreso(recompensa);
        System.out.println("Recompensa registrada para " + buque.getNombre() + " (" + buque.getTipo() + "): " + recompensa);
    }

    public boolean hayBuquesEnReparacion() {
        for (Buque buque : flotaActiva) {
            if (buque.getEstado() == EstadoBuque.EN_REPARACION) {
                return true;
            }
        }
        return false;
    }

    public void solicitarReparacion(Buque buque, boolean esExpress) {
        Reparacion reparacion = new Reparacion(buque, esExpress);
        if (reparacion.reparar(this)) {
            gastosPendientes += reparacion.getCosto();  // Registrar el gasto pendiente de la reparación
            System.out.println("A repair request has been filed for" + buque.getNombre() + " (" + buque.getTipo() + ")" +  "| Expected repair cost: " + reparacion.calcularCosto(buque, esExpress));
        }
    }

}
