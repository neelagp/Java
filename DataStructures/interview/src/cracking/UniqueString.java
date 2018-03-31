package cracking;


public class UniqueString {

    public static void main(String[] args) {
        String unique = "qqcdef";
        String nonUnique = "bcdef";
        Boolean val = isUnique(unique);
        System.out.println(val);


    }

    public static boolean isUnique(String str){
        if(str.length() > 128){
            return false;
        } else{
            boolean[] charSet = new boolean[128];
            for(int i =0; i< str.length(); i++){
                int val = str.charAt(i);
                if(charSet[val]){
                    return false;
                }
                else{
                    charSet[val] = true;
                }

            }
        }
        return true;
    }

}
