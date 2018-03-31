package cracking;

/**
 * Created by NeelaGouda on 5/3/16.
 */
public class Country {

    private String name;
    private String continent;
    private Integer population;

    public Country(String name, String continent, Integer population) {
        this.name = name;
        this.continent = continent;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public Integer getPopulation() {
        return population;
    }
}
