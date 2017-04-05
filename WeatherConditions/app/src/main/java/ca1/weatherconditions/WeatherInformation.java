package ca1.weatherconditions;

/**
 * Created by garet on 05/04/2017.
 */

public class WeatherInformation {

    private String City;
    private double Temperature;
    private WeatherConditions Condition;


    public WeatherInformation(String city, double temp, WeatherConditions condition){
        this.City = city;
        this.Temperature = temp;
        this.Condition = condition;
    }



    public String GetCity(){
        return City;
    }

    public double GetTemp(){
        return Temperature;
    }

    public WeatherConditions GetCondition() {
        return Condition;
    }

}

enum WeatherConditions{
    Cloudy, Sunny, Rain
}