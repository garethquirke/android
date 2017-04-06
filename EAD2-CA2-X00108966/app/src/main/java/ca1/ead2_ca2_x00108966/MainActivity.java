package ca1.ead2_ca2_x00108966;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private ArrayList<AndroidInfo> androidInfos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        androidInfos = new ArrayList<AndroidInfo>();
        androidInfos.add(new AndroidInfo("Nougat","7.1", 25, 2016));
        androidInfos.add(new AndroidInfo("Nougat","7.0",24,2016));
        androidInfos.add(new AndroidInfo("Marshmallow", "6.0",23,2015));
        androidInfos.add(new AndroidInfo("Lollipop", "5.1",22,2014));
        androidInfos.add(new AndroidInfo("Lollipop", "5.0",21,2014));
        androidInfos.add(new AndroidInfo("Kitkat", "4.4 - 4.4.4",19,2013));
        androidInfos.add(new AndroidInfo("Jelly Bean", "4.3.x",18,2012));
        androidInfos.add(new AndroidInfo("Jelly Bean", "4.2.x", 17, 2012 ));
        androidInfos.add(new AndroidInfo("Jelly Bean", "4.1.x", 16, 2012));

    }

    public void submit(View view){

        EditText input = (EditText) findViewById(R.id.input);
        TextView output = (TextView) findViewById(R.id.codeNameOuput);
        TextView output1 = (TextView) findViewById(R.id.platformversionOuput);
        TextView output2 = (TextView) findViewById(R.id.apiLevelOutput);
        TextView output3 = (TextView) findViewById(R.id.yearOuput);

        boolean found = false;
        int option = 0;

        try{
            option = (Integer.parseInt(input.getText().toString().trim()));
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Please enter an option", Toast.LENGTH_SHORT).show();
        }


                for(AndroidInfo info: androidInfos){
                    if(info.getApiLevel() == option){
                        found = true;
                        output.setText("Code Name: " + String.valueOf(info.CodeName));
                        output1.setText("Platform Version: " + String.valueOf(info.getPlatformVersion()));
                        output2.setText("API level: " + String.valueOf(info.getApiLevel()));
                        output3.setText("Year: " + String.valueOf(info.getYear()));
                    }
                }
                if(found == false){
                    output.setText("Not found");
                    output1.setText("");
                    output2.setText("");
                    output3.setText("");
                }
            }
        }



