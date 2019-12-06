import static java.lang.Character.*;

public class ROT13  {
    private final char[] upperCaseStart = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final String lowerCaseStart = "abcdefghijklmnopqrstuvwxyz";
    protected String startUpper;
    protected String startLower;
    protected String registerUpper;
    protected String registerLower;
    Character cs;
    Character cf;

    private Integer delta;


    ROT13(Character cs, Character cf) {
    delta = cf.compareTo(cs);
    }

    ROT13() {
        cs = 'a';
        cf = 'n';
        delta = cf.compareTo(cs);
    }


    public String crypt(String text) throws UnsupportedOperationException {

        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            Integer index = getAlphabetIndex(text.charAt(i)) + delta;
            Character in = (!isAlpha(text.charAt(i))) ?
                    text.charAt(i) :
                    (index < upperCaseStart.length) ?
                            upperCaseStart[index] :
                            upperCaseStart[index - upperCaseStart.length];

            encrypted.append(matchCase(text.charAt(i), in));
        }
        return encrypted.toString();
    }

    public Integer getAlphabetIndex(Character ch){
        Integer index = -1;
        for (int i = 0; i < upperCaseStart.length; i++) {
            if (String.valueOf(ch).toUpperCase().equals(String.valueOf(upperCaseStart[i]))) {
                index = i;
                break;
            }
        }
        return index;

    }

    public Boolean isAlpha(Character c) {
        return String.valueOf(c).matches("[A-Za-z]");
    }

   /* public Boolean isUpper(Character a) {
        return String.valueOf(a).matches("[A-Z]");
    } */

    public Character matchCase(Character in, Character out) {

        if (isUpperCase(in)) out = out.toString().toUpperCase().charAt(0);
        else out = out.toString().toLowerCase().charAt(0);
        return out;
    }

    public String encrypt(String text) {
       // delta = 13; //hardcoding for now
        return crypt(text);
    }

    public String decrypt(String text) {
        delta = upperCaseStart.length - delta;
        return crypt(text);
    }

    public String rotate(String s, Character c) {

        StringBuilder rotated = new StringBuilder();
        delta = c.compareTo(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            char in = (i+delta < s.length()) ?
                    s.charAt(i+delta) :
                    s.charAt(i+delta - s.length());

            rotated.append(in);
        }
        return rotated.toString();
    }

}
