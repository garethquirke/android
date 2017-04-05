package ca1.weatherconditions;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayList<WeatherInformation> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<WeatherInformation>();
        data.add(new WeatherInformation("Cork", 8, WeatherConditions.Sunny));
        data.add(new WeatherInformation("Dublin", 9, WeatherConditions.Sunny));
        data.add(new WeatherInformation("Galway", 10, WeatherConditions.Cloudy));
        data.add(new WeatherInformation("Limerick", 11, WeatherConditions.Rain));


        Spinner spinner = (Spinner) findViewById(R.id.citySpinner);
        List<String> cities = new ArrayList<String>();
        for(int i =0; i< data.size(); i++){
            cities.add(data.get(i).GetCity());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((adapter));

        spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        String city = parent.getItemAtPosition(pos).toString();
        TextView tempView = (TextView) findViewById(R.id.temperatureTextView);
        ImageView conditionsView = (ImageView) findViewById(R.id.conditionsImageView);

        for(WeatherInformation w: data){
            if(w.GetCity().equalsIgnoreCase(city)){
                tempView.setText(w.GetTemp() + "Celsius");

                if(w.GetCondition() == WeatherConditions.Sunny){
                    conditionsView.setImageResource(R.drawable.sunny);
                }
                else if (w.GetCondition() == WeatherConditions.Cloudy)
                {
                    conditionsView.setImageResource(R.drawable.cloudy);
                }
                else if (w.GetCondition() == WeatherConditions.Rain)
                {
                    conditionsView.setImageResource(R.drawable.rain);
                }
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
