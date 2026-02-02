package e1;
public class GuerreroDeMaza extends Teutones{
    private boolean mejorada;

    public GuerreroDeMaza(){
        super(40,30);
    }

    @Override
    public int getPuntosAtaque() {
        if(mejorada){
            return (int)(puntosAtaque * 1.25);
        }
        return puntosAtaque;
    }

    @Override
    public String toString() {
        return "Guerrero de Maza - Ataque: " + getPuntosAtaque() + ", Defensa: " + getPuntosDefensa();
    }
}
