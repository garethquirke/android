package ca1.countrymap;

/**
 * Created by garet on 05/04/2017.
 */

public class CountryInformation {

    private String Name;
    private int Population;
    private  WeatherCondition Condition;

    public CountryInformation(String name, int population, WeatherCondition condition) {
        Name = name;
        Population = population;
        Condition = condition;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int population) {
        Population = population;
    }

    public WeatherCondition getCondition() {
        return Condition;
    }

    public void setCondition(WeatherCondition condition) {
        Condition = condition;
    }
}

enum WeatherCondition{Cloudy, Sunny, Rainy}
