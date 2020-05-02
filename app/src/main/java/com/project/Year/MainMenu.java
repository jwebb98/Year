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


        Button SelectCategory;
        Button HowToPlay;
        Button UserProfileButton;
        Button TwoPlayer;
        SelectCategory = (Button) findViewById(R.id.btn_selectCategory);
        HowToPlay = (Button) findViewById(R.id.btn_howToPlay);
        UserProfileButton = (Button) findViewById(R.id.btn_profile);
        TwoPlayer = (Button) findViewById(R.id.btn_TwoPlayer);


        SelectCategory.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainMenu.this, CategorySelect.class);
                startActivity(myIntent);
                //randomIndex--;
            }
        });

        HowToPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainMenu.this, Instructions.class);
                startActivity(myIntent);
                //randomIndex--;
            }
        });

        UserProfileButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainMenu.this, UserProfile.class);
                startActivity(myIntent);
                //randomIndex--;
            }
        });

        TwoPlayer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainMenu.this, TwoPlayerCategoryScreen.class);
                startActivity(myIntent);
                //randomIndex--;
            }
        });



    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}
