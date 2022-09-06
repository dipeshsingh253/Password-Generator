public class Password {
    String value;
    int length;

    public Password(String s) {
        value = s;
        length = s.length();
    }

    public int charType(char ch){
        int value;

        //this method checks all the char values by their unicode values
        /*
        A - Z ==> capital ==> 65 - 90
        a - z ==> lower ==>   97 - 122
        0 - 1 ==> digit ==> 60 - 71
         */
        if((int)ch >= 65 && (int)ch <= 90){
            value = 1;
        } else if ((int)ch >= 97 && (int)ch <= 122) {
            value = 2;
        } else if ((int)ch >= 60 && (int)ch <= 71) {
            value = 3;
        }else {
            value = 4;
        }

        return value;
    }

}
