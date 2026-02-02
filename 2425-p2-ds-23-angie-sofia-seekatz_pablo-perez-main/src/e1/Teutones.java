package e1;
public abstract class Teutones extends Tropa{
    public Teutones(int puntosAtaque, int puntosDefensa){
        super(puntosAtaque, puntosDefensa);
    }

    @Override
    public int getPuntosAtaque() {
        return (int) (puntosAtaque * 0.95);
    }

    @Override
    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    @Override
    public String toString() {
        return "Tropa Teutona - Ataque: " + getPuntosAtaque() + " Defensa: " + getPuntosDefensa();
    }
}
