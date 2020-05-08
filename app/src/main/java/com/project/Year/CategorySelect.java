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
public class CategorySelect extends AppCompatActivity {
    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;
    TextView[] mDots;
    TextView Category1HighestScore;
    TextView Category2HighestScore;
    TextView CategoryInfo;
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
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_category_select );
        mSlideViewPager = ( ViewPager ) findViewById( R.id.slideViewPager );
        mDotLayout = ( LinearLayout ) findViewById( R.id.dotsLayout );
        Category1HighestScore = ( TextView ) findViewById( R.id.txt_catergory1HighScore );
        Category2HighestScore = ( TextView ) findViewById( R.id.txt_catergory2HighScore );
        CategoryInfo = ( TextView ) findViewById( R.id.txt_CategoryInfo );

        SharedPreferences settings = getSharedPreferences( "GAME_DATA", Context.MODE_PRIVATE );
        getHistoryScore2 = settings.getInt( "HISTORYSELECT_HIGH_SCORE", 0 );
        getFilmPosterScore2 = settings.getInt( "FILMPOSTERSELECT_HIGH_SCORE", 0 );
        getIconicAlbumScore2 = settings.getInt( "ICONICALBUMSELECT_HIGH_SCORE", 0 );
        getHipHopAlbumScore2 = settings.getInt( "HIPHOPSELECT_HIGH_SCORE", 0 );
        getUefaCLScore2 = settings.getInt( "UEFACLSELECT_HIGH_SCORE", 0 );
        getF1PodiumsScore2 = settings.getInt( "F1PODIUMSELECT_HIGH_SCORE", 0 );

        mNextBtn = ( Button ) findViewById( R.id.nextBtn );
        mBackBtn = ( Button ) findViewById( R.id.prevBtn );
        mCatergoryButton = ( Button ) findViewById( R.id.catergory_button );
        mCatergoryButton2 = ( Button ) findViewById( R.id.catergory_button2 );

        sliderAdapter = new SliderAdapter( this );
        mSlideViewPager.setAdapter( sliderAdapter );
        CategoryInfo.setText( "View available Categories and select the one you would like to play. NOTE: More Categories will be added in future updates.  " );
        CategoryInfo.setVisibility( View.VISIBLE );
        addDotsIndicator( 0 );
        mSlideViewPager.addOnPageChangeListener( viewListener );
        mNextBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                mSlideViewPager.setCurrentItem( mCurrentPage + 1 );
            }
        } );
        mBackBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                mSlideViewPager.setCurrentItem( mCurrentPage - 1 );
            }
        } );
        mCatergoryButton.setOnClickListener( new View.OnClickListener() {
            public void onClick( View view ) {
                Intent myIntent = new Intent( CategorySelect.this, MainActivity.class );
                startActivity( myIntent );
                finish();
            }
        } );
        mCatergoryButton2.setOnClickListener( new View.OnClickListener() {
            public void onClick( View view ) {
                if ( mCurrentPage == 3 ) {
                    Intent myIntent = new Intent( CategorySelect.this, MainActivity.class );
                    startActivity( myIntent );
                    mQuestionTopic = "HipHopAlbumCovers";
                    finish();
                } else if ( mCurrentPage == mDots.length - 1 ) {
                    Intent myIntent = new Intent( CategorySelect.this, MainActivity.class );
                    startActivity( myIntent );
                    mQuestionTopic = "F1Podiums";
                    finish();
                }
            }
        } );
    }
    public void addDotsIndicator( int position ) {
        mDots = new TextView[ 5 ];
        mDotLayout.removeAllViews();
        for ( int i = 0; i < mDots.length; i++ ) {
            mDots[ i ] = new TextView( this );
            mDots[ i ].setText( "." );
            mDots[ i ].setTextSize( 67 );
            mDots[ i ].setTextColor( getResources().getColor( R.color.Blacktransparency ) );
            mDotLayout.addView( mDots[ i ] );
        }
        if ( mDots.length > 0 ) {
            mDots[ position ].setTextColor( getResources().getColor( R.color.common_google_signin_btn_text_dark_focused ) );
        }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled( int i, float v, int i1 ) {}
        @Override
        public void onPageSelected( int i ) {
            addDotsIndicator( i );
            mCurrentPage = i;
            if ( i == 0 ) {
                mNextBtn.setEnabled( true );
                mBackBtn.setEnabled( false );
                mBackBtn.setVisibility( View.INVISIBLE );
                mCatergoryButton.setEnabled( false );
                mCatergoryButton.setVisibility( View.INVISIBLE );
                mCatergoryButton2.setVisibility( View.INVISIBLE );
                Category1HighestScore.setVisibility( View.INVISIBLE );
                CategoryInfo.setVisibility( View.VISIBLE );
                mNextBtn.setText( "Next" );
                mBackBtn.setText( "" );
            } else if ( i == 1 ) {
                mNextBtn.setEnabled( true );
                mBackBtn.setEnabled( true );
                mBackBtn.setVisibility( View.VISIBLE );
                mCatergoryButton.setEnabled( true );
                mCatergoryButton.setText( "Film Posters" );
                Drawable myDrawable = getResources().getDrawable( R.drawable.icons8filmreel50 );
                mCatergoryButton.setCompoundDrawablesWithIntrinsicBounds( null, myDrawable, null, null );
                Category1HighestScore.setText( "High Score: " + getFilmPosterScore2 );
                mCatergoryButton.setVisibility( View.VISIBLE );
                mCatergoryButton2.setVisibility( View.INVISIBLE );
                mNextBtn.setText( "Next" );
                mQuestionTopic = "IconicMoviePosters";
                mBackBtn.setText( "Back" );
                Category1HighestScore.setVisibility( View.VISIBLE );
                Category2HighestScore.setVisibility( View.INVISIBLE );
                CategoryInfo.setVisibility( View.INVISIBLE );
            } else if ( i == 2 ) {
                mNextBtn.setEnabled( true );
                mBackBtn.setEnabled( true );
                mBackBtn.setVisibility( View.VISIBLE );
                mNextBtn.setText( "Next" );
                mBackBtn.setText( "Back" );
                mCatergoryButton.setText( "Historical Events" );
                Category1HighestScore.setText( "High Score: " + getHistoryScore2 );
                mCatergoryButton.setVisibility( View.VISIBLE );
                mCatergoryButton2.setVisibility( View.INVISIBLE );
                Drawable myDrawable = getResources().getDrawable( R.drawable.icons8historical60 );
                mCatergoryButton.setCompoundDrawablesWithIntrinsicBounds( null, myDrawable, null, null );
                mQuestionTopic = "History";
                Category1HighestScore.setVisibility( View.VISIBLE );
                Category2HighestScore.setVisibility( View.INVISIBLE );
                CategoryInfo.setVisibility( View.INVISIBLE );
            } else if ( i == 3 ) {
                mNextBtn.setEnabled( true );
                mBackBtn.setEnabled( true );
                mBackBtn.setVisibility( View.VISIBLE );
                mNextBtn.setText( "Next" );
                mBackBtn.setText( "Back" );
                mCatergoryButton.setText( "Iconic Albums" );
                mCatergoryButton.setVisibility( View.VISIBLE );
                mQuestionTopic = "AlbumCovers";
                mCatergoryButton2.setText( "Hip Hop" );
                Drawable myDrawable5 = getResources().getDrawable( R.drawable.icons8musicrecord60 );
                mCatergoryButton.setCompoundDrawablesWithIntrinsicBounds( null, myDrawable5, null, null );
                Category1HighestScore.setText( "High Score: " + getIconicAlbumScore2 );
                mCatergoryButton2.setVisibility( View.VISIBLE );
                mQuestionTopic = "AlbumCovers";
                Category2HighestScore.setText( "High Score: " + getHipHopAlbumScore2 );
                Drawable myDrawable3 = getResources().getDrawable( R.drawable.icons8hiphopmusic60 );
                mCatergoryButton2.setCompoundDrawablesWithIntrinsicBounds( null, myDrawable3, null, null );
                Category1HighestScore.setVisibility( View.VISIBLE );
                Category2HighestScore.setVisibility( View.VISIBLE );
                CategoryInfo.setVisibility( View.INVISIBLE );
            } else if ( i == mDots.length - 1 ) {
                mNextBtn.setEnabled( true );
                mBackBtn.setEnabled( true );
                mBackBtn.setVisibility( View.VISIBLE );
                mCatergoryButton.setEnabled( true );
                mCatergoryButton.setText( "UEFA CL Teams" );
                Drawable myDrawable2 = getResources().getDrawable( R.drawable.uefacl1 );
                mCatergoryButton.setCompoundDrawablesWithIntrinsicBounds( null, myDrawable2, null, null );
                mQuestionTopic = "UefaChampionsLeague";
                Category1HighestScore.setText( "High Score: " + getUefaCLScore2 );
                mCatergoryButton2.setText( "F1 Podiums" );
                mCatergoryButton2.setVisibility( View.VISIBLE );
                Category2HighestScore.setText( "High Score: " + getF1PodiumsScore2 );
                Drawable myDrawable4 = getResources().getDrawable( R.drawable.icons8f1car70 );
                mCatergoryButton2.setCompoundDrawablesWithIntrinsicBounds( null, myDrawable4, null, null );
                mNextBtn.setText( "" );
                mCatergoryButton.setVisibility( View.VISIBLE );
                mBackBtn.setText( "Back" );
                Category1HighestScore.setVisibility( View.VISIBLE );
                Category2HighestScore.setVisibility( View.VISIBLE );
                CategoryInfo.setVisibility( View.INVISIBLE );
            }
        }
        @Override
        public void onPageScrollStateChanged( int i ) {}
    };
}