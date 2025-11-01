public class Remove_Letter {

    public static void main(String[] args) {

        System.out.println(removeString("Nishkarapplesh"));
        
    }

    static String removeLetter( String o){

        if ( o.isEmpty()){
            return "";
        }

        char ch = o.charAt(0);

        if ( ch == 'a'){
            return removeLetter(o.substring(1));

        } else {
            return ch + removeLetter(o.substring(1));

        }
    }


    static String removeString( String o){

        if ( o.isEmpty()){
            return "";
        }



        if ( o.startsWith("apple")){
            return removeString(o.substring(5));

        } else {
            return o.charAt(0)  + removeString(o.substring(1));

        }
    }
    
}

