package cracking;

/**
 * Created by NeelaGouda on 5/16/16.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        String duplicate = "teessrrttt";
        RemoveDuplicates dup = new RemoveDuplicates();
        dup.removeDup(duplicate.toCharArray());
    }

    public void removeDup(char[] duplicate){

        int length = duplicate.length;

        if (length == 0 || length == 1){
            return;
        }

        int tail =1;


        for(int i =1; i<length-1; i++){
            int j;
            for( j=0; j<tail; j++){
                if(duplicate[i] == duplicate[j])break;
            }

            if( j == tail){
                duplicate[tail] = duplicate[i];
                ++tail;
            }
        }
        duplicate[tail]= 0;

        System.out.println(String.valueOf(duplicate));


    }
}
