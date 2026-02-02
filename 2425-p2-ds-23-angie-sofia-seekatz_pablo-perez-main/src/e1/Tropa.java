package e1;
public abstract class Tropa{
    protected int puntosAtaque;
    protected int puntosDefensa;
    protected boolean tieneArmadura;

    public Tropa(int puntosAtaque, int puntosDefensa) {
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.tieneArmadura = false;
    }

    public abstract int getPuntosAtaque();
    public abstract int getPuntosDefensa();


    public String toString(){
        return "Ataque: " + puntosAtaque + "Defensa: " + puntosDefensa;
    }
}
