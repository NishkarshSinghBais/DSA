public class Reverse_String_of_Words {

    public static void main(String[] args){

        String str = "  Java Is      This ";
        System.out.println(reverse(str));
    }

    static String reverse(String str){

        String[] words = str.split(" +");

        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0 ; i--) {
            sb.append(words[i]);
            if ( i != 0 ){
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
