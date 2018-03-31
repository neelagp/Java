package cracking;

import java.util.*;

/**
 * Created by NeelaGouda on 7/30/17.
 */
public class Yelp {

    public static void main(String[] args) {


        List<List<Integer>> closestCrates = new ArrayList<List<Integer>>();
        List<Integer> crate = new ArrayList<Integer>();
        crate.add(1);
        crate.add(2);

        closestCrates.add(crate);
        closestLocations(1,closestCrates, 1);
    }

    static List<List<Integer>> closestLocations(int totalCrates,
                                         List<List<Integer>> allLocations,
                                         int truckCapacity)
    {
        // WRITE YOUR CODE HERE
        //save coordinate to area in the map
        List<List<Integer>> closestCrates = new ArrayList<List<Integer>>();
        Map<Integer,List<Integer>> coordinatesToArea = new TreeMap<Integer,List<Integer>>();
        for(List<Integer> locationOfItem : allLocations){
            int area = 0;
            for(Integer cordinate : locationOfItem){
                area = area + (cordinate * cordinate);
            }
            coordinatesToArea.put(area, locationOfItem);
        }
        int count =0;
        for(Map.Entry<Integer,List<Integer>> entry : coordinatesToArea.entrySet()){
            if(count >= truckCapacity) break;
            closestCrates.add(entry.getValue());
            count ++;

        }
        return closestCrates;
    }




}
