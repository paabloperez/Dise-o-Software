package e1;


import java.util.ArrayList;
import java.util.List;

public class Travian {

    public List<String> batalla(Aldea<?> aldeaA, Aldea<?> aldeaB) {
        List<String> resultado = new ArrayList<>();

        resultado.add("### Starts the battle ! --> " + aldeaA.getNombre() + " Attacks " + aldeaB.getNombre() + " ! ###");

        resultado.add(aldeaA.getNombre() + " have the following soldiery :");
        for (Tropa tropa : aldeaA.getEjercito()) {
            resultado.add(tropa.toString());
        }
        int poderAtaqueA = aldeaA.getPuntosAtaque();
        resultado.add("Total " + aldeaA.getNombre() + " attack power : " + poderAtaqueA);

        resultado.add(aldeaB.getNombre() + " have the following soldiery :");
        for (Tropa tropa : aldeaB.getEjercito()) {
            resultado.add(tropa.toString());
        }
        int poderDefensaB = aldeaB.getPuntosDefensa();
        resultado.add("Total " + aldeaB.getNombre() + " defense power : " + poderDefensaB);

        if (poderAtaqueA > poderDefensaB) {
            resultado.add(aldeaA.getNombre() + " with an age of " + aldeaA.getAnos() + " years WINS !");
        } else {
            resultado.add(aldeaB.getNombre() + " with an age of " + aldeaB.getAnos() + " years WINS !");
        }

        return resultado;
    }
}
