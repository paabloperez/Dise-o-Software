package e4;

import java.util.HashSet;

public class EuroCoinCollection {
    HashSet<EuroCoin> leuro = new HashSet<>(); //usamos HashSet en lugar de ArrayList porque a diferencia de la segunda,
    //no acepta repetidos

    public EuroCoinCollection() {
    }


    public boolean add (EuroCoin e){
        return leuro.add(e);
    }

    public boolean remove(EuroCoin e){
        return leuro.remove(e);
    }

    public int valueCollection (){
        int total = 0;
        EuroCoin tmp;
        for (EuroCoin euroCoin : leuro) {
            tmp = euroCoin;
            total = total + tmp.euroValue().getValue();
        }
        return total;
    }


    public int numberCoins (){
        if (leuro.isEmpty()) return 0;
        else return leuro.size();
    }

    public boolean coinInCollection (EuroCoin e) {
        return leuro.contains(e);
    }

}
