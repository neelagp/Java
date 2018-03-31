package cracking;

/**
 * Created by NeelaGouda on 5/5/16.
 */
public class URLify {

    static String  toReplace = "My name is Neela";

    public static void main(String[] args) {
        URLify urLify = new URLify();
        urLify.replaceString(toReplace.toCharArray(), toReplace.length());

    }

    private void replaceString(char [] str, int truelength){

        int i=0;
        int spaceCount=0;
        int index;

        for(i=0; i<str.length -1; i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }

        index = truelength+ spaceCount * 2;

        for(i=truelength-1; i>=0; i--){

            if(str[i] == ' '){
                str[index-1]= '0';
                str[index-2]= '2';
                str[index-3]= '%';
                index=index-3;

            }
            else{
                str[index-1] = str[i];
                index--;
            }

        }

        printArray(str);
    }

    private void printArray(char[] str) {
        for (int i =0; i< str.length; i++){
            System.out.print(str[i]);
        }
    }
}
