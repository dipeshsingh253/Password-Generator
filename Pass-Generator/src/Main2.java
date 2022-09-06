import java.util.Stack;

public class Main2 {

    public static void checkValidity(String input){
        Stack<Character> stack = new Stack<>();
        stack.push('c');
        if(input.length()%2==0){
            System.out.println("Invalid String");
            return;
        }

        String LOWERCASE_LETTERS = "defghijklmnopqrstuvwxyz";
        for(int i=0;i<LOWERCASE_LETTERS.length();i++){
            Character str = LOWERCASE_LETTERS.charAt(i);
            if(input.contains(str.toString())){
                System.out.println("Invalid String");
                return;
            }
        }

        int i=0;

        while(!(input.charAt(i) =='c')){
            //System.out.println(input.charAt(i));

            if(input.charAt(i)==' ' ){
                System.out.println("Invalid String");
                return;
            }else {
                stack.push(input.charAt(i));
            }
            i++;
        }

        //System.out.println(stack);

        i++;

        while (stack.peek()!='c' && i<input.length()){
           // System.out.println(i);
            char next = input.charAt(i);
            char x = stack.pop();
            if(!(x==next)){
                System.out.println("invalid string");
                return;
            }

            i++;
        }

        //System.out.println(stack);
        //System.out.println(input+" "+i);


        if(stack.size()>1){
            System.out.println("Invaldi String");
        }else {
            System.out.println("Valid String");
        }
//        try {
//            if(input.charAt(i)!=' '){
//                System.out.println("Invaldi String");
//            }
//        }catch (IndexOutOfBoundsException ioe){
//            System.out.println("Valid String");
//        }
    }

    public static void main(String[] args) {


        String input = "aabbbcbbba";
        String input2 = "abbacabba";
        String input3 = "abbcbb";

        checkValidity(input);
        checkValidity(input2);
        checkValidity(input3);


        //System.out.println(input.charAt(i));
    }

}
