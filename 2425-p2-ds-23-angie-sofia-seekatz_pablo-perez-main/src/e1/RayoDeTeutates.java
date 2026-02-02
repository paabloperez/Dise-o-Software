package e1;
public class RayoDeTeutates extends Galos{
    private boolean tieneArmadura;

    public RayoDeTeutates() {
        super(100, 25);
    }

    @Override
    public int getPuntosDefensa() {
        if(tieneArmadura){
            return (int)(puntosDefensa * 1.25);
        }
        return puntosDefensa;
    }

    @Override
    public int getPuntosAtaque() {
        if(tieneArmadura){
            return (int)(puntosAtaque * 0.75);
        }
        return puntosAtaque;
    }

    public void equiparArmadura(){
        this.tieneArmadura = true;
    }

    public void quitarArmadura(){
        this.tieneArmadura = false;
    }

    @Override
    public String toString() {
        return "Rayo de Teutates - Ataque: " + getPuntosAtaque() + " Defensa: " + getPuntosDefensa() + " Armadura: " + (tieneArmadura? "Si" : "No" ) ;
    }
}
