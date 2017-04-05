package ca1.countrymap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayList<CountryInformation> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        countries = new ArrayList<CountryInformation>();
        countries.add(new CountryInformation("Ireland", 3000, WeatherCondition.Sunny));
        countries.add(new CountryInformation("Catalonia", 4000, WeatherCondition.Cloudy));
        countries.add(new CountryInformation("Australia",5000, WeatherCondition.Rainy));


        // To create a spinner with list of country names as options
        Spinner spinner = (Spinner) findViewById(R.id.options);
        List<String> countryNames = new ArrayList<String>();
        for(int i = 0; i < countries.size(); i++){
            countryNames.add(countries.get(i).getName());
        }
        // now use an array adapter to assign values to the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, countryNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

    }

    // item on picker selected
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    {
        String name = parent.getItemAtPosition(pos).toString();
        TextView weatherText = (TextView) findViewById(R.id.weather);
        TextView populationText = (TextView) findViewById(R.id.population);
        ImageView mapPicture = (ImageView) findViewById(R.id.map);

        // java implementation of the for each loop
        for(CountryInformation c: countries){

        // an item has been selected from the list we now have to preform stuff to handle this
            if(c.getName().equalsIgnoreCase(name)){
                weatherText.setText("Weather: " + String.valueOf(c.getCondition()));
                populationText.setText("Population: " + String.valueOf(c.getPopulation()));

                if(name.equalsIgnoreCase("Ireland")){
                    mapPicture.setImageResource(R.drawable.ireland);
                }
                else if(name.equalsIgnoreCase("Catalonia")){
                    mapPicture.setImageResource(R.drawable.catalonia);
                }
                else if(name.equalsIgnoreCase("Australia")){
                    mapPicture.setImageResource(R.drawable.australia);
                }


            }


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
