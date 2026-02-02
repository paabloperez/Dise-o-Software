package e2;

public class KeyPad {

    public static boolean isValidKeyPad(char[][] keyPad) {
        if (keyPad == null || keyPad.length == 0) return false;  //por el buffer de teclado

        String revision = "1234567890ABCDEGHIJKLMNOPQRSTUVWXYZ";

        for (char[] row : keyPad) {
            if (row == null) return false; //revisas que no sea nulo el vector exterior
            if (row.length != keyPad[0].length) return false; //revisas que sea rectangular
        }

        boolean revisExterior = true;
        boolean revisInterior = true;
        int contExterior = 0;
        int contInterior = 0;


        for (char[] row : keyPad) {
            for (int i = 0; i < row.length; i++) {             //revisa que esten 1 2 3, 4 5 6, 7 8 9...
                if (row[i] != revision.charAt(contExterior)) {
                    revisExterior = false;
                }
                contExterior++;
            }
        }

        for (int i = 0; i < keyPad[0].length; i++) {
            for (int j = 0; j < keyPad.length; j++) {
                if (keyPad[j][i] != revision.charAt(contInterior)) {
                    revisInterior = false;
                }
                contInterior++;
            }
        }

        return revisExterior || revisInterior;


    }


    public static boolean areValidMovements(String[] input) {
        if (input == null || input.length == 0) { return false; }  //si no nos dieron movimientos
        for (String s : input) {   //revisamos que sean movimientos validos
            if (s == null || s.isEmpty()) {  //si uno de los movimientos esta vacio
                return false; }
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) != 'U' && s.charAt(j) != 'D' && s.charAt(j) != 'L' && s.charAt(j) != 'R') {   // letra no valida
                    return false;

                }
            }
        }

        return true;
    }


    public static String obtainCode(char[][] keyPad, String[] input) {
        StringBuilder resultado = new StringBuilder(); //si lo haces con un StringBuilder en lugar de concatenando es mejor porque cada
        //vez que concantenas se crea una cadena nueva
        if (!isValidKeyPad(keyPad) || !areValidMovements(input)) {
            throw new IllegalArgumentException();
        }

        int contVertical = 0, contHorizontal = 0;

        for (String s : input) {   //revisamos que sean movimientos validos
            if (s == null || s.isEmpty()) {  //si uno de los movimientos esta vacio
                throw new IllegalArgumentException(); }

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'U') {
                    contVertical--;
                }
                if (s.charAt(j) == 'D') {
                    contVertical++;
                }
                if (s.charAt(j) == 'L') {
                    contHorizontal--;
                }
                if (s.charAt(j) == 'R') {
                    contHorizontal++;
                }
                if (contVertical<=0) contVertical = 0;
                if (contHorizontal<=0) contHorizontal = 0;
                if (contVertical>= keyPad.length) contVertical = keyPad.length-1;
                if (contHorizontal>= keyPad[0].length) contHorizontal = keyPad[0].length-1;

                }
            resultado.append(keyPad[contVertical][contHorizontal]);
            }
        return resultado.toString();
        }

}













