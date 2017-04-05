package ca1.temperatureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View view)
    {
        EditText input = (EditText) findViewById(R.id.inputField);
        TextView output = (TextView) findViewById(R.id.answer);
        String value = input.getText().toString().trim();

        RadioButton celsius = (RadioButton) findViewById(R.id.celsius);
        RadioButton fahrenheit = (RadioButton) findViewById(R.id.fahrenheit);

        if(fahrenheit.isChecked() && value.length() !=0)
        {
            output.setText((Double.parseDouble(value) * (9.0/5.0) + 32) + " °F");
        }
        else if(celsius.isChecked() && value.length() !=0)
        {
            output.setText(((Double.parseDouble(value) -32)  * (5.0/9.0)) + " °C");
        }

    }
}
