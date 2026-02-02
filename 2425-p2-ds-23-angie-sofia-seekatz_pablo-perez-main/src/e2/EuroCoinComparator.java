package e2;

import java.util.Comparator;

public class EuroCoinComparator implements Comparator<EuroCoin> {

    @Override
    public int compare(EuroCoin o1, EuroCoin o2) {
        int countryCompare = o1.euroCountryType().compareTo(o2.euroCountryType());
        int valueCompare = o1.euroValue().compareTo(o2.euroValue());

            if (countryCompare != 0) return countryCompare;
            if (valueCompare != 0) return valueCompare;
            return Integer.compare(o1.year(), o2.year());
            }
}