package cracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeelaGouda on 5/3/16.
 */
public class Lambda {

    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        List<Country> countryList = lambda.populatedCountries();
        int population = lambda.getPopulation(countryList, "SouthAmerica");
        System.out.println(population);
    }

    public int getPopulation(List<Country> countries, String continent){
        int sum =0;
        for(Country c : countries){
            if(c.getContinent().equalsIgnoreCase(continent)){
                sum += c.getPopulation();
            }
        }

        return sum;
    }

    public List<Country> populatedCountries(){
        Country c1 = new Country("India", "Asia", 50000);
        Country c2 = new Country("China", "Asia", 50000);
        Country c3 = new Country("Mexico", "SouthAmerica", 10000);
        Country c4 = new Country("CostaRica", "CentralAmerica", 1000);
        Country c5 = new Country("Peru", "SouthAmerica", 4000);

      List<Country> populatedCountryList = new ArrayList<Country>();
        populatedCountryList.add(c1);
        populatedCountryList.add(c2);
        populatedCountryList.add(c3);
        populatedCountryList.add(c4);
        populatedCountryList.add(c5);

        return  populatedCountryList;
    }
}
