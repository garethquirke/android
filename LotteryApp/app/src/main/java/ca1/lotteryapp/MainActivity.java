package ca1.lotteryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ArrayList<Integer> numbers;
    Random randomGenerator;
    boolean exsists;
    int newNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        randomGenerator = new Random();
        numbers = new ArrayList<Integer>();
    }


    public void generate(View view){
        int range = 45;

        ArrayList<Integer> numbers = new ArrayList<Integer>(range);
        for(int i = 1; i<= range; i++){
            numbers.add(i);
        }

        Random random = new Random();
        ArrayList<Integer> lotteryNumbers = new ArrayList<Integer>(6);
        while(numbers.size() != 40){
            int num = random.nextInt(numbers.size());
            lotteryNumbers.add(num);
            numbers.remove(num);
        }

        String result = "";
        for(int i = 0; i < lotteryNumbers.size(); i++){
            result+= lotteryNumbers.get(i).toString() + ",";
        }


        TextView results = (TextView) findViewById(R.id.results);
        results.setText(result);

    }

}