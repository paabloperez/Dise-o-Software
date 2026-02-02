package e1;

//PATRÓN FACTORY

public class FabricaBuques {
    public static Buque crearBuque(String nombre, TipoBuque tipo, EstadoBuque estado, int totalMisiones) {
        switch (tipo) {
            case DE -> { // Destructores
                return new DE(nombre, tipo, estado, totalMisiones);
            }
            case DD -> { // Destructores de Escolta
                return new DD(nombre, tipo, estado, totalMisiones);
            }
            case CL -> { // Cruceros Ligeros
                return new CL(nombre, tipo, estado, totalMisiones);
            }
            case AV -> { // Portaaviones
                return new AV(nombre, tipo, estado, totalMisiones);
            }
            case CA -> { // Cruceros Acorazados
                return new CA(nombre, tipo, estado, totalMisiones);
            }
            case CV -> { // Cruceros de Batalla
                return new CV(nombre, tipo, estado, totalMisiones);
            }
            case BB -> { // Acorazados
                return new BB(nombre, tipo, estado, totalMisiones);
            }
            default -> {
                throw new IllegalArgumentException("Tipo de buque no válido: " + tipo);
            }
        }
    }
}
