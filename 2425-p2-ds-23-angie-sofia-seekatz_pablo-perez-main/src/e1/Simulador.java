package e1;
import java.util.ArrayList;
import java.util.List;

public class Simulador {

    public List<String> batalla(Aldea<?> aldeaA, Aldea<?> aldeaB) {
        List<String> resultado = new ArrayList<>();

        // Empezamos la batalla
        resultado.add("### Starts the battle ! --> " + aldeaA.getNombre() + " Attacks " + aldeaB.getNombre() + " ! ###");

        // Mostrar el ejército atacante
        resultado.add(aldeaA.getNombre() + " have the following soldiery :");
        for (Tropa tropa : aldeaA.getEjercito()) {
            resultado.add(tropa.toString());
        }
        int poderAtaqueA = aldeaA.getPuntosAtaque();
        resultado.add("Total " + aldeaA.getNombre() + " attack power : " + poderAtaqueA);

        // Mostrar el ejército defensor
        resultado.add(aldeaB.getNombre() + " have the following soldiery :");
        for (Tropa tropa : aldeaB.getEjercito()) {
            resultado.add(tropa.toString());
        }
        int poderDefensaB = aldeaB.getPuntosDefensa();
        resultado.add("Total " + aldeaB.getNombre() + " defense power : " + poderDefensaB);

        // Determinar el ganador
        if (poderAtaqueA > poderDefensaB) {
            resultado.add(aldeaA.getNombre() + " with an age of " + aldeaA.getAnos() + " years WINS !");
        } else {
            resultado.add(aldeaB.getNombre() + " with an age of " + aldeaB.getAnos() + " years WINS !");
        }

        return resultado;
    }
}
