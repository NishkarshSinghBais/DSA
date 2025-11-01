import java.util.ArrayList;

public class Permutation_of_String {

    public static void main(String[] args) {

        String str = "XYZ";
        System.out.println(permutation("", str));
    }

    static ArrayList<String> permutation(String p, String up){

        if ( up.isEmpty() ){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 0; i < up.length(); i++) {
            String newup = up.substring(0, i) + up.substring(i + 1);
            String newp = p + up.charAt(i);

            list2.addAll(permutation(newp, newup));


        }

        return list2;
    }
}
