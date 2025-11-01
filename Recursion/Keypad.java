public class Keypad {

    public static void main(String[] args) {

       System.out.println(countPad("", "12"));
        
    }

    static void pad(String p, String up){

        if ( up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0'; // char into int

        for (int i = (digit - 1) * 3; i < (digit * 3); i++) {

            char ch = (char) ('a' + i); 

            pad(p + ch, up.substring(1));
            
        }
    }


    static int countPad(String p, String up){

        if ( up.isEmpty()){
            return 1;
        }

        int count = 0;

        int digit = up.charAt(0) - '0'; // char into int

        for (int i = (digit - 1) * 3; i < (digit * 3); i++) {

            char ch = (char) ('a' + i); 

            count = count + countPad(p + ch, up.substring(1));

        }

        return count;
    
}

}
