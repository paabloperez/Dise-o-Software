package e1;

public class Reparacion {
    private Buque buque;
    private double costo;
    private boolean esExpress;

    public Reparacion(Buque buque, boolean esExpress){
        this.buque = buque;
        this.esExpress = esExpress;
        this.costo = calcularCosto(buque, esExpress);
    }


    public double calcularCosto(Buque buque, boolean esExpress) {
        if (esExpress) {
            return 0; // Costo nulo para reparaciones express
        }
        switch (buque.getTipo()) {
            case DE, DD -> { return 10000; }
            case CL, AV -> { return 20000; }
            case CA, CV -> { return 50000; }
            case BB -> { return 100000; }
            default -> { return 0; }
        }
    }

    public boolean reparar(BaseNaval base) {
        if (esExpress && buque instanceof BuquesUltraligeros && !base.hayBuquesEnReparacion()) {
            buque.cambiarEstado(EstadoBuque.DISPONIBLE);  // Reparación express: no hay costo y el buque está disponible inmediatamente
            System.out.println("Reparación express completada para " + buque.getNombre() + " sin costo.");
            return true;
        }

        if (base.getFondos() >= costo) {
            base.registrarGasto(costo);  // Se descuentan los fondos
            buque.cambiarEstado(EstadoBuque.EN_REPARACION);  // El buque entra en reparación
            System.out.println("Reparación solicitada para " + buque.getNombre() + " | Costo: " + costo);
            return true;
        } else {
            System.out.println("Fondos insuficientes para reparar " + buque.getNombre());
            return false;  // No se puede reparar si no hay fondos suficientes
        }
    }

    public double getCosto() {
        return costo;
    }
}
