package com.project.Year;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategorySelect extends MainActivity {

    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;

    TextView[] mDots;

    SliderAdapter sliderAdapter;

    Button mNextBtn;
    Button mBackBtn;
    Button mCatergoryButton;
    Button mCatergoryButton2;

    int mCurrentPage;
    static String mQuestionTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_select);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

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
                mNextBtn.setText("Next");
                mBackBtn.setText("");
            }
            else if(i == 1){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.VISIBLE);
                mCatergoryButton.setEnabled(true);
                mCatergoryButton.setText("Film Posters");
                mCatergoryButton.setVisibility(View.VISIBLE);
                mCatergoryButton2.setVisibility(View.INVISIBLE);
                mNextBtn.setText("Next");
                mQuestionTopic = "IconicMoviePosters";
                mBackBtn.setText("");

            }  else if(i == 2){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
                mCatergoryButton.setText("Historical Events");
                mCatergoryButton.setVisibility(View.VISIBLE);
                mCatergoryButton2.setVisibility(View.INVISIBLE);
                mQuestionTopic = "History";
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
                mCatergoryButton2.setVisibility(View.VISIBLE);
                mQuestionTopic = "AlbumCovers";
            }
            else if (i == mDots.length - 1){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mCatergoryButton.setEnabled(true);
                mCatergoryButton.setText("UEFA CL Teams");
                mQuestionTopic = "UefaChampionsLeague";
                mCatergoryButton2.setText("F1 Podiums");
                mCatergoryButton2.setVisibility(View.VISIBLE);
                mNextBtn.setText("");
                mCatergoryButton.setVisibility(View.VISIBLE);
                mBackBtn.setText("Back");

            }
        }




        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


}
