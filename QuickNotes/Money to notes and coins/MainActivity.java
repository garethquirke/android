package ca1.moneyconversionapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertMoney(View view){

        Money m = new Money();

        EditText input = (EditText) findViewById(R.id.centsInput);
        TextView output = (TextView) findViewById(R.id.outputText);

        int cents = (Integer.parseInt(input.getText().toString().trim()));

        if(cents >= 5){
            m.ConvertCents(cents);

            Money money = m.ConvertCents(cents);
            String out = money.Print();
            output.setText(out);
        }
        else {

            Context c = getApplicationContext();
            CharSequence text = "Enter an amount above 5";
            int duration = Toast.LENGTH_SHORT;
            Toast t = Toast.makeText(c, text, duration);
            t.show();
        }
    }
}
