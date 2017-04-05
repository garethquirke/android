package ca1.azurestorage;

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

        ((RadioButton) findViewById(R.id.geographicalRadioButton)).toggle();
    }



    public void calcStorageCost(View view){
        final double GeoCostPerGBLevel1 = 0.125;               	// up to 1 TB, geographically redundant
        final double GeoCostPerGBLevel2 = 0.11;                 // for excess of I TB, geographically redundant
        final double LocalCostPerGBLevel1 = 0.093;              // up to 1 TB, locally redundant
        final double LocalCostPerGBLevel2 = 0.083;              // for excess of I TB, locally redundant


        RadioButton geographicalRadio = (RadioButton) findViewById(R.id.geographicalRadioButton);
        boolean geographical = geographicalRadio.isChecked();

        EditText storageEditText = (EditText) findViewById(R.id.gigabyteStorageTextEdit);
        int storage = Integer.parseInt(storageEditText.getText().toString());

        double cost = 0;
        if(geographical){
            if(storage > 1000){
                cost = (1000 * GeoCostPerGBLevel1) + ((storage - 1000) * GeoCostPerGBLevel2);
            }
            else{
                cost = storage * GeoCostPerGBLevel1;
            }
        }
        else{
            if(storage > 1000){
                cost = (1000 * LocalCostPerGBLevel1) + ((storage - 1000) * LocalCostPerGBLevel2);
            }
            else{
                cost = storage * LocalCostPerGBLevel1;
            }
        }


        // output result
        TextView costTextView = (TextView) findViewById(R.id.costTextView);
        costTextView.setText("Cost = $ " + cost + " per month");

    }
}
