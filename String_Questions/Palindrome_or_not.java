public class Palindrome_or_not {

    public static void main(String[] args) {

        String str ="n";
        System.out.println(palindrome(str));

    }

    static boolean palindrome(String str){

        str = str.toLowerCase();

        if ( str.isEmpty() ){
            return true;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            int s = str.charAt(i);
            int e = str.charAt(str.length() - 1 - i);

            if ( s != e ){
                return false;
            }
        }

        return true;
    }
}
