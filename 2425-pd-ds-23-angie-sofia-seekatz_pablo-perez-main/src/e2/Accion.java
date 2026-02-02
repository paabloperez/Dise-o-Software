package e2;

import java.util.Objects;

public class Accion {
    public String simbolo;
    private double cierre;
    private double maximo;
    private double minimo;
    private double volumen;

    public Accion(String simbolo, double cierre, double maximo, double minimo, double volumen) {
        this.simbolo = simbolo;
        this.cierre = cierre;
        this.maximo = maximo;
        this.minimo = minimo;
        this.volumen = volumen;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public double getMaximo() {
        return maximo;
    }

    public double getMinimo() {
        return minimo;
    }

    public double getVolumen() {
        return volumen;
    }

    public double getCierre() {
        return cierre;
    }

    @Override
    public String toString() {
        return  "Accion " + simbolo + ": " + "Cierre " + cierre + " " + "Maximo:" + maximo + " Minimo:" + minimo + " Volumen:" + volumen;
    }

}