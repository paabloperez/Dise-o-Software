package e4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EuroCoinCollectionTest {
    private static EuroCoinCollection euroCoinCollection;
    private static EuroCoin e1, e2, e3, e4;

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



        euroCoinCollection = new EuroCoinCollection();
        euroCoinCollection.add(e1);
        euroCoinCollection.add(e4);
    }



    @Test
    void add() {
        assertFalse(euroCoinCollection.add(e1));
        assertTrue(euroCoinCollection.add(e2));  //añadimos e2 sin problema ya que no hay ninguna con diseño, cantidad y pais igual
        assertFalse(euroCoinCollection.add(e3));  //no podemos añadir e3 ya que es igual a e1 (solo que distinto año)
    }

    @Test
    void remove() {
        assertTrue(euroCoinCollection.remove(e1));
        assertTrue(euroCoinCollection.remove(e4));
        assertFalse(euroCoinCollection.remove(e2)); // podemos quitarla porque la añadimos antes en add
        assertFalse(euroCoinCollection.remove(e3)); //no podemos quitarla porque no esta e3

    }

    @Test
    void valueCollection() {
        euroCoinCollection.add(e1);  //añadimos e1 que la teniamos vacia aunque no lo entiendo por el setUp?
        euroCoinCollection.add(e4);  //añadimos e4 que teniamos solo e1 no lo entiendo por el setUp?
        assertEquals(210, euroCoinCollection.valueCollection());   //como estan e1 (2 euros = 200 centimos) y e4 (10 centimos), 210 centimos
        euroCoinCollection.remove(e1); //quitamos e1
        euroCoinCollection.remove(e4); //quitamos e4
        assertEquals(0, euroCoinCollection.valueCollection()); //no hay monedas, 0
    }

    @Test
    void numberCoins() {
        assertEquals(2, euroCoinCollection.numberCoins());
        euroCoinCollection.remove(e1);
        euroCoinCollection.remove(e4);
        assertEquals(0, euroCoinCollection.numberCoins());
    }

    @Test
    void coinInCollection() {
        assertTrue(euroCoinCollection.coinInCollection(e1));  //ya en el setUp la habiamos añadido junto a e4
        assertFalse(euroCoinCollection.coinInCollection(e2)); //no esta e2
        euroCoinCollection.remove(e1); // quitamos e1 dejando solo e4
        euroCoinCollection.add(e2); //añadimos e2 quedando en la lista e2 y e4
        assertTrue(euroCoinCollection.coinInCollection(e2)); //esta e2
        assertFalse(euroCoinCollection.coinInCollection(e3));  // no esta e3
        assertTrue(euroCoinCollection.coinInCollection(e4)); //esta e4
    }

}
