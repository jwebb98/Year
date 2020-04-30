package com.project.Year;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    TextView HistoryHighestScore;
    TextView FilmPostersHighestScore;
    TextView IconicAlbumsHighestScore;
    Button mMainMenuBtn;
    public static int getHistoryScore;
    public static int getFilmPosterScore;
    public static int getIconicAlbumScore;
    public static int getHipHopAlbumScore;
    public static int getUefaCLScore;
    public static int getF1PodiumsScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mMainMenuBtn = (Button) findViewById(R.id.btnMainMenu3);
        HistoryHighestScore = (TextView) findViewById(R.id.txt_HistoryScore);
        FilmPostersHighestScore = (TextView) findViewById(R.id.txt_FilmPostersScore);
        IconicAlbumsHighestScore = (TextView) findViewById(R.id.txt_IconicAlbumsScore);

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        UserProfile.getHistoryScore = settings.getInt("HISTORYPROFILE_HIGH_SCORE", 0);
        UserProfile.getFilmPosterScore = settings.getInt("FILMPOSTERPROFILE_HIGH_SCORE", 0);
        UserProfile.getIconicAlbumScore = settings.getInt("ICONICALBUMPROFILE_HIGH_SCORE", 0);
        UserProfile.getHipHopAlbumScore = settings.getInt("HIPHOPPROFILE_HIGH_SCORE", 0);
        UserProfile.getUefaCLScore = settings.getInt("UEFACLPROFILE_HIGH_SCORE", 0);
        UserProfile.getF1PodiumsScore = settings.getInt("F1PODIUMPROFILE_HIGH_SCORE", 0);


        HistoryHighestScore.setText("" + getHistoryScore);
        FilmPostersHighestScore.setText("" + getFilmPosterScore);
        IconicAlbumsHighestScore.setText("" + getIconicAlbumScore);



        mMainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(UserProfile.this, MainMenu.class);
                startActivity(myIntent);
                finish();
            }
        });
    }
}
