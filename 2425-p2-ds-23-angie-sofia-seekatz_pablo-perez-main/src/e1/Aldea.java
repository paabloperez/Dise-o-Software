package e1;

import java.util.ArrayList;
import java.util.List;

public class Aldea<Soldados extends Tropa> {
    private String nombre;
    private int anos;
    private int nivelMuralla;
    private List<Soldados> ejercito;

    public Aldea(){
        this.nombre = nombre;
        this.anos = anos;
        this.nivelMuralla = nivelMuralla;
        this.ejercito = new ArrayList<>();
    }


    public void addTropa(Soldados tropa){
        ejercito.add(tropa);
    }


    public int getPuntosAtaque(){
        int puntosAtaque = 0;
        for (Soldados tropa : ejercito){
            puntosAtaque += tropa.getPuntosAtaque();
        }
        return puntosAtaque;
    }

    public int getPuntosDefensa(){
        int puntosDefensa = 0;
        for (Soldados tropa : ejercito){
            puntosDefensa += tropa.getPuntosDefensa();
        }
        return puntosDefensa;
    }

    private int bonusMuralla(){
        if(ejercito.isEmpty()){
            return 0;
        }

        Soldados tropa = ejercito.get(0);
        if (tropa instanceof Romanos){
            return nivelMuralla*2;
        } else if (tropa instanceof  Galos) {
            return (int) (nivelMuralla*1.5);
        } else if (tropa instanceof Teutones) {
            return nivelMuralla*1;
        }
        return 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnos() {
        return anos;
    }

    public List<Soldados> getEjercito() {
        return ejercito;
    }

}
