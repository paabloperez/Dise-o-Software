package e4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EuroCoinTest {

    private static EuroCoin e1, e2, e3, e4, e5;

    @BeforeAll
    static void setUp(){
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

        e4 = new EuroCoin( null,
                ColorType.Oro, EuroCountryType.Belgium,  //año no valido
                "Marmota", 0);

        e5 = new EuroCoin( EuroValue.EURO10, //deberia dar error por el color
                ColorType.Bronce,
                EuroCountryType.Croatia,
                "Fake", 0);
    }



    @Test
    void isEuroNull (){
        assertFalse(e1.isEuroNull());
        assertFalse(e2.isEuroNull());
        assertFalse(e3.isEuroNull());
        assertTrue(e4.isEuroNull());
    }


    @Test
    void euroValue() {
        assertEquals(EuroValue.EURO200, e1.euroValue());
        assertEquals(EuroValue.EURO100, e2.euroValue());
        assertEquals(e1.euroValue(), e3.euroValue());
        assertNull(e4.euroValue());
        assertNotNull(e5.euroValue());
    }

    @Test
    void testEquals() {
        assertNotEquals(e1, e2);
        assertEquals(e1, e3);
        assertNotEquals(e1, e4);
    }

    @Test
    void testHashCode() {
        assertNotEquals(e1.hashCode(), e2.hashCode());
        assertEquals(e1.hashCode(), e3.hashCode());
        assertNotEquals(e1.hashCode(), e4.hashCode());
    }

    @Test
    void testToString() {
        String prueba = """
                Coin:
                Value :200
                Oro_Plata
                Austria
                Juan
                2003
                """;
        assertEquals(prueba, e1.toString());
    }
}
