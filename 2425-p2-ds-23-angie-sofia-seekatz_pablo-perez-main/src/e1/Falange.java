package e1;
public class Falange extends Galos{
    public Falange(){
        super(15, 40);
    }

    public String toString(){
        return "Falange - Ataque: " + getPuntosAtaque() + ", Defensa: " + getPuntosDefensa();
    }
}
