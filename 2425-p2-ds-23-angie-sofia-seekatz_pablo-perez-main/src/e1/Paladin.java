package e1;
public class Paladin extends Teutones{
    public Paladin(){
        super(55, 100);
    }

    @Override
    public String toString() {
        return "Paladin - Ataque: " + getPuntosAtaque() + ", Defensa: " + getPuntosDefensa();
    }


}
