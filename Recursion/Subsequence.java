public class Subsequence {

    public static void main(String[] args){

        all_possible("", "abc");

    }

    static void all_possible(String p, String up){

        if ( up.isEmpty() ){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        all_possible(p + ch, up.substring(1));
        all_possible(p, up.substring(1));

    }
    
}
