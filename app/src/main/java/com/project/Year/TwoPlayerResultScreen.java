package com.project.Year;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TwoPlayerResultScreen extends AppCompatActivity {

    TextView Player1Score;
    TextView Player2Score;
    TextView WhoWins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player_result_screen);

        Player1Score = (TextView) findViewById(R.id.Player1Score);
        Player2Score = (TextView) findViewById(R.id.Player2Score);
        WhoWins = (TextView) findViewById(R.id.WhoWinsLabel);
        Button mainMenuBtn = (Button) findViewById(R.id.btnMainMenu);


        if (TwoPlayerGameScreen.scoreOn > TwoPlayerGameScreen.scoreOnPlayer2){
            Player1Score.setText("Player 1 Final Score: "+ TwoPlayerGameScreen.scoreOn);
            Player2Score.setText("Player 2 Final Score: "+ TwoPlayerGameScreen.scoreOnPlayer2);
            WhoWins.setText("Player 1 Wins!");
        }

        else if (TwoPlayerGameScreen.scoreOn < TwoPlayerGameScreen.scoreOnPlayer2){
            Player1Score.setText("Player 1 Final Score: "+ TwoPlayerGameScreen.scoreOn);
            Player2Score.setText("Player 2 Final Score: "+ TwoPlayerGameScreen.scoreOnPlayer2);
            WhoWins.setText("Player 2 Wins!");
        }
        else if (TwoPlayerGameScreen.scoreOn == TwoPlayerGameScreen.scoreOnPlayer2){
            Player1Score.setText("Player 1 Final Score: "+ TwoPlayerGameScreen.scoreOn);
            Player2Score.setText("Player 2 Final Score: "+ TwoPlayerGameScreen.scoreOnPlayer2);
            WhoWins.setText("Draw!");
        }

        mainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(TwoPlayerResultScreen.this, MainMenu.class);
                startActivity(myIntent);
                finish();
            }
        });
    }
}
