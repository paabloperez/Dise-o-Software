package e1;
public class Petroriano extends Romanos{
    public Petroriano(){
        super(30, 65);
    }

    @Override
    public int getPuntosDefensa() {
        if(tieneArmadura){
            return (int) (puntosDefensa*1.1);
        }
        return puntosDefensa;
    }

    public void equiparArmadura(){
        tieneArmadura = true;
    }

    public void quitarArmadura(){
        tieneArmadura = false;
    }

    public String toString(){
        return "Tropa Petroriana - Ataque: " + getPuntosAtaque() + ", Defensa: " + getPuntosDefensa() +
                ", Armadura Equipada: " + (tieneArmadura? "Si" : "No");
    }



}
