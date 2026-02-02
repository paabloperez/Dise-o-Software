package e1;

public class StringGames {


    public static String bestCharacters(String s1, String s2) {
        int min1=0; int min2=0; int may1=0; int may2=0; int num1=0; int num2=0; int win1=0; int win2=0;

        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < s1.length(); i++) { /*porque tienen la misma longitud lo haces en el mismo for */
                if (Character.isLowerCase(s1.charAt(i)) ) {
                    min1++;
                }
                if (Character.isLowerCase(s2.charAt(i))) {
                    min2++;
                }

                if (Character.isUpperCase(s1.charAt(i))) {
                    may1++;
                }
                if (Character.isUpperCase(s2.charAt(i))) {
                    may2++;
                }

                if (Character.isDigit(s1.charAt(i))) {
                    num1++;
                }
                if (Character.isDigit(s2.charAt(i))) {
                    num2++;
                }
            }

            if (min1>=min2) {
                win1++;
            } else win2++;
            if (may1>=may2) {
                win1++;
            } else win2++;
            if (num1>=num2) {
                win1++;
            } else win2++;


            if (win2>win1) {
                return s2;
            } else return s1;


        }
    }


public static int crossingWords(String s1, String s2) {
    int igual=0;

    for (int i = 0; i < s1.length(); i++) {
        for (int j = 0; j < s2.length(); j++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                igual++;
            }
        }
    }
    return igual;
}


public static String wackyAlphabet(String s1, String s2) {
       String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder resultado = new StringBuilder();
       int valorS2=0, valorAlfabeto=0;

     if (s2.length() != alfabeto.length()) {
         throw new IllegalArgumentException();
    } else {
          for (int i = 0; i < s2.length(); i++) {
              valorS2=valorS2+Character.getNumericValue(s2.charAt(i));
              valorAlfabeto=valorAlfabeto+Character.getNumericValue(alfabeto.charAt(i));
          }
      }
      if (valorS2!=valorAlfabeto) {
          throw new IllegalArgumentException();
      }

      for (int i = 0; i < s2.length(); i++) {
        for (int j = 0; j < s1.length(); j++) {
            if (s1.charAt(j) == s2.charAt(i)) {
                resultado.append((s2.charAt(i)));
            }
        }
      }


    return resultado.toString();
}


}