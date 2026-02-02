package e2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccionTest {
     private static Accion a1, a2, a3, a4, a5;

     @BeforeEach
     void setUp() {
         a1 = new Accion( "APPL", 10.003, 1.9, 1.4, 10.50);
         a2 = new Accion( "Amigo", 10, 1.9, 1.4, 10.50);
         a3 = new Accion( "LUPP", 10, 1.9, 1.4, 10.50);
         a4 = new Accion( "MICR", 10, 1.9, 1.4, 10.50);
         a5 = new Accion( "MICR", 10, 1.9, 1.4, 10.50);
     }


    @Test
    void testToString() {
         String s = a1.toString();
         assertEquals("Accion APPL: Cierre 10.003 Maximo:1.9 Minimo:1.4 Volumen:10.5", s);
    }

}
