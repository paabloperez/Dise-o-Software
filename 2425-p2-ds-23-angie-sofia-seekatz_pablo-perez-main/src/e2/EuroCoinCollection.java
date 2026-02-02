package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EuroCoinCollection {
    List<EuroCoin> leuro = new ArrayList<>(); //usamos HashSet en lugar de ArrayList porque a diferencia de la segunda,
    //no acepta repetidos

    public EuroCoinCollection() {
    }


    public boolean add (EuroCoin e){
        for (EuroCoin c : leuro){
            if(c.equals(e)){
                return false;
            }
        }
        return leuro.add(e);
    }

    public boolean remove(EuroCoin e){
        if (leuro.contains(e)){
            return leuro.remove(e);
        }
        return false;
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

    public List<EuroCoin> sortedCoins() {
        List<EuroCoin> sortedList = new ArrayList<>(leuro);
        Collections.sort(sortedList); // por orden natural (Comparable)
        return sortedList;
    }



        public List<EuroCoin> sortedCoinsByYearThenValue() {
            List<EuroCoin> sortedList = new ArrayList<>(leuro);
            Collections.sort(sortedList, new EuroCoinComparator()); // usando el comparador externo
            return sortedList;
        }
    }











