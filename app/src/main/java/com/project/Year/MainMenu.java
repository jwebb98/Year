package com.project.Year;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends MainActivity{
    static String mQuestionTopic;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);

        History = (Button) findViewById(R.id.btn_Historical);
        Button HipHop;
        Button IconicAlbums;
        Button F1Podiums;
        Button UefaCLTeams;
        Button FilmPosters;
        HipHop = (Button) findViewById(R.id.btn_HipHop);
        IconicAlbums = (Button) findViewById(R.id.btn_IconicAlbums);
        F1Podiums = (Button) findViewById(R.id.btn_F1);
        UefaCLTeams = (Button) findViewById(R.id.btn_UefaCL);
        FilmPosters = (Button) findViewById(R.id.btn_Film);

        History.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(myIntent);
                mQuestionTopic = "History";
                //randomIndex--;
                finish();
            }
        });

        HipHop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(myIntent);
                mQuestionTopic = "HipHopAlbumCovers";
                //randomIndex--;
                finish();
            }
        });
        IconicAlbums.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(myIntent);
                mQuestionTopic = "AlbumCovers";
                //randomIndex--;
                finish();
            }
        });
        F1Podiums.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(myIntent);
                mQuestionTopic = "F1Podiums";
                //randomIndex--;
                finish();
            }
        });
        UefaCLTeams.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(myIntent);
                mQuestionTopic = "UefaChampionsLeague";
                //randomIndex--;
                finish();
            }
        });
        FilmPosters.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainMenu.this, MainActivity.class);
                startActivity(myIntent);
                mQuestionTopic = "IconicMoviePosters";
                //randomIndex--;
                finish();
            }
        });



    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}
