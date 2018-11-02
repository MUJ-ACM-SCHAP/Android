package com.yashovardhan99.randomgenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText minText,maxTest;
    TextView output;
    Button generate, die, dice2, coin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set views from IDs
        minText = findViewById(R.id.min);
        maxTest = findViewById(R.id.max);
        output = findViewById(R.id.output);
        generate = findViewById(R.id.generate);
        die = findViewById(R.id.die);
        dice2 = findViewById(R.id.dice2);
        coin = findViewById(R.id.coin);
        //set onClickListener on buttons
        generate.setOnClickListener(this);
        die.setOnClickListener(this);
        dice2.setOnClickListener(this);
        coin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) { //onClickListener
        switch (v.getId()){ //checking which button was pressed
            case R.id.generate: //generate random in range
                try{
                    int min = Integer.parseInt(minText.getText().toString());
                    int max = Integer.parseInt(maxTest.getText().toString());
                    // may throw NumberFormatException if NaN
                    if(max<min)
                        throw new NumberFormatException(); //to output error when min > max
                    int random = (int) (min + Math.random()*(max - min + 1)); //generating random
                    output.setText("Generated : "+random); //output
                } catch (NumberFormatException e){
                    output.setText("Invalid input"); //error message
                } catch (NullPointerException e){
                    output.setText("An error occured");
                } finally {
                    generate.setText("Generate another"); //optional
                }
                break;
            case R.id.die: //for a single die
                int dieRoll = (int) (6*Math.random() + 1); //random in range 1-6
                output.setText("You rolled a "+dieRoll); //output
                break;
            case R.id.dice2: //for 2 dice
                int dieRoll1 = (int) (6*Math.random() + 1); //random 1
                int dieRoll2 = (int) (6*Math.random() + 1); //random 2
                output.setText("You rolled "+dieRoll1+" and "+dieRoll2+"; Sum = "+(dieRoll1+dieRoll2)); //output
                break;
            case R.id.coin:
                if(Math.random()<0.5) //since output is in range [0,1), we can say [0,0.5) is heads and [0.5,1) is tails.
                    output.setText("Its Heads!");
                else
                    output.setText("You got Tails!");
                break;
        }
    }
}