import javax.swing.*;

public class Alphabet {

    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    public static final String NUMBERS = "1234567890";

    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";

    private final StringBuilder string;
    public Alphabet(boolean includeUpper, boolean includeLower, boolean includeInteger, boolean includeSymbol) {

        string = new StringBuilder();

        if(includeUpper){
            string.append(UPPERCASE_LETTERS);
        }
        if (includeLower) {
            string.append(LOWERCASE_LETTERS);
        }
        if (includeInteger){
            string.append(NUMBERS);
        }
        if(includeSymbol){
            string.append(SYMBOLS);
        }

    }

    public String getAlphabet(){
        return string.toString();
    }
}
