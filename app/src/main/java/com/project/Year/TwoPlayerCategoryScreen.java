package com.project.Year;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TwoPlayerCategoryScreen extends AppCompatActivity {

    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;

    TextView[] mDots;
    TextView Category1HighestScore;
    TextView Category2HighestScore;

    SliderAdapter sliderAdapter;

    Button mNextBtn;
    Button mBackBtn;
    Button mCatergoryButton;
    Button mCatergoryButton2;
    TextView CategoryInfo;

    int mCurrentPage;
    static String mQuestionTopic;

    public static int getHistoryScore2;
    public static int getFilmPosterScore2;
    public static int getIconicAlbumScore2;
    public static int getHipHopAlbumScore2;
    public static int getUefaCLScore2;
    public static int getF1PodiumsScore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player_category_screen);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);


        mNextBtn = (Button) findViewById(R.id.nextBtn);
        mBackBtn = (Button) findViewById(R.id.prevBtn);
        mCatergoryButton = (Button) findViewById(R.id.catergory_button);
        mCatergoryButton2 = (Button) findViewById(R.id.catergory_button2);
        CategoryInfo =(TextView) findViewById(R.id.txt_CategoryInfo2);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        CategoryInfo.setText("2 Player Mode Rules - Player 1 will enter their guess, then player 2 will enter theirs. Scores are revealed after each question. Highest score at the end of the match wins!"
        + "NOTE: More Categories will be added in future updates. ");
        CategoryInfo.setVisibility(View.VISIBLE);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSlideViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
            }
        });

        mCatergoryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(TwoPlayerCategoryScreen.this, TwoPlayerGameScreen.class);
                startActivity(myIntent);
                //randomIndex--;
                finish();

            }
        });

        mCatergoryButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mCurrentPage == 3) {
                    Intent myIntent = new Intent(TwoPlayerCategoryScreen.this, TwoPlayerGameScreen.class);
                    startActivity(myIntent);
                    mQuestionTopic = "HipHopAlbumCovers";
                    //randomIndex--;
                    finish();
                }
                else if (mCurrentPage == mDots.length - 1) {
                    Intent myIntent = new Intent(TwoPlayerCategoryScreen.this, TwoPlayerGameScreen.class);
                    startActivity(myIntent);
                    mQuestionTopic = "F1Podiums";
                    //randomIndex--;
                    finish();
                }
            }

        });
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[5];
        mDotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(".");
            mDots[i].setTextSize(67);
            mDots[i].setTextColor(getResources().getColor(R.color.Greytransparency));

            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.Blacktransparency));
        }
    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if(i == 0) {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);
                mCatergoryButton.setEnabled(false);
                mCatergoryButton.setVisibility(View.INVISIBLE);
                mCatergoryButton2.setVisibility(View.INVISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("");
                CategoryInfo.setVisibility(View.VISIBLE);
            }
            else if(i == 1){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mCatergoryButton.setEnabled(true);
                mCatergoryButton.setText("Film Posters");
                mCatergoryButton.setVisibility(View.VISIBLE);
                mCatergoryButton2.setVisibility(View.INVISIBLE);
                Drawable myDrawable = getResources().getDrawable(R.drawable.icons8filmreel50);
                mCatergoryButton.setCompoundDrawablesWithIntrinsicBounds(null,myDrawable,null,null);
                mNextBtn.setText("Next");
                mQuestionTopic = "IconicMoviePosters";
                mBackBtn.setText("Back");
                CategoryInfo.setVisibility(View.INVISIBLE);

            }  else if(i == 2){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
                mCatergoryButton.setText("Historical Events");
                Drawable myDrawable = getResources().getDrawable(R.drawable.icons8historical60);
                mCatergoryButton.setCompoundDrawablesWithIntrinsicBounds(null,myDrawable,null,null);
                mCatergoryButton.setVisibility(View.VISIBLE);
                mCatergoryButton2.setVisibility(View.INVISIBLE);
                mQuestionTopic = "History";
                CategoryInfo.setVisibility(View.INVISIBLE);
            }
            else if(i == 3){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
                mCatergoryButton.setText("Iconic Albums");
                Drawable myDrawable5 = getResources().getDrawable(R.drawable.icons8musicrecord60);
                mCatergoryButton.setCompoundDrawablesWithIntrinsicBounds(null,myDrawable5,null,null);
                mCatergoryButton.setVisibility(View.VISIBLE);
                mQuestionTopic = "AlbumCovers";
                mCatergoryButton2.setText("Hip Hop");
                Drawable myDrawable3 = getResources().getDrawable(R.drawable.icons8hiphopmusic60);
                mCatergoryButton2.setCompoundDrawablesWithIntrinsicBounds(null,myDrawable3,null,null);
                mCatergoryButton2.setVisibility(View.VISIBLE);
                mQuestionTopic = "AlbumCovers";
                CategoryInfo.setVisibility(View.INVISIBLE);
            }
            else if (i == mDots.length - 1){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mCatergoryButton.setEnabled(true);
                mCatergoryButton.setText("UEFA CL Teams");
                mQuestionTopic = "UefaChampionsLeague";
                Drawable myDrawable2 = getResources().getDrawable(R.drawable.uefacl1);
                mCatergoryButton.setCompoundDrawablesWithIntrinsicBounds(null,myDrawable2,null,null);
                mCatergoryButton2.setText("F1 Podiums");
                Drawable myDrawable4 = getResources().getDrawable(R.drawable.icons8f1car70);
                mCatergoryButton2.setCompoundDrawablesWithIntrinsicBounds(null,myDrawable4,null,null);
                mCatergoryButton2.setVisibility(View.VISIBLE);
                mNextBtn.setText("");
                mCatergoryButton.setVisibility(View.VISIBLE);
                mBackBtn.setText("Back");
                CategoryInfo.setVisibility(View.INVISIBLE);
            }
        }




        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


}
