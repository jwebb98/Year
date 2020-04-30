package com.project.Year;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        TextView highScoreLabel = (TextView) findViewById(R.id.highScoreLabel);
        Button mainMenuBtn = (Button) findViewById(R.id.btnMainMenu);

        int historyScoreOn = getIntent().getIntExtra("HISTORY_SCORE",0);
        int filmScoreOn = getIntent().getIntExtra("FILM_SCORE",0);
        int albumsScoreOn = getIntent().getIntExtra("ALBUMS_SCORE",0);
        int hiphopScoreOn = getIntent().getIntExtra("HIPHOP_SCORE",0);
        int f1PodiumsScoreOn = getIntent().getIntExtra("F1PODIUMS_SCORE",0);
        int uefaCLScoreOn = getIntent().getIntExtra("UEFACL_SCORE",0);
        //scoreLabel.setText(historyScoreOn + "");

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int historyHighScore = settings.getInt("HISTORY_HIGH_SCORE", 0);
        int filmHighScore = settings.getInt("FILM_HIGH_SCORE", 0);
        int albumsHighScore = settings.getInt("ALBUMS_HIGH_SCORE", 0);
        int hiphopHighScore = settings.getInt("HIPHOP_HIGH_SCORE", 0);
        int f1PodiumsHighScore = settings.getInt("F1PODIUMS_HIGH_SCORE", 0);
        int uefaCLHighScore = settings.getInt("UEFACL_HIGH_SCORE", 0);


        if (historyScoreOn > historyHighScore){
            scoreLabel.setText(historyScoreOn + "");
            highScoreLabel.setText("High Score : " + historyScoreOn);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HISTORY_HIGH_SCORE", historyScoreOn);
            editor.commit();
            editor.putInt("HISTORYPROFILE_HIGH_SCORE", historyScoreOn);
            editor.commit();
            editor.putInt("HISTORYSELECT_HIGH_SCORE", historyScoreOn);
            editor.commit();
        }

         if (filmScoreOn > filmHighScore){
            scoreLabel.setText(filmScoreOn + "");
            highScoreLabel.setText("High Score : " + filmScoreOn);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("FILM_HIGH_SCORE", filmScoreOn);
            editor.commit();
             editor.putInt("FILMPOSTERPROFILE_HIGH_SCORE", filmScoreOn);
             editor.commit();
             editor.putInt("FILMPOSTERSELECT_HIGH_SCORE", filmScoreOn);
             editor.commit();
         }

        else if (albumsScoreOn > albumsHighScore){
            scoreLabel.setText(albumsScoreOn + "");
            highScoreLabel.setText("High Score : " + albumsScoreOn);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("ALBUMS_HIGH_SCORE", albumsScoreOn);
            editor.commit();
             editor.putInt("ICONICALBUMPROFILE_HIGH_SCORE", albumsScoreOn);
             editor.commit();
             editor.putInt("ICONICALBUMSELECT_HIGH_SCORE", albumsScoreOn);
             editor.commit();
        }

        else if (hiphopScoreOn > hiphopHighScore){
            scoreLabel.setText(hiphopScoreOn + "");
            highScoreLabel.setText("High Score : " + hiphopScoreOn);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIPHOP_HIGH_SCORE", hiphopScoreOn);
            editor.commit();
             editor.putInt("HIPHOPPROFILE_HIGH_SCORE", hiphopScoreOn);
             editor.commit();
             editor.putInt("HIPHOPSELECT_HIGH_SCORE", hiphopScoreOn);
             editor.commit();
        }


        else if (f1PodiumsScoreOn > f1PodiumsHighScore){
            scoreLabel.setText(f1PodiumsScoreOn + "");
            highScoreLabel.setText("High Score : " + f1PodiumsScoreOn);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("F1PODIUMS_HIGH_SCORE", f1PodiumsScoreOn);
            editor.commit();
             editor.putInt("F1PODIUMPROFILE_HIGH_SCORE", f1PodiumsScoreOn);
             editor.commit();
             editor.putInt("F1PODIUMSELECT_HIGH_SCORE", f1PodiumsScoreOn);
             editor.commit();
        }

        else if (uefaCLScoreOn > uefaCLHighScore){
            scoreLabel.setText(uefaCLScoreOn + "");
            highScoreLabel.setText("High Score : " + uefaCLScoreOn);
             SharedPreferences.Editor editor = settings.edit();
             editor.putInt("UEFACL_HIGH_SCORE", uefaCLScoreOn);
             editor.commit();
             editor.putInt("UEFACLPROFILE_HIGH_SCORE", uefaCLScoreOn);
             editor.commit();
             editor.putInt("UEFACLSELECT_HIGH_SCORE", uefaCLScoreOn);
             editor.commit();

        }
         else if (f1PodiumsScoreOn < f1PodiumsHighScore && CategorySelect.mQuestionTopic == "F1Podiums"){
             scoreLabel.setText(f1PodiumsScoreOn + "");
             highScoreLabel.setText("High Score : " + f1PodiumsHighScore);
             SharedPreferences.Editor editor = settings.edit();
             editor.putInt("F1PODIUMPROFILE_HIGH_SCORE", f1PodiumsScoreOn);
             editor.commit();
             editor.putInt("F1PODIUMSELECT_HIGH_SCORE", f1PodiumsScoreOn);
             editor.commit();
         }


         else if (historyScoreOn < historyHighScore && CategorySelect.mQuestionTopic == "History"){
            scoreLabel.setText(historyScoreOn + "");
            highScoreLabel.setText("High Score for History : " + historyHighScore);
             SharedPreferences.Editor editor = settings.edit();
             editor.putInt("HISTORYPROFILE_HIGH_SCORE", historyHighScore);
             editor.commit();
             editor.putInt("HISTORYSELECT_HIGH_SCORE", historyHighScore);
             editor.commit();
        }

        else if (filmScoreOn < filmHighScore && CategorySelect.mQuestionTopic == "IconicMoviePosters"){
             scoreLabel.setText(filmScoreOn + "");
            highScoreLabel.setText("High Score : " + filmHighScore);
             SharedPreferences.Editor editor = settings.edit();
             editor.putInt("FILMPOSTERPROFILE_HIGH_SCORE", filmHighScore);
             editor.commit();
             editor.putInt("FILMPOSTERSELECT_HIGH_SCORE", filmHighScore);
             editor.commit();
        }
        else if (albumsScoreOn < albumsHighScore && CategorySelect.mQuestionTopic == "AlbumCovers"){
             scoreLabel.setText(albumsScoreOn + "");
            highScoreLabel.setText("High Score : " + albumsHighScore);
             SharedPreferences.Editor editor = settings.edit();
             editor.putInt("ICONICALBUMPROFILE_HIGH_SCORE", albumsHighScore);
             editor.commit();
             editor.putInt("ICONICALBUMSELECT_HIGH_SCORE", albumsHighScore);
             editor.commit();
        }
        else if (hiphopScoreOn < hiphopHighScore && CategorySelect.mQuestionTopic == "HipHopAlbumCovers"){
             scoreLabel.setText(hiphopScoreOn + "");
            highScoreLabel.setText("High Score : " + hiphopHighScore);
             SharedPreferences.Editor editor = settings.edit();
             editor.putInt("HIPHOPPROFILE_HIGH_SCORE", hiphopHighScore);
             editor.commit();
             editor.putInt("HIPHOPSELECT_HIGH_SCORE", hiphopHighScore);
             editor.commit();
        }
        else if (uefaCLScoreOn < uefaCLHighScore && CategorySelect.mQuestionTopic == "UefaChampionsLeague"){
             scoreLabel.setText(uefaCLScoreOn + "");
            highScoreLabel.setText("High Score : " + uefaCLHighScore);
             SharedPreferences.Editor editor = settings.edit();
             editor.putInt("UEFACLPROFILE_HIGH_SCORE", uefaCLHighScore);
             editor.commit();
             editor.putInt("UEFACLSELECT_HIGH_SCORE", uefaCLHighScore);
             editor.commit();
        }

        mainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(result.this, MainMenu.class);
                startActivity(myIntent);
                finish();
            }
        });
    }
}
