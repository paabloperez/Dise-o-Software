package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class EuroCoinCollectionTest {
    private static EuroCoinCollection euroCoinCollection;
    private static EuroCoin e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;

    @BeforeEach
    void setUp(){
        e1 = new EuroCoin(EuroValue.EURO200,
                ColorType.Oro_Plata,
                EuroCountryType.Austria,
                "Juan", 2003);

        e2 = new EuroCoin( EuroValue.EURO100,
                ColorType.Oro_Plata,
                EuroCountryType.Austria,
                "Ardilla", 2005);

        e3 = new EuroCoin(EuroValue.EURO200,   //revisamos que salgan que ambas monedas son iguales aunque tengan distinto año
                ColorType.Oro_Plata,
                EuroCountryType.Austria,
                "Juan", 2006);

        e4 = new EuroCoin(EuroValue.EURO10,
                ColorType.Oro,
                EuroCountryType.Andorra,
                "Andorrana", 2000);

        e5 = new EuroCoin(EuroValue.EURO200,
                ColorType.Oro_Plata,
                EuroCountryType.Spain,
                "Castillo", 2010);

        e6 = new EuroCoin(EuroValue.EURO100,
                ColorType.Oro_Plata,
                EuroCountryType.Spain,
                "Animal", 2016);

        e7 = new EuroCoin(EuroValue.EURO20,
                ColorType.Oro,
                EuroCountryType.France,
                "Pato", 2017);

        e8 = new EuroCoin(EuroValue.EURO100,
                ColorType.Oro_Plata,
                EuroCountryType.Spain,
                "Bandera", 2009);

        e9 = new EuroCoin(EuroValue.EURO100,
                ColorType.Oro_Plata,
                EuroCountryType.Italy,
                "Torre", 2013);

        e10= new EuroCoin(EuroValue.EURO50,
                ColorType.Oro,
                EuroCountryType.Italy,
                "Personaje", 2014);

        euroCoinCollection = new EuroCoinCollection();
        euroCoinCollection.add(e1);
        euroCoinCollection.add(e4);
        euroCoinCollection.add(e5);
        euroCoinCollection.add(e6);
        euroCoinCollection.add(e7);
        euroCoinCollection.add(e8);
        euroCoinCollection.add(e9);
        euroCoinCollection.add(e10);
    }



    @Test
    void add() {
        assertFalse(euroCoinCollection.add(e1));
        assertTrue(euroCoinCollection.add(e2));  //añadimos e2 sin problema ya que no hay ninguna con diseño, cantidad y pais igual
        assertFalse(euroCoinCollection.add(e3));  //no podemos añadir e3 ya que es igual a e1 (solo que distinto año)
    }

    @Test
    void removeCoin() {
        assertTrue(euroCoinCollection.removeCoin(e1));
        assertTrue(euroCoinCollection.removeCoin(e4));
        assertFalse(euroCoinCollection.removeCoin(e2));
        assertFalse(euroCoinCollection.removeCoin(e3));

    }

    @Test
    void valueCollection() {
        euroCoinCollection.add(e1);
        euroCoinCollection.add(e4);
        assertEquals(780, euroCoinCollection.valueCollection());
        euroCoinCollection.removeCoin(e1);
        euroCoinCollection.removeCoin(e4);
        assertEquals(570, euroCoinCollection.valueCollection());
        euroCoinCollection.removeCoin(e5);
        euroCoinCollection.removeCoin(e6);
        euroCoinCollection.removeCoin(e7);
        euroCoinCollection.removeCoin(e8);
        euroCoinCollection.removeCoin(e9);
        euroCoinCollection.removeCoin(e10);
        assertEquals(0, euroCoinCollection.valueCollection());
    }

    @Test
    void numberCoins() {
        assertEquals(8, euroCoinCollection.numberCoins());
        euroCoinCollection.removeCoin(e1);
        euroCoinCollection.removeCoin(e4);
        assertEquals(6, euroCoinCollection.numberCoins());
        euroCoinCollection.removeCoin(e5);
        euroCoinCollection.removeCoin(e6);
        euroCoinCollection.removeCoin(e7);
        assertEquals(3, euroCoinCollection.numberCoins());
        euroCoinCollection.removeCoin(e8);
        euroCoinCollection.removeCoin(e9);
        euroCoinCollection.removeCoin(e10);
        assertEquals(0, euroCoinCollection.numberCoins());
    }

    @Test
    void coinInCollection() {
        assertTrue(euroCoinCollection.coinInCollection(e1));  //ya en el setUp la habiamos añadido junto a e4
        assertFalse(euroCoinCollection.coinInCollection(e2)); //no esta e2
        euroCoinCollection.removeCoin(e1); // quitamos e1 dejando solo e4
        euroCoinCollection.add(e2); //añadimos e2 quedando en la lista e2 y e4
        assertTrue(euroCoinCollection.coinInCollection(e2)); //esta e2
        assertFalse(euroCoinCollection.coinInCollection(e3));  // no esta e3
        assertTrue(euroCoinCollection.coinInCollection(e4)); //esta e4
    }

    @Test
    void testLongIterator() {
        Iterator<EuroCoin> iterator = euroCoinCollection.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        assertEquals(8, count);
    }

    @Test
    void testCountryFilter() {
        Iterator<EuroCoin> iteratorES = euroCoinCollection.iterator(EuroCountryType.Spain);
        String[] expected = {"EURO200-ES", "EURO100-ES", "EURO100-ES"};
        int index = 0;
        while (iteratorES.hasNext()) {
            EuroCoin coin = iteratorES.next();  // Guardar el resultado de next() en una variable
            assertEquals(expected[index], coin.euroValue() + "-" + coin.euroCountryType().getISO());
            index++;
        }
        assertEquals(expected.length, index);
    }

    @Test
    void testWithoutCountryFilter() {
        Iterator<EuroCoin> iterator = euroCoinCollection.iterator(null);
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        assertEquals(8, count);
    }

    @Test
    void testConcurrentModificationException() {
        Iterator<EuroCoin> iterator = euroCoinCollection.iterator();
        euroCoinCollection.add(e2);
        assertThrows(ConcurrentModificationException.class, iterator::next);
    }

    @Test
    void testRemoveMethod() {
        Iterator<EuroCoin> iteratorES   = euroCoinCollection.iterator(EuroCountryType.Spain);
        assertTrue(iteratorES.hasNext());
        iteratorES.next(); // EURO2-ES
        iteratorES.remove(); // Remueve EURO2-ES
        assertEquals(7, euroCoinCollection.leuro.size());

        assertThrows(IllegalStateException.class, iteratorES::remove);

        iteratorES.next(); // EURO1-ES
        iteratorES.remove(); // Remueve EURO1-ES
        assertEquals(6, euroCoinCollection.leuro.size());
    }

    @Test
    void testNoSuchElementException() {
        Iterator<EuroCoin> iteratorES = euroCoinCollection.iterator(EuroCountryType.Spain);
        while (iteratorES.hasNext()) {
            iteratorES.next();
        }
        assertThrows(NoSuchElementException.class, iteratorES::next);
    }
}







