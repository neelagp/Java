package sorting;

/**
 * Created by NeelaGouda on 2/2/16.
 */
public class StringExamples {



    public static void main(String[] args) {
        String str1 = new String("my name is, neela");
        String s1 = str1.substring(5);
        System.out.println("s1 = " + s1);
        String s2 = str1.substring(5,5);
        System.out.println("s2 = " + s2);
        /*String s3 = str1.substring(-1,5);
        System.out.println("s3 = " + s3);*/
        String s4 = str1.trim();
        System.out.println("s4 = " + s4);
        String s5 = new String(s4);

        double result = 4.0/0.0;
        System.out.println("result = " + result);


    }
}
