package e1;

public class EquitesImperatoris extends Romanos{
    public EquitesImperatoris(){
        super(120, 65);
    }

    public String toString(){
        return "Equites Imperatoris - Ataque: " + getPuntosAtaque() + ", Defensa: " + getPuntosDefensa();
    }
}
