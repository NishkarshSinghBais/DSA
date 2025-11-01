public class Remove_letter_from_string {

    public static void main(String[] args) {

        String up = "castapple app application";
        System.out.println(removeLetters("", up));
    }

    static String remove(String p, String up){

        if ( up.isEmpty() ){
            return p;
        }

        char ch = up.charAt(0);

        if ( ch == 'a' ){
            return remove(p, up.substring(1));
        } else {
            return ch + remove(p, up.substring(1));
        }
    }

    static String removeLetters(String p, String up){

        if ( up.isEmpty() ){
            return p;
        }

        char ch = up.charAt(0);

        if ( up.startsWith("app")){
            return removeLetters(p, up.substring(3));
        } else {
            return ch + removeLetters(p, up.substring(1));
        }
    }
}
