package e3;


import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class EuroCoinCollection implements Iterable<EuroCoin>, Iterator<EuroCoin> {

    ArrayList<EuroCoin> leuro = new ArrayList<>();

    private int modCount = 0;
    private EuroCountryType countryFilter;

    public EuroCoinCollection() {
    }

    public boolean add(EuroCoin e) {
        if (!leuro.contains(e)) {
            modCount++;
            return leuro.add(e);
        } else return false;
    }

    public boolean removeCoin(EuroCoin e) {
        return leuro.remove(e);
    }

    public int valueCollection() {
        int total = 0;
        EuroCoin tmp;
        Iterator<EuroCoin> it = leuro.iterator();
        while (it.hasNext()) {
            tmp = it.next();
            total = total + tmp.euroValue().getValue();
        }
        return total;
    }


    public int numberCoins() {
        if (leuro.isEmpty()) return 0;
        else return leuro.size();
    }

    public boolean coinInCollection(EuroCoin e) {
        return leuro.contains(e);
    }


    @Override
    public Iterator<EuroCoin> iterator() {
        return new CountryCoinIterator(null);
    }

    public Iterator<EuroCoin> iterator(EuroCountryType CountryFilter) {
        return new CountryCoinIterator(CountryFilter);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public EuroCoin next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    private class CountryCoinIterator implements Iterator<EuroCoin> {
        private int cursor = 0;
        private EuroCountryType countryFilter;
        private int expectedModCount = modCount;
        private int lastRet = -1;

        public CountryCoinIterator(EuroCountryType country) {
            this.countryFilter = country;
        }

        @Override
        public boolean hasNext() {
            while (cursor < leuro.size()) {
                EuroCoin moneda = leuro.get(cursor);
                if (countryFilter == null || countryFilter.equals(moneda.euroCountryType())) {
                    return true;
                }
                cursor++;
            }
            return false;
        }

        @Override
        public EuroCoin next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            lastRet = cursor;
            cursor++;
            return leuro.get(lastRet);
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException("No se puede llamar a remove() sin llamar antes a next().");
            }
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            leuro.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
            expectedModCount = ++modCount;
        }
    }



}

