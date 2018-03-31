package scoring;

import java.util.ArrayList;

/**
 * Created by NeelaGouda on 2/8/16.
 */
public class ScoringApp2 {

    public static void multTables ( int max ) {


        //print out table

        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= max; j++) {

                System.out.print(i * j + " ");
                ArrayList<String> arrayList = new ArrayList<String>();

            }
            System.out.println(" \n");
        }
    }

    public static void main(String[] args) {
        multTables(4);
    }
}
