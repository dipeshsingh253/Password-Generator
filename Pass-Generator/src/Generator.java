import java.util.Scanner;

public class Generator {

    Alphabet alphabet;

    public static Scanner scanner;

    public Generator(Scanner input){
        scanner = input;
    }

    public Generator(boolean includeUpper, boolean includeLower, boolean includeInteger, boolean includeSymbol) {
        alphabet = new Alphabet(includeUpper, includeLower, includeInteger, includeSymbol);
    }

    public void mainLoop(){

        System.out.println("Hey there, Welcome to Shivay Password Service...");

        printOptions();

        String userChoice = "-1";

        while(!userChoice.equals("3")){
            userChoice = scanner.next();

            switch (userChoice){
                case "1":{
                    createPassword();
                    printOptions();
                    break;
                }
                case "2":{
                    System.out.println("Choice is 2");
                    printOptions();
                    break;
                }
                case "3":{
                    System.out.println("Chal bhai chalate hai ab..");
                    break;
                }
                default:{
                    System.out.println("Kindly Slect one of the following");
                    printOptions();
                }

            }
        }

    }

    private void createPassword() {

        boolean includeUpper = false;
        boolean includeLower = false;
        boolean includeInteger = false;
        boolean includeSymbols = false;

        //boolean isOkay = false;
        System.out.println("Hello, Welcome to the Password Generator :) Answer the following questions");

        System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
        printYesOrNo();
        includeUpper = returnAppropriate(scanner.next());

        System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
        printYesOrNo();
        includeLower = returnAppropriate(scanner.next());

        System.out.println("Do you want Numbers \"1234...\" to be used? ");
        printYesOrNo();
        includeInteger = returnAppropriate(scanner.next());

        System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
        printYesOrNo();
        includeSymbols = returnAppropriate(scanner.next());

        System.out.println(includeUpper);
        System.out.println(includeLower);
        System.out.println(includeInteger);
        System.out.println(includeSymbols);

        if(!includeUpper && !includeLower && !includeInteger && !includeSymbols){
            System.out.println("In order to generate password you must choose at least Yes one time");
            System.out.println("Try again ...!");
            return;
        }

        System.out.println("Great! Now enter the length of the password");
        int length = scanner.nextInt();

        final Generator generator = new Generator(includeUpper, includeLower, includeInteger, includeSymbols);
        final Password password = generator.generatePasswordOfLength(length);

        System.out.println("Your Generated Password is : "+password.value);


    }


    private Password generatePasswordOfLength(int length){
        final StringBuilder password = new StringBuilder();
        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength -1; //length of string that consist all possible char we can use to create password
        int min = 0; // this will always be zero
        int range = max - min +1;
        /*
        explanation of above formula:
        let say if Math.random()  => always returns double<1 ex:0.24587845 etc.

        if we will multiply this Math.random with any other constant number there might be a case when the index becomes>length

        so prevent this situation I have used above formula that limits the value of random index;
         */

        for (int i=0; i<length;i++){
            int randomIndex = (int)(Math.random()*range)-min; //this value will never exceed value of length
            password.append(alphabet.getAlphabet().charAt(randomIndex));
        }

        return new Password(password.toString());
    }

    private void printYesOrNo() {
        System.out.println("1 : Yes");
        System.out.println("2 : No");
    }

    private boolean returnAppropriate(String s){
        if(!s.equals("1") && !s.equals("2")){
            System.out.println("Choosing rather than Yes or No will be consider as No");
            return false;
        }
        if(s.equalsIgnoreCase("1")){
            return true;
        }
        else {
            return false;
        }
    }

    private void printOptions() {

        System.out.println("Enter your choice...");
        System.out.println();

        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Quit");
        System.out.print("Choice:");

    }


}
