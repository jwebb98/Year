package com.project.Year;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategorySelect extends AppCompatActivity {

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
        setContentView(R.layout.activity_category_select);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);
        Category1HighestScore =(TextView) findViewById(R.id.txt_catergory1HighScore);
        Category2HighestScore =(TextView) findViewById(R.id.txt_catergory2HighScore);

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        getHistoryScore2 = settings.getInt("HISTORYSELECT_HIGH_SCORE", 0);
        getFilmPosterScore2 = settings.getInt("FILMPOSTERSELECT_HIGH_SCORE", 0);
        getIconicAlbumScore2 = settings.getInt("ICONICALBUMSELECT_HIGH_SCORE", 0);
        getHipHopAlbumScore2 = settings.getInt("HIPHOPSELECT_HIGH_SCORE", 0);
        getUefaCLScore2 = settings.getInt("UEFACLSELECT_HIGH_SCORE", 0);
        getF1PodiumsScore2 = settings.getInt("F1PODIUMSELECT_HIGH_SCORE", 0);

        mNextBtn = (Button) findViewById(R.id.nextBtn);
        mBackBtn = (Button) findViewById(R.id.prevBtn);
        mCatergoryButton = (Button) findViewById(R.id.catergory_button);
        mCatergoryButton2 = (Button) findViewById(R.id.catergory_button2);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

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
                    Intent myIntent = new Intent(CategorySelect.this, MainActivity.class);
                    startActivity(myIntent);
                    //randomIndex--;
                    finish();

            }
        });

        mCatergoryButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mCurrentPage == 3) {
                    Intent myIntent = new Intent(CategorySelect.this, MainActivity.class);
                    startActivity(myIntent);
                    mQuestionTopic = "HipHopAlbumCovers";
                    //randomIndex--;
                    finish();
                    }
                else if (mCurrentPage == mDots.length - 1) {
                    Intent myIntent = new Intent(CategorySelect.this, MainActivity.class);
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
                Category1HighestScore.setVisibility(View.INVISIBLE);
                Category2HighestScore.setVisibility(View.INVISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("");
            }
            else if(i == 1){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mCatergoryButton.setEnabled(true);
                mCatergoryButton.setText("Film Posters");
                Category1HighestScore.setText("Highest Score = " + getFilmPosterScore2);
                mCatergoryButton.setVisibility(View.VISIBLE);
                mCatergoryButton2.setVisibility(View.INVISIBLE);
                mNextBtn.setText("Next");
                mQuestionTopic = "IconicMoviePosters";
                mBackBtn.setText("Back");
                Category1HighestScore.setVisibility(View.VISIBLE);
                Category2HighestScore.setVisibility(View.INVISIBLE);


            }  else if(i == 2){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
                mCatergoryButton.setText("Historical Events");
                Category1HighestScore.setText("Highest Score = " + getHistoryScore2);
                mCatergoryButton.setVisibility(View.VISIBLE);
                mCatergoryButton2.setVisibility(View.INVISIBLE);
                mQuestionTopic = "History";
                Category1HighestScore.setVisibility(View.VISIBLE);
                Category2HighestScore.setVisibility(View.INVISIBLE);
            }
            else if(i == 3){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
                mCatergoryButton.setText("Iconic Album Covers");
                mCatergoryButton.setVisibility(View.VISIBLE);
                mQuestionTopic = "AlbumCovers";
                mCatergoryButton2.setText("Hip Hop Albums");
                Category1HighestScore.setText("Highest Score = " + getIconicAlbumScore2);
                mCatergoryButton2.setVisibility(View.VISIBLE);
                mQuestionTopic = "AlbumCovers";
                Category2HighestScore.setText("Highest Score = " + getHipHopAlbumScore2);
                Category1HighestScore.setVisibility(View.VISIBLE);
                Category2HighestScore.setVisibility(View.VISIBLE);
            }
            else if (i == mDots.length - 1){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mCatergoryButton.setEnabled(true);
                mCatergoryButton.setText("UEFA CL Teams");
                mQuestionTopic = "UefaChampionsLeague";
                Category1HighestScore.setText("Highest Score = " + getUefaCLScore2);
                mCatergoryButton2.setText("F1 Podiums");
                mCatergoryButton2.setVisibility(View.VISIBLE);
                Category2HighestScore.setText("Highest Score = " + getF1PodiumsScore2);
                mNextBtn.setText("");
                mCatergoryButton.setVisibility(View.VISIBLE);
                mBackBtn.setText("Back");
                Category1HighestScore.setVisibility(View.VISIBLE);
                Category2HighestScore.setVisibility(View.VISIBLE);

            }
        }




        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


}
