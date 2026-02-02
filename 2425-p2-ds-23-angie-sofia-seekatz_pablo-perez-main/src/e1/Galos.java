package e1;
public class Galos extends Tropa {
    private int nivelMuralla;

    public Galos(int puntosAtaque, int puntosDefensa) {
        super(puntosAtaque, puntosDefensa);
    }

    @Override
    public int getPuntosAtaque() {
        return (int) (puntosAtaque * 1.2);
    }

    public int getPuntosDefensa() {
        return (int) (puntosDefensa + (1.5 * nivelMuralla));
    }

    public int getNivelMuralla() {
        return nivelMuralla;
    }

    public void setNivelMuralla(int nivelMuralla) {
        this.nivelMuralla = nivelMuralla;
    }

    @Override
    public String toString() {
        return "Tropa Gala - Ataque: " + getPuntosAtaque() + ", Defensa: " + getPuntosDefensa();
    }
}
