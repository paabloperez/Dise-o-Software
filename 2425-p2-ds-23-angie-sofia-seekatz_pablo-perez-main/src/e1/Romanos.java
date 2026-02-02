package e1;
public class Romanos extends Tropa{
    public Romanos(int puntosAtaque, int puntosDefensa) {
        super(puntosAtaque, puntosDefensa);
    }

    public int getPuntosAtaque() {
        return (int) (puntosAtaque * 1.10);
    }

    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    public String toString() {
        return "Tropa Romana - Ataque: " + getPuntosAtaque() + " Defensa: " + getPuntosDefensa();
    }
}
