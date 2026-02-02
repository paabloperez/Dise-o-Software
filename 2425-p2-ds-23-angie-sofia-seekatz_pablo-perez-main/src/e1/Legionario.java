package e1;
public class Legionario extends Romanos{
    public Legionario(){
        super(40,35);   //40 ataque, 35 de defensa
    }

    public String toString(){
        return "Legionario - Ataque: " + getPuntosAtaque() + "Defensa: " + getPuntosDefensa();
    }
}
