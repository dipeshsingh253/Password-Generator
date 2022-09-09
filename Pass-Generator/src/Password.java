public class Password {
    String value;
    int length;

    public Password(String s) {
        value = s;
        length = s.length();
    }

    private int charType(char ch){
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

    private int getStrength(){
        String password = this.value;
        int count = 0;
        /*
        this method will return count :
        if(count> 6) then the password is strong
        if(count<6 > 4) then it is good
        if(count<4) then it is week
         */
        boolean upperIncluded = false;
        boolean lowerIncluded = false;
        boolean numberIncluded = false;
        boolean symbolIncluded = false;

        if(password.length()>=12){
            count++;
            count++;
        }else{
            count++;
        }


        for (int i=0;i<password.length();i++){

           char c = password.charAt(i);

           if(charType(c)==1) upperIncluded = true;
           if(charType(c)==2) lowerIncluded = true;
           if(charType(c)==3) numberIncluded = true;
           if(charType(c)==4) symbolIncluded = true;

        }


        if(upperIncluded) count++;
        if(lowerIncluded) count++;
        if(numberIncluded) count++;
        if(symbolIncluded) count++;

        return count;
    }

    public void returnScore(){
        int score = this.getStrength();

        if(score>=6) {
            System.out.println("Strong");
        } else if (score<6 && score>4) {
            System.out.println("Medium");
        }else {
            System.out.println("Week");
        }
    }

}
