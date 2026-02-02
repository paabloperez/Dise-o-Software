package e2;

import java.util.List;

public class EstrategiaConcreta implements Estrategia {
    private List<String> simbolos;

    public EstrategiaConcreta(List<String> simbolos) {
        this.simbolos = simbolos;
    }

    @Override
    public void ejecutar(Accion acc) {
        if (simbolos.contains(acc.getSimbolo())) {
            System.out.println("Accion:" + acc);
        }
    }
}
