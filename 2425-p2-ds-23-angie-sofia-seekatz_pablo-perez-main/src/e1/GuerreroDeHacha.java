package e1;
public class GuerreroDeHacha extends Teutones{
    public GuerreroDeHacha(){
        super(60, 30);
    }

    public String toString(){
        return "Guerrero de Hacha - Ataque: " + getPuntosAtaque() + ", Defensa: " + getPuntosDefensa();
    }
}
