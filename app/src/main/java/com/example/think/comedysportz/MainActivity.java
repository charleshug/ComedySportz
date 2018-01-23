package com.example.think.comedysportz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int currentGameRoundTextCounter = 0;
    String[] roundsList = {"Opening", "Choice", "Ref's Choice", "Catch Up", "Halftime", "Head to Head", "Challenge", "Last Chance"};

    int blueScoreInt;
    int redScoreInt;


    //GUI variables
    TextView gameRoundText;
    Button gameRoundLeft_Button;
    Button gameRoundRight_Button;
    Button blueScoreboard;
    Button redScoreboard;
    TextView blueScoreView;
    TextView redScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GUI references
        gameRoundText = (TextView) findViewById(R.id.gameRoundText);
        gameRoundLeft_Button = (Button) findViewById(R.id.gameRoundLeft_Button);
        gameRoundRight_Button = (Button) findViewById(R.id.gameRoundRight_Button);

        //TODO
        //get scoreboard GUI reference
//        blueScoreboard = (Button) findViewById(R.id.blueScoreboard);
        blueScoreView = (TextView) findViewById(R.id.blueScore);
//        redScoreboard = (Button) findViewById(R.id.redScoreboard);
        redScoreView = (TextView) findViewById(R.id.redScore);


        //Set scores and game round TextView
        blueScoreInt = 0;
        blueScoreView.setText(Integer.toString(blueScoreInt));
        redScoreInt = 0;
        redScoreView.setText(Integer.toString(redScoreInt));
        gameRoundText.setText(roundsList[currentGameRoundTextCounter]);

        //set listeners
        gameRoundLeft_Button.setOnClickListener(leftButton_OnClickListener);
        gameRoundRight_Button.setOnClickListener(rightButton_OnClickListener);

        //TODO
        //set generic scoreboard listener
        blueScoreView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //increase score
                blueScoreInt++;
                blueScoreView.setText(Integer.toString(blueScoreInt));
            }
        });

        redScoreView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //increase score
                redScoreInt++;
                redScoreView.setText(Integer.toString(redScoreInt));
            }
        });
    }


    View.OnClickListener leftButton_OnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            //forward the game direction
            changeGame(false);
        }
    };

    View.OnClickListener rightButton_OnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            //reverse the game direction
            changeGame(true);
        }
    };

    public void changeGame(boolean direction) {
        if (direction && currentGameRoundTextCounter < (roundsList.length - 1))
            currentGameRoundTextCounter++;
        if (!direction && currentGameRoundTextCounter > 0)
            currentGameRoundTextCounter--;

        gameRoundText.setText(roundsList[currentGameRoundTextCounter]);
    }


}



