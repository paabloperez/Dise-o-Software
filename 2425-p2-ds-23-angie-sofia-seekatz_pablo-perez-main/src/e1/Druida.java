package e1;
public class Druida extends Galos{
    public Druida(){
        super(45, 115);
    }

    public String toString(){
        return "Druida - Ataque: " + getPuntosAtaque() + ", Defensa: " + getPuntosDefensa();
    }
}
